package com.chainsys.modal;

public class StudentLogin {
public String name;
public String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "StudentLogin [name=" + name + ", password=" + password + "]";
}
}
