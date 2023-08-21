package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.InquiryBean;

/**
 * t_inquiryテーブルのDAOです。
 * @author 此上
 */

public class InquiryDetailDAO {
	/**
	 * 編集する問合せ情報を返します。
	 * @param CustomerId
	 * @return そのCustomerIdの問合せ情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public InquiryBean detail(int CustomerId)
			throws SQLException, ClassNotFoundException{

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("t2.inquiry_id ");
		sb.append(", t2.customer_id ");
		sb.append(", t1.customer_name ");
		sb.append(", t2.inquiry_datetime ");
		sb.append(", t2.inquiry_contents ");
		sb.append(", t2.reply_contents ");
		sb.append(", t3.status_code ");
		sb.append(", t3.status_name ");
		sb.append("FROM ");
		sb.append("t_inquiry t2 JOIN m_customer t1 ");
		sb.append("ON t2.customer_id = t1.customer_id JOIN customer_db.m_status t3 ");
		sb.append("ON t2.status_code = t3.status_code ");
		sb.append("WHERE t1.customer_id = ?;");
		String sql = sb.toString();

		InquiryBean inquiryBean = new InquiryBean();

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {

			// プレースホルダへの値の設定
			pstmt.setInt(1, CustomerId);
			ResultSet res = pstmt.executeQuery();

			//結果の操作
			if(res.next()) {

				//beanに値をセット
				inquiryBean.setInquiryId(res.getInt("inquiry_id"));
				inquiryBean.setCustomerId(res.getInt("customer_id"));
				inquiryBean.setCustomerName(res.getString("customer_name"));
				inquiryBean.setInquiryDatetime(res.getTimestamp("inquiry_datetime"));
				inquiryBean.setInquiryContents(res.getString("inquiry_contents"));
				inquiryBean.setReplyContents(res.getString("reply_contents"));
				inquiryBean.setStatusCode(res.getString("status_code"));
				inquiryBean.setStatusName(res.getString("status_name"));
			}
		}
		return inquiryBean;
	}

}
