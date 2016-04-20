package com.supermarket.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.user;
import com.supermarket.mysql.person;
import com.supermarket.service.getUser;
import com.supermarket.util.MyBatisUtil;

@Service
public class getUserImpl implements getUser {

	public user getOneUser(String userName, String password) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		person pers=new person();
		pers.setUserName(userName);
		pers.setPassword(password);
		String statment="com.supermarket.mapper.personMapper.getPerson";
		
		person pers2=session.selectOne(statment,pers);
		session.close();
		user user = null;
		if(pers2!=null) user=new user(pers2);	
		if(pers2!=null){	
			return user;
		}else{
			//user.setExist(false);
			return null;
		}
		
	}

	public ArrayList<user> getListUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
