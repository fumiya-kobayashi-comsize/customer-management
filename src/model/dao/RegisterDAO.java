package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.CustomerBean;

/**
 * 顧客情報の登録処理を行うモデルクラスです。
 * @author 此上
 */

public class RegisterDAO {
	public int insert(CustomerBean customerBean)
			throws SQLException, ClassNotFoundException {

		int insertCount = 0; //処理件数
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(" m_customer ");
		sb.append("(customer_name ");
		sb.append(",customer_name_kana ");
		sb.append(",postal_code ");
		sb.append(",address ");
		sb.append(",area_code ");
		sb.append(",contact_person_name ");
		sb.append(",contact_person_name_kana ");
		sb.append(",contact_person_tel ");
		sb.append(",user_id) ");
		sb.append("VALUES ");
		sb.append("(?,?,?,?,?,?,?,?,?); ");
		String sql = sb.toString();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, customerBean.getCustomerName());
			pstmt.setString(2, customerBean.getCustomerNameKana());
			pstmt.setString(3, customerBean.getPostalCode());
			pstmt.setString(4, customerBean.getAddress());
			pstmt.setString(5, customerBean.getAreaCode());
			pstmt.setString(6, customerBean.getContactPersonName());
			pstmt.setString(7, customerBean.getContactPersonNameKana());
			pstmt.setString(8, customerBean.getContactPersonTel());
			pstmt.setString(9, customerBean.getUserId());

			insertCount = pstmt.executeUpdate();
		}
		return insertCount;
	}

	public int selectId(String customerName) throws SQLException, ClassNotFoundException {
		String sql = "SELECT customer_id FROM m_customer WHERE customer_name = ?";
		int customerId = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			// プレースホルダへの値の設定
			pstmt.setString(1, customerName);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				customerId  = res.getInt("customer_id");
			}
		}
		return customerId;
	}
}
