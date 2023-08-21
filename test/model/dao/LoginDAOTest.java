package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * LoginDAOのTestクラスです。
 * @author 吉田
 */


class LoginDAOTest {

	@Test
	void test1LoginCheck() {
		LoginDAO loginDao = new LoginDAO();
		boolean loginCheck =false;
		try {
			loginCheck = loginDao.loginCheck("1234","da63e2fb4169549cf2204d3ba4766405");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		assertEquals(true,loginCheck);
	}

	@Test
	void test2LoginCheck() {
		LoginDAO loginDao = new LoginDAO();
		boolean loginCheck =false;
		try {
			loginCheck = loginDao.loginCheck("","");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		assertEquals(false,loginCheck);

	}

}
