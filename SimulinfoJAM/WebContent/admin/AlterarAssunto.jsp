<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabeçalho.html"%>

	<form method="post" action="../RemoverAssuntoServlet">
		<c:forEach var="assunto" items="${assuntos}">
			<input type="radio" name="assunto" value="${assunto.id}"> ${assunto.descricao}
		</c:forEach>
	<a href="../BuscarAssuntoServlet"> <input type="button" value="Alterar"> </a>
	<input type="submit" value="Remover">		
	</form>
	
<%@ include file="..\Rodape.html"%>