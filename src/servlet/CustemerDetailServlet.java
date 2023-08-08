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
import model.entity.CustomerBean;
import model.entity.UserBean;

/**
 * 編集する顧客情報を表示
 * @author 竹内
 */
@WebServlet("/custemer-detail-servlet")
public class CustemerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustemerDetailServlet() {
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
		DetailDAO dao = new DetailDAO();
		List<UserBean> userList = null;
		List<CustomerBean> areaList = null;

		try {

			//customerIdを取得
			CustomerBean detailbean = dao.detail(request.getParameter("CustomerId"));

			//編集する顧客情報をセッションに入れる
			HttpSession session =request.getSession();
			session.setAttribute("detailbean", detailbean);

			//ユーザーID、ユーザーNameのリストを取得
			userList = dao.userList();
			session.setAttribute("userList", userList);

			//area_code、area_nameのリストを取得
			areaList = dao.areaList();
			session.setAttribute("areaList", areaList);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("customer-update.jsp");
		rd.forward(request, response);
	}

}
