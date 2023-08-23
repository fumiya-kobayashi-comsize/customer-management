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

import model.dao.DeleteDAO;
import model.dao.DetailDAO;
import model.entity.CustomerBean;

/**
 * 削除処理をするコントロール
 * @author 吉田
 */
/**
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
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

		// リクエストのエンコーディング方式を指定
			request.setCharacterEncoding("UTF-8");

			DeleteDAO dao = new DeleteDAO();
			DetailDAO detailDao = new DetailDAO();
			CustomerBean customerBean = new CustomerBean();

			int processingNumber = 0; //処理件数
			try {

				//customerIdを取得
				customerBean = detailDao.detail(Integer.parseInt(request.getParameter("CustomerId")));


				processingNumber = dao.foreignDelete(Integer.parseInt(request.getParameter("CustomerId")));

				// 削除処理
				processingNumber = dao.deleteCustmor(Integer.parseInt(request.getParameter("CustomerId")));

				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				// 処理件数をリクエストスコープに設定
				request.setAttribute("processingNumber", processingNumber);

				//削除する顧客情報をセッションに設定ｐ
				HttpSession session =request.getSession();
				session.setAttribute("deletebean", customerBean);


				// 削除結果画面に遷移

				if (processingNumber == 0){
					RequestDispatcher rd = request.getRequestDispatcher("delete-failure.jsp");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("delete-success.jsp");
					rd.forward(request, response);


				}


			}

}
