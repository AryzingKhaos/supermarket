package com.supermarket.dao;

import org.springframework.stereotype.Repository;

//@Repository
public class productList {
	private int id;
	private String title;
	private String image;
	private int price;
	private boolean productList;
	
	//这个类完全没用到
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isProductList() {
		return productList;
	}
	public void setProductList(boolean productList) {
		this.productList = productList;
	}
	
}
