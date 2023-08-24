package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * m_customerテーブルのDAOです。
 * @author 吉田、竹内
 */

public class DeleteDAO {

	/**
	 * 外部キーのcustomerIdを削除し、処理件数を返します。
	 * @param 削除する情報（customerId）
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int foreignDelete(int customerId)
			throws SQLException, ClassNotFoundException {

		String sql1 = "DELETE FROM t_inquiry WHERE customer_id = ?";

		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql1);) {

			// プレースホルダへの値の設定
			pstmt.setInt(1, customerId);
			//processingNumber =
			pstmt.executeUpdate();

		}
		return processingNumber;

	}

	/**
	 * 主キーのcustomerIdを削除し、処理件数を返します。
	 * @param 削除する情報（customerId）
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteCustmor(int customerId)
			throws SQLException, ClassNotFoundException {

		String sql2 = "DELETE FROM m_customer WHERE customer_id = ?";

		int processingNumber = 0; //処理件数
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql2);) {

			// プレースホルダへの値の設定
			pstmt.setInt(1, customerId);
			processingNumber = pstmt.executeUpdate();

		}
		return processingNumber;

	}

}
