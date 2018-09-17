package com.service.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.service.dao.MyProductImpl;
import com.service.model.Product;

@Path("userservice")
public class ProductController {
	MyProductImpl manageProduct = new MyProductImpl();

	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void addProduct(Product p) throws Exception {
		manageProduct.addProduct(p);
		System.out.println("record added");
	}

	@Path("show")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })//in both the formats
	public List<Product> products() throws Exception {
		return manageProduct.products();
	}

	@Path("remove/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("id") int productId) throws Exception {
		manageProduct.deleteProduct(productId);
		return "Record deleted";
	}

	@Path("update")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON })
	public String updateProduct(Product product) throws Exception {
		manageProduct.updateProduct(product);
		return "Record Updated";
	}

	@Path("byNameOrPrice/{name}/{price}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getSalary(@PathParam("name") String name, @PathParam("price") int price) throws Exception {

		return manageProduct.byNameOrPrice(name, price);
	}
}
