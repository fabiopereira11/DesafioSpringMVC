<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link type="text/css" href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet"/>
		<title>Pagina de lista de Produtos</title>
</head>
<body>
		<div>
		<center><h1 class="page-header">Lista de Produtos</h1></center>
		<i>${message}</i><br/>
		<table class="table table-hover" style="text-align: center;" border="0px" cellpadding="0" cellspacing="0" >
			<thead>
				<tr>
					<th width="25px"><center>id</center></th>
					<th width="150px"><center>Produto</center></th>
					<th width="25px"><center>Quantidade</center></th>
					<th width="25px"><center>Marca</center></th>
					<th width="25px"><center>Modelo</center></th>
					<th width="25px"><center>Descrição</center></th>
					<th width="50px"><center>Ações</center></th>
				</tr>
			</thead>
		<tbody>
			<c:forEach var="produto" items="${produtoList}">
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.qtdProduto}</td>
					<td>${produto.marca}</td>
					<td>${produto.modelo}</td>
					<td>${produto.descricao}</td>
					<td>
						<a href="${pageContext.request.contextPath}/produto/edit/${produto.id}.html">Editar</a><br/>
						<a href="${pageContext.request.contextPath}/produto/delete/${produto.id}.html">Deletar</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		<a href="${pageContext.request.contextPath}/produto/create.html" class="btn btn-success">Inserir novo produto</a>
		<a href="${pageContext.request.contextPath}/" class="btn btn-primary">Inicio</a><br/>
</body>
</html>