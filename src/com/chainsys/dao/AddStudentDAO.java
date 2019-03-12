package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chainsys.modal.AddStudent;
import com.chainsys.passgeneration.ConnectionUtil;

public class AddStudentDAO {
	public void add(AddStudent addStudent) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "insert into student_login(id,name,year,rollno,department,email,password) values(student_login_id_seq.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, addStudent.getName());
			preparedStatement.setInt(2, addStudent.getYear());
			preparedStatement.setInt(3, addStudent.getRollno());
			preparedStatement.setString(4, addStudent.getDepartment());
			preparedStatement.setString(5, addStudent.getEmail());
			preparedStatement.setString(6, addStudent.getPassword());
			@SuppressWarnings("unused")
			int rows = preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("unable to insert");
		}
	}
}
