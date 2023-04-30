<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
<link href="../bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="../jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap-filestyle.min.js"></script>
<title>Insert title here</title>
</head>
<body>


	<%--      <form:form method="POST" modelAttribute="fisierIncarcat" enctype="multipart/form-data">
               <div class="form-group">
                    	<form:input path="fisier" type="file" name="fisier"/>
                    	<input type="submit" name="submit">
                    </div>
               </form:form>>
 --%>
   <jsp:include page="../meniuNavigare.jsp" flush="true"/>
	<div class="container">

		<div class="panel panel-default fit ">
			<div class="panel-heading">
				<h3 class="panel-title">Adauga document</h3>
			</div>
			<div class="panel-body">
				<form:form method="post" modelAttribute="resursa" enctype="multipart/form-data">
					
					<div class="form-group inputMargin ">
								
						<label for="denumireResursa" class="col-md-2 control-label">Denumire resursa</label>
						<div class="col-md-10">
							<form:input path="denumireResursa" type="text" class="form-control input-lg"
								id="denumireResursa" />
						</div>
					</div>
					<div class="form-group ">
					    <label for="upload" class="col-md-2 control-label margine-20">Selecteaza fisier</label>
						<div class="col-md-8 margine-20">
								<input id="upload" type="file" name="fisier" class="form-control filestyle" data-buttonBefore="true">
								
						</div>
					</div>
                     <div class="form-group">
						<div class="col-md-offset-2 col-md-8 margine-20">
							<button type="submit" class="btn btn-default btn-lg">Adauga
								resursa</button>
						</div>
					</div> 
			
			   
				</form:form>

			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(":file").filestyle('buttonText', 'Selecteaza fisier..');
	$(":file").filestyle('buttonBefore', 'true');
	</script>
	
</body>
</html>