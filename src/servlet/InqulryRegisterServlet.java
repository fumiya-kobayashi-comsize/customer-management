package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InqulryRegisterDAO;
import model.entity.InquiryBean;


/**
 * Servlet implementation class InqulryRegisterServlet
 */

/**
 * 問合せ情報の登録処理を行うコントロールクラスです。
 * @author 吉田
 */
@WebServlet("/InqulryRegisterServlet")
public class InqulryRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InqulryRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//DAO生成
			InqulryRegisterDAO inqulryDao = new InqulryRegisterDAO();
		//リスト作成
			List<InquiryBean> statusList = null;

			try {
			//t_inquiryテーブルのリストをセッションにセット
			HttpSession session =request.getSession();
			statusList = inqulryDao.statusList();
			session.setAttribute("inqulryStatusList", statusList);

			} catch (SQLException | ClassNotFoundException e) {

				e.printStackTrace();

				}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("inqulry-register.jsp");
			rd.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		// DAOのインスタンス化
		InqulryRegisterDAO inqulryDao = new InqulryRegisterDAO();
		// Beanのインスタンス化
		InquiryBean inqulryregisterBean = new InquiryBean();

		//入力された問合せ情報をbeanにセット
		String[] arrayStatus = request.getParameter("status").split(",");

		String inquiryDatetime = request.getParameter("inquiryDatetime");
		Timestamp ts = Timestamp.valueOf(inquiryDatetime);



		inqulryregisterBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		inqulryregisterBean.setInquiryDatetime(ts);
		inqulryregisterBean.setInquiryContents(request.getParameter("inquiryContents"));
		inqulryregisterBean.setReplyContents(request.getParameter("replyContents"));
		inqulryregisterBean.setStatusCode(request.getParameter("statusCode"));
		inqulryregisterBean.setStatusCode(arrayStatus[0]);
		inqulryregisterBean.setStatusName(arrayStatus[1]);


			int inquryinsertCount = 0;//処理件数

			try {
				inquryinsertCount = inqulryDao.insert(inqulryregisterBean);//登録処理
				inqulryregisterBean.setInquiryId(inqulryDao.selectId(inqulryregisterBean.getCustomerId()));
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();
				// 顧客情報の登録情報をセッションに設定
				session.setAttribute("inqulryregisterBean", inqulryregisterBean);


				// 遷移先画面の分岐
				if (inquryinsertCount > 0) {
					response.sendRedirect(request.getContextPath() + "inqulry-success.jsp");
				} else {
					response.sendRedirect(request.getContextPath() + "inqulry-failure.jsp");
				}
			}



}
