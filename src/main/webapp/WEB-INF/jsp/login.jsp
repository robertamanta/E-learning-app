<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!DOCTYPE html >

<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
<link href="bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<title>Login</title>
</head>

<body class="login">
	<div class="container">
		<div
			class="row col-md-6 col-md-offset-4 login-panel">

			<div class="panel panel-primary ">

				<div class="panel-heading login-panel-head">
					<div class="panel-title" id="titlu-login">Login</div>
					<div id="parola-uitata">
						<a href="#" id="parola-uitata">Ai uitat parola?</a>
					</div>
				</div>

				<div class="panel-body login-panel-body">

					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Nume de utilizator sau parola gresite!.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>Ai fost delogat cu succes!</p>
						</div>
					</c:if>

					<c:if test="${param.regis!=null}">
						<div class="alert alert-success">
							<p>Inregistrare reusita!</p>
						</div>
					</c:if>

					<form:form modelAttribute="utilizator" method="post">

						<div id="form-login">
							<div class="input-group  inputMargin ">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
							<form:input path="numeUtilizator" type="text"
								class="form-control input-lg" id="nume_utilizator"
								placeholder="Nume utilizator" />
							</div>

							<div class="input-group sectiune">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span>
								<form:input path="parola" type="password"
								class="form-control input-lg" id="parola" placeholder="Parola" />
							</div>

							<div class="input-group">
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me"> Tine-ma minte!
									</label>
								</div>
							</div>
						</div>

						<div class="input-group">
							<div class="col-sm-12 ">
								<button type="submit" class="btn btn-primary mybtn" id="log-btn">Log
									in</button>
							</div>
						</div>

						<div style="border-top: 1px solid #999; padding-top: 20px"
							class="form-group">
							<div class="input-group">

								<div>
									Nu esti inregistrat? <a
										href='<c:url value="/registration.html" />'>Creeaza cont!</a>
								</div>

							</div>
						</div>

					</form:form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>