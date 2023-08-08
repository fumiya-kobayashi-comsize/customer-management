package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;
import model.entity.UserBean;
/**
 * m_customerテーブルのDAOです。
 * @author 竹内
 */
public class DetailDAO {
	/**
	 * 編集する顧客情報を返します。
	 * @param CustomerId
	 * @return そのCustomerIdの顧客情報
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public CustomerBean detail(String CustomerId)
			throws SQLException, ClassNotFoundException{

		String sql ="SELECT t1.customer_id, t1.customer_name, t1.customer_name_kana,"
				+ " t1.postal_code, t1.address, t2.area_name, t1.area_code,  t1.contact_person_name,"
				+ " t1.contact_person_name_kana, t1.contact_person_tel, t3.user_name, t1.user_id "
				+ " FROM m_customer t1 JOIN m_area t2 ON t1.area_code = t2.area_code "
				+ " JOIN m_user t3 ON t1.user_id = t3.user_id "
				+ " WHERE t1.customer_id =?";

		CustomerBean detailbean = new CustomerBean();

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {

			// プレースホルダへの値の設定
			pstmt.setString(1, CustomerId);
			ResultSet res = pstmt.executeQuery();

			//結果の操作
			if(res.next()) {

				//beanに値をセット
				detailbean.setCustomerId(res.getInt("customer_id"));
				detailbean.setCustomerName(res.getString("customer_name"));
				detailbean.setCustomerNameKana(res.getString("customer_name_kana"));;
				detailbean.setPostalCode(res.getString("postal_code"));
				detailbean.setAddress(res.getString("address"));
				detailbean.setAreaName(res.getString("area_name"));
				detailbean.setAreaCode(res.getString("area_code"));
				detailbean.setContactPersonName(res.getString("contact_person_name"));
				detailbean.setContactPersonNameKana(res.getString("contact_person_name_kana"));
				detailbean.setContactPersonTel(res.getString("contact_person_tel"));
				detailbean.setUserName(res.getString("user_Name"));
				detailbean.setUserId(res.getString("user_id"));

			}
		}
		return detailbean;
	}

	/**
	 * ユーザーリストを返します。
	 * @param なし
	 * @return user_id、user_nameのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<UserBean> userList()
			throws SQLException, ClassNotFoundException{

		List<UserBean> userList = new ArrayList<UserBean>();

		String sql = "SELECT user_id, user_name FROM m_user";

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				//beanのインスタンス化
				UserBean userbean = new UserBean();

				//beanに値をセット
				userbean.setUserId(res.getString("user_id"));
				userbean.setUserName(res.getString("user_name"));

				userList.add(userbean);
			}
		}
		return userList;
	}

	/**
	 * エリアリストを返します。
	 * @param なし
	 * @return area_code、area_nameのリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CustomerBean> areaList()
			throws SQLException, ClassNotFoundException{

		List<CustomerBean> areaList = new ArrayList<CustomerBean>();

		String sql = "SELECT area_code, area_name FROM m_area";

		//DB接続の取得、PreparedStatementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {

			//結果の操作
			while (res.next()) {

				//beanのインスタンス化
				CustomerBean areabean = new CustomerBean();

				//beanに値をセット
				areabean.setAreaCode(res.getString("area_code"));
				areabean.setAreaName(res.getString("area_name"));

				areaList.add(areabean);
			}
		}
		return areaList;
	}

}
