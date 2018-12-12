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
		<h1>${homeOfficeName}</h1>
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
				<h1>Home Office Details</h1>
				<a href="/openCreateOfficer" type="button" class="btn">Create
					Officer</a>
				<table class="table table-hover table-condensed">
					<c:if test="${!empty homeOfficeOfficers}">
						<thead>
							<tr>
								<th class="col-md-4">Officer Id</th>
								<th class="col-md-2">Officer Name</th>
								<th class="col-md-2">Role</th>
								<th class="col-md-2"></th>
								<th class="col-md-2"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${homeOfficeOfficers}" var="officer">
								<tr>
									<td class="col-md-4">${officer.officerId}</td>
									<td class="col-md-2">${officer.firstName}&nbsp;${officer.lastName}</td>
									<td class="col-md-2">${officer.roleName}</td>
									<td class="col-md-2"><a href="/getOfficer/${officer.officerId}"
										type="button" class="btn"><span
											class="glyphicon glyphicon-eye-open"></span></a></td>
									<td class="col-md-2"><a href="/getOfficer/${officer.officerId}"
										type="button" class="btn"><span
											class="glyphicon glyphicon-edit"></span></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</c:if>

				</table>
				<a href="/openCreateOfficer" type="button" class="btn">Create
					Officer</a>

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
