package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.CustomerBean;

/**
 * m_customerテーブルのDAOです。
 * @author 竹内
 */

public class UpdateDAO {
	/**
	 * updateした処理件数を返します。
	 * @param 変更する情報（updateBean）
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public int update(CustomerBean updateBean)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE m_customer SET customer_name =?, "
				+ " customer_name_kana =?, postal_code =?, "
				+ " address =?, area_code =?, contact_person_name =?, "
				+ " contact_person_name_kana =?, contact_person_tel =?, user_id =? "
				+ " WHERE customer_id =?";

		//処理件数
		int count = 0;

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダへの値の設定
			pstmt.setString(1,updateBean.getCustomerName());
			pstmt.setString(2,updateBean.getCustomerNameKana());
			pstmt.setString(3,updateBean.getPostalCode());
			pstmt.setString(4,updateBean.getAddress());
			pstmt.setString(5,updateBean.getAreaCode());
			pstmt.setString(6,updateBean.getContactPersonName());
			pstmt.setString(7,updateBean.getContactPersonNameKana());
			pstmt.setString(8,updateBean.getContactPersonTel());
			pstmt.setString(9,updateBean.getUserId());
			pstmt.setInt(10,updateBean.getCustomerId());

			count = pstmt.executeUpdate();
		}
		return count;
	}
}
