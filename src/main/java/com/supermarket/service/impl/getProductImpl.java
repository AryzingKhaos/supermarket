package com.supermarket.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.*;
import com.supermarket.mysql.content;
import com.supermarket.service.getProduct;
import com.supermarket.util.MyBatisUtil;
@Service
public class getProductImpl implements getProduct {

	public product getOneProduct(user user,int contentId) throws UnsupportedEncodingException{
		SqlSession session = MyBatisUtil.getSqlSession(true);
		int type=0;//1代表未购买内容
		String statgtcntnt="com.supermarket.mapper.contentMapper.getContent";
		content content=session.selectOne(statgtcntnt,contentId);
		product product=new product(content,user);
		session.close();
		return product;
	}

	
	public product getOneProduct(int contentId)throws UnsupportedEncodingException{
		SqlSession session = MyBatisUtil.getSqlSession(true);
		int type=0;//1代表未购买内容
		String statgtcntnt="com.supermarket.mapper.contentMapper.getContent";
		content content=session.selectOne(statgtcntnt,contentId);
		product product=new product(content);
		session.close();
		return product;
	}
	
	
	public List<product> getAllProduct(user user) throws UnsupportedEncodingException {
		List<product> arrProduct=new ArrayList<product>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		//int type=0;//1代表未购买内容
		String statment="com.supermarket.mapper.contentMapper.getAllContent";	
		List<content> contentList=session.selectList(statment);
		session.close();
		for(content contentone:contentList){
			product productTemp=new product(contentone,user);
			arrProduct.add(productTemp);
			//System.out.println(productTemp.getIsSell());
		}
		return arrProduct;
	}
	
	public List<product> getAllProduct() throws UnsupportedEncodingException {
		List<product> arrProduct=new ArrayList<product>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		//int type=0;//1代表未购买内容
		String statment="com.supermarket.mapper.contentMapper.getAllContent";	
		List<content> contentList=session.selectList(statment);
		session.close();
		user user=new user();
		for(content contentone:contentList){
			arrProduct.add(new product(contentone,user));
		}
		return arrProduct;
	}


}
