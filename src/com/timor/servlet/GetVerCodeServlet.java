package com.timor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timor.factory.DaoFactory;
import com.timor.library.Email;

/**
 * Servlet implementation class GetVerCodeServlet
 */

public class GetVerCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVerCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter(); 
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        try {
        if(username == null || "".equals(username)){
        	out.print("学号不能为空");   
			out.flush();
			out.close();
		} else if (DaoFactory.getIUserDaoInstance().findByUno(username) == null) {
			out.print("没有该用户");
			out.flush();
			out.close();
		}
		else if (email == null || "".equals(email)) {
			out.print("邮箱不能为空");
			out.flush();
			out.close();
		} else if (!DaoFactory.getIUserDaoInstance().findPasswordByUno(username, email)) {
			out.print("邮箱错误");
			out.flush();
			out.close();		
		}
		else if (DaoFactory.getIUserDaoInstance().findPasswordByUno(username, email)) {
			int rand1 = (int)(100000+Math.random()*(999999-100000+1));
			Email mail = new Email(email,String.valueOf(rand1));
			request.getSession().setAttribute("secretcode", rand1);
			request.getSession().setAttribute("uno", username);
			mail.Send();
			out.flush();
			out.close();
		}
        } catch (Exception e) {
				e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
