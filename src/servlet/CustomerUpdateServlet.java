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

import model.dao.UpdateDAO;
import model.entity.CustomerBean;

/**
 * Servlet implementation class CustomerUpdateServlet
 */
@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
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
		request.setCharacterEncoding("UTF-8");

		int count = 0;

		UpdateDAO updatedao = new UpdateDAO();
		CustomerBean updateBean = new CustomerBean();

		String[] userArray = request.getParameter("user").split(",");
		String[] areaArray = request.getParameter("area").split(",");

		HttpSession session = request.getSession();

		updateBean.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		updateBean.setCustomerName(request.getParameter("customerName"));
		updateBean.setCustomerNameKana(request.getParameter("customerNameKana"));
		updateBean.setPostalCode(request.getParameter("postalCode"));
		updateBean.setAddress(request.getParameter("address"));
		updateBean.setAreaCode(areaArray[0]);
		updateBean.setAreaName(areaArray[1]);
		updateBean.setContactPersonName(request.getParameter("contactPersonName"));
		updateBean.setContactPersonNameKana(request.getParameter("contactPersonNameKana"));
		updateBean.setContactPersonTel(request.getParameter("contactPersonTel"));
		updateBean.setUserId(userArray[0]);
		updateBean.setUserName(userArray[1]);

		try {
			count = updatedao.update(updateBean);


		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}

		session.setAttribute("updateBean",updateBean);

		if (count > 0) {

			RequestDispatcher rd = request.getRequestDispatcher("update-success.jsp");
			rd.forward(request, response);

		}else {

			RequestDispatcher rd = request.getRequestDispatcher("update-failure.jsp");
			rd.forward(request, response);

		}

	}

}
