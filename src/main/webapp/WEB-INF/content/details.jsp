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
<title><s:property value="video.name" />剧情介绍</title>
<link type="text/css" rel="stylesheet" href="./css/base.css">
<style type="text/css">
ol {
	list-style: none;
}
</style>
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

	<h5 style="text-align: center;">
		<s:property value="video.name" />
	</h5>
	<div>
		<img style="display: inline-block; width: 140px; height: 200;"
			src="<s:property value='video.imageLink'/>" alt="none" />
		<ol>
			<li>影片名：<s:property value="video.name" /></li>
			<li>类型：<s:property value="video.type" /></li>
			<li>发布日期：<s:property value="video.releaseDate" /></li>
			<li>影片介绍：<s:property value="video.details" /></li>
		</ol>
	</div>

	<h5 style="text-align: center;">播放列表</h5>
	<%-- 只有一集，直接显示播放内容 --%>
	<s:if test="video.playLinks.size() <= 1">
		<a href="<s:property value='video.playLinks[0]'/>">点击播放</a>
	</s:if>
	<s:else>
		<s:iterator id="playLink" value="video.playLinks">
			<ol>
				<li><s:property /></li>
			</ol>
		</s:iterator>
	</s:else>
</body>
</html>