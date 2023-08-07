package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.CustomerBean;



public class UpdateDAO {
	public int update(CustomerBean updateBean)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE m_customer SET customer_name =?, "
				+ "customer_name_kana =?, postal_code =? "
				+ "address =?, area_code =?, contact_person_name =?"
				+ "contact_person_name_kana =?, contact_person_tel =?, user_id =?"
				+ "WHERE customer_id =?";

		int count = 0;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, updateBean.getCustomerName());
			pstmt.setString(2, updateBean.getCustomerNameKana());
			pstmt.setString(3, updateBean.getPostalCode());
			pstmt.setString(4, updateBean.getAddress());
			pstmt.setString(5, updateBean.getAreaCode());
			pstmt.setString(6, updateBean.getContactPersonName());
			pstmt.setString(7, updateBean.getContactPersonNameKana());
			pstmt.setString(8, updateBean.getUserId());
			pstmt.setInt(9,updateBean.getCustomerId());

			count = pstmt.executeUpdate();
		}
		return count;
	}
}
