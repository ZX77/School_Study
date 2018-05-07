package ht.bean;

import java.io.Serializable;

public class Book implements Serializable{

	private int bookId;
	private String bookName;
	private float price;
	private int count; //库存数量
	public Book(){};
	public Book(int bookId,String bookName,float price,int count){
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
