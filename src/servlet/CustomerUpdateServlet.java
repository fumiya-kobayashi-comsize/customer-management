package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UpdateDAO;
import model.entity.CustomerBean;

/**
 * 顧客情報の編集を行う
 * @author 竹内
 */
@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//処理件数
		int count = 0;

		UpdateDAO updatedao = new UpdateDAO();
		CustomerBean updateBean = new CustomerBean();
		HttpSession session = request.getSession();

		// 選択されたカテゴリとコードを取得し、カンマ区切りで配列に分割
		String[] userArray = request.getParameter("user").split(",");
		String[] areaArray = request.getParameter("area").split(",");

		// 変更情報をbeanにセット
		updateBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		updateBean.setCustomerName(request.getParameter("customerName"));
		updateBean.setCustomerNameKana(request.getParameter("customerNameKana"));
		updateBean.setPostalCode(request.getParameter("postalCode"));
		updateBean.setAddress(request.getParameter("address"));
		updateBean.setAreaCode(areaArray[0]);
		updateBean.setAreaName(areaArray[1]);
		updateBean.setContactPersonName(request.getParameter("contactPersonName"));
		updateBean.setContactPersonNameKana(request.getParameter("contactPersonNameKana"));
		updateBean.setContactPersonTel(request.getParameter("contactPersonTel"));
		updateBean.setUserId(userArray[0]);
		updateBean.setUserName(userArray[1]);

		try {
			count = updatedao.update(updateBean);


		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//beanをセッションに入れる
		session.setAttribute("updateBean",updateBean);

		//処理件数によって結果を分岐
		if (count > 0) {

			RequestDispatcher rd = request.getRequestDispatcher("update-success.jsp");
			rd.forward(request, response);

		}else {

			RequestDispatcher rd = request.getRequestDispatcher("update-failure.jsp");
			rd.forward(request, response);

		}

	}

}
