<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home Office View</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
		<h1>Home Office View</h1>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/getAllOfficers">List of Officers</a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-10 text-left">
				<h1>${homeOfficeOfficer.firstName}&nbsp;${homeOfficeOfficer.lastName} - Details</h1>
				<h2>Role: ${homeOfficeOfficer.roleName}</h2>
				
				<table class="table table-hover">

					<thead>
						<tr>
							<th class="col-md-3">Test Name</th>
							<th class="col-md-2">Expiration in months</th>
							<th class="col-md-2">status</th>
							<th class="col-md-2">Verifier Name</th>
							<th class="col-md-3">verification date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${homeOfficeOfficer.tests}" var="test">
							<tr>
								<td class="col-md-3">${test.testName}</td>
								<td class="col-md-2">${test.expirationInMonths}</td>
								<td class="col-md-2">${test.status}</td>
								<td class="col-md-2">${test.verifierName}</td>
								<td class="col-md-3">${test.date}</td>
							</tr>
						</c:forEach>
					</tbody>


				</table>
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="col-md-3">Training Name</th>
							<th class="col-md-2">Expiration in months</th>
							<th class="col-md-2">status</th>
							<th class="col-md-2">Verifier Name</th>
							<th class="col-md-3">verification date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${homeOfficeOfficer.trainings}" var="training">
							<tr>
								<td class="col-md-3">${training.trainingName}</td>
								<td class="col-md-2">${training.expirationInMonths}</td>
								<td class="col-md-2">${training.status}</td>
								<td class="col-md-2">${training.verifierName}</td>
								<td class="col-md-3">${training.date}</td>
							</tr>
						</c:forEach>
					</tbody>


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
