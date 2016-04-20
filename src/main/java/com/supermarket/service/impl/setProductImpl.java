package com.supermarket.service.impl;

import java.io.UnsupportedEncodingException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.product;
import com.supermarket.mysql.content;
import com.supermarket.service.setProduct;
import com.supermarket.util.MyBatisUtil;
@Service
public class setProductImpl implements setProduct {
	public void setOneProduct(int id,String title,String abstracts,String icon,String text,int price) throws UnsupportedEncodingException{
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String statupdata="com.supermarket.mapper.contentMapper.updateContent";
		content contentOrg=new content();
		contentOrg.setId(id);
		contentOrg.setTitle(title);
		contentOrg.setAbstracts(abstracts);
		contentOrg.setIcon(icon);
		//String text = new String(textOrg.getBytes("iso-8859-1")); 
		contentOrg.setText(text);
		contentOrg.setPrice(price);
		//System.out.println(productOrg);
		session.update(statupdata, contentOrg);
		session.close();
	}
}
