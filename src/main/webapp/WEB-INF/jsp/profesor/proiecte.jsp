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
		<div class="col-md-8 text-left">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Proiecte create</h3>
				</div>
				<div class="panel-body">
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Denumire</th>
        <th>Descriere</th>
        <th>Optiuni</th>
      </tr>
    </thead>
    <tbody>
   		<tr class="display-inline">
   			
   		</tr>
      	<c:forEach var="grup" items="${grupuri}">
      		   <tr>
      				<td>${grup.denumireGrup}</td>
      				<td>${grup.descriereGrup}</td>
      				<td></td>
      			</tr>

      	</c:forEach>
    </tbody>
  </table>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<a href="<c:url value="/profesor/adaugaGrup.html"/>"><img alt="" class="imagine-meniu" src="../bootstrap/images/adauga_grup.jpg">
                Adauga grup
            </a>
		</div>
	</div>
</body>
</html>