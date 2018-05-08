<%@page import="quanye.dessertvideo.domain.Sitcom"%>
<%@page import="quanye.dessertvideo.domain.Portrait"%>
<%@page import="quanye.dessertvideo.domain.Movies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<span class="title"> <s:a action="index.action">
		<img alt="logo" src="./images/logo.png" width="20%" height="20%"
			style="margin-left: 8%">
	</s:a> <s:form action="search.action" class="search-form" method="post">
		<input type="text" name="name" placeholder="搜索..."
			class="search-input" />
	</s:form>
</span>
<%
	pageContext.setAttribute("movies", Movies.values());
	pageContext.setAttribute("portraits", Portrait.values());
	pageContext.setAttribute("sitcoms", Sitcom.values());
%>
<div class="menu">
	<ol>
		<s:iterator id="name" value="#attr.movies">
			<li role="presentation"><s:a action="showtype" role="menuitem">
					<s:param name="type" value="#name.getName()" />
					<s:property value="#name.getName()" />
				</s:a></li>
		</s:iterator>
	</ol>
</div>
<div class="menu">
	<ol>
		<s:iterator id="name" value="#attr.sitcoms">
			<li role="presentation"><s:a action="showtype" role="menuitem">
					<s:param name="type" value="#name.getName()" />
					<s:property value="#name.getName()" />
				</s:a></li>
		</s:iterator>
	</ol>
</div>

<div class="menu">
	<ol>
		<li><s:a action="showtype">
				<s:param name="type" value="%{'综艺'}" />综艺</s:a></li>
		<li><s:a action="showtype">
				<s:param name="type" value="%{'动漫'}" />动漫</s:a></li>
	</ol>
</div>
