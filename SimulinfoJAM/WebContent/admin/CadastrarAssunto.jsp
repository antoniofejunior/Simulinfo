<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="..\Cabeçalho.html"%>

	<form method="post" action="../CadastrarAssuntoServlet">
	Descrição: <input type="text" name="descricao">
	<input type="submit" value="Salvar">	
	</form>

<%@ include file="..\Rodape.html"%>