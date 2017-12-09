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
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        try {
        if(pass1 == null || "".equals(pass2) || pass1.length() < 8 || pass1.length() > 16){
        	out.print("请输入8到16位的新密码");   
			out.flush();
			out.close();
        }else if(!pass1.equals(pass2)){
        	out.print("两次填写的密码不一致");   
			out.flush();
			out.close();
		}else if(request.getSession().getAttribute("uno") == null){
			out.print("该用户不存在");   
			out.flush();
			out.close();
		}
        else if(DaoFactory.getIUserDaoInstance().resetPassword(request.getSession().getAttribute("uno").toString(), pass1)){
        	request.getSession().removeAttribute("uno");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
