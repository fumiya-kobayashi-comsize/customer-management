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
 * 削除する問合せ情報を表示するコントロールクラス
 * @author 此上
 */

/**
 * Servlet implementation class InquiryDeleteDetailServlet
 */
@WebServlet("/InquiryDeleteDetailServlet")
public class InquiryDeleteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryDeleteDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InquiryDetailDAO inquiryDetailDao = new InquiryDetailDAO();
		try {

			//inquiryIdを取得
			InquiryBean inquiryBean = inquiryDetailDao.detail(Integer.parseInt(request.getParameter("inquiryId")));

			//編集する顧客情報をセッションに入れる
			HttpSession session = request.getSession();
			session.setAttribute("inquiryDeleteDetailBean", inquiryBean);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("inquiry-delete.jsp");
		rd.forward(request, response);
	}
}
