package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.CustomerBean;

/**
 * UpdateDAOのTestクラスです。
 * @author 竹内
 */

class UpdateDAOTest {


	@Test
	void test() {

		UpdateDAO updateDAO = new UpdateDAO();
		CustomerBean updateBean = new CustomerBean();

		updateBean.setCustomerName("株式会社A");
		updateBean.setCustomerNameKana("かぶしきがいしゃえー");
		updateBean.setPostalCode("1239806");
		updateBean.setAddress("埼玉県さいたま市");
		updateBean.setAreaCode("A400");
		updateBean.setContactPersonName("担当３");
		updateBean.setContactPersonNameKana("たんとうさん");
		updateBean.setContactPersonTel("09074659273");
		updateBean.setUserId("1234");
		updateBean.setCustomerId(1);

		int count = 0;

		try {
			count = updateDAO.update(updateBean);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		//(期待値、実際の値)
		assertEquals(1, count);

	}

}
