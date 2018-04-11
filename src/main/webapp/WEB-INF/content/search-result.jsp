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
<title>搜索结果</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
</head>
<body>

	<span class="title"> <s:a action="index.action">
			<img alt="logo" src="./images/logo.png" width="20%" height="20%"
				style="margin-left: 8%">
		</s:a> <s:form action="search.action" class="search-form" method="post">
			<input type="text" name="name" placeholder="搜索..."
				class="search-input" />
		</s:form>
	</span>
	<div class="menu">
		<ol>
			<li><s:a action="showtype" method="post">
					<s:param name="type" value="动作片"></s:param>电影</s:a></li>
			<li><s:a action="showtype" mothod="post">
					<s:param name="type" value="国产剧"></s:param>连续剧</s:a></li>
			<li><s:a action="showtype" method="post">
					<s:param name="type" value="国产剧"></s:param>国产剧</s:a></li>
			<li><s:a action="showtype" method="post">
					<s:param name="type" value="综艺"></s:param>综艺</s:a></li>
			<li><s:a action="showtype" method="post">
					<s:param name="type" value="动漫"></s:param>动漫</s:a></li>
		</ol>
	</div>

	<!-- 最新电影 -->
	<h5>搜索结果</h5>
	<s:iterator id="video" value="videos">
		<div class="responsive">
			<div class="img">
				<s:a action="details.action">
					<s:param name="id" value="#video.id" />
					<img src='<s:property value="#video.imageLink"/>'
						alt='<s:property value="#video.name"/>' width="300" height="200">
				</s:a>
				<div class="desc">
					<s:property value="#video.name" />
				</div>
			</div>
		</div>
	</s:iterator>
</body>
</html>