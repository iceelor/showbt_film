<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>${dytt8.title}---<#if showBtStatic("websetting@websetting_title")??>${showBtStatic("websetting@websetting_title").sValue}</#if></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="<#if showBtStatic("websetting@websetting_movie_keywords")??>${showBtStatic("websetting@websetting_movie_keywords").sValue}</#if>"/>
		<meta name="description" content="<#if showBtStatic("websetting@websetting_movie_description")??>${showBtStatic("websetting@websetting_movie_description").sValue}</#if>"/>
		<link rel="shortcut icon" href="/favicon.ico" />		
		<#if showBtStatic("websetting@websetting_head")??>${showBtStatic("websetting@websetting_head").sValue}</#if>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_01.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/dytt8_content.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/bdsstyle.css" rel="stylesheet"/>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery.slider.js"></script>		
	</head>
	<body>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/top.ftl">
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
								<div class="desc-wrapper">
									<br/>
									<br/>
									<br/>
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


					<!--类似电影begin-->
					<div style="" id="similarMovie">
						<div class="tang-carousel mod-main-detail" id="tang-carouselA">
							<div class="hd">
								<h2>类似电影</h2>
								<a id="similarMovieLinkMore" href="#" target="_blank" class="more">更多&gt;&gt;</a>
							</div>
							<div class="tang-carousel-container" id="TANGRAM$5__container">
								<ol class="tang-carousel-element" id="TANGRAM$5__element" style="width: 660px;">
									<li class="tang-carousel-item tang-carousel-item-selected" id="TANGRAM$6-carousel-item">
										<dl>
											<dt>
												<a static="stp=po" target="_blank" href="#"> <img src="pic/01.jpg">
													<span class="subtitbg"></span> <span class="year">2003</span>
													<span class="rating"><em>8.4</em>分</span>
												</a>
											</dt>
											<dd class="title">
												<a target="_blank" href="/dianying_intro/?id=26382&amp;page=1">两小无猜</a>
											</dd>
											<dd class="sub-title">奥斯卡影后玛丽蓉-科蒂</dd>
										</dl>
									</li>
									<li class="tang-carousel-item" id="TANGRAM$7-carousel-item">
										<dl>
											<dt>
												<a target="_blank" href="#"> <img src="pic/02.jpg">
													<span class="subtitbg"></span> <span class="year">2011</span>
													<span class="rating"><em>7.8</em>分</span>
												</a>
											</dt>
											<dd class="title">
												<a static="stp=ti" target="_blank" href="#">假小子</a>
											</dd>
										</dl>
									</li>
									<li class="tang-carousel-item" id="TANGRAM$8-carousel-item">
										<dl>
											<dt>
												<a target="_blank" href="#"> <img src="pic/03.jpg">
													<span class="subtitbg"></span> <span class="year">1998</span>
													<span class="rating"><em>8.5</em>分</span>
												</a>
											</dt>
											<dd class="title">
												<a static="stp=ti" target="_blank" href="#">秋天的故事</a>
											</dd>
											<dd class="sub-title">将现代男女那种不能言的</dd>
										</dl>
									</li>
									<li class="tang-carousel-item" id="TANGRAM$9-carousel-item">
										<dl>
											<dt>
												<a static="stp=po" target="_blank" href="#"> <img src="pic/04.jpg">
													<span class="subtitbg"></span> <span class="year">1993</span>
													<span class="rating"><em>8.0</em>分</span>
												</a>
											</dt>
											<dd class="title">
												<a target="_blank" href="/dianying_intro/?id=25708&amp;page=1">芳芳</a>
											</dd>
											<dd class="sub-title">亚历（文森特&amp;#8226;佩</dd>
										</dl>
									</li>
									<li class="tang-carousel-item" id="TANGRAM$10-carousel-item">
										<dl>
											<dt>
												<a target="_blank" href="#"> <img src="pic/05.jpg">
													<span class="subtitbg"></span> <span class="year">2009</span>
													<span class="rating"><em>7.4</em>分</span>
												</a>
											</dt>
											<dd class="title">
												<a static="stp=ti" target="_blank"
													href="/dianying_intro/?id=17045&amp;page=1">枕边的男人</a>
											</dd>
											<dd class="sub-title">苏菲玛索和她的男友,认</dd>
										</dl>
									</li>
								</ol>
							</div>
						</div>
					</div>
					<!--类似电影begin-->


					<!--预告区begin-->
					<div style="" class="mod-main-detail mod-detail-prevue" id="detailPrevue">
						<div class="hd">
							<h2>
								预告<b></b>花絮<b></b>音乐
							</h2>
						</div>
						<div class="bd">
							<ul>
								<li>
									<a class="link-pic" target="_blank" href="#">
										<img alt="《锈与骨》预告片" src="pic/1.jpg">
										<span class="duration-mask"></span><span class="duration">01:53</span>
										<span class="s-mask"></span><span class="s-play"></span>
									</a> 
									<a title="《锈与骨》预告片" class="link-title" target="_blank" href="#">《锈与骨》预告片</a>
								</li>
								<li>
									<a class="link-pic" target="_blank" href="#">
									<img alt="《锈与骨》精彩预告片合集 法语影后邂逅落魄拳手" src="pic/2.jpg">
									<span class="duration-mask"></span><span class="duration">05:37</span>
									<span class="s-mask"></span><span class="s-play"></span></a> 
									<a title="《锈与骨》精彩预告片合集 法语影后邂逅落魄拳手" class="link-title" target="_blank" href="#">《锈与骨》精彩预告片合集...</a>
								</li>
								<li>
									<a class="link-pic" target="_blank" href="#">
									<img alt="锈与骨 法国预告片2" src="pic/3.jpg">
									<span class="duration-mask"></span><span class="duration">01:47</span>
									<span class="s-mask"></span><span class="s-play"></span>
									</a> 
									<a title="锈与骨 法国预告片2" class="link-title" target="_blank" href="#">锈与骨 法国预告片2</a>
								</li>
								<li>
									<a class="link-pic" target="_blank" href="#">
										<img alt="锈与骨 片段1" src="pic/4.jpg">
										<span class="duration-mask"></span><span class="duration">01:23</span>
										<span class="s-mask"></span><span class="s-play"></span>
									</a> 
									<a title="锈与骨 片段1" class="link-title" target="_blank" href="#">锈与骨片段1</a>
								</li>
							</ul>
						</div>
					</div>
					<!--预告区end-->
					<!--影评区begin-->
					<div class="mod-main-detail" id="douban">
						<div class="hd">
							<h2>豆瓣影评</h2>
						</div>
						<div class="douban">
							<ul class="list">
								<li class="item"><div class="title-bg">
										<h4 class="title">
											<a static="stp=title" target="_blank"
												href="http://movie.douban.com/review/5652988/"
												class="title-link">是什么拯救了那些我们所热爱的</a>
										</h4>
										<span class="grade"><span class="grade-bg">&nbsp;</span><span
											style="width: 44px;" class="grade-star"></span></span>
									</div>
									<p class="text">
										我始终觉得欧洲人在电影里谈感情的方式跟美国人不同，他们习惯于细腻无比的起承转合：光线，角度，细节的安排以至于睫毛的颤动都是给人感觉“粗糙”的老美无法想象得到也不会用这样的方式来表现的。其实并不是很喜欢的题材，只是冲着Marion和海报去看的。故事在略显诡异的配乐中缓缓展开，画面和人声都有种家用摄像机的私密感......
										<a static="stp=all" target="_blank"
											href="http://movie.douban.com/review/5652988/"
											class="more-link">全部&gt;&gt;</a>
									</p>
									<p class="info">
										<span class="nnt-love">0人喜欢此影评</span><span class="date">2012-11-13</span>
									</p></li>
							</ul>
						</div>
					</div>
					<!--影评区end-->
				</div>
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
										<li><a href="content?id=${cat.id}">${cat.title}</a></li>
										</#list>
									</#if>
								</ul>
								<strong>随便看看</strong>
								<ul>
									<#if faverteList ??>
										<#list faverteList as fav>
										<li><a href="content?id=${fav.id}">${fav.title}</a>
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
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/foot.ftl">
	</body>
</html>