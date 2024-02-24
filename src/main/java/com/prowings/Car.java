package com.prowings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "CarTable")

@NamedQueries({
	@NamedQuery(name="GET_ALL_CARS", query = "From Cars"),
	@NamedQuery(name = "GET_SUV_CARS", query = "From Cars c where c.type = 'SUV'"),
})

@NamedQuery(name = "GET_CARS_COUNT", query = "select count(1) from Car")

@NamedNativeQuery(name = "GETCARS", query = "SELECT * FROM cartable")
@NamedNativeQueries({
	@javax.persistence.NamedNativeQuery(name = "GETCARS", query = "SELECT * FROM cartable"),
	
})
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String companyName;
	@Column
	private String type;
	@Column
	private double price;
	
	public Car() {
		super();
	}

	public Car(String companyName, String type, double price) {
		super();
		this.companyName = companyName;
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", companyName=" + companyName + ", type=" + type + ", price=" + price + "]";
	}

	
	
}
