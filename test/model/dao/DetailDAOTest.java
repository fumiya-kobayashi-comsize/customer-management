package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import model.entity.CustomerBean;
import model.entity.UserBean;

class DetailDAOTest {

	@Disabled
	@Test
	void test1Detail() {
		CustomerBean detailbean = new CustomerBean();
		DetailDAO detailDao = new DetailDAO();

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			detailbean = detailDao.detail(16);
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("detail.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i != 0) {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");


					assertEquals(Integer.parseInt(data[0]), detailbean.getCustomerId());
					assertEquals(data[1], detailbean.getCustomerName());
					assertEquals(data[2], detailbean.getCustomerNameKana());
					assertEquals(data[3], detailbean.getPostalCode());
					assertEquals(data[4], detailbean.getAddress());
					assertEquals(data[5], detailbean.getAreaName());
					assertEquals(data[6], detailbean.getAreaCode());
					assertEquals(data[7], detailbean.getContactPersonName());
					assertEquals(data[8], detailbean.getContactPersonNameKana());
					assertEquals(data[9], detailbean.getContactPersonTel());
					assertEquals(data[10], detailbean.getUserName());
					assertEquals(data[11], detailbean.getUserId());
				}

				//行数のインクリメント
				i++;

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Disabled
	@Test
	void test2Detail() {
		CustomerBean detailbean = new CustomerBean();
		DetailDAO detailDao = new DetailDAO();

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			detailbean = detailDao.detail(16);
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("detail.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//読み込み行
			String line;

			//読み込み行数の管理
			int i = 0;

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//先頭行は列名
				if (i != 1) {

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");


					assertEquals(Integer.parseInt(data[0]), detailbean.getCustomerId());
					assertEquals(data[1], detailbean.getCustomerName());
					assertEquals(data[2], detailbean.getCustomerNameKana());
					assertEquals(data[3], detailbean.getPostalCode());
					assertEquals(data[4], detailbean.getAddress());
					assertEquals(data[5], detailbean.getAreaName());
					assertEquals(data[6], detailbean.getAreaCode());
					assertEquals(data[7], detailbean.getContactPersonName());
					assertEquals(data[8], detailbean.getContactPersonNameKana());
					assertEquals(data[9], detailbean.getContactPersonTel());
					assertEquals(data[10], detailbean.getUserName());
					assertEquals(data[11], detailbean.getUserId());
				}

				//行数のインクリメント
				i++;

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	void testUserList() {
		DetailDAO detailDao = new DetailDAO();
		List<UserBean> userList = new ArrayList<UserBean>();

		try {
			userList = detailDao.userList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("121314", userList.get(0).getUserId());
		assertEquals("伊藤", userList.get(0).getUserName());
	}


	@Test
	void testAreaList() {
		DetailDAO detailDao = new DetailDAO();
		List<CustomerBean> customerList = new ArrayList<CustomerBean>();

		try {
			customerList = detailDao.areaList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals("A100", customerList.get(0).getAreaCode());
		assertEquals("北関東", customerList.get(0).getAreaName());
	}
}
