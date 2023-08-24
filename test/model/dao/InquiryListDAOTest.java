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
 * t_inquiryテーブルから表示する問合せ情報を検索するDAOのテストクラス
 * @author 此上
 */

class InquiryListDAOTest {

	@Test
	void testSelectInquiry() {
		List<InquiryBean> inquiryList = new ArrayList<InquiryBean>();
		InquiryListDAO dao = new InquiryListDAO();
		//ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {
			inquiryList = dao.selectInquiry();
			//読み込みファイルのインスタンス生成
			//ファイル名を指定する
			fi = new FileInputStream("inquiryList.csv");
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

					assertEquals(Integer.parseInt(data[0]), inquiryList.get(i - 1).getInquiryId());
					assertEquals(Integer.parseInt(data[1]), inquiryList.get(i - 1).getCustomerId());
					assertEquals(data[2], inquiryList.get(i - 1).getCustomerName());

					String inputDateString = data[3];
					Timestamp ts = Timestamp.valueOf(inputDateString);

					assertEquals(ts, inquiryList.get(i - 1).getInquiryDatetime());
					assertEquals(data[4], inquiryList.get(i - 1).getInquiryContents());
					assertEquals(data[5], inquiryList.get(i - 1).getReplyContents());
					assertEquals(data[6], inquiryList.get(i - 1).getStatusCode());
					assertEquals(data[7], inquiryList.get(i - 1).getStatusName());
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