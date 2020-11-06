package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static WineDao createWineDao() {
		DataSource ds = getDataSource();
		//DataSourceをUserDaoImplに渡す
		//→UserDaoImplはDataSourceを元に、
		//接続を作ることができる
		return new WineDaoImpl(ds);
	}

	public static UserDao createUserDao() {
		return new UserDaoImpl(getDataSource());
	}

	/**
	 * DataSourceを作るメソッド
	 */

	private static DataSource getDataSource() {

		InitialContext ctx = null;
		DataSource ds = null;

		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/wine_note_db");
		}
		 catch(NamingException e) {
			 if(ctx != null) {
				 try {
					 ctx.close();
				 }
				  catch(NamingException e1) {
					  throw new RuntimeException(e);
				  }
			 }
			  throw new RuntimeException(e);
		 }
		  return ds;
	}

}
