<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator id="video" value="videos">
	<div class="img img-rounded">
		<s:a action="details.action">
			<s:param name="id" value="#video.id" />
			<img src='<s:property value="#video.imageLink"/>'
				alt='<s:property value="#video.name"/>' width="300" height="200">
		</s:a>
		<div class="desc">
			<s:property value="#video.name" />
		</div>
	</div>
</s:iterator>