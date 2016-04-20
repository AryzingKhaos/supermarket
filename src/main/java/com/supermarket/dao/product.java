package com.supermarket.dao;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.supermarket.mysql.*;
import com.supermarket.util.MyBatisUtil;


//@Repository
public class product {
	private int id;
	private String title;
	private String summary;
	private String detail;
	private String image;
	private int price;
	private int buyPrice;
	private boolean isBuy=false;
	private boolean isSell=false;
	
	public product (content content,user user) throws UnsupportedEncodingException{
		this.id=content.getId();
		this.title=content.getTitle();
		this.summary=content.getAbstracts();
		this.detail=content.getText();
		this.image=content.getIcon();
		this.price=content.getPrice();
		inti(user);
		if (user.getUserType()==1){
			setIsSell(user);
		}
	}
	
	public product(content content)throws UnsupportedEncodingException{
		this.id=content.getId();
		this.title=content.getTitle();
		this.summary=content.getAbstracts();
		this.detail=content.getText();
		this.image=content.getIcon();
		this.price=content.getPrice();
	}
	
	public void inti(user user) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		List<trx> arrtrx =new ArrayList<trx>();
		String stat="com.supermarket.mapper.trxMapper.getAllTrxbyUserID";
		arrtrx=session.selectList(stat,user.getId());
		session.close();
		for(trx trxx : arrtrx){
			if(trxx.getPersonId()==user.getId()&&trxx.getContentId()==this.id){
				//将当前用户传入这个函数中，就可以唯一匹配contentid和personid了
				this.buyPrice = trxx.getBuyPrice();
			}
			if(user.getUserType()==0){
				//用户类型为0,是买家
				if(trxx.getPersonId()==user.getId()&&trxx.getContentId()==this.id){
					this.isBuy=true;
				}
				//如果是卖家，那么在另一个方法里写。因为逻辑完全不一样
			}
			//System.out.println(this.isBuy());
		}
	}
	
	public void setIsSell(user user){
		if (user.getUserType()==1){
			//用户类型为1,是卖家
			SqlSession session = MyBatisUtil.getSqlSession(true);
			List<trx> arrTrxOfContent =new ArrayList<trx>();
			String stat="com.supermarket.mapper.trxMapper.getTrxbyContentID";
			//arrTrxOfContent=session.selectList(stat,this.id);
			trx trxone=session.selectOne(stat,this.id);
			//arrTrxOfContent=session.selectList(stat,this.id);
			session.close();
			if(trxone!=null&&trxone.getId()!=0) this.isSell=true;
			//if(arrTrxOfContent.get(0).getId()!=0) this.isSell=true;
		}
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public boolean getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public boolean getIsSell() {
		return isSell;
	}
	public void setIsSell(boolean isSell) {
		this.isSell = isSell;
	}
}
