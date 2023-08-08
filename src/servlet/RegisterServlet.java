package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.RegisterDAO;
import model.entity.CustomerBean;

/**
 * Servlet implementation class RegisterServlet
 */

/**
 * 顧客情報の登録処理を行うコントロールクラスです。
 * @author 此上
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// DAOのインスタンス化
		RegisterDAO registerDao = new RegisterDAO();
		// Beanのインスタンス化
		CustomerBean customerBean = new CustomerBean();

		//入力された顧客情報をbeanにセット
		String[] arrayArea = request.getParameter("area").split(",");
		String[] arrayUser = request.getParameter("user").split(",");

		customerBean.setCustomerName(request.getParameter("customerName"));
		customerBean.setCustomerNameKana(request.getParameter("customerNameKana"));
		customerBean.setPostalCode(request.getParameter("postalCode"));
		customerBean.setAreaCode(arrayArea[0]);
		customerBean.setAreaName(arrayArea[1]);
		customerBean.setContactPersonName(request.getParameter("contactPersonName"));
		customerBean.setContactPersonNameKana(request.getParameter("contactPersonNameKana"));
		customerBean.setContactPersonTel(request.getParameter("contactPersonTel"));
		customerBean.setUserId(arrayUser[0]);
		customerBean.setUserId(arrayUser[1]);

		int insertCount = 0;//処理件数

		try {
			insertCount = registerDao.insert(customerBean);//登録処理
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 顧客情報の登録情報をセッションに設定
		session.setAttribute("registerBean", customerBean);


		// 遷移先画面の分岐
		if (insertCount > 0) {
			response.sendRedirect(request.getContextPath() + "/register-success.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/register-failure.jsp");
		}
	}

}
