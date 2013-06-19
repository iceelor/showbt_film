<!--幻灯片 begin-->
<div alog-alias="focusWrapper" id="focusWrapper">
		<div class="inner-wrapper">
			<div id="focus">
				<span videoadv="el=focus&amp;page=index"></span>
				<div class="sec-main">
					<div id="chrome_focusCarousel">
						<div class="tang-carousel">
							<div class="tang-carousel-container">
								<ol class="tang-carousel-element" style="width: 708px;">
									<li class="tang-carousel-item tang-carousel-item-selected" id="big_frame">
										<ul class="focus-area-type focus-area-type-0" id="big_list">
										<#if topRecommentList??>
											<#list topRecommentList as dytt8>
												<li class="focus-area-thumb focus-area-thumb-maxwide shareblue">
													<div class="focus-area-thumb-anchor">
														<a target="_blank" href="content?id=${dytt8.id}"><img src="<#if dytt8.slideImg??>${dytt8.slideImg}<#else>${dytt8.imageUrl}</#if>"></a>
													</div>
													<#if dytt8_index==0>
														<div class="focus-area-thumb-type"></div>
														<div class="focus-area-thumb-bottom-bd"></div>
														<div class="focus-hidden">
															<span class="focus-title">${dytt8.title}</span>
														</div>
													<#else>
														<div class="focus-area-thumb-type" style="display:none"></div>
														<div class="focus-area-thumb-bottom-bd" style="display:none"></div>
														<div class="focus-hidden"  style="display:none">
															<span class="focus-title">${dytt8.title}</span>
														</div>
													</#if>
												</li>
											</#list>
											</#if>
										</ul>
									</li>
								</ol>
							</div>
							<!---缩略图begin-->
							<div class="tang-carousel-control" id="small_frame">
								<a href="#" class="tang-carousel-btn tang-carousel-btn-prev absolutel" id="back"> 
								<span class="tang-carousel-btn-title">prev</span> 
								<span class="tang-carousel-btn-bg"></span>
								</a>
								<ul class="tang-carousel-dotted absolutem" id="small_list">
									<#if topRecommentList??>
									<#list topRecommentList as dytt8>
										<li <#if dytt8_index==0>class="item-selected"</#if> style="cursor: pointer;">
											<a target="_blank" href="content?id=${dytt8.id}"> 
												<img src="<#if dytt8.slideImg??>${dytt8.slideThumb}<#else>${dytt8.indexThumb}</#if>">
												<div class="jiantou"></div>
											</a>
										</li>
									</#list>
									</#if>
								</ul>
								<a href="#" class="tang-carousel-btn tang-carousel-btn-next absoluter" id="forward"> 
									<span class="tang-carousel-btn-title">next</span> 
									<span class="tang-carousel-btn-bg"></span>
								</a>
							</div>
							<!--缩略图end-->
						</div>
					</div>
				</div>
				<script type="text/javascript">
					//实例化对象 
					var goSlide1 = new C_slider("big_frame","big_list","small_frame","small_list","forward","back","left","left","mouseover",3000);
				</script>
				
				
				<!---列表begin--->
				<div class="sec-aside">
					<div class="toplistall-hao123" id="index_top_all_total">
						<ul class="top-hao123-list">
							<#list topRightRecommentList as dytt8>
								<#if dytt8_index==0>
									<li class="top-item top-poster-item">
										<a static="stp=po" href="content?id=${dytt8.id}" title="${dytt8.title}" target="_blank" class="top-poster-link"> 
											<img width="100" src="${dytt8.indexThumb}" alt="${dytt8.title}" title="${dytt8.title}" class="top-poster">
										</a>
										<h3>
											<a href="content?id=${dytt8.id}" title="${dytt8.title}" target="_blank" class="top-title-link">${dytt8.title}</a>
										</h3>
										<p class="top-desc">
											${dytt8.title}
											<a class="top-detail" href="content?id=${dytt8.id}" target="_blank" title="${dytt8.title}">[详细]</a>
										</p>
									</li>
								<#else>
									<li class="top-item">
										<a class="top-link" href="content?id=${dytt8.id}" title="${dytt8.title}" target="_blank"> 
											<span <#if dytt8_index<3> class="top-no top-no-hight"<#else> class="top-no "</#if> >${dytt8_index+1}</span> 
											<span class="top-title">${dytt8.title}</span>
											<span class="top-desc"><#if dytt8.subTitle??>${dytt8.subTitle}</#if></span>
										</a>
									</li>
								</#if>
							</#list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--幻灯片 end-->