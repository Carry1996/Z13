package com.timor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timor.factory.DaoFactory;
import com.timor.vo.User;

public class ShowInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String path="person_info.jsp";
		
		User pre_userinfo=null;
		String uno=(String)request.getSession().getAttribute("uno");
//		String uno="161530309";
		try {
			if(DaoFactory.getIUserDaoInstance().findByUno(uno)!=null){
				pre_userinfo=new User();
				pre_userinfo=DaoFactory.getIUserDaoInstance().findByUno(uno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pre_userinfo", pre_userinfo);
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
