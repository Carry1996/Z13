/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timor.servlet;

import com.timor.factory.DaoFactory;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FindPasswordServlet", urlPatterns = {"/FindPasswordServlet"})
public class FindPasswordServlet extends HttpServlet {

   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        } catch (Exception e) {
				e.printStackTrace();
		}
     
//        request.setAttribute("username", username);
//        request.setAttribute("email", email);
//        request.getRequestDispatcher("forget_password.jsp").forward(request, response);
           
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }



}
