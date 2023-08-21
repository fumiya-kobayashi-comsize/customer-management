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

import model.dao.InquiryDetailDAO;
import model.entity.InquiryBean;

/**
 * Servlet implementation class InquiryDetailServlet
 */
@WebServlet("/InquiryDetailServlet")
public class InquiryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InquiryDetailServlet() {
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
		InquiryDetailDAO inquiryDetailDao = new InquiryDetailDAO();

		try {

			//customerIdを取得
			InquiryBean inquiryBean = inquiryDetailDao.detail(Integer.parseInt(request.getParameter("CustomerId")));

			//編集する顧客情報をセッションに入れる
			HttpSession session =request.getSession();
			session.setAttribute("inquiryDetailBean", inquiryBean);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("inquiry-update.jsp");
		rd.forward(request, response);
	}

}
