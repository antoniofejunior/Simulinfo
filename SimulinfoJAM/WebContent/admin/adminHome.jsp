<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabeçalho.html"%>

<h1> Bem vindo administrador  ${user.nome} </h1>
<a href="CadastrarAdmin.jsp"> Cadastrar Administrador </a><br>
<a href="CadastrarQuestao.jsp"> Cadastrar Questão</a><br>
<a href="CadastrarConcurso.jsp"> Cadastrar Concurso </a><br>
<a href="CadastrarAssunto.jsp"> Cadastrar Assunto</a><br>
<a href="AlterarAdmin.jsp"> Alterar administrador </a><br>
<a href="AlterarAssunto.jsp"> Alterar Assunto</a><br>
<a href="AlterarConcurso.jsp"> Alterar Concurso</a><br>

<%@ include file="..\Rodape.html"%>