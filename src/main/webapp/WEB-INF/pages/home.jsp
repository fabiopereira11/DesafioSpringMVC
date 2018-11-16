<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link type="text/css" href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/>
	<title>Cadastro de Produtos</title>
</head>
<body>
	<center>
		<div class="page-header">
			<h1>Cadastro de Produtos</h1>
			<h1><small>Bem vindo ao cadastramento de produtos!!.</small></h1><br/>
		</div>
		<i>${message}</i><br/>
		
		<a href="${pageContext.request.contextPath}/produto/create.html"  class="btn btn-success">Inserir novo produto</a><br/><br/>
		<a href="${pageContext.request.contextPath}/produto/list.html"  class="btn btn-info">Visualizar todos os produtos</a><br/>
		
	</center>
</body>
</html>