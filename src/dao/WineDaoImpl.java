package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Wine;

public class WineDaoImpl implements WineDao{

	 private DataSource ds;

	 //引数ありのコンストラクタを作成
	 //→FactoryからDataSourceを受け取るため

	 public WineDaoImpl(DataSource ds) {
		 this.ds = ds;
	 }

	//全データ取得（ワイン情報）
	@Override
	public List<Wine> findAll() throws Exception {
	     List<Wine> wines = new ArrayList<>();
	     try(Connection con = ds.getConnection()){
	    	 String sql = "SELECT * FROM wine";
	    	 PreparedStatement stmt = con.prepareStatement(sql);
	    	 ResultSet rs = stmt.executeQuery();

	    	 while(rs.next()) {
	    		 wines.add(mapToWine(rs));
	    	 }
	     }
	      catch(Exception e) {
	    	  throw e;
	      }

	     return wines;

	}

	@Override
	public Wine findById() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Wine wine) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO wine"
					+ " (name, image, evaluation, type, country, price, date, comment)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, wine.getName());
			stmt.setString(2, wine.getImage());
			stmt.setObject(3, wine.getEvaluation(), Types.INTEGER );
			stmt.setString(4, wine.getType());
			stmt.setString(5, wine.getCountry());
			stmt.setObject(6, wine.getPrice(), Types.INTEGER);

			//java.util.Dateからjava.sql.Dateに変換
			long bd = wine.getDate().getTime();
			stmt.setDate(7, new java.sql.Date(bd));

			stmt.setString(8, wine.getComment());

			stmt.executeUpdate();
		}
		 catch(Exception e) {
			   throw e;

		 }

	}


	@Override
	public void delete(Wine wine) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * wineテーブルから取得したデータ
	 * ResultSetをWineオブジェクトに変換
	 * @throws SQLException
	 */

	private Wine mapToWine(ResultSet rs) throws SQLException{

		//各カラムのデータを取り出す
		Integer id = (Integer)rs.getObject("id");
		String name = rs.getString("name");
		String image = rs.getString("image");
		Integer evaluation = (Integer)rs.getObject("evaluation");
		String type = rs.getString("type");
		String country = rs.getString("country");
		Integer price = (Integer)rs.getObject("price");
		Date date = rs.getTimestamp("date");
		String comment = rs.getString("comment");

		//取り出したデータをまとめる
		Wine wine = new Wine();
		wine.setId(id);
		wine.setName(name);
		wine.setImage(image);
		wine.setEvaluation(evaluation);
		wine.setType(type);
		wine.setCountry(country);
		wine.setPrice(price);
		wine.setDate(date);
		wine.setComment(comment);


		return wine;
	}

}
