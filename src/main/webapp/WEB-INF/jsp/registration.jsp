<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html >
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
<link href="bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Inregistrare</title>


</head>

<body>
	<div class="container bloc-principal">

		<div class="panel panel-default  box">
			<div class="panel-heading">
				<h3 class="panel-title">Formular de inregistrare</h3>
			</div>
			<div class="panel-body">
			<c:if test="${userExists!=null}">
						<div class="alert alert-danger">
							<p>${userExists}</p>
						</div>
					</c:if>
			  
				<form:form modelAttribute="utilizator" method="POST"
					class="form-horizontal" data-toggle="validator">

					<div class="form-group ">
						<label for="nume" class="col-md-2 control-label">Nume</label>
						<div class="col-md-8">
							<form:input path="nume" type="text"
								class="form-control input-lg" id="nume" placeholder="Nume" />
							<form:errors path="nume" element="div" class="error" />
						</div>
					</div>

					<div class="form-group">
						<label for="prenume" class="col-sm-2 control-label">Prenume</label>
						<div class="col-md-8">
							<form:input path="prenume" type="text"
								class="form-control input-lg" id="prenume" placeholder="Prenume" />
							<form:errors path="prenume" element="div" class="error" />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-2 control-label">Email</label>
						<div class="col-md-8">
							<form:input path="email" type="email"
								class="form-control input-lg" id="email" placeholder="Email" />
							<form:errors path="email" class="error" />
						</div>
					</div>

					<div class="form-group">
						<label for="nume_utilizator" class="col-md-2 control-label">Nume
							utilizator</label>
						<div class="col-md-8">
							<form:input path="numeUtilizator" type="text"
								class="form-control input-lg" id="nume_utilizator"
								placeholder="Nume utilizator" />
							<form:errors path="numeUtilizator" element="div" class="error" />
						</div>
					</div>

					<div class="form-group">
						<label for="parola" class="col-md-2 control-label">Parola</label>
						<div class="col-md-8">
							<form:input path="parola" type="password"
								class="form-control input-lg" id="parola" placeholder="Parola" />
							<form:errors path="parola" class="error" />

						</div>
					</div>

					<div class="form-group">
						<label for="parolaReintrodusa" class="col-md-2 control-label">Reintroducere
							parola</label>
						<div class="col-md-8 ">
							<form:input path="potrivireParola" type="password"
								class="form-control input-lg" id="parolaReintrodusa"
								data-match="#parola"
								data-match-error="Parolele nu se potrivesc!"
								placeholder="Parola" />
							<form:errors path="potrivireParola" class="error" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="descriere" class="col-md-2 control-label">Descriere</label>
						<div class="col-md-8 ">
							<form:input path="descriere" type="text"
							class="form-control input-lg" id="descriere"
								placeholder="Scurta descriere" />
							<form:errors path="potrivireParola" class="error" />
						</div>
					</div>

					<div class="form-group">
						<label for="rol" class="col-sm-2 control-label">Tipul de
							utilizator </label>
						<div class="col-sm-8">
							<form:select path="tipUtilizator.tip" name="roluri" id="rol"
								class="form-control input-lg">
								<option value="profesor">PROFESOR</option>
								<option value="cursant">CURSANT</option>
							</form:select>
							<form:errors path="tipUtilizator.tip" class="error" />

						</div>
					</div>



					<div class="form-group">
						<div class="col-md-offset-2 col-md-8">
							<button type="submit" class="btn btn-success btn-lg">Creare
								cont</button>
						</div>
					</div>
					<div class="control-group"></div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>