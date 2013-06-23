<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><#if showBtStatic("websetting@websetting_title")??>${showBtStatic("websetting@websetting_title").sValue}<#else>秀种资源网</#if></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="keywords" content="<#if showBtStatic("websetting@websetting_keywords")??>${showBtStatic("websetting@websetting_keywords").sValue}</#if>"/>
		<meta name="description" content="<#if showBtStatic("websetting@websetting_description")??>${showBtStatic("websetting@websetting_description").sValue}</#if>"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_01.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/module_static_8d4870a0.css" rel="stylesheet"/>
		<link href="${showBtStatic("websetting@websetting_template_default_path").sValue}css/movie_27a6d47d.css" rel="stylesheet"/>
		<script type="text/javascript" src="${showBtStatic("websetting@websetting_template_default_path").sValue}js/jquery-1.7.2.min.js"></script>
	</head>
	<body>
	<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/top.ftl">
	<div id="main">
		<!--new list begin-->
		<div id="bd-content" class="bd-content bd-subchannel-movie">
			<!--BAN-->
			<div class="bd-filter" id="bd-filter">
             <div class="bd-filter-header">
                 <h2 class="bd-channel-title">电影筛选</h2>
                 <div class="bd-other-channels">
	                 <a target="_blank" href="/dianshi_index/" title="全部电视剧" class="bd-channel-link">全部电视剧</a>
			         <sapn class="bd-split">|</sapn>
				     <a target="_blank" href="/dongman_index/" title="全部动漫" class="bd-channel-link">全部动漫</a>
			         <sapn class="bd-split">|</sapn>
				     <a target="_blank" href="/zongyi_index/" title="全部综艺" class="bd-channel-link">全部综艺</a>
			     </div>
             </div>
             <div id="bd-filter-condition" class="bd-filter-content">
            	<#if catList??>
            		<#list catList?keys as id>
		                <div class="bd-filter-section">
		                    <h3 class="bd-filter-title">${catList[id].category}:</h3>
		                    <div static="s=1701&amp;tn=submovie_hao123&amp;bl=type&amp;stp=type" class="bd-filter-list filter-group">
		                        <a title="全部" href="#" class="filter-sel  filter-sel-active " data-val="" data-key="type"><span>全部</span></a>
		                        <#if catList[id].child??>
		                        	<#list catList[id].child as cate>
		                        		<a title="${cate.category}" href="#" class="filter-sel "><span>${cate.category}</span></a>
		                        	</#list>
		                        </#if>
		                    </div>
		                </div>
		            </#list>
                </#if>
		    </div>
             <div class="bd-filter-bottom">
                 <div class="bd-filter-result">共有<span class="bd-filter-count" id="bd-filter-count">${total}</span>个符合条件的内容</div>
	             <span class="bd-order-tip">排序:</span>
	             <ul class="bd-filter-order filter-group" id="bd-filter-order">
		            <li class="dropdown-default"><span class="dropdown-default-text">按热门</span><a class="order-arrow" href="#"></a></li>
		            <li class="dropdown-item"><a title="按热门" href="#" class="filter-sel   filter-sel-active " data-val="hot" data-key="order">按热门</a></li>
		            <li class="dropdown-item"><a title="按更新" href="#" class="filter-sel  " data-val="pubtime" data-key="order">按更新</a></li>
		            <li class="dropdown-item"><a title="按评价" href="#" class="filter-sel  " data-val="rating" data-key="order">按评价</a></li>
    			</ul>
             </div>
         </div>
			<!--BAN-->
			<!--CONTENT-->
			<div id="bd-videos" class="bd-videos">
				<ul id="bd-video-list" class="bd-video-list" style="display: block;">
					<#if filmList ??>
						<#list filmList as dytt8>
							<#macro rowlast>bd-video-item   bd-video-meta-right</#macro>
							<#if 1<(dytt8_index+1)>
								<#if (dytt8_index+1)%6==0>
									<#macro rowlast>bd-video-item bd-video-item-last bd-video-meta-left</#macro>		
								<#else>
									<#macro rowlast>bd-video-item   bd-video-meta-right</#macro>									
								</#if>
							</#if>
							<li class="<@rowlast />">
			                    <div class="bd-video-poster">
			                        <a class="bd-video-link" target="_blank" href="content?id=${dytt8.id}" style="display: block;">
			                            <img alt="${dytt8.title}" src="<#if dytt8.indexThumb??>${dytt8.indexThumb}</#if>" class="bd-video-img" style="margin-top: -2px; margin-left: 0px; height: 189px; width: 134px; visibility: visible;">
			                            <span class="bd-video-rating"><em>7.8</em> 分</span>
			                            <span class="bd-video-bg"></span>
			                        </a>
			                    </div>
			                    <div class="bd-video-primary">
			                        <h4 class="bd-video-title"><a target="_blank" title="${dytt8.title}" href="content?id=${dytt8.id}" static="stp=ti">${dytt8.title}</a></h4>
				                    <div class="bd-video-actors">
					                    <#if dytt8.protagonist ??>
											<#list dytt8.protagonist?split(" ") as p>
												<a target="_blank" href="#" title="${p}">${p}</a>
												<#break>
											</#list>
										</#if>
			                        </div>
				               		<div class="bd-video-s-intro" title="激情创业的青春年少">激情创业的青春年少</div>                    
				               	</div>
		                	</li>
	                </#list>
                </#if>
				</ul>
			</div>
			<!--CONTENT END-->
			<!--page-->
			<div id="bd-pagination" class="bd-pagination">
				<div id="bd-pagination-list" class="bd-pagination-list filter-group" static="s=1701&tn=submovie_hao123&bl=pagebar">
					<#if 1<page-5>
						<a class="bd-pagination-page bd-pagination-prev filter-sel" href="filmList?t=m&page=1" title="首页" data-val="1" data-key="pn">首页</a>
					</#if>
					<#if 1<page>
						<a class="bd-pagination-page bd-pagination-prev filter-sel" href="filmList?t=m&page=${page-1}">&lt;上一页</a>
					</#if>
					<#list beginPageNum ..endPageNum as pp>
						<a <#if pp==page>class="bd-pagination-page filter-sel-active filter-sel" <#else>class="bd-pagination-page filter-sel"</#if> href="filmList?t=m&page=${pp}">${pp}</span>
					</#list>
					<#if page<maxPage>
						<a class="bd-pagination-page bd-pagination-next filter-sel" href="filmList?t=m&page=${page+1}">下一页&gt;</a>
					</#if>
					<#if 4<maxPage-page>
					<a class="bd-pagination-page bd-pagination-prev filter-sel" href="filmList?t=m&page=${maxPage}" title="尾页" data-val="112" data-key="pn">尾页</a>
					</#if>
				</div>
			</div>
			<!--page end-->
		</div>
		<!--new list end-->	
</div>
<#include "/"+showBtStatic("websetting@websetting_template_default_path").sValue+"/foot.ftl">
	</body>
</html>