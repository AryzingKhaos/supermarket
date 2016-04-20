package com.supermarket.controller;

import com.supermarket.util.*;
import com.supermarket.service.impl.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.supermarket.dao.user;
import com.supermarket.mysql.*;
import java.util.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/api")
public class apiController {
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody 
	public Object apiLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,
			HttpSession httpsession){
//		SqlSession session = MyBatisUtil.getSqlSession(true);
//		person pers=new person();	
//		pers.setUserName(userName);
//		String statment="com.supermarket.mapper.personMapper.getPerson";
//		person pers2=session.selectOne(statment,pers);
		
		getUserImpl gui=new getUserImpl();
		user user=gui.getOneUser(userName, password);
		JSONObject jsonObject = new JSONObject();
		if(user!=null){
			jsonObject.put("code", 200);
			jsonObject.put("message", "成功");
			jsonObject.put("result", true);
			httpsession.setAttribute("user", user);
		}else{
			jsonObject.put("code", 204);
			jsonObject.put("message", "找不到该用户");
			jsonObject.put("result", false);
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody 
	public Object apiDelete(@RequestParam("id") int id,
			HttpSession httpsession){
		JSONObject jsonObject = new JSONObject();
		deleteContentImpl dci=new deleteContentImpl();
		boolean booldci=dci.deleteOneContent(id);
		if(booldci){
			//因为deleteOneContent返回一个boolean值，如果删除成功，那么就会返回true
			jsonObject.put("code", 200);
			jsonObject.put("message", "成功");
			jsonObject.put("result", true);
		}else{
			jsonObject.put("code", 204);
			jsonObject.put("message", "失败");
			jsonObject.put("result", false);
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/buy",method=RequestMethod.POST)
	@ResponseBody 
	public Object apiBuy(@RequestParam("id") int id,
			HttpSession httpsession){
		JSONObject jsonObject = new JSONObject();
		user user =(user)httpsession.getAttribute("user");
		setTrxImpl sti=new setTrxImpl();
		boolean boolsti=sti.insertOneTrx(user, id);
		if(boolsti){
			jsonObject.put("code", 200);
			jsonObject.put("message", "成功");
			jsonObject.put("result", true);
		}else{
			jsonObject.put("code", 204);
			jsonObject.put("message", "失败");
			jsonObject.put("result", false);
		}
		
		
		return jsonObject;
	}
	
}
