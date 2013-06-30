<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<div class="search-wrap" id="searchBox">
		<div id="searchLogo" class="baidu-logo" track-key="search_baidu_web">
			<a href="http://www.baidu.com/index.php?tn=monline_5_dg" title="百度"></a>
		</div>
		<form enctype="application/x-www-form-urlencoded" method="get"
			action="http://i.g-fox.cn/search" class="search-form" id="searchForm"
			name="search-form" accept-charset="utf-8" track-title="百度"
			track-url="http://i.g-fox.cn/search" track-key="search_baidu_web">
			<div class="outer-wrap">
				<div class="inner-wrap">
					<input type="text" autocomplete="off" class="search-key keyInput"
						name="q" id="searchKey"><input type="hidden" name="engine"
						id="searchCurrent" value="baidu_web"><input type="button"
						value="搜索" class="search-btn" id="searchBtn">
				</div>
			</div>
		</form>
	</div>
</body>
</html>