package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;
import model.entity.InquiryBean;


/**
 * ～説明～
 * @author 吉田
 */


public class InqulryRegisterDAO {

	/**
	 * insertした処理件数を返します。
	 * @param 変更する情報（Bean）
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public int insert(InquiryBean inquiryBean)
			throws SQLException, ClassNotFoundException {

		int inquryinsertCount = 0; //処理件数
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(" t_inquiry ");
		sb.append("(customer_id ");
		sb.append(",inquiry_datetime ");
		sb.append(",inquiry_contents ");
		sb.append(",reply_contents ");
		sb.append(", status_code) ");
		sb.append("VALUES ");
		sb.append("(?,?,?,?,?); ");
		String sql = sb.toString();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, inquiryBean.getCustomerId());
			pstmt.setTimestamp(2, inquiryBean.getInquiryDatetime());
			pstmt.setString(3, inquiryBean.getInquiryContents());
			pstmt.setString(4, inquiryBean.getReplyContents());
			pstmt.setString(5, inquiryBean.getStatusCode());

			inquryinsertCount = pstmt.executeUpdate();
		}
		return inquryinsertCount;
	}



	/**
	 * 問合せ情報を返します。
	 * @return 問合せ情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public int selectId(int customerId) throws SQLException, ClassNotFoundException {

		String sql = "SELECT inquiry_id FROM t_inquiry WHERE customer_id = ?";
		int inquiryId = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setInt(1, customerId);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				customerId  = res.getInt("customer_id");
			}
		}
		return customerId;
	}


	/**
	 * カスタマーリストを返します。
	 * @param なし
	 * @return customer_id、customer_nameのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CustomerBean> customerList()
			throws SQLException, ClassNotFoundException{

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();

		String sql = "SELECT customer_id, customer_name FROM m_customer";

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				//beanのインスタンス化
				CustomerBean customerbean = new CustomerBean();

				//beanに値をセット
				customerbean.setCustomerId(res.getInt("customer_id"));
				customerbean.setCustomerName(res.getString("customer_name"));

				customerList.add(customerbean);
			}
		}
		return customerList;
	}





	/**
	 * ステータスリストを返します。
	 * @param なし
	 * @return status_code、status_nameのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<InquiryBean> statusList()
			throws SQLException, ClassNotFoundException{

		List<InquiryBean> statusList = new ArrayList<InquiryBean>();

		String sql = "SELECT * FROM m_status";

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				//beanのインスタンス化
				InquiryBean inquirybean = new InquiryBean();

				//beanに値をセット
				inquirybean.setStatusCode(res.getString("status_code"));
				inquirybean.setStatusName(res.getString("status_name"));

				statusList.add(inquirybean);
			}
		}
		return statusList;
	}
}
