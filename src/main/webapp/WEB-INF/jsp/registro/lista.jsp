<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>AppGuia</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="container-fluid" style="margin-top:80px">		
			<c:import url="/WEB-INF/jsp/header.jsp"/>
		</div>			

		<div class="dropdown">
		    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
		      Registros
		    </button>
		    <div class="dropdown-menu">
		      <a class="dropdown-item" href="/registro">Novo</a>
		    </div>
		  </div>	
		<br>

		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">
			  <strong>Erro!!</strong> ${msgError}
			</div>		
		</c:if>

		<c:if test="${not empty registros}">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>NOME</th>
			        <th>OBSERVADOR</th>
			        <th>AVES</th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="r" items="${registros}">
				      <tr>
				        <td>${r.id}</td>
				        <td>${r.nome}</td>
				        <td>${r.observador.nome}</td>
				        <td>${r.aves.size()}</td>
				        <td><a href="/registro/${r.id}/consultar">consultar</a></td>
				        <td><a href="/registro/${r.id}/excluir">excluir</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
			</table>	
		</c:if>
		<c:if test="${empty registros}">
			<div class="alert alert-warning">
				<strong>Sem registros cadastrados!!</strong>
			</div>
		</c:if>
	</div>
</body>
</html>