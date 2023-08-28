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

import model.dao.InquiryDetailDAO;
import model.entity.InquiryBean;

/**
 * 編集する問合せ情報を表示するコントロールクラス
 * @author 此上
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
		List<InquiryBean> updateStatusList = null;

		try {

			//inquiryIdを取得
			InquiryBean inquiryBean = inquiryDetailDao.detail(Integer.parseInt(request.getParameter("inquiryId")));
			updateStatusList = inquiryDetailDao.statusList();

			//編集する顧客情報をセッションに入れる
			HttpSession session =request.getSession();
			session.setAttribute("inquiryDetailBean", inquiryBean);
			session.setAttribute("updateStatusList", updateStatusList);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("inquiry-update.jsp");
		rd.forward(request, response);
	}

}
