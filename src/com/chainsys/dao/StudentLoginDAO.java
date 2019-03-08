package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.modal.StudentLogin;
import com.chainsys.passgeneration.ConnectionUtil;

public class StudentLoginDAO {

	public boolean validator(StudentLogin studentLogin) throws SQLException {
		boolean result = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select name,password from student_login where name=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, studentLogin.getName());
		preparedStatement.setString(2, studentLogin.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();
		result = resultSet.next();
	//	System.out.println(result);
		return result;

		}

}
