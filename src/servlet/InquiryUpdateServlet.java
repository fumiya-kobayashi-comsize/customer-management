package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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
		Date datetime = datetime(inquiryDatetime);
		Timestamp ts = new Timestamp(datetime.getTime());

		// 変更情報をbeanにセット
		inquiryBean.setInquiryId(Integer.parseInt(request.getParameter("inquiryId")));
		inquiryBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		inquiryBean.setInquiryDatetime(ts);
		inquiryBean.setInquiryContents(request.getParameter("inquiryContents"));
		inquiryBean.setReplyContents(request.getParameter("replyContents"));
		inquiryBean.setStatusName(request.getParameter("statusName"));
		inquiryBean.setStatusCode(request.getParameter("statusCode"));

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

	public static Date datetime(String datetime) {
		Date date = null;
        try {
            String strDate = datetime;

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) sdFormat.parse(strDate);

        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
