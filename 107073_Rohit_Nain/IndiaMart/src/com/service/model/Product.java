package com.service.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "Product_Info")
@XmlType(propOrder = { "productId", "productName", "totalQuantity", "productPrice", "mfgDate" })
public class Product {

	private int productId;
	private String productName;
	private int productPrice;
	private int totalQuantity;
	private String mfgDate;

	@XmlElement(name = "pId")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@XmlElement(name = "name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@XmlElement(name = "qty")
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@XmlElement(name = "price")
	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	// @XmlTransient
	@XmlElement(name = "manufDate")
	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", totalQuantity=" + totalQuantity + ", mfgDate=" + mfgDate + "]";
	}

	public Product(int productId, String productName, int productPrice, int totalQuantity, String mfgDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.totalQuantity = totalQuantity;
		this.mfgDate = mfgDate;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
