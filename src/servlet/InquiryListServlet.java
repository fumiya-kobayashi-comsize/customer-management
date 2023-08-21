package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InquiryListDAO;
import model.entity.InquiryBean;

/**
 * Servlet implementation class InquiryListServlet
 */
@WebServlet("/InquiryListServlet")
public class InquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryListServlet() {
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

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		//DAO、Bean生成
		InquiryListDAO inquiryListDao = new InquiryListDAO();

		//リスト作成
		List<InquiryBean> inquiryList = new ArrayList<InquiryBean>();

		try {
			inquiryList = inquiryListDao.selectInquiry();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		//Listをセッションに設定
		session.setAttribute("inquiryList", inquiryList);

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("inquiry-list.jsp");
		rd.forward(request, response);
	}
}
