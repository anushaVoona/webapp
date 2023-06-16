package com.MyFIrstWebApplication.Webapplication.LoginController;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	public Todo(int id, String description, int total, int Price, String username) {
		super();
		this.id = id;
		this.description = description;
		this.total = total;
		this.price = Price;
		this.username = username;
	}

	public Todo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 5, message = "Enter atleast 5 letters")
	private String description;
	@Range(min = 0, max = 30, message = "Dont enter more than 30")
	private int total;
	private int price;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", Total=" + total + ", price=" + price + "]";
	}

}
