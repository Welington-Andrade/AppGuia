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
	
		<h3>Registros: ${operacao}</h3>
	
	    <div class="form-group">
	      <label for="usr">Observador:</label>
	      <label for="usr">${registro.observador.nome}</label>
	    </div>
	
	    <div class="form-group">
	      <label for="usr">Nome:</label>
	      <label for="usr">${registro.nome}</label>
	    </div>

		<div class="form-group">
			<label for="usr">Aves:</label>

			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>NOME</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="ave" items="${registro.aves}">
				      <tr>
				        <td>${ave.id}</td>
				        <td>${ave}</td>
				      </tr>
			      </c:forEach>
			    </tbody>
			</table>	
		</div>	
	</div>
</body>
</html>