<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ShowBt电影网</title>
		<meta name="keywords" content="电影下载,最新电影,电影天堂,电影网,高清电影下载,电影网站,showbt.com"/>
		<meta name="description" content="秀种电影网－可以在线收看从各大视频网站搜集到的最新搞笑视频"/>
		<link href="css/module_01.css" rel="stylesheet"/>
		<link href="css/dytt8_content.css" rel="stylesheet"/>
		<link href="css/bdsstyle.css" rel="stylesheet"/>
		<style type="text/css">
			body { background-image:url(text.txt); background-attachment:fixed; }
			#bottomNav { z-index:999; position:fixed; bottom:0; left:0; width:100%; _position:absolute;
			_top: expression_r(documentElement.scrollTop + documentElement.clientHeight-this.offsetHeight); overflow:visible; }
		</style>
	</head>
	<body>
	<#include "/top.ftl">
	<iframe src="${video.sourceUrl}" id="iframepage" name="iframepage" frameBorder=0 scrolling=auto width="100%" height=800></iframe>
	<#include "/foot.ftl">
	</body>
</html>