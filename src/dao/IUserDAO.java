package com.laptrinhjavaweb.dao;

import pojo.Users;

public interface IUserDAO  {
	Users findByUserNameAndPasswordAndStatus(String userName, String password);
        int saveAcount(String userName,String password);
        
   
}
