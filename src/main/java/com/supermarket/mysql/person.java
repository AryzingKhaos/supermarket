package com.supermarket.mysql;

public class person {
	private int id;
	private String userName;
	private String password;
	private String nickName;
	private int userType;
	
	@Override
	public String toString() {
        return "person ["
        		+ "id=" + id
        		+ ", userName=" + userName 
        		+ ", password=" + password 
        		+ ", nickName=" + nickName 
        		+ ", userType=" + userType + "]";
    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
	
}
