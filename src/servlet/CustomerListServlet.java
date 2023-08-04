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

import model.dao.CustomerListDAO;
import model.entity.CustomerBean;


/**
 * 顧客情報一覧を表示
 * @author 竹内
 */
@WebServlet("/customer-list-servlet")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
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
		List<CustomerBean> customerList = null;
		CustomerListDAO listDao = new CustomerListDAO();

		try {
			//customerListの取得
			customerList = listDao.selectAll();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
		//customerListをセッションに入れる
		HttpSession session = request.getSession();
		session.setAttribute("customerList", customerList);

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("customer-list.jsp");
		rd.forward(request, response);

	}


}
