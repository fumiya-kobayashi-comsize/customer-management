package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;


/**
 * ログイン認証処理を制御する
 * @author 吉田、竹内
 */
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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


		String url = null; //画面遷移先

		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");

		//HashPass.javaをインスタンス化
		HashPass hashpass = new HashPass();
		//ハッシュ化したパスワードの変数
		String pass = null;

		String hashSalt = null;
		String salt = "SopkHdb";


		try {
			//入力されたパスワード(String password)を送り、
			//ハッシュ化したパスワード(String pass)を受け取る
			pass = hashpass.hash(password);

			//ハッシュ化したパスワードとsaltを連結して再度ハッシュ化
			hashSalt = hashpass.hash(salt + pass);

			// DAOの生成
			LoginDAO loginDao = new LoginDAO();

			// DAOの利用
			if (loginDao.loginCheck(userId, hashSalt)) {
				// 認証成功
				url = "menu.jsp";

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションスコープへの属性の設定
				session.setAttribute("userId", userId);

				} else {
					// 認証失敗
					url = "login.jsp";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			// リクエストの転送
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

	}

}

