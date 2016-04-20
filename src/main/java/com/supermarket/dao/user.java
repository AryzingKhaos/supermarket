package com.supermarket.dao;
import org.springframework.stereotype.Repository;

import com.supermarket.mysql.*;


//@Repository
public class user {
	private int id=-1;//����һ����ʼֵ����֤���ݿ������IDΪ0�����жϲ�����userΪ�յ�����
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
		//��û�����ݵ�ʱ��
		this.id=-1;
		this.userName="����";
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
