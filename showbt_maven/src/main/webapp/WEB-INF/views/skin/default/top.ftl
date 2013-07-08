<div id="top">
	<div id="tl">
		<a href="${websetting_url}"><img width="203" height="66" alt="秀种资源网" src="${staticServePath}/${websetting_template_default_path}img/logo.jpg"></a>
	</div>
	<div id="tr">
		<p>
			<a style="color:#FF0000" href="#">今日最新电影</a>
			<a style="color:#FF0000" href="#">今日最新电视剧</a>
			<a target="_self" onclick="javascript:window.external.AddFavorite('${websetting_url}', '秀种免费资源网-showbt.com')" href="#">加入收藏</a>
		</p>
		<ul id="trl">
			<div class="showad">
				${ad_index_top_img}
				<div style="display:none"></div>
			</div>
		</ul>
		<div id="trr">
			<form target="_blank" onsubmit="return false;" name="formsearch" id="form1">
				<input type="text" onblur="if(this.value==''){this.value='直接输入电影的关键词...';}" onfocus="if(this.value=='直接输入电影的关键词...'){this.value='';}" value="直接输入电影的关键词..." id="search-keyword" class="k" name="keyword">
				<input type="image" src="${staticServePath}/${websetting_template_default_path}img/tsoubtn.jpg" onclick="search();" value="提交" id="button" class="r" name="searchtype">
			</form><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a style="color:#0067B0" href="http://www.showbt.com">最新电影下载</a>就上秀种网www.showbt.com </p>
		</div>
	</div>
</div>
<script language="javascript">
	function search(){
		var obj = document.getElementById("form1");
		var kw = obj.keyword.value;
		obj.action="http://donkey4u.com/search/"+kw+"";
		obj.submit();
	}
</script>
<!--导航begin-->
	<div static="s=1701&amp;tn=movie_hao123&amp;bl=menu_hao123" class="hao-menu">
		<div class="hao-menu-bd">
			<ul>
				<li <#if t ??><#if t=='i'>class="hao-selected "<#else> class="hao-first "</#if></#if>><a target="_self" href="${staticServePath}/index?t=i">首页</a></li>
				<li <#if t ??><#if t=='m'>class="hao-selected "</#if></#if>><a target="_self" href="${staticServePath}/filmList?t=m">电影</a></li>
				<li <#if t ??><#if t=='v'>class="hao-selected "</#if></#if>><a target="_self" href="${staticServePath}/videoList?t=v">在线视频</a></li>
				<li <#if t ??><#if t=='s'>class="hao-selected "</#if></#if>><a target="_self" href="${staticServePath}/search?t=s">搜索种子</a></li>
				<!--<li class="hao-nobg"><a target="_self" href="#/">综艺</a></li>
				<li><a target="_self" href="#">动漫</a></li>
				<li><a target="_self" href="#">直播</a></li>
				<li class="hao-menu-v"><a target="_blank" href="#">百度视频</a></li>
				<li class="hao-menu-v"><a target="_self" href="#">优酷搞笑</a></li>
				-->
			</ul>
		</div>
	</div>
	<!--导航end-->