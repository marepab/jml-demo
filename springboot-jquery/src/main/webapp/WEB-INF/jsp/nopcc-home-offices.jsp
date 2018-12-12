<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>NPoCC View</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
</style>
</head>
<body>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>NPoCC View</h1>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/getAllRoles">Roles</a></li>
					<li><a href="/home-offices">Home Offices</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-10 text-left">
				<h1>Home Offices List</h1>
				
				<table class="table table-hover table-condensed">
					<thead>
						<tr>
							<th class="col-md-3">Home Office Id</th>
							<th class="col-md-3">Home Office Name</th>
							<th class="col-md-3"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${homeOffices}" var="homeOffice">
							<tr>
								<td class="col-md-3">${homeOffice.homeOfficeId}</td>
								<td class="col-md-3">${homeOffice.homeOfficeName}</td>
								<td class="col-md-3"><a href="/getOffice/${homeOffice.homeOfficeId}" type="button"
									class="btn"><span class="glyphicon glyphicon-eye-open"></span></a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>

			

		</div>

		<footer class="container-fluid text-center">
			<p>Atmecs JML POC</p>
		</footer>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
