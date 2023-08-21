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
			loginCheck = loginDao.loginCheck("1234","cf42cb5b11549c86f4c2aa8ffc7f8d3f");
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
