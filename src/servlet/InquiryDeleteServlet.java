package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InquiryDeleteDAO;
import model.entity.InquiryBean;

/**
 * Servlet implementation class InquiryDeleteServlet
 */
@WebServlet("/InquiryDeleteServlet")
public class InquiryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryDeleteServlet() {
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
		InquiryDeleteDAO inquiryDeleteDao = new InquiryDeleteDAO();
		InquiryBean InquiryBean = new InquiryBean();

		int inquiryDeleteCount = 0; //処理件数
		try {

			// 削除処理
			inquiryDeleteCount = inquiryDeleteDao.inquiryDelete(Integer.parseInt(request.getParameter("inquiryId")));

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 処理件数をリクエストスコープに設定
		request.setAttribute("inquiryDeleteCount", inquiryDeleteCount);

		// 削除結果画面に遷移

		if (inquiryDeleteCount == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("inquiry-delete-failure.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("inquiry-delete-success.jsp");
			rd.forward(request, response);
		}
	}
}
