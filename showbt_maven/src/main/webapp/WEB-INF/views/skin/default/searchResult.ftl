<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><#if showBtStatic("websetting@websetting_title")??>${showBtStatic("websetting@websetting_title").sValue}<#else>秀种资源网</#if></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="<#if showBtStatic("websetting@websetting_keywords")??>${showBtStatic("websetting@websetting_keywords").sValue}</#if>"/>
		<meta name="description" content="<#if showBtStatic("websetting@websetting_description")??>${showBtStatic("websetting@websetting_description").sValue}</#if>"/>
		<link rel="shortcut icon" href="/favicon.ico" />		
		<#if showBtStatic("websetting@websetting_head")??>${showBtStatic("websetting@websetting_head").sValue}</#if>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_01.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_static_8d4870a0.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/movie_27a6d47d.css" rel="stylesheet"/>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery-1.7.2.min.js"></script>
		<script language="javascript">
		function seedSearch(url){
			var obj = document.getElementById("seedSearchForm");
			obj.action=url;
			obj.submit();
		}
		</script>
		<style>
		.search-wrap {
		    background-color: #FFFFFF;
		    border: 1px solid #C4C2C2;
		    border-radius: 0 0 5px 5px;
		    height: 138px;
		    margin: auto;
		    overflow: hidden;
		    position: relative;
		}
		
		.baidu-logo {
		    background-position: 0 5px;
		}
		.baidu-logo, .google-logo, .taobao-logo, .jingdong-logo, .dangdang-logo, .amazon-logo {
		    background: url("${showBtStatic("websetting@websetting_template_default_path").sValue}img/logo.jpg") no-repeat scroll 0 10px transparent;
		    height: 122px;
		    left: 20px;
		    position: absolute;
		    top: 45px;
		    width: 290px;
		}
		.wrap {
		    margin: auto;
		    width: 798px;
		    padding-top: 7%;
		    padding-bottom: 7%;
		}
		.search-form {
		    left: 220px;
		    position: absolute;
		    top: 65px;
		}
					
		.outer-wrap {
		    background: none repeat scroll 0 0 #CDE6FE;
		    padding: 3px;
		    width: 508px;
		}
					
		.inner-wrap {
		    background: none repeat scroll 0 0 #FFFFFF;
		    border: 1px solid #009AE2;
		    height: 30px;
		}
		
		.search-key {
		    background: none repeat scroll 0 0 transparent;
		    border: 0 none;
		    float: left;
		    height: 30px;
		    padding: 0 4px;
		    width: 400px;
		}
		
		.search-btn {
		    background-position: 0 0;
		    border: 0 none;
		    color: #FFFFFF;
		    float: right;
		    height: 30px;
		    line-height: 30px;
		    text-align: center;
		    width: 85px;
		}
		.search-nav li.current, .search-btn {
		    background: url("${showBtStatic("websetting@websetting_template_default_path").sValue}img/btn_bgs.png") no-repeat scroll 0 0 transparent;
		}
		</style>
	</head>
	<body>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/top.ftl">
	<div id="main">
	<div class="search-wrap" id="searchBox">
			<form enctype="application/x-www-form-urlencoded" method="post" class="search-form" id="seedSearchForm" name="search-form" accept-charset="utf-8" >
				<div class="outer-wrap">
					<div class="inner-wrap">
						<input type="text" autocomplete="off" class="search-key keyInput" name="keywords" id="searchKey" value="${keywords}" />
						<input type="button" value="搜索" onClick="seedSearch('searchDo')" class="search-btn" id="searchBtn" />
					</div>
				</div>
			</form>
		</div>
		<ul>
		<li style="color:#ff0000;">声明：该页的所有数据都是能过爬虫临时采集，服务器不存储任何数据</li>
		<#if result ??>
			<#list result as bs>
				<li style="height:30px;">
				${bs.title}      |        ${bs.fileSize}   |
				<!-- JavaScript专用链代码 -->
				<script src="http://pstatic.xunlei.com/js/webThunderDetect.js"></script>
				<script src="http://pstatic.xunlei.com/js/base64.js"></script>
				<script language="javascript">
				var thunder_url = "${bs.magnetUrl}";
				var thunder_pid = "${bs.id}";
				var restitle = "";
				document.write('<a href="#" thunderHref="' + ThunderEncode(thunder_url) + '" thunderPid="' + thunder_pid + '" thunderResTitle="' + restitle + '" onClick="return OnDownloadClick_Simple(this,2,4)" oncontextmenu="ThunderNetwork_SetHref(this)">迅雷专用高速下载</a> ');
				</script>
				</li>
			</#list>
			<li><< <a onClick="seedSearch('searchDo?page=${page-1}')" href="javascript:void(0);">上一页</a>    <a onClick="seedSearch('searchDo?page=${page+1}')" href="javascript:void(0);">下一页</a>>> </li>
		</#if>
		</ul>
	</div>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/foot.ftl">
	</body>
</html>