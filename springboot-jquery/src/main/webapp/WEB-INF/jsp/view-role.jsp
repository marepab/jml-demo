<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Role View</title>
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
	<div class="jumbotron" style="margin-bottom: 0">
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
				<h1>${roleName}- Role Details</h1>

				<table class="table table-hover table-condensed">
					<c:if test="${!empty role.tests}">
						<thead>
							<tr>
								<th class="col-md-3">Test Name</th>
								<th class="col-md-3">Expiration in months</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${role.tests}" var="test">
								<tr>
									<td class="col-md-3">${test.testName}</td>
									<td class="col-md-3">${test.expirationInMonths}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>					
					
				</table>
				<table class="table table-hover table-condensed">
					<c:if test="${!empty role.trainings}">
						<thead>
							<tr>
								<th class="col-md-3">Training Name</th>
								<th class="col-md-3">Expiration in months</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${role.trainings}" var="training">
								<tr>
									<td class="col-md-3">${training.trainingName}</td>
									<td class="col-md-3">${training.expirationInMonths}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>					
					
				</table>

				<hr>
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
