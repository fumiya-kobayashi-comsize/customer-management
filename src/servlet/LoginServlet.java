package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

		String pass = null;

		try {
			//入力されたパスワード(String password)とsalt(String userId)を送り、
			//ハッシュ化したパスワード(String pass)を受け取る
			pass = hash(password + userId);

			// DAOの生成
			LoginDAO loginDao = new LoginDAO();

			// DAOの利用
			if (loginDao.loginCheck(userId, pass)) {
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

	/**
	 * パスワードをハッシュ化する。
	 *
	 * @param password パスワード
	 * @return pass ハッシュ化されたパスワード
	 * @throws NoSuchAlgorithmException
	 */
	public String hash(String password) throws NoSuchAlgorithmException {

		 MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		 //passwordをbyte型で読み込む
		 messageDigest.update(password.getBytes());
		 //byte型の配列を作る
		 byte[] digest = messageDigest.digest();

		 //文字列を操作
		 StringBuffer buffer = new StringBuffer();
		 	for(int i = 0; i < digest.length; i++) {
		 		//16進数に変換
		 		String tmp = Integer.toHexString(digest[i] & 0xff);
		 		//16進数になった配列の要素をつなげる
		 		if(tmp.length() == 1) {
		 			buffer.append('0').append(tmp);
		 		} else {
		 			buffer.append(tmp);
		 		}
		 	}
		 	//String型で受け取る
		 	String pass = buffer.toString();

		 return pass;

	}

}

