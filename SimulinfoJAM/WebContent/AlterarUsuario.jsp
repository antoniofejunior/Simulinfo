<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="Cabeçalho.html"%>


	<form method ="post" action="AlterarUsuarioServlet">
		Nome: <input type="text" name="nome" value="${usuario.nome}"/>
		Senha: <input type="password" name="senha"/>
		<input type="submit" value="Salvar" />
	</form>

<%@ include file="Rodape.html"%>