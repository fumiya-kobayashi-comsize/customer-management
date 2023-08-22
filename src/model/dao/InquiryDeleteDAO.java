package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * t_inquiryテーブルのDAOです。
 * @author 此上
 */

public class InquiryDeleteDAO {
	/**
	 * 問合せ情報を削除するモデルクラスです。
	 * @param inquiryId
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	*/

		public int inquiryDelete(int inquiryId) throws SQLException, ClassNotFoundException {

			String sql = "DELETE FROM t_inquiry WHERE inquiry_id = ?";
			int inquiryDeleteCount = 0; //処理件数

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);) {
				// プレースホルダへの値の設定
				pstmt.setInt(1, inquiryId);
				inquiryDeleteCount = pstmt.executeUpdate();
			}
			return inquiryDeleteCount;

		}
}
