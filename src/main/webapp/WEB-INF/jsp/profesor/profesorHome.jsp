<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>

<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/styles.css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<title>Acasa</title>
</head>
<body>
	<h1>Bine ai venit ${numeProfesor} !</h1>

	<div class="container">
			<h4 class="bg-primary">Cursuri adaugate</h4>
			<div>${cursuriInexistente}</div>
			<c:if test="${not empty categoriiCursuri}">
				<c:forEach var="categorie" items="${categoriiCursuri}">
				
						<button type="button" class="btn btn-info" data-toggle="collapse"
							data-target="#categorie">${categorie.key}</button>
						
								<c:forEach var="curs" items="${categorie.value}">
								
										<c:url value="cursCreat.html" var="cursCreat">
											<c:param name="idCurs" value="${curs.idCurs}" />
										</c:url>
										<a href='<c:url value="${cursCreat}" />'>${curs.denumireCurs}</a>
								
								</c:forEach>
						
				</c:forEach>
			</c:if>
	
		<%-- <button type="button" class="btn btn-info" data-toggle="collapse"
			data-target="#categorie">Programare WEB</button>
		<div id="categorie" class="collapse">
			<div class="row">				
				<div class="col-xs-6 col-md-3">
					<a href="<c:url value="/cursCreat" />" class="thumbnail"> <img
						src="bootstrap/images/programare-web.png" alt="...">
					</a>
				</div>

				<div class="col-xs-6 col-md-3">
					<a href="<c:url value="/cursCreat" />" class="thumbnail"> <img
						src="bootstrap/images/programare-web.png" alt="...">
					</a>
				</div>
			</div>
		</div> --%>
	</div>


</body>
</html>