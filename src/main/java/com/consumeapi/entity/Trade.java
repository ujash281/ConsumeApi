package com.consumeapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trade {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String price;
	private String qty;
	private String quoteQty;
	private long time;
	private Boolean isBuyerMaker;
	private Boolean isBestMatch;
	public Trade() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getQuoteQty() {
		return quoteQty;
	}
	public void setQuoteQty(String quoteQty) {
		this.quoteQty = quoteQty;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Boolean getIsBuyerMaker() {
		return isBuyerMaker;
	}
	public void setIsBuyerMaker(Boolean isBuyerMaker) {
		this.isBuyerMaker = isBuyerMaker;
	}
	public Boolean getIsBestMatch() {
		return isBestMatch;
	}
	public void setIsBestMatch(Boolean isBestMatch) {
		this.isBestMatch = isBestMatch;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", price=" + price + ", qty=" + qty + ", quoteQty=" + quoteQty + ", time=" + time
				+ ", isBuyerMaker=" + isBuyerMaker + ", isBestMatch=" + isBestMatch + "]";
	}

}
