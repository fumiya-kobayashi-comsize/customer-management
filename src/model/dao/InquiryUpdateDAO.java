package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.InquiryBean;

/**
 * t_inquiryテーブルのDAOです。
 * @author 此上
 */

public class InquiryUpdateDAO {
	/**
	 * updateした処理件数を返します。
	 * @param 変更する情報（inquiryBean）
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public int update(InquiryBean inquiryBean)
			throws SQLException, ClassNotFoundException {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append("t_inquiry ");
		sb.append("SET ");
		sb.append("inquiry_datetime = ? ");
		sb.append(", inquiry_contents = ? ");
		sb.append(", reply_contents = ? ");
		sb.append(", status_code = ? ");
		sb.append("WHERE inquiry_id = ?;");
		String sql = sb.toString();

		//処理件数
		int count = 0;

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setTimestamp(1,inquiryBean.getInquiryDatetime());
			pstmt.setString(2,inquiryBean.getInquiryContents());
			pstmt.setString(3,inquiryBean.getReplyContents());
			pstmt.setString(4,inquiryBean.getStatusCode());
			pstmt.setInt(5,inquiryBean.getInquiryId());

			count = pstmt.executeUpdate();
		}
		return count;
	}
}
