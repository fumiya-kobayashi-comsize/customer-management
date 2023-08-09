package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DetailDAO;
import model.dao.RegisterDAO;
import model.entity.CustomerBean;
import model.entity.UserBean;

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
		//DAO生成
		DetailDAO ditailDao = new DetailDAO();
		//リスト作成
		List<UserBean> userList = null;
		List<CustomerBean> areaList = null;

		try {
			//m_userテーブルとm_areaテーブルのリストをセッションにセット
			HttpSession session =request.getSession();
			userList = ditailDao.userList();
			session.setAttribute("registerUserList", userList);

			areaList = ditailDao.areaList();
			session.setAttribute("registerAreaList", areaList);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
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
		CustomerBean registerBean = new CustomerBean();

		//入力された顧客情報をbeanにセット
		String[] arrayArea = request.getParameter("area").split(",");
		String[] arrayUser = request.getParameter("user").split(",");

		registerBean.setCustomerName(request.getParameter("customerName"));
		registerBean.setCustomerNameKana(request.getParameter("customerNameKana"));
		registerBean.setPostalCode(request.getParameter("postalCode"));
		registerBean.setAddress(request.getParameter("address"));
		registerBean.setAreaCode(arrayArea[0]);
		registerBean.setAreaName(arrayArea[1]);
		registerBean.setContactPersonName(request.getParameter("contactPersonName"));
		registerBean.setContactPersonNameKana(request.getParameter("contactPersonNameKana"));
		registerBean.setContactPersonTel(request.getParameter("contactPersonTel"));
		registerBean.setUserId(arrayUser[0]);
		registerBean.setUserName(arrayUser[1]);

		int insertCount = 0;//処理件数

		try {
			insertCount = registerDao.insert(registerBean);//登録処理
			registerBean.setCustomerId(registerDao.selectId(registerBean.getCustomerName()));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		// 顧客情報の登録情報をセッションに設定
		session.setAttribute("registerBean", registerBean);


		// 遷移先画面の分岐
		if (insertCount > 0) {
			response.sendRedirect(request.getContextPath() + "/register-success.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/register-failure.jsp");
		}
	}

}
