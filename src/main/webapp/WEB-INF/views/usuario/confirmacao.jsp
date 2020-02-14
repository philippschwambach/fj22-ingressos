<%--
  Created by IntelliJ IDEA.
  User: nando
  Date: 27/01/17
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ingresso:template>
    <jsp:body>
        <form action="/usuario/cadstrar" method="post">
        	
        	<span class="text-danger">${param.error}</span>
        	
        	<input type="hidden" name="token.uuid" value="${confirmacaoLoginForm.token.uuid }">
        	<input type="hidden" name="token.email" value="${confirmacaoLoginForm.token.email }">
        	
        	<div class="form-group">
        		<label for="password">Senha</label>
        		<input id="password" type="password" name="password" class="form-control">
        	</div>
        	
        	<buton class"btn btn-primary" type="submit">Cadastrar</buton>
        	
        </form>
    </jsp:body>
</ingresso:template>