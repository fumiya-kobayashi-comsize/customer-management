package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * DeleteDAOのTestクラスです。
 * @author 吉田、竹内
 */


class DeleteDAOTest {

	@Test
	void testDetail1() {
		DeleteDAO dao = new DeleteDAO();
		int processingNumber = 0;
		try {
			processingNumber = dao.foreignDelete(1);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, processingNumber);
	}


	@Test
	void testDetail2() {
		DeleteDAO dao = new DeleteDAO();
		int processingNumber = 0;
		try {
			processingNumber = dao.deleteCustmor(1);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, processingNumber);
	}



}
