package com.chainsys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.modal.ApplyPass;
import com.chainsys.passgeneration.ConnectionUtil;

public class ApplyPassDAO {
	public void add(ApplyPass applyPass) {
			try {
				Connection connection = ConnectionUtil.getConnection();
				String sql = "insert into apply_pass(id,name,department,year,rollno,email,leave_date,purpose,phone_no,created_date) values(apply_pass_id_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				preparedStatement.setString(1, applyPass.getName());
				preparedStatement.setString(2, applyPass.getDepartment());
				preparedStatement.setInt(3, applyPass.getYear());
				preparedStatement.setInt(4, applyPass.getRollno());
				preparedStatement.setString(5, applyPass.getEmail());
				preparedStatement
						.setDate(6, Date.valueOf(applyPass.getLeavedate()));
				preparedStatement.setString(7, applyPass.getLeavepurpose());
				preparedStatement.setLong(8, applyPass.getPhonenumber());
				preparedStatement.setTimestamp(9, applyPass.getCreateddate());
				@SuppressWarnings("unused")
				int rows = preparedStatement.executeUpdate();
				ConnectionUtil.close(connection, preparedStatement, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	public ArrayList<ApplyPass> findByName(String name) throws Exception {
		ApplyPass applyPass1 = null;
		ResultSet resultSet = null;
		ArrayList<ApplyPass> applyPass = new ArrayList<ApplyPass>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select rollno,leave_date,purpose,status from apply_pass where name=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql2);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				applyPass1 = new ApplyPass();
				applyPass1.setRollno(resultSet.getInt("rollno"));
				applyPass1.setLeavedate(resultSet.getDate("leave_date")
						.toLocalDate());
				applyPass1.setLeavepurpose(resultSet.getString("purpose"));
				applyPass1.setStatus(resultSet.getString("status"));
				applyPass.add(applyPass1);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to selectByName");
		}
		return applyPass;
	}

	public ApplyPass updateApproveStatus(ApplyPass applyPass) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "update apply_pass set status='Aproved' where rollno=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, applyPass.getRollno());
			@SuppressWarnings("unused")
			int rows = preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to update");
		}
		return applyPass;
	}

	public ApplyPass updateRejectStatus(ApplyPass applyPass) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "update apply_pass set status='Rejected' where rollno=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, applyPass.getRollno());
			@SuppressWarnings("unused")
			int rows = preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to update");
		}
		return applyPass;
	}

	public ArrayList<ApplyPass> findAllHistory() throws Exception {
		ApplyPass applyPass = null;
		ArrayList<ApplyPass> history = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql1 = "select id,name,department,year,rollno,leave_date,purpose,status from apply_pass";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				applyPass = new ApplyPass();
				applyPass.setId(resultSet.getInt("id"));
				applyPass.setName(resultSet.getString("name"));
				applyPass.setDepartment(resultSet.getString("department"));
				applyPass.setYear(resultSet.getInt("year"));
				applyPass.setRollno(resultSet.getInt("rollno"));
				applyPass.setLeavedate(resultSet.getDate("leave_date")
						.toLocalDate());
				applyPass.setLeavepurpose(resultSet.getString("purpose"));
				applyPass.setStatus(resultSet.getString("status"));
				history.add(applyPass);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable findAll");
		}
		return history;
	}

	public ArrayList<ApplyPass> searchBy(String name, String department,
			String status) throws Exception {
		ApplyPass applyPass1 = null;
		ResultSet resultSet = null;
		ArrayList<ApplyPass> applyPass = new ArrayList<ApplyPass>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select id,name,department,year,rollno,leave_date,purpose,status from apply_pass where name=? or department=? or status=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql2);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, department);
			preparedStatement.setString(3, status);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				applyPass1 = new ApplyPass();
				applyPass1.setId(resultSet.getInt("id"));
				applyPass1.setName(resultSet.getString("name"));
				applyPass1.setDepartment(resultSet.getString("department"));
				applyPass1.setYear(resultSet.getInt("year"));
				applyPass1.setRollno(resultSet.getInt("rollno"));
				applyPass1.setLeavedate(resultSet.getDate("leave_date")
						.toLocalDate());
				applyPass1.setLeavepurpose(resultSet.getString("purpose"));
				applyPass1.setStatus(resultSet.getString("status"));
				applyPass.add(applyPass1);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to selectBy");
		}
		return applyPass;
	}

	public ArrayList<ApplyPass> findPending() throws Exception {
		ApplyPass applyPass = null;
		ArrayList<ApplyPass> leaveList = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql1 = "select id,name,department,year,rollno,leave_date,purpose from apply_pass where status ='pending'";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				applyPass = new ApplyPass();
				applyPass.setId(resultSet.getInt("id"));
				applyPass.setName(resultSet.getString("name"));
				applyPass.setDepartment(resultSet.getString("department"));
				applyPass.setYear(resultSet.getInt("year"));
				applyPass.setRollno(resultSet.getInt("rollno"));
				applyPass.setLeavedate(resultSet.getDate("leave_date")
						.toLocalDate());
				applyPass.setLeavepurpose(resultSet.getString("purpose"));
				leaveList.add(applyPass);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable findPending");
		}
		return leaveList;
	}
}
