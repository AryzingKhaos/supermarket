package com.supermarket.controller;
import com.supermarket.util.*;
import com.supermarket.service.getProduct;
import com.supermarket.service.insertProduct;
import com.supermarket.service.impl.*;
import com.supermarket.dao.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supermarket.mysql.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.supermarket.dao.*;


@Controller
//@RequestMapping("/supermarket")
public class marketController {

	//ApplicationContext content=new ClassPathXmlApplicationContext("spring-mvc.xml");
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String loginpage() throws IOException{
		return "login";
	}
	

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(HttpServletResponse response, ModelMap map,HttpSession httpsession) throws IOException{
//		SqlSession session = MyBatisUtil.getSqlSession(true);
		int type=0;//1代表未购买内容
//		String statment="com.supermarket.mapper.contentMapper.getAllContent";	
//		List<content> productList=session.selectList(statment);
//		session.close();
		user user=(user)httpsession.getAttribute("user");
		getProductImpl gpi=new getProductImpl();
		List<product> productList;
		if(user!=null){
			productList=gpi.getAllProduct(user);
			System.out.println(user.getUserType());
		}else{
			productList=gpi.getAllProduct();
		}
		map.addAttribute("productList",productList);
		map.addAttribute("user",user);
		map.addAttribute("type",type);
		return "index";
	}
	
	
	@RequestMapping(value="/show",method = RequestMethod.GET)
	public String show(@RequestParam ("id") int id,
			HttpServletResponse response, ModelMap map,HttpSession httpsession) throws IOException{
//		SqlSession session = MyBatisUtil.getSqlSession(true);
		int type=0;//1代表未购买内容
//		String statgtcntnt="com.supermarket.mapper.contentMapper.getContent";
//		content product=session.selectOne(statgtcntnt,id);
//		session.close();
		user user=(user)httpsession.getAttribute("user");
		getProductImpl gpi=new getProductImpl();
		product product;
		if(user!=null){
			product=gpi.getOneProduct(user,id);
		}else{
			product=gpi.getOneProduct(id);
		}
		map.addAttribute("product",product);
		map.addAttribute("type",type);
		map.addAttribute("user",user);
		return "show";
	}
	
	
	@RequestMapping(value="/account",method=RequestMethod.GET)
	public String account(ModelMap map,HttpSession httpsession){
		user user=(user)httpsession.getAttribute("user");
		SqlSession session = MyBatisUtil.getSqlSession(true);
		List<trx> arrtrx =new ArrayList<trx>();
		String stat="com.supermarket.mapper.trxMapper.getAllTrxbyUserID";
		arrtrx=session.selectList(stat,user.getId());
		List<buyList> buylistlist=new ArrayList<buyList>();
		for(trx trxx : arrtrx){
			buyList buylist=new buyList(trxx);
			buylistlist.add(buylist);
		}
		map.addAttribute("buyList",buylistlist);
		map.addAttribute("user",user);
		return "account";
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("id") int id,HttpSession httpsession,
			ModelMap map) throws UnsupportedEncodingException{

		user user=(user)httpsession.getAttribute("user");
		getProductImpl gpi=new getProductImpl();
		product product;
		if(user!=null){
			product=gpi.getOneProduct(user,id);
		}else{
			product=gpi.getOneProduct(id);
		}
		map.addAttribute("product",product);
		map.addAttribute("user",user);
		return "edit";
	}
	
	
	//@Autowired
	//getProduct gpi;
	
	
	@RequestMapping(value="/editSubmit",method=RequestMethod.POST)
	public String editSubmit2(
//			@RequestParam("id") int id,
//			@RequestParam("title") String title,
//			@RequestParam("summary") String abstracts,
//			@RequestParam("image") String icon,
//			@RequestParam("detail") String text,
//			@RequestParam("price") int price,
			product productFromWeb,
			HttpSession httpsession,
			ModelMap map) throws UnsupportedEncodingException{
		
		setProductImpl spi=new setProductImpl();
		spi.setOneProduct(productFromWeb.getId(), productFromWeb.getTitle(), 
				productFromWeb.getSummary(), productFromWeb.getImage(),
				productFromWeb.getDetail(),productFromWeb.getPrice());
		user user=(user)httpsession.getAttribute("user");
		getProduct gpi=new getProductImpl();
		product product;
		if(user!=null){
			product=gpi.getOneProduct(user,productFromWeb.getId());
		}else{
			product=gpi.getOneProduct(productFromWeb.getId());
		}
		//System.out.println(product.getText());
		map.addAttribute("product",product);
		map.addAttribute("user",user);
		return "editSubmit";
	}
	
	@RequestMapping(value="/public",method=RequestMethod.GET)
	public String publics(HttpSession httpsession){
		user user=(user)httpsession.getAttribute("user");
		return "public";
	}
	
	//@Autowired
	//insertProduct ipi;
	
	@RequestMapping(value="/publicSubmit",method=RequestMethod.POST)
	public String publicSubmit(
//			@RequestParam("title") String title,
//			@RequestParam("image") String icon,
//			@RequestParam("summary") String abstracts,
//			@RequestParam("detail") String text,
//			@RequestParam("price") int price,
			product productFromWeb,
			HttpSession httpsession,
			ModelMap map) throws UnsupportedEncodingException{
		user user=(user)httpsession.getAttribute("user");
		insertProduct ipi=new insertProductImpl();
		product product=ipi.insertOneProduct(
				productFromWeb.getTitle(), 
				productFromWeb.getSummary(), productFromWeb.getImage(),
				productFromWeb.getDetail(),productFromWeb.getPrice());
		map.addAttribute("product",product);
		map.addAttribute("user",user);
		return "publicSubmit";
	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession httpsession,ModelMap map){
		httpsession.removeAttribute("user");
		return new ModelAndView("redirect:/index");
	}
	
	
	
}
