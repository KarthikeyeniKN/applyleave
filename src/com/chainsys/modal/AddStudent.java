package com.chainsys.modal;

public class AddStudent {
public String name;
public int year;
public int rollno;
public String department;
public String email;
public String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "AddStudent [name=" + name + ", year=" + year + ", rollno=" + rollno
			+ ", department=" + department + ", email=" + email + ", password="
			+ password + "]";
}

}
