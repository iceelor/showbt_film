<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/jquery.cleditor.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.cleditor.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
     $("#input").cleditor({width:600,height:300})[0].focus();
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
<form action="updateAdDo.action" method="post">
<input type="hidden" name="id" value="${ad.id}" />
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="b5d6e6">
<tr><td width="3%" height="22" background="../images/tab/bg.gif" bgcolor="#FFFFFF" colspan="3"></td></tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">标题</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="title" size="70" value="${ad.title}"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">广告位置标记</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="adKey" size="70" value="${ad.adKey}"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">广告来源</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="source" size="70" value="${ad.source}"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">广告宽度</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="width" size="70" value="${ad.width}"></td>
  </tr>
   <tr>
    <td height="20" bgcolor="#FFFFFF">广告高度</td><td height="20" bgcolor="#FFFFFF"><input type="text" name="height" size="70" value="${ad.height}"></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF">广告代码</td><td height="20" bgcolor="#FFFFFF">
    <textarea  name="adCode" cols=60 rows=6>${ad.adCode}</textArea></td>
  </tr>
  <tr>
    <td height="20" bgcolor="#FFFFFF"></td><td height="20" bgcolor="#FFFFFF"><input type="submit" value="修改广告"></td>
  </tr>
</table>
</form>
</body>
</html>