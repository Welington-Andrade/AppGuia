<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css" href="style.css">

<nav class="navbar navbar-expand-sm bg-success navbar-dark fixed-top">
	
	<h4>Olá  ${user.nome}</h4>
	<a href="/login"><img alt="logo" src="/infnet-logo.png"></a><h3>AppGuia</h3>
	
  	<ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="/observadores">Observadores</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/registros">Registros</a>
	    </li>	    
	    <li class="nav-item">
	      <a class="nav-link" href="/aves">Aves</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/especies">Espécies</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/familias">Famílias</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/ordens">Ordens</a>
	    </li>    
	</ul>
	<br>
	<a id="logout" class="navbar-brand" href="/sair">Logout</a> 
</nav>