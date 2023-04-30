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
<title>Grupuri</title>
</head>
<body>
	<%@ include file="../meniuNavigare.jsp"%>
		<div class="container-fluid text-center fit">
		<div class="col-md-2">
		</div>
		<div class="col-md-8 text-left">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Utilizatori</h3>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Denumire</th>
								<th>Optiuni</th>
							</tr>
						</thead>
						<tbody>
							<tr class="display-inline">

							</tr>
							<c:forEach var="cursant" items="${cursanti}">
								 
								<tr >
									<td>${cursant.numeUtilizator}</td>
									<td><span class="glyphicon glyphicon-plus"></span>
										<span class="glyphicon glyphicon-minus"></span>
									</td>
								</tr>
							   
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-2">
					</div>
	</div>
	<script type="text/javascript">
	jQuery(document).ready(function($) {
	    $(".grup-link").click(function() {
	        window.document.location = $(this).data("href");
	    });
	});
	</script>
</body>
</html>