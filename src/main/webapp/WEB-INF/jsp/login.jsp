<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
	</div>
	
<div class="container">
    <h1>Projeto AppGuia</h1>
    <p>Sistema para guia de observação de aves</p>
  
  <c:if test="${not empty mensagem}">
	  <div class="alert alert-warning">
	    <strong>Erro!</strong> ${mensagem}
	  </div>
  </c:if>
  <form action="/login" class="was-validated" method="post">
    <div class="form-group">
      <label for="uname">Login:</label>
      <input type="text" class="form-control" placeholder="Entre com o login" name="login" required>
      <div class="valid-feedback">ok</div>
      <div class="invalid-feedback">Por favor, insira o login!</div>
    </div>
    <div class="form-group">
      <label for="pwd">Senha:</label>
      <input type="password" class="form-control" placeholder="Entre com a senha" name="senha" required>
      <div class="valid-feedback">ok</div>
      <div class="invalid-feedback">Por favor, insira a senha!</div>
    </div>

    <button type="submit" class="btn btn-primary">Logar</button>
  </form>
</div>

</body>
</html>