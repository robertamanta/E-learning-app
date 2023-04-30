<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>

<head>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-editable.css" rel="stylesheet">
<link href="../bootstrap/css/stiluri.css" rel="stylesheet">
<script type="text/javascript" src="../jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/bootstrap-editable.js"></script>
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
					<div class="linie-orizontala">
					
						
						<h4 >${curs.descriereCurs }
						</h4>
				    </div>
						<div class="col-md-12 box" id="continutCurs">
							<form:form modelAttribute="curs" method="POST">
								<form:hidden path="denumireCurs" value="${curs.denumireCurs}" />
								<form:hidden path="descriereCurs" />
								<form:hidden path="durataCurs" />

								<div class="col-md-8 margine-10">
									<table>
										<c:forEach var="capitol" varStatus="i"
											items="${curs.capitole}">
											<tr class="capitol">
												<td class="display-block"><div
														class="col-md-8 margine-10">
														<form:input path="capitole[${i.index}].denumireCapitol"
															value="${capitol.denumireCapitol}"
															class="form-control input-lg cp"
															placeholder="Denumire capitol" />
														<form:errors path="capitole[${i.index}].denumireCapitol"
															element="div" class="error" />
														<form:hidden path="capitole[${i.index}].idCapitol"
															value="${capitol.idCapitol}" id="idCapitol" />
													</div>


													<div class="col-md-1 margine-20">
														<p data-placement="top" data-toggle="tooltip"
															title="Adaugare lectie">
															<button type="button"
																class="btn btn-primary btn-xs adaugareLectie"
																value="${capitol.idCapitol}" id="btnIdCapitol">
																<span class="glyphicon glyphicon-plus"></span>
															</button>
														</p>
													</div>

													<div class="col-md-1 margine-20 ">
														<p data-placement="top" data-toggle="tooltip"
															title="Stergere capitol">
															<button type="submit" value="${capitol.idCapitol}"
																name="stergereCapitol" class="btn btn-danger btn-xs">
																<span class="glyphicon glyphicon-trash"></span>
															</button>
														</p>
													</div></td>

												<c:forEach var="lectie" varStatus="j"
													items="${capitol.lectii}">

													<td class="lectie display-block"><div
															class="col-md-8 margine-10">
															<form:input
																path="capitole[${i.index}].lectii[${j.index }].denumireLectie"
																value="${lectie.denumireLectie}"
																class="form-control input-md" />
															<form:hidden
																path="capitole[${i.index}].lectii[${j.index }].idLectie"
																value="${lectie.idLectie}" />
														</div>
														<div class="col-md-2 margine-15">
															<p data-placement="top" data-toggle="tooltip"
																title="Stergere lectie">
																<button type="submit" value="${lectie.idLectie}"
																	name="stergereLectie" class="btn btn-primary btn-xs">
																	<span class="glyphicon glyphicon-trash"></span>
																</button>
															</p>
														</div>
														<div class="col-md-1 margine-15">

															<c:url value="incarcareResursa.html"
																var="incarcareResursa">
																<c:param name="idLectie" value="${lectie.idLectie}" />
															</c:url>
															<p data-placement="top" data-toggle="tooltip"
																title="Adaugare Resursa">
																<a href='<c:url value="${incarcareResursa}" />'>
																	<button type="button" value="${lectie.idLectie}"
																		name="stergereLectie" class="btn btn-primary btn-xs">
																		<span class="glyphicon glyphicon-upload"></span>
																	</button>
																</a>
															</p>
														</div>

														<div class="col-md-1 margine-15">


															<p data-placement="top" data-toggle="tooltip"
																title="Adaugare Test">
																<a href='<c:url value="/profesor/teste.html" />'>
																	<button type="button" name="adaugareTest"
																		class="btn btn-primary btn-xs">
																		<span class="glyphicon glyphicon-edit"></span>
																	</button>
																</a>
															</p>
														</div></td>

												</c:forEach>

											</tr>
										</c:forEach>

									</table>
									<div class="form-group">
										<div class="col-md-offset-2 col-md-2">
											<button type="submit" class="btn btn-default btn-lg mybtn">Salveaza
												modificari</button>
										</div>
									</div>
								</div>

								<div class="col-md-4 margine-20">
								    <button type="button"
										class="btn mybtn btn-block adaugareCapitol float" id="btnSectiune">
										<img src="../bootstrap/images/interface.png"> Capitol
									</button>
									
									<c:url value="teste.html" var="teste">
												<c:param name="idCurs" value="${curs.idCurs}" />
									</c:url>
									 <a href='<c:url value="${teste}" />'>
									 <button type="button"
										class="btn mybtn btn-block adaugareTest float" id="btnSectiune">
										<img src="../bootstrap/images/interface.png">Teste
									</button>
									</a>
									
									
								</div>


								<div class="modal fade" id="myModal" role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Adauga capitol</h4>
											</div>
											<div class="modal-body">
												<p>Denumire capitol</p>
												<input type="text" class="form-control" id="numeCapitol"
													name="adaugaCapitol" maxlength="60">
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Renunta</button>
												<button type="submit" class="btn btn-danger"
													id="btnAdaugaCapitol">Adauga capitol</button>
											</div>
										</div>
									</div>
								</div>

								<div class="modal fade" id="modalLectie" role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Adauga lectie</h4>
											</div>
											<div class="modal-body">
												<p>Denumire lectie</p>
												<input type="text" class="form-control" name="adaugaLectie"
													maxlength="60"> <input type="hidden"
													class="form-control" id="modalIdCapitol" name="idCapitol"
													maxlength="60">
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Renunta</button>
												<button type="submit" class="btn btn-danger"
													id="btnAdaugaLectie">Adauga lectie</button>
											</div>
										</div>
									</div>
								</div>
							</form:form>

						</div>


						<div class="col-md-2 linieVerticala">


							<script type="text/javascript">
								$('#continutCurs').on(
										'click',
										'.stergereCapitol',
										function(e) {
											e.preventDefault();
											$(this).closest('.capitol')
													.remove();

											return false;
										});
							</script>

							<script>
								$('#continutCurs').on('click',
										'.adaugareCapitol', function() {
											$("#myModal").modal('show');
											add = $(this);

										});
								$('#continutCurs').on(
										'click',
										'.adaugareLectie',
										function() {
											$("#modalLectie").modal('show');
											add = $(this);
											//var capitol=$(this).prev().attr('value');
											$('#modalIdCapitol').val(
													$(this).val());
										});
							</script>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>