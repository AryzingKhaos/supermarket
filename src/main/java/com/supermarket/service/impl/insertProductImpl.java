package com.supermarket.service.impl;

import java.io.UnsupportedEncodingException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.product;
import com.supermarket.dao.user;
import com.supermarket.mysql.content;
import com.supermarket.service.insertProduct;
import com.supermarket.util.MyBatisUtil;
@Service
public class insertProductImpl implements insertProduct {

	public product insertOneProduct( String title, String abstracts, String icon, String text, int price)
			throws UnsupportedEncodingException {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String stat="com.supermarket.mapper.contentMapper.addContent";
		content content=new content();
		
		content.setAll(title, icon, abstracts, text, price);
		session.insert(stat,content);
		String stat2="com.supermarket.mapper.contentMapper.getContentbyAllElement";
		product product=new product((content)session.selectOne(stat2,content));
		return product;
	}

}
