<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="..\Cabeçalho.html"%>

	<form method ="post" action="../CadastrarAdminServlet">
		Login: <input type = "text" name ="login"/><br /><br>
		Nome: <input type="text" name="nome" /><br /><br>
		Senha: <input type="text" name="senha" /><br /><br>
		<input type="submit" value="Salvar" />
	</form>				

<%@ include file="..\Rodape.html"%>