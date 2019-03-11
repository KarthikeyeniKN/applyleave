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
	public void add(ApplyPass applyPass) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();

			String sql = "insert into apply_pass(id,name,department,year,rollno,email,leave_date,purpose,phone_no,created_date) values(apply_pass_sno_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, applyPass.name);
			preparedStatement.setString(2, applyPass.department);
			preparedStatement.setInt(3, applyPass.year);
			preparedStatement.setInt(4, applyPass.rollno);
			preparedStatement.setString(5, applyPass.email);
			preparedStatement.setDate(6, Date.valueOf(applyPass.leavedate));
			preparedStatement.setString(7, applyPass.leavepurpose);
			preparedStatement.setLong(8, applyPass.phonenumber);
			preparedStatement.setTimestamp(9, applyPass.createddate);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("unable to insert");
		}
	}

	public ArrayList<ApplyPass> findAll() throws Exception {
		ApplyPass applyPass = null;
		ArrayList<ApplyPass> leaveList = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql1 = "select id,name,department,year,rollno,leave_date,purpose from apply_pass";
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
				// System.out.println("sucess");
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable findAll");
		}
		return leaveList;
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

			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows);
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
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new Exception("unable findFood");
		}
		return history;
	}

	public ArrayList<ApplyPass> searchBy(String name, String department,
			String status) {
		ApplyPass applyPass1 = null;
		ResultSet resultSet = null;
		ArrayList<ApplyPass> applyPass = new ArrayList<ApplyPass>();
		//System.out.println("entered");
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "select id,name,department,year,rollno,leave_date,purpose,status from apply_pass where name=? or department=? or status=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql2);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, department);
			preparedStatement.setString(3, status);
		//	preparedStatement.setInt(4, year);
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
			
				// System.out.println(applyPass1);
				applyPass.add(applyPass1);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("Unable to selectBy");
		}
		System.out.println(applyPass1);
		return applyPass;
	}
}
