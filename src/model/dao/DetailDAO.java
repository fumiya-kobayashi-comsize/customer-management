package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.CustomerBean;
/**
 * m_customerテーブルのDAOです。
 * @author 竹内
 */
public class DetailDAO {
	/**
	 * 編集する顧客情報を返します。
	 * @return 顧客情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CustomerBean detail(String CustomerId)
			throws SQLException, ClassNotFoundException{

		String sql ="SELECT t1.customer_id, t1.customer_name, t1.customer_name_kana,"
				+ " t1.postal_code, t1.address, t2.area_name, t1.contact_person_name,"
				+ " t1.contact_person_name_kana, t1.contact_person_tel, t3.user_name "
				+ " FROM m_customer t1 JOIN m_area t2 ON t1.area_code = t2.area_code "
				+ " JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ " WHERE t1.customer_id =?";

		CustomerBean detailbean = new CustomerBean();

		//DB接続
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {

			pstmt.setString(1, CustomerId);
			ResultSet res = pstmt.executeQuery();

			//結果の操作
			if(res.next()) {
				detailbean.setCustomerId(res.getInt("customer_id"));
				detailbean.setCustomerName(res.getString("customer_name"));
				detailbean.setCustomerNameKana(res.getString("customer_name_kana"));;
				detailbean.setPostalCode(res.getString("postal_code"));
				detailbean.setAddress(res.getString("address"));
				detailbean.setAreaName(res.getString("area_name"));
				detailbean.setContactPersonName(res.getString("contact_person_name"));
				detailbean.setContactPersonNameKana(res.getString("contact_person_name_kana"));
				detailbean.setContactPersonTel(res.getString("contact_person_tel"));
				detailbean.setUserName(res.getString("user_Name"));

			}
		}
		return detailbean;
	}

}
