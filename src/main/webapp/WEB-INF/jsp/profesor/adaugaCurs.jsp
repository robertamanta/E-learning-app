<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html >
<html>

<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
<link href="../bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="../jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap-filestyle.min.js"></script>

<title>Adaugare curs</title>

<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<jsp:include page="../meniuNavigare.jsp" flush="true" />
	
	<div class="container">

		<div class="panel panel-default ">
			 <div class="panel-heading">
				<h3 class="panel-title">Adaugare Curs</h3>
			</div>
			
			<div class="panel-body">
				<form:form modelAttribute="curs" method="POST" enctype="multipart/form-data"
					class="form-horizontal">

					<div class="form-group ">
						<label for="codCurs" class="col-md-2 control-label">Cod
							curs:</label>
						<div class="col-md-8">
							<form:input path="idCurs" type="text"
								class="form-control input-lg" id="codCurs" placeholder="Ex:C1" />
							<form:errors path="idCurs" class="error" />
						</div>
					</div>


					<div class="form-group">
						<label for="categorie" class="col-md-2 control-label">Categorie:
						</label>
						<div class="col-sm-8">
							<form:select path="categorieCurs.denumireCategorie"
								name="categorii" id="categorie" class="form-control input-lg">
								<option value="Baze de date">Baze de date</option>
								<option value="Tehnologii bazate pe Java">Tehnologii bazate pe Java</option>
								<option value="Web Design">Web Design</option>
							</form:select>
							<form:errors path="categorieCurs.denumireCategorie" class="error" />

						</div>
					</div>
					<div class="form-group ">
						<label for="denumire" class="col-md-2 control-label">Denumire:</label>
						<div class="col-md-8">
							<form:input path="denumireCurs" type="text"
								class="form-control input-lg" id="denumire"
								placeholder="Denumire curs" />
							<form:errors path="denumireCurs" class="error" />
						</div>
					</div>

					<div class="form-group ">
						<label for="descriere" class="col-md-2 control-label">Descriere:</label>
						<div class="col-md-8">
							<form:textarea path="descriereCurs" type="text"
								class="form-control input-lg" id="descriere" rows="3"
								placeholder="Scurta descriere" />
							<form:errors path="descriereCurs" class="error" />
						</div>
					</div>
					<div class="form-group ">
						<label for="durata" class="col-md-2 control-label">Durata:</label>
						<div class="col-md-8">
							<form:input path="durataCurs" type="text"
								class="form-control input-lg" id="durata"
								placeholder="Durata in minute" />
							<form:errors path="durataCurs" class="error" />
						</div>
					</div>

					<div class="form-group ">
						<label for="pret" class="col-md-2 control-label">Pret:</label>
						<div class="col-md-8">
							<form:input path="pret" type="text" class="form-control input-lg"
								id="pret" />
							<form:errors path="pret" class="error" />
						</div>
					</div>
                  
                  <div class="form-group ">
					    <label for="upload" class="col-md-2 control-label">Pictograma</label>
						<div class="col-md-8">
								<input id="upload" type="file" name="file" class="form-control filestyle" accept=".png,.jpg">
						</div>
					</div>
					
                    
					<div class="form-group">
						<div class="col-md-offset-2 col-md-2">
							<button type="submit" class="btn btn-default btn-lg">Adauga
								curs</button>
						</div>
					</div>
                </form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(":file").filestyle('buttonText', 'Selecteaza imagine...');
	$(":file").filestyle('buttonBefore', 'true');
	</script>
</body>
</html>