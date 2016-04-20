package com.supermarket.dao;

import java.sql.Date;

import java.text.SimpleDateFormat;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supermarket.mysql.*;
import com.supermarket.util.MyBatisUtil;

//@Repository
public class buyList {
	private int id;
	private String title;
	private String image;
	private int buyPrice;
	private long buyTime;
	
	public  buyList(trx trxx){
		this.id=trxx.getId();
		int idd=trxx.getContentId();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String statgtcntnt="com.supermarket.mapper.contentMapper.getContent";
		content con=session.selectOne(statgtcntnt,idd);
		this.title=con.getTitle();
		this.image=con.getIcon();
		this.buyPrice=trxx.getBuyPrice();
		this.buyTime=trxx.getBuyTime();
	}
	
	public String buytime2date(){
		Date date=new Date(this.buyTime);
		String strs="";
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			strs=sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return strs;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public long getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}
}
