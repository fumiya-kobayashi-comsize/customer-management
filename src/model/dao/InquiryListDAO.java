package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.InquiryBean;

/**
 * t_inquiryテーブルのDAOです。
 * @author 此上
 */

public class InquiryListDAO {
	/**
	 * すべての問合せ情報のリストを返します。
	 * @param なし
	 * @return 問合せ情報のリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public List<InquiryBean> selectInquiry()
			throws SQLException, ClassNotFoundException{

		List<InquiryBean> inquiryList = new ArrayList<InquiryBean>();

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
		sb.append("ON t2.status_code = t3.status_code;");
		String sql = sb.toString();

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				//beanインスタンス化
				InquiryBean inquiryBean = new InquiryBean();

				//beanに値をセット
				inquiryBean.setInquiryId(res.getInt("inquiry_id"));
				inquiryBean.setCustomerId(res.getInt("customer_id"));
				inquiryBean.setCustomerName(res.getString("customer_name"));
				inquiryBean.setInquiryDatetime(res.getTimestamp("inquiry_datetime"));
				inquiryBean.setInquiryContents(res.getString("inquiry_contents"));
				inquiryBean.setReplyContents(res.getString("reply_contents"));
				inquiryBean.setStatusCode(res.getString("status_code"));
				inquiryBean.setStatusName(res.getString("status_name"));

				inquiryList.add(inquiryBean);
			}
		}
		return inquiryList;
	}
}
