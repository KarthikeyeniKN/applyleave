<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status</title>
<style>
#Status{
    padding-top: 5%;
}
#badgeDiv {
	width: 150px;
}

#badgeSpan {
	background-color: darkslategrey;
	height: 40px;
	font-size: 20px
}
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
}</style>
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
						<li class="nav-item">
							<form method="post" action="applyleave.html">
								<button id="ApplyLeave" type="submit" name="ApplyLeave"
									class="btn btn-success waves-effect btn-sm">
									<i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;Apply Leave
								</button>
							</form>
						</li>
					</ul>
					<ul class="navbar-nav nav-flex-icons">
						<li class="nav-item">
						<a href="studentlogin.html">
							<button type="button"
								class="btn btn-danger waves-effect btn-sm" id="Logout">
								<i class="fa fa-power-off"></i>&nbsp;&nbsp;&nbsp;&nbsp;LogOut
							</button>
							</a>
						</li>
					</ul>
				</div>

			</div>
		</nav>
		<!-- Navbar -->
	</header>>
	<main class="pt-5 mx-lg-5">
	<div class="row wow fadeIn" id="Status">

		<!--Grid column-->
		<div class="col-md-16 mb-4">

			<div id="badgeDiv" class="card mb-4 wow fadeIn">
				<span id="badgeSpan" class="badge darkgreen"> <i
					id="badgeIcon" class="fa fa-th-list" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;Status
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
						<th scope="col">Rollno</th>
						<th scope="col">LeaveDate</th>
						<th scope="col">Purpose</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>${STATUS.rollno}</td>
						<td>${STATUS.leavedate}</td>
						<td>${STATUS.leavepurpose}</td>
						<td>${STATUS.status}</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
</main>

</body>
</html>