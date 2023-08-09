package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * m_customerテーブルのDAOです。
 * @author 吉田
 */

public class DeleteDAO {

/**
 * 顧客情報を削除するモデルクラスです。
 * @return 処理件数
 * @throws SQLException
 * @throws ClassNotFoundException
*/

	public int deleteCustmor(int customerId) throws SQLException, ClassNotFoundException {

		String sql = "DELETE FROM m_customer WHERE customer_id = ?";
		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, customerId);
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;

	}

}
