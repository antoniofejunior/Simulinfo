<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="..\Cabe�alho.html"%>

	<form method="post" action="../CadastrarConcursoServlet">
		Descri��o: <input type="text" name="descricao">
		Ano:<input type="text" name="ano">
		<input type="submit" value="Salvar">	
	</form>
	
<%@ include file="..\Rodape.html"%>