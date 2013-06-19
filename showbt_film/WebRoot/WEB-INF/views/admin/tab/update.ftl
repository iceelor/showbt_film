<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../css/jquery.cleditor.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../../js/jquery.cleditor.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
     $("#input").cleditor()[0].focus();
   });
 </script>
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
</head>
<body>
<form action="updateDo.action" method="post">
<input type="hidden" value="${dytt8.id}" name="id" />
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="b5d6e6">
<tr><td width="3%" height="22" background="../../images/tab/bg.gif" bgcolor="#FFFFFF" colspan="3"></td></tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">标题</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="title" size="70" value="${dytt8.title}"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">副标题</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="subtitle" size="70" value="<#if dytt8.subtitle??>${dytt8.subtitle}</#if>"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">类型</td><td height="20" bgcolor="#FFFFFF">
    <select name="category">
    	<option value="0">选择分类</option>
    	<option value="1">动作</option>
    </select></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">下载地址</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="downUrl" value="${dytt8.downUrl}" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">原始地址</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="sourceUrl" value="<#if dytt8.sourceUrl??>${dytt8.sourceUrl}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">在线地址</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="sourceUrl" value="<#if dytt8.onlineUrl??>${dytt8.onlineUrl}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">图片</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="imageUrl" value="${dytt8.imageUrl}" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">首页小图</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="indexThumb" value="<#if dytt8.indexThumb??>${dytt8.indexThumb}</#if>" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">幻灯小图</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="slideThumb" value="<#if dytt8.slideThumb??>${dytt8.slideThumb}</#if>" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">幻灯大图</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="slideImg" value="<#if dytt8.slideImg??>${dytt8.slideImg}</#if>" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">推荐小图</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="recommendImg" value="<#if dytt8.recommendImg??>${dytt8.recommendImg}</#if>" size=70></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">主演</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="protagonist" value="<#if dytt8.protagonist??>${dytt8.protagonist}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">导演</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="director" value="<#if dytt8.director??>${dytt8.director}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">年代</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="showTime" value="<#if dytt8.showTime??>${dytt8.showTime}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">地区</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="district" value="<#if dytt8.district??>${dytt8.district}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">标签</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="tags" size="70" value="<#if dytt8.tags??>${dytt8.tags}</#if>"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">视频时长</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="timeLen" value="<#if dytt8.timeLen??>${dytt8.timeLen}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">文件大小</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="fileSize" value="<#if dytt8.fileSize??>${dytt8.fileSize}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">语言</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="language" value="<#if dytt8.language??>${dytt8.language}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">字幕</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="caption" value="<#if dytt8.caption??>${dytt8.caption}</#if>" size="70"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">视频尺寸</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="videoSize" size="70" value="<#if dytt8.videoSize??>${dytt8.videoSize}</#if>"></td>
  </tr>
   <tr>
    <td height="20" bgcolor="#FFFFFF">文件格式</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="fileFormat" size="70" value="<#if dytt8.fileFormat??>${dytt8.fileFormat}</#if>"></td>
  </tr>
   <tr>
    <td height="20" bgcolor="#FFFFFF">推荐</td><td height="20" bgcolor="#FFFFFF">
   <input type="radio" name="recommend"   <#if dytt8.recommend==1>checked</#if> value="1"/> 首页幻灯
    <input type="radio" name="recommend"  <#if dytt8.recommend==2>checked</#if>  value="2"/>首页顶部推荐
    <input type="radio" name="recommend" <#if dytt8.recommend==3>checked</#if>  value="3"/>首页中部推荐
    </td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">内容</td><td height="20" bgcolor="#FFFFFF"><textarea id="input" name="content">${dytt8.content}</textarea></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF"></td><td height="20" bgcolor="#FFFFFF"><input type="submit" value="更新"></td>
  </tr>
</table>
</form>
</body>
</html>