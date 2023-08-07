package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

/**
 * m_customerテーブルのDAOです。
 * @author 竹内
 */

public class CustomerListDAO {
	/**
	 * すべての顧客情報のリストを返します。
	 * @return 顧客情報のリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public List<CustomerBean> selectAll()
			throws SQLException, ClassNotFoundException{

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();

		String sql = "SELECT t1.customer_id, t1.customer_name, t1.customer_name_kana,"
				+ " t1.postal_code, t1.address, t1.area_code, t2.area_name,"
				+ " t1.contact_person_name, t1.contact_person_name_kana,"
				+ " t1.contact_person_tel,t1.user_id, t3.user_name "
				+ " FROM m_customer t1 JOIN m_area t2 ON t1.area_code = t2.area_code "
				+ " JOIN m_user t3 ON t1.user_id = t3.user_id";

		//DB接続
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				CustomerBean customerbean = new CustomerBean();
				customerbean.setCustomerId(res.getInt("customer_id"));
				customerbean.setCustomerName(res.getString("customer_name"));
				customerbean.setCustomerNameKana(res.getString("customer_name_kana"));
				customerbean.setPostalCode(res.getString("postal_code"));
				customerbean.setAddress(res.getString("address"));
				customerbean.setAreaCode(res.getString("area_code"));
				customerbean.setAreaName(res.getString("area_name"));
				customerbean.setContactPersonName(res.getString("contact_person_name"));
				customerbean.setContactPersonNameKana(res.getString("contact_person_name_kana"));
				customerbean.setContactPersonTel(res.getString("contact_person_tel"));
				customerbean.setUserId(res.getString("user_id"));
				customerbean.setUserName(res.getString("user_name"));

				customerList.add(customerbean);
			}
		}
		return customerList;
	}

}
