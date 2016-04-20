package com.supermarket.service;

import java.io.UnsupportedEncodingException;
import com.supermarket.dao.*;
import org.springframework.stereotype.Service;


public interface insertProduct {
	public product insertOneProduct(String title,String abstracts,String icon,String text,int price) throws UnsupportedEncodingException;
}
