package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import model.entity.InquiryBean;

/**
 * t_inquiryテーブルから編集する問合せ情報を検索するDAOのテストクラス
 * @author 此上
 */

class InquiryUpdateDAOTest {

	@Test
	void test() {
		InquiryUpdateDAO dao = new InquiryUpdateDAO();
		InquiryBean inquiryResult = new InquiryBean();

		String inputDateString = "2023-08-01 12:00:00";
		Timestamp ts = Timestamp.valueOf(inputDateString);

		inquiryResult.setInquiryDatetime(ts);
		inquiryResult.setInquiryContents("テスト１");
		inquiryResult.setReplyContents("テスト１");
		inquiryResult.setStatusCode("00");
		inquiryResult.setInquiryId(1);
		int count = 0;
		try {
			count = dao.update(inquiryResult);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//(期待値、実際の値)
		assertEquals(1, count);
	}

}
