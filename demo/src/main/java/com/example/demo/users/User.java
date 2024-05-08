package com.example.demo.users;

//User.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String name;

 private String email;

private String password;
  
public void setId(Long id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setPassword(String password) {
	this.password = password;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getId() {
	return id;
}

public String getName() {
	return name;
}

public String getPassword() {
	return password;
}

public String getEmail() {
	return email;
}

  
}