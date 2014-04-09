<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabeçalho.html"%>

	<form method="post" action="../RemoverConcursoServlet">
		<c:forEach var="concurso" items="${concursos}">
			<input type="radio" name="concurso" value="${concurso.id}"> ${concurso.descricao}
		</c:forEach>
	<a href="../BuscarConcursoServlet"> <input type="button" value="Alterar"> </a>
	<input type="submit" value="Remover">		
	</form>
	
<%@ include file="..\Rodape.html"%>