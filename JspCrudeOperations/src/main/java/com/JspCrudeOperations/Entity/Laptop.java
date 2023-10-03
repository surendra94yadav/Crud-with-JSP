package com.JspCrudeOperations.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int id;
	private String brand;
	private String  price;
	
	public Laptop(int id, String brand, String price) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}
	

}
