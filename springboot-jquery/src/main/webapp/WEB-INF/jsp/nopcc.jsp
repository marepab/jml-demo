<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>NPoCC View</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.jumbotron {
  background-image: url("../assets/TopBarBanner.jpg");
  background-size: cover;
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
				<h1>Roles Data</h1>
				<button type="button" class="btn" data-toggle="modal"
					data-target="#add-role-modal">Add new role</button>
				<table class="table table-hover table-condensed">
					<thead>
						<tr>
							<th class="col-md-4">Role Name</th>
							<th class="col-md-1"></th>
							<th class="col-md-1"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roles}" var="role">
							<tr>
								<td class="col-md-4">${role.roleName}</td>
								<td class="col-md-1"><a href="/getRole/${role.roleName}" type="button"
									class="btn"><span class="glyphicon glyphicon-eye-open"></span></a></td>
								<td class="col-md-1"><a href="/getRole/${role.roleName}"><span
										class="glyphicon glyphicon-edit"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="button" class="btn" data-toggle="modal"
					data-target="#add-role-modal">Add new role</button>
				<hr>
			</div>

			<!-- add role modal start-->
			<div id="add-role-modal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Add new role - with required
								capabilities</h4>
						</div>
						<div class="modal-body">
							<!-- form start-->
							<form class="form-horizontal" action="/createRole" method="post">
								<div class="form-group">
									<label class="control-label col-sm-2" for="role-name">Role
										name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="role-name"
											name="roleName" placeholder="Enter role name">
									</div>
								</div>
								Tests:
								<div class="form-group">
									<label class="control-label col-sm-2">Test Name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="test-name-1"
											name="tests[0].testName" placeholder="Enter test name">
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Expiration in
										months:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" id="expiration-1"
											name="tests[0].expirationInMonths"
											placeholder="Enter expiration time in months">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="test-name-2">Test
										Name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="test-name-2"
											name="tests[1].testName" placeholder="Enter test name">
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="test-expiration-2">Expiration
										in months:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											id="test-expiration-2" name="tests[1].expirationInMonths"
											placeholder="Enter expiration time in months">
									</div>
								</div>
								Training:
								<div class="form-group">
									<label class="control-label col-sm-2" for="training-name-1">Training
										Name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="training-name-1"
											name="trainings[0].trainingName"
											placeholder="Enter training name">
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-2"
										for="training-expiration-1">Expiration in months:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											id="training-expiration-1"
											name="trainings[0].expirationInMonths"
											placeholder="Enter expiration time in months">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="training-name-2">Training
										Name:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="training-name-2"
											name="trainings[1].trainingName"
											placeholder="Enter training name">
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-2"
										for="training-expiration-2">Expiration in months:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											id="training-expiration-2"
											name="trainings[1].expirationInMonths"
											placeholder="Enter expiration time in months">
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Save</button>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</form>
							<!-- form end-->
						</div>
					</div>

				</div>
			</div>
			<!-- add role modal end -->

		</div>

		<footer class="container-fluid text-center">
			<p>Atmecs JML POC</p>
		</footer>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
