package ht.bean;

import java.io.Serializable;

/*
 * 保存购物车内的购买图书信息
 * 
 * */
public class Car implements Serializable{

	private int bookId;
	private String bookName;
	private float price;
	private int count; //购买数量
	public Car(){};
	public Car(int bookId,String bookName,float price,int count){
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.count = count;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
