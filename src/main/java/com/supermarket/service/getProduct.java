package com.supermarket.service;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.supermarket.dao.*;
import com.supermarket.mysql.*;
import org.springframework.stereotype.Service;


public interface getProduct {
	public product getOneProduct(user user,int contentId)throws UnsupportedEncodingException;
	public product getOneProduct(int contentId)throws UnsupportedEncodingException;
	public List<product> getAllProduct(user user) throws UnsupportedEncodingException;
	public List<product> getAllProduct() throws UnsupportedEncodingException;
}
