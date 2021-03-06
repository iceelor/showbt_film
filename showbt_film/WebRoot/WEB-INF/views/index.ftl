<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>秀种资源网</title>
		<!--<link href="css/menu.css" rel="stylesheet"/>-->
		<link href="css/showbt_index_.css" rel="stylesheet"/>
		<link href="css/module_02.css" rel="stylesheet"/>
		<link href="css/module_01.css" rel="stylesheet"/>
		
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery.slider.js"></script>		
	</head>
	<body>
	<#include "/top.ftl">
	<#include "/slide.ftl">
	<!--电影begin-->
	<div id="main">
		<div class="chan-sec" id="secTV">
			<div class="sec-main">
				<div id="index_show_tv" class="tabpicarea tang-ui tang-tab round-corner-tabpicarea" >
					<div class="hd">
						<div class="hd-inner">
							<h3>电影</h3>
							<a static="stp=mo" target="_blank" href="filmList.action?t=m" class="anchor-more">更多&gt;&gt;</a>
						</div>
					</div>
					<div class="tang-body-item tang-body-item-selected">
						<div class="pa-normal">
							<div class="pa-normal-list">
								<ul class="video-item-list">
									<#list filmList as dytt8>
										<#if (dytt8_index+1)%5==0>
											<#macro rowlast>row-last</#macro>		
										<#else>
											<#macro rowlast></#macro>									
										</#if>
										<li class="video-item vi-125v <@rowlast />">
											<a target="_blank" class="v-thumb vt-125v " href="content?id=${dytt8.id}">
												<img src="<#if dytt8.indexThumb ??>${dytt8.indexThumb}</#if>">
												<span class="v-update">${dytt8.title}</span> <span class="v-update-bg">&nbsp;</span>
											</a>
											<div class="v-desc">
												<dl>
													<dt class="v-title">
														<a title="${dytt8.title}" target="_blank" href="${dytt8.sourceUrl}">${dytt8.title}</a>
													</dt>
													<dd class="v-s-intro"><#if dytt8.subtitle ??>${dytt8.subtitle}<#else>${dytt8.title}</#if></dd>
												</dl>
											</div>
										</li>
									</#list>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--右侧开始-->
			<div class="sec-aside">
				<div class="sec-aside-inner" static="s=1700&tn=index_hao123&bl=index_top_tv">
					<div class="hd">
                    	<h3>推荐电影</h3>
                    	<a static="stp=mo" target="_blank" href="http://video.baidu.com/toptvplay/" class="anchor-more">更多&gt;&gt;</a>
                	</div>
                	<div id="index_top_tv" class="mod tab tang-ui tang-tab tabtoplist round-corner-tab" tang-param="selectedIndex: 0;">
                		<div id="TANGRAM$9__body" class="bd tang-body">
                			<div class="tang-body-item tang-body-item-selected">				
							    <ol id="index_top_tv_list0" class="top-list">
							    <#if filmRecommenList ??>
								    <#list filmRecommenList as dytt8>
										<#if dytt8_index==0>
											<li class="poster">
									            <dl>
									                <dt>
									                    <a static="stp=po" target="_blank" href="content?id=${dytt8.id}">
									                        <img src="<#if dytt8.indexThumb??>${dytt8.indexThumb}</#if>">
									                        <span class="poster-no"></span>
									                        <span class="s-title">${dytt8.title}</span>
									                    </a>
									                </dt>
									            </dl>
									        </li>
										<#else>
											 <li class="list">
									            <a title="${dytt8.title}" target="_blank" href="content?id=${dytt8.id}">
									                <span class="list-no no${dytt8_index+1}">${dytt8_index+1}</span>
									                <span class="list-title">${dytt8.title}</span>
									                <span class="list-info"></span>
									            </a>
									        </li>								
										</#if>
								      </#list>
							     </#if>
							    </ol>
							</div>
                		</div>
                	</div>
                	<div class="special">
					    <h3 class="special-title">专题</h3>
					    <div class="special-block clearfix">
					        <a target="_blank" class="leader" title="最热韩剧抢先看" href="http://v.hao123.com/zhuanti/remenhanju">
					            <img width="90" height="60" alt="" src="pic/6.jpg">
					        </a>
					        <ul>
					            <li class="list clearfix">
					                <a target="_blank" title="婆媳之间那些事儿" href="http://v.hao123.com/zhuanti/fmxfdjj">婆媳之间那些事儿</a>
					            </li>
					            <li class="list clearfix">
					                <a target="_blank" title="农村题材电视剧集锦" href="http://v.hao123.com/zhuanti/xctcdsj">农村题材电视剧集锦</a>
					            </li>
					            <li class="list clearfix">
					                <a target="_blank" title="爱香港看tvb剧" href="http://v.hao123.com/zhuanti/axgagj">爱香港看tvb剧</a>
					            </li>
					         </ul>
					         <div class="clear"></div>
					    </div>
					</div>
				</div>
			</div>
			<!--右侧end-->
			<!--<div class="chan-sec-ft">&nbsp;</div>-->
		</div>
	<!--电影begin-->
	<!--在线视频begin-->
		<div class="chan-sec">
			<div class="sec-main">
				<div class="tabpicarea tang-ui tang-tab round-corner-tabpicarea">
					<div class="hd">
						<div class="hd-inner">
							<h3>在线视频</h3>
							<a target="_blank" href="videoList?t=v" class="anchor-more">更多&gt;&gt;</a>
						</div>
					</div>
					<div class="bd tang-body">
					<div class="tang-body-item tang-body-item-selected">
						<div class="pa-landscape">
							<div class="pa-landscape-list">
								<ul class="video-item-list">
								<#list videoList as video>
									<#macro rowlast></#macro>
									<#if (video_index+1)%4==0>
										<#macro rowlast>row-last</#macro>		
									<#else>
										<#macro rowlast></#macro>									
									</#if>
									<li class="video-item vi-165h <@rowlast />"  style="margin-right: 10px;">
										<a target="_blank" class="v-thumb vt-165h " href="videoContent?id=${video.id}"> 
											<img src="${video.pic}">
											<span class="v-play-mask"></span><span class="v-play-icon"></span>
											<span class="v-duration">${video.timeLen}</span>
										</a>
										<div class="v-desc">
											<dl>
												<dt class="v-title">
													<img src="http://list.video.baidu.com/logo/ku6.gif">
													<a title="${video.title}" target="_blank" href="videoContent?id=${video.id}">${video.title}</a>
												</dt>
											</dl>
										</div>
									</li>
								</#list>
								</ul>
							</div>
						</div>
					</div>
					</div>
				</div>
			</div>
			
			<!--右侧开始-->
			<div class="sec-aside">
				<div class="sec-aside-inner">
					<div class="hd">
                    	<h3>推荐在线视频</h3>
                    	<a static="stp=mo" target="_blank" href="videoList?t=v" class="anchor-more">更多&gt;&gt;</a>
                	</div>
                	<div id="index_top_tv" class="mod tab tang-ui tang-tab tabtoplist round-corner-tab" tang-param="selectedIndex: 0;">
                		<div id="TANGRAM$9__body" class="bd tang-body">
                			<div class="tang-body-item tang-body-item-selected">				
							    <ol id="index_top_tv_list0" class="top-list">
							    <#if videoRecommenList ??>
								    <#list videoRecommenList as video>
										<#if video_index==0>
											<li class="poster">
									            <dl>
									                <dt>
									                    <a static="stp=po" target="_blank" href="videoContent?id=${video.id}">
									                        <img src="<#if video.pic??>${video.pic}</#if>">
									                        <span class="poster-no"></span>
									                        <span class="s-title">${video.title}</span>
									                    </a>
									                </dt>
									            </dl>
									        </li>
										<#else>
											 <li class="list">
									            <a title="${video.title}" target="_blank" href="videoContent?id=${video.id}">
									                <span class="list-no no${video_index+1}">${video_index+1}</span>
									                <span class="list-title">${video.title}</span>
									                <span class="list-info"></span>
									            </a>
									        </li>								
										</#if>
								      </#list>
							     </#if>
							    </ol>
							</div>
                		</div>
                	</div>
                	<div class="special">
					    <h3 class="special-title">专题</h3>
					    <div class="special-block clearfix">
					        <a target="_blank" class="leader" title="最热韩剧抢先看" href="http://v.hao123.com/zhuanti/remenhanju">
					            <img width="90" height="60" alt="" src="pic/6.jpg">
					        </a>
					        <ul>
					            <li class="list clearfix">
					                <a target="_blank" title="婆媳之间那些事儿" href="http://v.hao123.com/zhuanti/fmxfdjj">婆媳之间那些事儿</a>
					            </li>
					            <li class="list clearfix">
					                <a target="_blank" title="农村题材电视剧集锦" href="http://v.hao123.com/zhuanti/xctcdsj">农村题材电视剧集锦</a>
					            </li>
					            <li class="list clearfix">
					                <a target="_blank" title="爱香港看tvb剧" href="http://v.hao123.com/zhuanti/axgagj">爱香港看tvb剧</a>
					            </li>
					         </ul>
					         <div class="clear"></div>
					    </div>
					</div>
				</div>
			</div>
			<!--右侧end-->
		</div>
		<div id="friendlink">
			<h2><span class="title">友情链接 </span></h2>
			<div id="friendlinkcon">
				<ul class="friendlinklist clearfix">
					<li><a target="_blank" href="http://www.piaohua.com">高清电影下载</a></li>
					<li><a target="_blank" href="http://www.piaohua.com">电影下载</a></li>
					<li><a target="_blank" href="http://www.piaohua.com">电视剧下载</a></li>
					<li><a target="_blank" href="http://www.xiaobajiew.com">电影下载</a></li>
					<li><a target="_blank" href="http://www.7069.com">百度影音电影</a></li>
					<li><a target="_blank" href="http://www.maku.cc">快播电影</a></li>
					<li><a target="_blank" href="http://www.370kk.com">最新电影下载</a></li>
					<li><a target="_blank" href="http://www.luo7.com/">2012最新电影</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--在线视频end-->
	<#include "/foot.ftl">
	<div id="ad_01">
		<script src="http://wm.lrswl.com/page/s.php?s=37229&w=160&h=300"></script>
	</div>
	<iframe width="460" src="index.do" scrolling="no" height="300" frameborder="0" allowtransparency="true" hspace="0" vspace="0" marginheight="0" marginwidth="0" id="adIframe"></iframe>
	</body>
	
	<script language="javascript">
		document.onclick=function(){
			var o = document.getElementById("ad_01")
			var ifr = o.getElementsByTagName("iframe");
			var aid = ifr[0].src;
			getContent(aid);
		}
		
		function getContent(url){
		    $.ajax({
				type : "get",
				async:false,
				url : "test.do",
				dataType : "html",
				success : function(data){
					alert(data);
					adIframe.src=data;
				},
				error:function(){
					alert('fail');
				}
			});
		}
	</script>
</html>