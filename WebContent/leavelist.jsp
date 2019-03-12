<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Leave List</title>
<Style>
#fontstyle {
	font-family: arial;
	font-size: 18px;
}

@media ( min-width :1200px) {
	.navbar, .page-footer, main {
		padding-left: 150px
	}
}

#Logout {
	color: white;
	font-size: 18;
	box-shadow: 5px 5px 18px #888888;
}

#Logout:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

#LeaveList {
	padding-top: 5%;
}

#badgeDiv {
	width: 150px;
}

#badgeSpan {
	background-color: darkslategrey;
	height: 40px;
	font-size: 20px;
}

#btn-align {
	vertical-align: right;
}
</Style>
</head>
<body class="grey lighten-3" id="fontstyle">
	<header>
		<!-- Navbar -->
		<nav
			class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
			<div class="container-fluid">
				<!-- Links -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<!-- Left -->
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a>Gosphen College of
								Engineering and Technology </a></li>
					</ul>
					<!-- Right -->
					<ul class="navbar-nav nav-flex-icons">
						<li class="nav-item"><a href="addstudent.html">
								<button id="Add" type="submit" name="Add"
									class="btn btn-success waves-effect btn-sm">
									<i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;Add
									Student
								</button>
						</a></li>
					</ul>
					<ul class="navbar-nav nav-flex-icons">
						<li class="nav-item">
							<form method="post" action="HistoryServlet">
								<button id="History" type="submit" name="Status"
									class="btn btn-success waves-effect btn-sm">
									<i class="fa fa-th-list" aria-hidden="true"></i>&nbsp;&nbsp;History
								</button>
							</form>
						</li>
					</ul>
					<ul class="navbar-nav nav-flex-icons">
						<li class="nav-item"><a href="adminlogin.jsp">
								<button type="button" class="btn btn-danger waves-effect btn-sm"
									id="Logout">
									<i class="fa fa-power-off"></i>&nbsp;&nbsp;&nbsp;&nbsp;LogOut
								</button>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- Navbar -->
	</header>
	<main class="pt-5 mx-lg-5">
	<div class="row wow fadeIn" id="LeaveList">

		<!--Grid column-->
		<div class="col-md-16 mb-4">

			<div id="badgeDiv" class="card mb-4 wow fadeIn">
				<span id="badgeSpan" class="badge darkgreen"> <i
					id="badgeIcon" class="fa fa-th-list" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Leave
					List
				</span>
			</div>
		</div>
	</div>
	<div class="card">
		<!--Card content-->
		<div class="card-body">
			<table class="table table-hover">
				<thead class="blue-grey lighten-4">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Department</th>
						<th scope="col">Year</th>
						<th scope="col">Rollno</th>
						<th scope="col">LeaveDate</th>
						<th scope="col">Purpose</th>
						<th scope="col" id="BUTTON">Reject Approve</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="leavelist" items="${LEAVELIST}">
						<tr>
							<td>${leavelist.id}</td>
							<td>${leavelist.name}</td>
							<td>${leavelist.department}</td>
							<td>${leavelist.year}</td>
							<td>${leavelist.rollno}</td>
							<td>${leavelist.leavedate}</td>
							<td>${leavelist.leavepurpose}</td>
							<td>
								<div id="btn-align">
									<form method="post" action="UpdateRejectServlet">
										<button id="Reject" type="submit" name="Rejectrollno"
											value="${leavelist.rollno}" class="btn btn-danger btn-sm">Reject</button>
									</form>
									<form method="post" action="UpdateApproveServlet">
										<button id="Aprove" type="submit" name="Aproverollno"
											value="${leavelist.rollno}" class="btn btn-success btn-sm">Approve</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</main>
</body>
</html>