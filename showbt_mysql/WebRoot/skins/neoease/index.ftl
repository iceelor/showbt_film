<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${blogTitle}">
        <meta name="keywords" content="${metaKeywords}"/>
        <meta name="description" content="<#list articles as article>${article.articleTitle}<#if article_has_next>,</#if></#list>"/>
        </@head>
    </head>
    <body>
        ${topBarReplacement}
        <#include "header.ftl">
        <div class="body">
            <div class="wrapper">
                <div class="main">
                    <#include "article-list.ftl">
                </div>
                <#include "side.ftl">
                <div class="clear"></div>
            </div>
        </div>
        <#include "footer.ftl">
    </body>
</html>
