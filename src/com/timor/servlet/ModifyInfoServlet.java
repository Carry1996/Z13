package com.timor.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.timor.factory.DaoFactory;
import com.timor.vo.User;

public class ModifyInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ModifyInfoServlet() {
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
		String path="person_info_modify.jsp";
		
		boolean flag=false;
		String uno=(String)request.getSession().getAttribute("uno");
//		String uno="161530309";//测试用
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
        try {
			su.upload();
		//	su.save("D:\\课程\\计算机学科\\卓越班\\项目\\Weshare\\WebRoot\\images");
			su.save("C:\\Users\\张万鹏\\workspace\\Zz\\WebContent\\headerimg");
		} catch (SmartUploadException e1) {
			e1.printStackTrace();
		}
        
        String img_addr=su.getFiles().getFile(0).getFileName();
		String nickname = su.getRequest().getParameter("new_nickname");
		String phone = su.getRequest().getParameter("new_phone");
        try {
        	if (DaoFactory.getIUserDaoInstance().changeNickname(uno, nickname)&&DaoFactory.getIUserDaoInstance().changePhone(uno, phone)&&DaoFactory.getIUserDaoInstance().changeImgUrl(img_addr, uno)) {
        		flag=true;//new_userinfo.add(true);
        	} else {
        		flag=false;//new_userinfo.add(false);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		request.setAttribute("flag", flag);
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
