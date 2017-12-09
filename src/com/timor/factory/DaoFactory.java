package com.timor.factory;


import com.timor.dao.IUserDao;
import com.timor.dao.proxy.UserDaoProxy;

public class DaoFactory {
	
	public static IUserDao getIUserDaoInstance() throws Exception{
		return new UserDaoProxy();
	}
}
