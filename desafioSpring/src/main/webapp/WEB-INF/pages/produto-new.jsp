<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link type="text/css" href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/> 	
	<title>Novo Produto</title>
</head>
<body>

	<center>
	<h1 class="page-header">Novo Produto</h1>
		<form:form class="form-horizontal" cssStyle="margin-left: 500px;" method="POST" commandName="produto" action="${pageContext.request.contextPath}/produto/create.html" >
				<div class="form-group">
					<div class="form-group">
						<label class="col-lg-2 control-label">*Produto :.</label>
						<div class="col-lg-3"><form:input class="form-control" path="nome" /></div>
						<div class="col-lg-3"><form:errors path="nome" cssStyle="color: red;"/></div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">*Quantidade do Produto :.</label>
						<div class="col-lg-2"><form:input class="form-control" path="qtdProduto" /></div>
						<div class="col-lg-3"><form:errors path="qtdProduto" cssStyle="color: red;"/></div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Marca:.</label>
						<div class="col-lg-3"><form:input class="form-control" path="marca" /></div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Modelo:.</label>
						<div class="col-lg-3"><form:input class="form-control" path="modelo" /></div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Descrição:.</label>
						<div class="col-lg-3"><form:input class="form-control" path="descricao" /></div>
					</div>
					<div class="form-group" style="margin-left: -500px;">
						<span><button type="submit" class="btn btn-success">Inserir</button></span>
						<a href="${pageContext.request.contextPath}/produto/list.html" class="btn btn-info">Visualizar todos os produtos</a><br/>
					</div>
				</div>
		</form:form>
		
		<br />
		<span><a href="${pageContext.request.contextPath}/" class="btn btn-primary" >Inicio</a></span>
	 	
	 	<br />
	<i>${message}</i><br/>
	</center>
</body>
</html>