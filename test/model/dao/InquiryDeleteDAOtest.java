package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * InquiryDeleteDAOのTestクラスです。
 * @author 此上
 */


class InquiryDeleteDAOTest{

	@Test
	void testInquiryDelete() {
		InquiryDeleteDAO dao = new InquiryDeleteDAO();
		int inquiryDeleteCount = 0; //処理件数
		try {
			inquiryDeleteCount = dao.inquiryDelete(1);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, inquiryDeleteCount);
	}

}
