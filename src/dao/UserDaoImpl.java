package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.User;

public class UserDaoImpl implements UserDao {

	private DataSource ds;

	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public User findByLoginAndLoginPass(String loginId, String loginPass) throws Exception {

		User user = null;

		// DBとの照合
		// IDとPassに該当するものがあるか？
		try(Connection con = ds.getConnection()){
			// IDが合っているか？
			String sql = "SELECT * FROM user"
					+ " WHERE login_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();

			// 該当するIDがない ⇒ rs.next()はfalseを返す
			if(rs.next()) {
				// IDは正しい
				// Passは正しいか？
				String hashedPass = rs.getString("login_pass");
				if(BCrypt.checkpw(loginPass, hashedPass)){
					// Passも正しい
					// 管理者データをuserに入れる
					user = new User();
					user.setLoginId(loginId);

				}

			}
		}
       catch(Exception e){
    	   throw e;
       }

		// IDとPassが正しければuserには管理者データが入ってくる
		// 正しくない場合、userはnull
		return user;

	}


}
