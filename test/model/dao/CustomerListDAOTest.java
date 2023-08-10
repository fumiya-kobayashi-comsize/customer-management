package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CustomerBean;

class CustomerListDAOTest {

	@Test
	void testselectAll() {
		List<CustomerBean> customerList = new ArrayList<CustomerBean>();
		CustomerListDAO customerListDAO = new CustomerListDAO();

		//ファイル読み込みで使用する３つのクラス
		//指定したファイルをバイナリファイル(PC語、0と1で表されるデータ形式)として読み込むクラス
		FileInputStream fi = null;
		//指定したストリームを指定した文字コードのテキストファイルとして読み込むクラス
		InputStreamReader is = null;
		//テキストファイルを読み込むクラス
		//BufferedReaderクラスのreadlineメソッドを使うことでテキストファイルを1行ずつ読み込む
		BufferedReader br = null;

	try {
		customerList = customerListDAO.selectAll();

		//読み込みファイルのインスタンス生成
		//ファイル名("m_customer.csv")を指定し、バイナリファイル( fi )として読み込む
		fi = new FileInputStream("m_customer.csv");
		//読み込んだバイナリファイル( fi )を指定した文字コード("UTF-8")のテキストファイル( is )として読み込む
		is = new InputStreamReader(fi, "UTF-8");
		//読み込んだテキストファイル( is )を読み込む
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

				assertEquals(Integer.parseInt(data[0]),  customerList.get(i - 1).getCustomerId());
				assertEquals(data[1], customerList.get(i - 1).getCustomerName());
				assertEquals(data[2], customerList.get(i - 1).getCustomerNameKana());
				assertEquals(data[3], customerList.get(i - 1).getPostalCode());
				assertEquals(data[4], customerList.get(i - 1).getAddress());
				assertEquals(data[5], customerList.get(i - 1).getAreaCode());
				assertEquals(data[6], customerList.get(i - 1).getAreaName());
				assertEquals(data[7], customerList.get(i - 1).getContactPersonName());
				assertEquals(data[8], customerList.get(i - 1).getContactPersonNameKana());
				assertEquals(data[9], customerList.get(i - 1).getContactPersonTel());
				assertEquals(data[10], customerList.get(i - 1).getUserId());
				assertEquals(data[11], customerList.get(i - 1).getUserName());

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

}

