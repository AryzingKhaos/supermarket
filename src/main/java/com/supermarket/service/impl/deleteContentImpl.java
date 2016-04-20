package com.supermarket.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.product;
import com.supermarket.mysql.content;
import com.supermarket.service.deleteContent;
import com.supermarket.util.MyBatisUtil;

@Service
public class deleteContentImpl implements deleteContent {

	public boolean deleteOneContent(int id) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String stat="com.supermarket.mapper.contentMapper.deleteContent";
		session.delete(stat, id);
		String statgtcntnt="com.supermarket.mapper.contentMapper.getContent";
		content content=session.selectOne(statgtcntnt,id);
		session.close();
		if(content==null){
			return true;
		}else{
			return false;
		}
	}

}
