package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.CustomerBean;

/**
 * m_customerテーブルに顧客情報を登録するDAOクラスのテストクラス
 * @author 此上
 */

class RegisterDAOTest {

	@Test
	void test1Insert() {
		//読み込みファイルのインスタンス生成
		RegisterDAO registerDao = new RegisterDAO();
		CustomerBean customerBean = new CustomerBean();
		int insertCount = 0; //処理件数

		customerBean.setCustomerName("会社A");
		customerBean.setCustomerNameKana("かいしやえー");
		customerBean.setPostalCode("000-0000");
		customerBean.setAddress("東京都千代田区");
		customerBean.setAreaCode("A100");
		customerBean.setContactPersonName("担当者A");
		customerBean.setContactPersonNameKana("たんとうしやえー");
		customerBean.setContactPersonTel("00011112222");
		customerBean.setUserId("1234");

		try {
			insertCount = registerDao.insert(customerBean);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//(期待値、実際の値)
		assertEquals(1, insertCount);
	}

	@Test
	void test2Insert() {
		//読み込みファイルのインスタンス生成
		RegisterDAO registerDao = new RegisterDAO();
		CustomerBean customerBean = new CustomerBean();
		int insertCount = 0; //処理件数

		customerBean.setCustomerName("会社A");
		customerBean.setCustomerNameKana("かいしやえー");
		customerBean.setPostalCode("000-00000");
		customerBean.setAddress("東京都千代田区");
		customerBean.setAreaCode("A100");
		customerBean.setContactPersonName("担当者A");
		customerBean.setContactPersonNameKana("たんとうしやえー");
		customerBean.setContactPersonTel("00011112222");
		customerBean.setUserId("1234");

		try {
			insertCount = registerDao.insert(customerBean);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//(期待値、実際の値)
		assertEquals(0, insertCount);
	}

}
