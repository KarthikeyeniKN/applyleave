<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.8/css/mdb.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<style>
#login {
	font-family: Arial, Helvetica, sans-serif;
	float: right;
	height: 550px;
	width: 600px;
	font-size: 24px;
	letter-spacing: 1px;
	color: white;
	padding-top: 70px;
	padding-left: 70px;
	background: rgba(711, 511, 611, 0.20);
}

#input {
	width: 200px;
}

#h1 {
	font-family: Arial, Helvetica, sans-serif;
	float: center;
	font-size: 30px;
	letter-spacing: 1px;
	text-align: center;
	color: black;
}

body {
	background-image: url("image/b.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1400px 800px;
	background-opacity: 1.5;
}

#about {
	float: left;
	height: 450px;
	width: 750;
	font-family: "Times New Roman", Times, serif;
	letter-spacing: 1px;
	font-size: 32px;
	color: white;
	text-align: center;
	margin-top: 200px;
	font-weight: 300;
	font-style: italic;
	opacity: 2.5;
}
</style>
</head>
<body>
	<div id="about">
		<p>Gosphen College of Engineering and Technology</p>
	</div>
	<div id="login">
		<h2>
			Student Login <a href="adminlogin.jsp"><button type="submit"
					class="btn btn-success waves-effect">Admin Login</button> </a>
		</h2>
		<form method="post" action="StudentLoginServlet">
			<label for="name">User Name : </label>
			<div id="input">
				<input class="form-control" type="text" required id="name"
					name="name" placeholder=" Enter your name" autofocus>
			</div>
			<br> <label for="password">Password : </label>
			<div id="input">
				<input class="form-control" type="password" required name="password"
					id="password" placeholder="Enter password"><br>
			</div>
			<div class="center">
				<p>
					Forgot Password? <a href="" data-toggle="modal"
						data-target="#pwdModal" id="forgetpass">Click here</a>
				</p>
			</div>
			<h3>${INVALID}</h3>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>