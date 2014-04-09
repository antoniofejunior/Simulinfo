<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ include file="..\Cabeçalho.html"%>
	<form method="post" action="../CadastraQuestaoServlet">
		Concurso: <select id="concurso">
					<c:forEach var="concurso" items="${concursos}">
						<option value="${concurso.id}">${concurso.descricao}</option>
					</c:forEach>
				</select>
		<a href="CadastrarConcurso.jsp"><input type="button" value="novo Concurso"></a>
				<br>
		Assunto: <select id="assunto">
					<c:forEach var="assunto" items="${assuntos}">
						<option value="${assunto.id}">${assunto.descricao}</option>
					</c:forEach>
				</select>
		<a href="CadastrarAssunto.jsp"><input type="button" value="novo Assunto"></a>
				<br>
		Descrição: <textarea cols="10" rows="30" name="descricao" style="height: 100px; width: 500px;">	</textarea><br>
		Alternativa correta:<input type="text" name="correta"><br>
		Alternetivas incorretas:<br>
		<input type="text" name="incorreta1"><br>
		<input type="text" name="incorreta2"><br>
		<input type="text" name="incorreta3"><br>
				
	</form>
<%@ include file="..\Rodape.html"%>