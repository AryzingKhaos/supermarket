package com.supermarket.service;
import java.io.UnsupportedEncodingException;

import com.supermarket.dao.*;
import org.springframework.stereotype.Service;


public interface setProduct {
	public void setOneProduct(int id,String title,String abstracts,String icon,String text,int price) throws UnsupportedEncodingException;
}
