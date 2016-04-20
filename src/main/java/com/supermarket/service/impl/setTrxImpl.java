package com.supermarket.service.impl;

import java.util.Date; 

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.supermarket.dao.user;
import com.supermarket.mysql.content;
import com.supermarket.mysql.*;
import com.supermarket.service.setTrx;
import com.supermarket.util.MyBatisUtil;
@Service
public class setTrxImpl implements setTrx {

	public boolean insertOneTrx(user user, int contentId) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String stat="com.supermarket.mapper.contentMapper.getContent";
		content content=session.selectOne(stat, contentId);
		Date date=new Date();
		long time=date.getTime();
		//trx trx=new trx(user.getId(),content.getId(),content.getPrice(),time);
		trx trx=new trx();
		trx.setContentId(content.getId());
		trx.setPersonId(user.getId());
		trx.setBuyPrice(content.getPrice());
		trx.setBuyTime(time);
		String statinsert="com.supermarket.mapper.trxMapper.addTrx";
		session.update(statinsert,trx);
		session.close();
		return true;
		//返回boolean类型，方便扩展
	}

}
