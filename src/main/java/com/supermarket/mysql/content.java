package com.supermarket.mysql;

import java.sql.SQLException;

import com.mysql.jdbc.Blob;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class content {
	private int id=-1;
	private int price ;
	private String title;
	private String icon ;//Í¼Æ¬
	private String abstracts;//ÕªÒª
	private byte[] text;//ÕýÎÄ

	
	
	public boolean isExist(){
		if (this.id!=-1) return true;
		return false;
	}
	
	public void setAll(String title,String icon,String abstracts,String text,int price) throws UnsupportedEncodingException{
		this.title=title;
		this.icon=icon;
		this.abstracts=abstracts;
		this.text=text.getBytes("ISO-8859-1");
		this.price=price;
	}

	@Override
	public String toString() {
        return "content ["
        		+ "id=" + id
        		+ ", price=" + price 
        		+ ", title=" + title 
        		+ ", icon=" + icon 
        		+ ", abstracts=" + abstracts 
        		+ ", text=" + text 
        		+ "]";
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getText() throws UnsupportedEncodingException {
		String text=new String(this.text,"ISO-8859-1");
		return text;
	}

//	public void setText(Blob blob) {
//		try{  
//	         String content = new String();  
//	         ByteArrayInputStream msgContent =(ByteArrayInputStream) blob.getBinaryStream();
//	         System.out.println(msgContent);
//	         byte[] byte_data = new byte[msgContent.available()];
//	         msgContent.read(byte_data, 0,byte_data.length);
//	         System.out.println(msgContent);
//	         content = new String(byte_data);
//	         System.out.println(content);
//	         this.text = content;
//	    } catch(SQLException e) {  
//	         e.printStackTrace();  
//	    }
//		
//	}
	public void setText(String text) throws UnsupportedEncodingException {
		this.text=text.getBytes("ISO-8859-1");
	}
	

}
