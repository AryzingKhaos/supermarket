package com.supermarket.service;
import java.util.ArrayList;

import com.supermarket.dao.*;
import com.supermarket.mysql.*;

import org.springframework.stereotype.Service;


public interface getUser {
	public user getOneUser(String userName,String password);
	public ArrayList<user> getListUser();
}


