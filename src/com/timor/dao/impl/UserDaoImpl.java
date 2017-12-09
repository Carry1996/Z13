package com.timor.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.timor.dao.IUserDao;
import com.timor.vo.User;


public class UserDaoImpl implements IUserDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public boolean logIn(String uno, String password) throws Exception {
		boolean flag = false;
		try {
			String sql = "select uname from userinfo where uno = ? and password = ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, uno);
			this.ps.setString(2, password);
			ResultSet rs = this.ps.executeQuery();
			if (rs.next()) {
				rs.getString(1);
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.ps != null) {
				try {
					this.ps.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}	


	@Override
	public boolean register(User user) throws Exception {
		boolean flag = false;
		String sql = "insert into userinfo (uno,uname,phone,sex,password,email,exp,register_date) values (?,?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, user.getUno());
		this.ps.setString(2, user.getUname());
		this.ps.setString(3, user.getPhone());
		this.ps.setString(4, user.getSex());
		this.ps.setString(5, user.getPassword());
		this.ps.setString(6, user.getEmail());
		this.ps.setInt(7, user.getExp());
		this.ps.setDate(8, new java.sql.Date(new Date().getTime()));
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	public boolean findPasswordByUno(String uno, String email) throws Exception {
		boolean flag = false;
		String sql = "select * from userinfo where uno = ? and email = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		this.ps.setString(2, email);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			flag =true;
		}
		rs.close();
		this.ps.close();
		return flag;
	}

	@Override
	public boolean increaseExp(String uno) throws Exception {
		boolean flag = false;
		String sql_select = "select exp from userinfo where uno = ?";
		this.ps = this.conn.prepareStatement(sql_select);
		this.ps.setString(1,uno);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			int e = rs.getInt(1);
			ps.close();
			String sql_update = "update userinfo set exp = ? where uno = ?";
			this.ps = this.conn.prepareStatement(sql_update);
			this.ps.setInt(1, e+5);
			this.ps.setString(2, uno);
			if(this.ps.executeUpdate()>0){
				flag = true;
			}
		}
		rs.close();
		ps.close();
		return flag;
	}


	@Override
	public boolean resetPassword(String uno, String password) throws Exception {
		boolean flag=false;
		String sql="update userinfo set password=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, password);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changeNickname(String uno, String nickname) throws Exception {
		boolean flag=false;
		String sql="update userinfo set nickname=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, nickname);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changePhone(String uno, String phone) throws Exception {
		boolean flag=false;
		String sql="update userinfo set phone=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, phone);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changeImgUrl(String imgurl,String uno) throws Exception {
		boolean flag;
		flag = false;
		try {
			String sql = "update userinfo set img_addr = ? where uno = ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, imgurl);
			this.ps.setString(2, uno);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.ps != null) {
				try {
					this.ps.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}

	@Override
	public User findByUno(String uno) throws Exception {
		User user = null;
		String sql = "select uno, uname, age, phone, sex, nickname, email, exp, img_addr, register_date from userinfo where uno = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		ResultSet rs = this.ps.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setUno(rs.getString(1));
			user.setUname(rs.getString(2));
			user.setAge(rs.getInt(3));
			user.setPhone(rs.getString(4));
			user.setSex(rs.getString(5));
			user.setNickname(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setExp(rs.getInt(8));
			user.setImg_addr(rs.getString(9));
			user.setRegister_date(rs.getDate(10));
		}
		rs.close();
		this.ps.close();
		return user;
	}

	@Override
	public int getLevel(String uno) throws Exception {
		int level = 0;
		try {
			String sql = "select exp from userinfo where uno = ?";
			this.ps= this.conn.prepareStatement(sql);
			this.ps.setString(1, uno);
			ResultSet rs = this.ps.executeQuery();
			if (rs.next()) {
				int exp = rs.getInt(1);
				if (exp >= 0 && exp < 5) {
					level = 1;
				} else if (exp >= 5 && exp < 15) {
					level = 2;
				} else if (exp >= 15 && exp < 30) {
					level = 3;
				} else if (exp >= 30 && exp < 50) {
					level = 4;
				} else if (exp >= 50 && exp < 100) {
					level = 5;
				} else if (exp >= 100 && exp < 200) {
					level = 6;
				} else if (exp >= 200 && exp < 500) {
					level = 7;
				} else if (exp >= 500 && exp < 1000) {
					level = 8;
				} else if (exp >= 1000) {
					level = 9;
				}
				rs.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				this.ps.close();
			} catch (Exception e2) {
				throw e2;
			}
		}
		return level;
	}

	@Override
	public List<User> getGoodUsers() throws Exception {
		List<User> all = new ArrayList<User>();
		String sql = "select img_addr,uname,exp,sex,uno from userinfo order by exp DESC limit 8";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setImg_addr(rs.getString(1));
			user.setUname(rs.getString(2));
			user.setExp(rs.getInt(3));
			user.setSex(rs.getString(4));
			user.setUno(rs.getString(5));
			all.add(user);
		}
		rs.close();
		this.ps.close();
		return all;
	}

	@Override
	public int getPrecentage(String uno) throws Exception {
		int precentage = 0;
		try {
			String sql = "select exp from userinfo where uno = ?";
			this.ps= this.conn.prepareStatement(sql);
			this.ps.setString(1, uno);
			ResultSet rs = this.ps.executeQuery();
			if (rs.next()) {
				int exp = rs.getInt(1);
				if (exp >= 0 && exp < 5) {
					precentage = exp * 100 / 5;
				} else if (exp >= 5 && exp < 15) {
					precentage = (exp - 5) * 100 / 10;
				} else if (exp >= 15 && exp < 30) {
					precentage = (exp - 15) * 100 / 15;
				} else if (exp >= 30 && exp < 50) {
					precentage = (exp - 30) * 100 / 20;
				} else if (exp >= 50 && exp < 100) {
					precentage = (exp - 50) * 100 / 50;
				} else if (exp >= 100 && exp < 200) {
					precentage = (exp - 100) * 100 / 100;
				} else if (exp >= 200 && exp < 500) {
					precentage = (exp - 200) * 100 / 300;
				} else if (exp >= 500 && exp < 1000) {
					precentage = (exp - 500) * 100 / 500;
				} else if (exp >= 1000) {
					precentage = 100;
				}
				rs.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				this.ps.close();
			} catch (Exception e2) {
				throw e2;
			}
		}
		return precentage;
	}


}
