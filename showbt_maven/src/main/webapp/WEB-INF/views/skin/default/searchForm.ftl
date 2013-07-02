<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><#if showBtStatic("websetting@websetting_title")??>${showBtStatic("websetting@websetting_title").sValue}<#else>秀种资源网</#if></title>
		<!--<link href="css/menu.css" rel="stylesheet"/>-->
		<link rel="shortcut icon" href="/favicon.ico" />		
		<#if showBtStatic("websetting@websetting_head")??>${showBtStatic("websetting@websetting_head").sValue}</#if>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/showbt_index_.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_02.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_01.css" rel="stylesheet"/>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery.slider.js"></script>	
		
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

	<div class="wrap">
		<div class="search-wrap" id="searchBox">
			<div id="searchLogo" class="baidu-logo" track-key="search_baidu_web">
			</div>
			<form enctype="application/x-www-form-urlencoded" method="post" action="searchDo" class="search-form" id="seedSearchForm" name="search-form" accept-charset="utf-8" >
				<div class="outer-wrap">
					<div class="inner-wrap">
						<input type="text" autocomplete="off" maxlength="20" class="search-key keyInput" name="keywords" id="searchKey" value="欧美" />
						<input type="button" value="搜索" onclick="seedSearch()" class="search-btn" id="searchBtn" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/foot.ftl">
</html>
<script language="javascript">
function seedSearch(){
	document.getElementById("seedSearchForm").submit();
}
</script>