package com.timor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timor.factory.DaoFactory;
import com.timor.vo.User;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter(); 
		String pathsuccess = "index.jsp";
		String pathfailure = "login.html";
		String uno = request.getParameter("username");
		String password = request.getParameter("password");
		List<String>info = new ArrayList<String>();
		if(uno == null || "".equals(uno)) {
			out.print("用户学号不能为空");   
			out.flush();
			out.close();
		}else if(password == null ||"".equals(password)){
			out.print("用户密码不能为空");   
			out.flush();
			out.close();
		}
		else{
			User user = new User();
			user.setUno(uno);
			user.setPassword(password);
			try {
				if(DaoFactory.getIUserDaoInstance().logIn(uno, password)) {
					request.getSession().setAttribute("uno", uno);
					out.flush();
					out.close();
				}else {
					out.print("用户名或密码错误");   
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		request.setAttribute("info", info);
//		request.getRequestDispatcher(pathfailure).forward(request, response);
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
