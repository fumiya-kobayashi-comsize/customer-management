package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * m_userテーブルのDAOです。
 * @author 吉田、竹内
 */


public class LoginDAO {
	/**
	 * ユーザID・パスワードをもとにログイン認証を行う。
	 *
	 * m_userに該当するレコードが存在するかどうかを検索する。
	 *
	 * @param userId ユーザID
	 * @param pass パスワード
	 * @return 認証成功の場合 true、そうでない場合 false
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public boolean loginCheck(String userId, String pass)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt =  con.prepareStatement(sql)){

			// プレースホルダへの値の設定
			pstmt.setString(1, userId);
			pstmt.setString(2, pass);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			if(res.next()) {
				return true;
			}

		}
		return false;
	}
}
