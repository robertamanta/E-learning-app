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
<title>Acasa</title>
</head>
<body>
	<%@ include file="../meniuNavigare.jsp"%>

	<div class="container-fluid text-center fit">
		<div class="row content fit">
			<div class="col-md-2 meniu-body" id="right" >

				 <a href="">
				    <img alt="" class="imagine-meniu" src="../bootstrap/images/profesor1.png"> 
				 </a> 
				 <div><a href="<c:url value="/profesor/adaugaCurs.html"/>"> Adauga curs nou</a></div>

			</div>
			<div class="col-md-8 text-left sidenav">
          
					<div>${cursuriInexistente}</div>
					<c:if test="${not empty categoriiCursuri}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3>Cursuri create</h3>
							</div>
							<div class="panel-body">
								<c:forEach var="categorie" items="${categoriiCursuri}">
									<hr> ${categorie.key}<hr>
									<div class="row">
										<c:forEach var="curs" items="${categorie.value}">

											<c:url value="cursCreat.html" var="cursCreat">
												<c:param name="idCurs" value="${curs.idCurs}" />
											</c:url>
											<c:url value="imagine.html" var="imagine">
												<c:param name="idCurs" value="${curs.idCurs}" />
											</c:url>
											<div class="col-md-3">
												<a href='<c:url value="${cursCreat}" />' class="thumbnail"><img 
													src='<c:url value="../${imagine}" />'></a>
												<div class="caption">
													<h3>${curs.denumireCurs}</h3>
											     </div>

											</div>
										</c:forEach>
									</div>
								</c:forEach>

							</div>
						</div>

					</c:if>

				
			</div>
          <div class="col-md-2 meniu-body">
           <a href="<c:url value="/profesor/grupuri.html"/>"><img alt="" class="imagine-meniu" src="../bootstrap/images/group.png">
                Grupuri
                </a>
            <a><img alt="" class="imagine-meniu" src="../bootstrap/images/project.png">
                Proiecte
                </a>
            <a><img alt="" class="imagine-meniu" src="../bootstrap/images/Discussion.jpg">
                Discutii
                </a>
              <a><img alt="" class="imagine-meniu" src="../bootstrap/images/Calendar1.png">
                Calendar
                </a>
                 <a href="<c:url value="/profesor/teste.html"/>"><img alt="" class="imagine-meniu" src="../bootstrap/images/test.png">
                Teste
                </a>
                 
                         </div>

		</div>
		</div>
		
</body>
</html>