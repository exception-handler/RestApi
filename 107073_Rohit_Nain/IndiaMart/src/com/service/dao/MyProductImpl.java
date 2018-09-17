package com.service.dao;

import java.util.List;

import com.service.model.Product;
import com.service.utility.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyProductImpl implements MyProduct {
	static List<Product> productList = new ArrayList<>();
	Connection con = null;
	PreparedStatement ps;
	ResultSet rs = null;

	@Override
	public void addProduct(Product p) throws Exception {
		System.out.println("inside insert method");
		int id = p.getProductId();
		String name = p.getProductName();
		int price = p.getProductPrice();
		int quantity = p.getTotalQuantity();
		String mfgData = p.getMfgDate();
		String query = "insert into product_Info values(?,?,?,?,?)";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, price);
		ps.setInt(4, quantity);
		ps.setString(5, mfgData);
		ps.executeUpdate();
		System.out.println("Inserted");

	}

	@Override
	public List<Product> products() throws Exception {
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select * from product_Info");
		rs = ps.executeQuery();
		while (rs.next()) {
			productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));

		}
		return productList;
	}

	@Override
	public List<Product> byNameOrPrice(String name, int price) throws Exception {

		List<Product> productlist1 = new ArrayList<>();
		String query = "select * from product_Info where productName=? and productPrice>=? ";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, price);
		rs = ps.executeQuery();
		while (rs.next()) {

			productlist1.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));

		}
		return productlist1;
	}

	@Override
	public void updateProduct(Product p) throws Exception {
		System.out.println("Inside update user");
		String query = "update product_Info SET productName =?, productPrice=?, totalQuantity=?, mfgDate=? WHERE productId =?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, p.getProductName());
		ps.setInt(2, p.getProductPrice());
		ps.setInt(3, p.getTotalQuantity());
		ps.setString(4, p.getMfgDate());
		ps.setInt(5, p.getProductId());
		ps.executeUpdate();

	}

	@Override
	public void deleteProduct(int productId) throws Exception {
		System.out.println("inside delete");
		String query = "delete from product_Info WHERE productId =?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setInt(1, productId);
		ps.executeUpdate();
	}

}
