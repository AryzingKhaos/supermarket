package com.supermarket.dao;
import org.springframework.stereotype.Repository;

import com.supermarket.mysql.*;


//@Repository
public class user {
	private int id=-1;//赋了一个初始值，保证数据库中如果ID为0，则判断不出此user为空的问题
	private String userName;
	private String nickName;
	private int userType=2;
	private boolean isExist;


	public user(person p){
		if(p!=null&&p.getUserName()!=null&&p.getPassword()!=null) {isExist=true;}
		else {isExist=false;}
		this.id=p.getId();
		this.userName=p.getUserName();
		this.userType=p.getUserType();
		this.nickName=p.getNickName();
	}
	public user(){
		//当没有数据的时候
		this.id=-1;
		this.userName="无名";
		this.userType=1;
		this.isExist=false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean Exist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
}
