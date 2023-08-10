package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DeleteDAOTest {

	@Disabled
	@Test
	void testDetail() {
		DeleteDAO dao = new DeleteDAO();
		int processingNumber = 0;
		try {
			processingNumber = dao.deleteCustmor(10);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, processingNumber);
	}



}
