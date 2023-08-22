package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InquiryUpdateDAO;
import model.entity.InquiryBean;

/**
 * 問合せ情報の編集を行う
 * @author 此上
 */
@WebServlet("/InquiryUpdateServlet")
public class InquiryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryUpdateServlet() {
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

		//処理件数
		int count = 0;

		InquiryUpdateDAO inquiryUpdateDao = new InquiryUpdateDAO();
		InquiryBean inquiryBean = new InquiryBean();
		HttpSession session = request.getSession();

		String inquiryDatetime = request.getParameter("inquiryDatetime");
		Timestamp ts = Timestamp.valueOf(inquiryDatetime);

		String[] arrayStatus = request.getParameter("status").split(",");

		// 変更情報をbeanにセット
		inquiryBean.setInquiryId(Integer.parseInt(request.getParameter("inquiryId")));
		inquiryBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		inquiryBean.setCustomerName(request.getParameter("customerName"));
		inquiryBean.setInquiryDatetime(ts);
		inquiryBean.setInquiryContents(request.getParameter("inquiryContents"));
		inquiryBean.setReplyContents(request.getParameter("replyContents"));
		inquiryBean.setStatusName(arrayStatus[1]);
		inquiryBean.setStatusCode(arrayStatus[0]);

		try {

			count = inquiryUpdateDao.update(inquiryBean);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//beanをセッションに入れる
		session.setAttribute("inquiryUpdateBean", inquiryBean);

		//処理件数によって結果を分岐
		if (count > 0) {

			RequestDispatcher rd = request.getRequestDispatcher("inquiry-update-success.jsp");
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("inquiry-update-failure.jsp");
			rd.forward(request, response);

		}
	}
}
