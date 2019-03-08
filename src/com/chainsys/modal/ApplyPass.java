package com.chainsys.modal;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ApplyPass {
	public int id;
	public String name;
	public String department;
	public int year;
	public String rollno;
	public String email;
	public LocalDate leavedate;
	public String leavepurpose;
	public long phonenumber;
	public String status;
	public Timestamp createddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(LocalDate leavedate) {
		this.leavedate = leavedate;
	}

	public String getLeavepurpose() {
		return leavepurpose;
	}

	public void setLeavepurpose(String leavepurpose) {
		this.leavepurpose = leavepurpose;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ApplyPass [id=" + id + ", name=" + name + ", department="
				+ department + ", year=" + year + ", rollno=" + rollno
				+ ", email=" + email + ", leavedate=" + leavedate
				+ ", leavepurpose=" + leavepurpose + ", phonenumber="
				+ phonenumber + ", status=" + status + ", createddate="
				+ createddate + "]";
	}

}
