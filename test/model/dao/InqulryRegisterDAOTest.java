package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CustomerBean;
import model.entity.InquiryBean;

/**
 * InqulryRegisterDAOのテストクラスです。
 * @author 吉田
 */

class InqulryRegisterDAOTest {

	@Test
	void testInqulryRegister() {

		InqulryRegisterDAO dao = new InqulryRegisterDAO();
		InquiryBean bean = new InquiryBean();

		bean.setCustomerId(1);

		String inputDateString = "2023-08-01 12:00:00";
		Timestamp ts = Timestamp.valueOf(inputDateString);

		bean.setInquiryDatetime(ts);
		bean.setInquiryContents("テスト１");
		bean.setReplyContents("テスト１");
		bean.setStatusCode("00");

		int inquryinsertCount =0; //登録処理

		try {
			inquryinsertCount = dao.insert(bean);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		//(期待値、実際の値)
		assertEquals(1, inquryinsertCount);

	}

	@Test
	void testCustomerList() {

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();
		InqulryRegisterDAO dao = new InqulryRegisterDAO();

		//ファイル読み込みで使用する３つのクラス
		//指定したファイルをバイナリファイル(PC語、0と1で表されるデータ形式)として読み込むクラス
			FileInputStream fi = null;
			//指定したストリームを指定した文字コードのテキストファイルとして読み込むクラス
			InputStreamReader is = null;
			//テキストファイルを読み込むクラス
			//BufferedReaderクラスのreadlineメソッドを使うことでテキストファイルを1行ずつ読み込む
			BufferedReader br = null;

			try {
				customerList= dao.customerList();

				//読み込みファイルのインスタンス生成
				//ファイル名("customerlist.csv")を指定し、バイナリファイル( fi )として読み込む
				fi = new FileInputStream("customerlist.csv");
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

					}

					//行数のインクリメント
					i++;

				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}


	}

	@Test
	void testStatusList() {

		List<InquiryBean> statusList = new ArrayList<InquiryBean>();
		InqulryRegisterDAO dao = new InqulryRegisterDAO();

		//ファイル読み込みで使用する３つのクラス
		//指定したファイルをバイナリファイル(PC語、0と1で表されるデータ形式)として読み込むクラス
			FileInputStream fi = null;
		//指定したストリームを指定した文字コードのテキストファイルとして読み込むクラス
			InputStreamReader is = null;
		//テキストファイルを読み込むクラス
		//BufferedReaderクラスのreadlineメソッドを使うことでテキストファイルを1行ずつ読み込む
			BufferedReader br = null;

			try {
				statusList=dao.statusList();

		//読み込みファイルのインスタンス生成
		//ファイル名("statuslist.csv")を指定し、バイナリファイル( fi )として読み込む
			fi = new FileInputStream("statuslist.csv");
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

				assertEquals(data[0], statusList.get(i - 1).getStatusCode());
				assertEquals(data[1], statusList.get(i - 1).getStatusName());

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
