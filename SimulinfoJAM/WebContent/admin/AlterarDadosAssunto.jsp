<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabe�alho.html"%>

	<form method="post" action="../AlterarAssuntoServlet">
		Descri��o: <input type="text" name="descricao" value="${altAssunto.descricao}">
		Ano:<input type="text" name="ano" value="${altAssunto.ano}">
		<input type="submit" value="Salvar">
	</form>
	
<%@ include file="..\Rodape.html"%>