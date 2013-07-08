<#macro head title>
	<title>${title}</title>
	<#nested>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="author" content="showbt iceelor" />
	<meta name="generator" content="showbt 秀种资源网 秀美退" />
	<meta name="owner" content="showbt Team" />
	<meta name="copyright" content="秀种资源网" />
	<meta http-equiv="Window-target" content="_top" />
	<link href="${staticServePath}/${websetting_template_default_path}css/module_01.css" rel="stylesheet"/>
	<link rel="icon" type="image/png" href="${staticServePath}/favicon.png" />
	<script type="text/javascript" src="${staticServePath}/${websetting_template_default_path}js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${staticServePath}/${websetting_template_default_path}js/jquery.slider.js"></script>		
	<#if websetting_html_head??>${websetting_html_head}</#if>
</#macro>