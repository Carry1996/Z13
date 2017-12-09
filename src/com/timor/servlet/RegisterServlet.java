package com.timor.servlet;

import com.timor.factory.DaoFactory;
import com.timor.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 17-7-19.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            上传图片   手机号 bug

             */

    	resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter(); 
        String path = "login.html";
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        String uname = req.getParameter("uname");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String uno = req.getParameter("uno");
        String sex = req.getParameter("sex");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String regex = "[0-9]{11,11}";
        String img_addr = "1.jpg";
        try {
        if (uno == null || "".equals(uno) || uno.length() != 9) {
            out.print("请输入9位学号");   
    		out.flush();
    		out.close();
        }else if(DaoFactory.getIUserDaoInstance().findByUno(uno) != null){
    		out.print("用户名已存在");   
			out.flush();
			out.close();
        }else if (password1 == null || "".equals(password1)) {
            out.print("密码不能为空");   
			out.flush();
			out.close();
        }else if (password1.length() < 6 || password1.length() > 16) {
            out.print("请输入8-16位的密码");   
			out.flush();
			out.close();
        }else if (password2.equals(password1) != true) {
            out.print("两次输入的密码不一致");   
			out.flush();
			out.close();
        }else if (uname == null || "".equals(uname)) {
        	out.print("姓名不能为空");   
			out.flush();
			out.close();  
        }else if (uname.length() > 15 || uname.length() < 2) {
            out.print("请输入2-15位的姓名");   
			out.flush();
			out.close();
        }else if (phone == null || "".equals(phone)) {
        	out.print("手机号不能为空");   
			out.flush();
			out.close();
        }else if (phone.length() != 11 || !phone.matches(regex)) {
            out.print("请输入11位手机号");   
			out.flush();
			out.close();
 
        
        }else{
            User user = new User();
            user.setUno(uno);
            user.setUname(uname);
            user.setSex(sex);
            user.setPassword(password1);
            user.setEmail(email);
            user.setExp(0);
            user.setPhone(phone);
            user.setImg_addr(img_addr);
            
            	 if (!(DaoFactory.getIUserDaoInstance().register(user) && DaoFactory.getIUserDaoInstance().changeImgUrl(img_addr, uno))) {
                    out.print("注册失败");   
        			out.flush();
        			out.close();
                } else {
                	out.flush();
        			out.close();
                }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    //    req.setAttribute("info", info);
    //    req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

    }
}
