<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabeçalho.html"%>

	<form method="post" action="../AlterarConcursoServlet">
		Descrição: <input type="text" name="descricao" value="${altconcurso.descricao}">
		Ano:<input type="text" name="ano" value="${altconcurso.ano}">
		<input type="submit" value="Salvar">	
	</form>
	
<%@ include file="..\Rodape.html"%>