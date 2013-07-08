<#include "macro-head.ftl">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<@head title="${dytt8.title}---${websetting_title?html}">
	        <meta name="keywords" content="<#if dytt8.tags ??><#list dytt8.tags?split(" ") as tag>${tag}<#if tag_has_next>,</#if></#list></#if>,${websetting_movie_keywords}"/>              
	        <meta name="description" content="<#if dytt8.tags ??><#list dytt8.tags?split(" ") as tag>${tag}<#if tag_has_next>,</#if></#list></#if>,${websetting_movie_description}"/>
        </@head>			
		<link href="${staticServePath}/${websetting_template_default_path}css/dytt8_content.css" rel="stylesheet"/>
		<link href="${staticServePath}/${websetting_template_default_path}css/bdsstyle.css" rel="stylesheet"/>		
		
	</head>
	<body>
	<#include "top.ftl">
	<div id="main" style="margin-top:15px;">
		<div id="contentSec" class="content-sec">
			<div class="sec-main">
				<div class="sec-main-inner">
					<div static="tn=movie_detail_hao123&amp;bl=spa" id="specialArea">
						<div
							class="special-area sp-movie-area clearfix special-area-first special-area-last"
							data-id="37056">
							<div class="info-sec">
								<div class="title-wrapper clearfix">
									<div class="title-cont">
										<h3>
											<span><#if dytt8.title ??>${dytt8.title}</#if></span>
										</h3>
									</div>
								</div>
								<#if ad_content_movie_top_img??>
									<div id="ad_01">
										${ad_content_movie_top_img}
									</div>
								</#if>
								<div class="desc-wrapper">
									<a href="#down">点下载</a>
								</div>
								<!--
								<div class="desc-wrapper">
									<div class="sinfo topm12">
										<span class="greytxt">主演：</span>
										<#if dytt8.protagonist ??>
											<#list dytt8.protagonist?split(" ") as p>
												<span class="plaintxt onel pr14">${p}</span>
											</#list>
										</#if>
									</div>
									<div class="sinfo topm12">
										<span class="greytxt">导演：</span><span
											class="plaintxt onel pr14"><#if dytt8.director ??>${dytt8.director}</#if></span>
									</div>
									<div class="sinfo topm12">
										<span class="greytxt">地区：</span><span
											class="plaintxt onel pr14"><#if dytt8.district ??>${dytt8.district}</#if></span>
									</div>
									<div class="sinfo topm12">
										<span class="greytxt">上映时间：</span><span
											class="plaintxt onel pr14"><#if dytt8.showTime ??>${dytt8.showTime}</#if></span>
									</div>
									<div class="sinfo topm12">
										<span class="greytxt">类别：</span><span
											class="plaintxt onel pr14">剧情</span><span
											class="plaintxt onel pr14">爱情</span><span
											class="plaintxt onel pr14">艺术</span>
									</div>
								</div>
								<div static="bl=dnaTags&amp;tn=movie_detail_hao123"
									class="sinfo topm12 dnaTags">
									<span class="greytxt">标签：</span>
										<#if dytt8.tags ??>
											<#list dytt8.tags?split(" ") as tag>
												<a target="_blank" href="#"><span>${tag}</span></a>
											</#list>
										</#if>
								</div>
								-->
								<p class="sinfo nobmargin">
									<!--<span class="greytxt">简介：</span>-->
									<span class="vdetail plaintxt">
										${dytt8.content}
									</span>
								</p>
							</div>
							<div class="AL_link AL_f clearfix">
								<a static="stp=lj&amp;to=play" class="AL_play" href="#" target="_blank"></a>
								<div class="AL_res clearfix">
									<div class="more-site-cont">
										<span class="more-site-title">下载地址：</span>
										<div class="more-site-list">
											<a name="down"></a>
											<!-- JavaScript专用链代码 -->
											<script src="http://pstatic.xunlei.com/js/webThunderDetect.js"></script>
											<script src="http://pstatic.xunlei.com/js/base64.js"></script>
											<script language="javascript">
											var thunder_url = "${dytt8.downUrl}";
											var thunder_pid = "${dytt8.id}";
											var restitle = "";
											document.write('<a href="#" thunderHref="' + ThunderEncode(thunder_url) + '" thunderPid="' + thunder_pid + '" thunderResTitle="' + restitle + '" onClick="return OnDownloadClick_Simple(this,2,4)" oncontextmenu="ThunderNetwork_SetHref(this)">迅雷专用高速下载</a> ');
											</script>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<#if ad_content_movie_bottom_img??>
					<div id="ad_01">
						${ad_content_movie_bottom_img}
					</div>
				</#if>
			</div>
			<!--左侧图片区begin-->
			<div id="secAside" class="sec-aside" style="height: auto;">
				<div static="tn=movie_detail_hao123&amp;bl=poster" id="poster">
					<div class="poster-area poster-movie-area clearfix" data-id="37056">
						<div class="poster-sec">
							<div class="bottompic">
							<strong>爱情片下载排行</strong>
								<ul>
									<#if categoryList ??>
										<#list categoryList as cat>
										<li><a href="<#if cat.htmlUrl??>${staticServePath}/${cat.htmlUrl}<#else>${staticServePath}/content?id=${cat.id}</#if>">${cat.title}</a></li>
										</#list>
									</#if>
								</ul>
								<strong>随便看看</strong>
								<ul>
									<#if faverteList ??>
										<#list faverteList as fav>
										<li><a href="<#if fav.htmlUrl??>${staticServePath}/${fav.htmlUrl}<#else>${staticServePath}/content?id=${fav.id}</#if>">${fav.title}</a>
											<span><#if fav.protagonist ??>${fav.protagonist}</#if></span></li>
										</#list>
									</#if>
								</ul>
							</div>
						</div>
						<div style="float: none;" class="share-bar"></div>
					</div>
				</div>
			</div>
			<!--左侧图片区end-->
		</div>
	</div>
	<#include "foot.ftl">
	</body>
</html>