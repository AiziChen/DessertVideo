<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title><s:property value="type" /></title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
</head>
<body>
	<s:include value="_header.jsp"></s:include>

	<div class="panel panel-info">
		<!-- 面板标题 -->
		<div class="panel-heading">
			<h5 class="panel-title">
				<s:property value="type" />
			</h5>
		</div>
		<!-- 面板内容 -->
		<div class="panel-body">
			<s:include value="_body.jsp"></s:include>
		</div>
	</div>
	<s:if test="totalPage > 1">
		<div
			style="display: block; clear: both; text-align: right; margin-right: 8%; margin-bottom: 5%;">
			<s:a action="showtype" class="btn btn-primary">
				<s:param name="type" value="type"></s:param>
				<s:param name="page" value="page+1"></s:param>
			下一页
		</s:a>
			<br /> 当前
			<s:property value="page" />
			/共
			<s:property value="totalPage" />
			页
		</div>
	</s:if>
	
	<s:include value="_footer.jsp"></s:include>
</body>
</html>