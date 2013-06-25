<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>${video.title}---<#if showBtStatic("websetting@websetting_title")??>${showBtStatic("websetting@websetting_title").sValue}</#if></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="<#if showBtStatic("websetting@websetting_video_keywords")??>${showBtStatic("websetting@websetting_video_keywords").sValue}</#if>"/>
		<meta name="description" content="<#if showBtStatic("websetting@websetting_video_description")??>${showBtStatic("websetting@websetting_video_description").sValue}</#if>"/>
		<link rel="shortcut icon" href="/favicon.ico" />		
		<#if showBtStatic("websetting@websetting_head")??>${showBtStatic("websetting@websetting_head").sValue}</#if>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_01.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/dytt8_content.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/bdsstyle.css" rel="stylesheet"/>
		<style type="text/css">
			body { background-image:url(text.txt); background-attachment:fixed; }
			#bottomNav { z-index:999; position:fixed; bottom:0; left:0; width:100%; _position:absolute;
			_top: expression_r(documentElement.scrollTop + documentElement.clientHeight-this.offsetHeight); overflow:visible; }
		</style>
	</head>
	<body>
	
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"top.ftl">
	<iframe src="${video.sourceUrl}" id="iframepage" name="iframepage" frameBorder=0 scrolling=auto width="100%" height=800></iframe>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"foot.ftl">
	</body>
</html>