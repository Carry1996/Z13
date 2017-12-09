package com.timor.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import com.timor.dao.IUserDao;
import com.timor.dao.impl.UserDaoImpl;
import com.timor.dbc.DataBaseConnection;
import com.timor.vo.User;

public class UserDaoProxy implements IUserDao{
	private DataBaseConnection dbc = null;
	private IUserDao dao = null;
	
	public UserDaoProxy() throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new UserDaoImpl(this.dbc.getConnection());
	}
	
	public boolean logIn(String uno, String password) throws Exception {
		boolean flag = false;
		try {
			if(uno != null){
				flag = this.dao.logIn(uno, password);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return flag;
	}
	@Override
	public boolean register(User user) throws Exception {
		boolean flag = false;
		try{
            	flag = this.dao.register(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closeConnection();;
		}
		return flag;
	}

	@Override
	public boolean findPasswordByUno(String uno, String email) throws Exception {
		boolean flag = false;
		try{
			if(uno != null){
				flag = this.dao.findPasswordByUno(uno, email);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closeConnection();;
		}
		return flag;
	}

	@Override
	public boolean increaseExp(String uno) throws Exception {
		boolean flag = false;
		try{
			if(uno != null){
				flag = this.dao.increaseExp(uno);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closeConnection();;
		}
		return flag;
	}

	@Override
	public boolean resetPassword(String uno, String password) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.resetPassword(uno, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();;
		}
		return flag;
	}

	@Override
	public boolean changeNickname(String uno, String nickname) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.changeNickname(uno, nickname);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();;
		}
		return flag;
	}

	@Override
	public boolean changePhone(String uno, String phone) throws Exception {
		boolean flag=false;
		try {
			flag=this.dao.changePhone(uno, phone);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();;
		}
		return flag;
	}
	@Override
	public boolean changeImgUrl(String imgurl, String uno) throws Exception {
		boolean flag = false;
		try {
			if(uno != null){
				flag = this.dao.changeImgUrl(imgurl, uno);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return flag;
	}

	@Override
	public User findByUno(String uno) throws Exception {
		User user = null;
		try {
			user = this.dao.findByUno(uno);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return user;
	}


	@Override
	public int getLevel(String uno) throws Exception {
		int level = 0;
		try {
			if (uno != null) {
				level = this.dao.getLevel(uno);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return level;
	}

	@Override
	public List<User> getGoodUsers() throws Exception {
		List<User> all = new ArrayList<User>();
		try {
			all = this.dao.getGoodUsers();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return all;
	}

	@Override
	public int getPrecentage(String uno) throws Exception {
		int precentage = 0;
		try {
			if (uno != null) {
				precentage = this.dao.getPrecentage(uno);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return precentage;
	}

}
