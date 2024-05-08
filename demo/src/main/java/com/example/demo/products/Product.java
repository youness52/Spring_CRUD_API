package com.example.demo.products;

//User.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String name;

 private String description;

 private Float price;

public void setId(Long id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setDescription(String description) {
	this.description = description;
}

public void setPrice(Float price) {
	this.price = price;
}

public Long getId() {
	return id;
}

public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public Float getPrice() {
	return price;
}


  

  
}