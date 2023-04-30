<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<link href="../bootstrap/css/stiluri.css" rel="stylesheet">
<title>Grup nou</title>
</head>
<body>
	<%@ include file="../meniuNavigare.jsp"%>
<div class="container-fluid text-center fit">
		<div class="col-md-2">
		</div>
		<div class="col-md-8 text-left">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Grup nou</h3>
					
				</div>
				<div class="panel-body">
					<form:form modelAttribute="grup" method="POST" class="form-horizontal">

					<div class="form-group ">
						<label for="cheieGrup" class="col-md-2 control-label">Cheie
							grup:</label>
						<div class="col-md-8">
							<form:input path="idGrup" type="text"
								class="form-control input-lg" id="cheieGrup"  />
						</div>
					</div>
					
					<div class="form-group ">
						<label for="denumireGrup" class="col-md-2 control-label">Denumire grup:
						</label>
						<div class="col-md-8">
							<form:input path="denumireGrup" type="text"
								class="form-control input-lg" id="denumireGrup" placeholder="Denumire grup"  />
						</div>
					</div>
					
					<div class="form-group ">
						<label for="descriere" class="col-md-2 control-label">Descriere grup:</label>
						<div class="col-md-8">
							<form:textarea path="descriereGrup" type="text"
								class="form-control input-lg" id="descriere" rows="3"
								placeholder="Scurta descriere" />
							
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-offset-2 col-md-2">
							<button type="submit" class="btn btn-default btn-lg">Adauga
								grup</button>
						</div>
					</div>
					</form:form>
				
				</div>
			</div>
		</div>
		<div class="col-md-2">
			
		</div>
	</div>

</body>
</html>