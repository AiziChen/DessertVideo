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
	<s:include value="_header.jsp"></s:include>


	<div class="panel panel-info">
		<!-- 面板标题 -->
		<div class="panel-heading">
			<h5 class="panel-title">
				<s:property value="video.name" />
			</h5>
		</div>
		<!-- 面板内容 -->
		<div class="panel-body">
			<div class="well well-lg">
				<img style="display: inline-block;" class="img-rounded"
					src="<s:property value='video.imageLink'/>" alt="none" />
				<div class="well">
					<ol>
						<li>影片名：<s:property value="video.name" /></li>
						<li>类型：<s:property value="video.type" /></li>
						<li>发布日期：<s:property value="video.releaseDate" /></li>
						<li>影片介绍：<s:property value="video.details" /></li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<div class="panel panel-info">
		<!-- 面板标题 -->
		<div class="panel-heading">
			<h5 class="panel-title">播放列表</h5>
		</div>
		<!-- 面板内容 -->
		<div class="panel-body">
			<%-- 只有一集，直接显示播放内容 --%>
			<s:if test="video.playLinks.size() <= 1">
				<a class="btn btn-info" target="_blank"
					href="<s:property value='video.playLinks[0]'/>">点击播放</a>
			</s:if>
			<s:else>
				<s:iterator id="playLink" value="video.playLinks">
					<ol>
						<li><s:property /></li>
					</ol>
				</s:iterator>
			</s:else>
		</div>
	</div>

	<s:include value="_footer.jsp"></s:include>
</body>
</html>