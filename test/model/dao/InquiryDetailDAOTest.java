package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.InquiryBean;

/**
 * t_inquiryテーブルから編集する問合せ情報を検索するDAOのテストクラス
 * @author 此上
 */

class InquiryDetailDAOTest {

	@Test
	void testInquiryDetail() {
		InquiryDetailDAO dao = new InquiryDetailDAO();
		InquiryBean bean = new InquiryBean();
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			bean = dao.detail(1);
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("t_inquiry.csv");
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

					assertEquals(Integer.parseInt(data[0]), bean.getInquiryId());
					assertEquals(Integer.parseInt(data[1]), bean.getCustomerId());
					assertEquals(data[2], bean.getCustomerName());

					String inputDateString = data[3];
					Timestamp ts = Timestamp.valueOf(inputDateString);

					assertEquals(ts, bean.getInquiryDatetime());
					assertEquals(data[4], bean.getInquiryContents());
					assertEquals(data[5], bean.getReplyContents());
					assertEquals(data[6], bean.getStatusCode());
					assertEquals(data[7], bean.getStatusName());
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
	void testStatusList() {
		InquiryDetailDAO dao = new InquiryDetailDAO();
		List<InquiryBean> statusList = new ArrayList<InquiryBean>();

		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			statusList = dao.statusList();
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("inquiryDetailStatusList.csv");
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
