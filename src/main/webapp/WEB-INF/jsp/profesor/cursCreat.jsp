<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>

<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-editable.css" rel="stylesheet">
<link href="bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-editable.js"></script>
<title>${curs.denumireCurs}</title>
</head>
<body>
	<%@ include file="../meniuNavigare.jsp"%>
	<div class="container-fluid  fit">
		<div class="row content fit">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">${curs.denumireCurs}</div>

					<div class="panel-body">
						<div class="col-md-10">
							<h4 class="linieOrizontala">${curs.descriereCurs }</h4>
							<div class="col-md-8 box" id="continutCurs"></div>
						</div>

						<div class="col-md-2 linieVerticala">

							<button class="btn mybtn btn-block " id="btnSectiune">
								<img src="bootstrap/images/interface.png"> Sectiune
							</button>
							<div class="modal fade" id="myModal" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Adauga lectie</h4>
										</div>
										<div class="modal-body">
											<p>Nume lectie</p>
											<input type="text" class="form-control" id="numeLectie"
												maxlength="60">
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Renunta</button>
											<button type="button" class="btn btn-danger"
												id="btnAdaugaLectie">Adauga lectie</button>
										</div>
									</div>
								</div>
							</div>

							<script>
								var contor = 1;

								$('#btnSectiune')
										.click(
												function() {

													$("#continutCurs")
															.append(
																	'<div class="sectiune" > <span href="#"  class="label label-primary editareSpan">Sectiune '
																			+ contor
																			+ '</span> <span class="stergere" data-toggle="tooltip" data-placement="bottom" title="Sterge capitol"><img src="bootstrap/images/delete.png"></span>'
																			+ '<span class="adaugare" data-toggle="tooltip" data-placement="bottom" title="Adauga lectie"><img src="bootstrap/images/add.png"></span>'
																			+ '</div>');
													contor = contor + 1;

												});

								$('#continutCurs').on(
										'click',
										'.stergere',
										function(e) {
											e.preventDefault();
											$(this).closest('.sectiune')
													.remove();
											return false;
										});

								$('#continutCurs').on('click', '.editareSpan',
										function() {
											$('.editareSpan').editable({
												type : 'text',
												pk : 1,
												title : 'Nume sectiune'

											});
										});

								var add;
								$('#continutCurs').on('click', '.adaugare',
										function() {
											$("#myModal").modal('show');
											add = $(this);

										});

								//click pe butonul adauga de pe modal
								$('#myModal')
										.on(
												'click',
												'#btnAdaugaLectie',
												function() {
													var numeLectie = $(
															'#numeLectie')
															.val();
													add
															.closest(
																	'.sectiune')
															.append(
																	'<div class="lectie">'
																			+ '<span class="label  label-lectie" data-underline="false">'
																			+ numeLectie
																			+ '</span>'
																			+ ' <span class="stergereLectie" data-toggle="tooltip" data-placement="bottom" title="Sterge lectie"><img src="bootstrap/images/delete.png"></span>'
																			+ '<span class="dropdown">'
																			+ '<button class="btn add dropdown-toggle" type="button" data-toggle="dropdown">Adauga '
																			+ '<span class="caret"></span></button>'
																			+ '<ul class="dropdown-menu">'
																			+ '<li><a href="#">Continut</a></li>'
																			+ '<li><a href="#">Document|Prezentare</a></li>'
																			+ '<li><a href="#">Audio</a></li>'
																			+ '<li><a href="#">Video</a></li></ul></span>'
																			+ '</div>');
													$('#numeLectie').val('');
													$('#myModal').modal('hide');

												});

								$('#continutCurs')
										.on(
												'click',
												'.stergereLectie',
												function(e) {
													e.preventDefault();
													$(this).closest('.lectie')
															.remove();
													return false;
												});
								$('#continutCurs').on('click', '.label-lectie',
										function() {
											$('.label-lectie').editable({
												type : 'text',
												pk : 1,
												title : 'Denumire lectie'

											});
										});
							</script>
							<script>
								$('#continutCurs').on('mouseover', '.sectiune',
										function() {
											$('.stergere').tooltip();
											$('.adaugare').tooltip();
										});
							</script>


						</div>
						<button class="btn  btn-default btn-lg" id="btnSalveaza"
							type="submit">Salveaza modificari</button>
						<script>
							$('#btnSalveaza').click(function() {
								$('.editareSpan').each(function() {
									console.log($(this).text())
									
								})
							})
					    
						</script>
						<form:form id="hidenForm" style="display: none;" method="POST"  modelAttribute="curs">
							<form:input path="curs.capitole" type="text"
								class="form-control input-lg" id="codCurs" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>