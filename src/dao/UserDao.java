package dao;

import domain.User;

public interface UserDao {

	// IDとPassを元に1人分の管理者データを返すメソッド
	User findByLoginAndLoginPass(String loginId, String loginPass);
}
