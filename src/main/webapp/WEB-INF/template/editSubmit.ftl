<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<#assign productId = RequestParameters['id']>
<div class="g-doc">
    <#if product>
    <div class="n-result">
        <h3>编辑成功！</h3>
        <p><a href="./show?id=${product.id}">[查看内容]</a><a href="./index">[返回首页]</a></p>
    </div>
    <#else>
    <div class="n-result">
        <h3>编辑失败！</h3>
        <p><a href="./edit?id=${product.id}">[重新编辑]</a><a href="./index">[返回首页]</a></p>
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
</body>
</html>