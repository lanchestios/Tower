<html>
<header>
    <#include "layout/head.ftl">
</header>
<nav>
    <#include "layout/nav.ftl">
</nav>
<body>
--------------------- INDEX JSP ---------------------
FreeMarker模板代码可以直接使用的内置对象
1. Request 用法 <#--${Request["attributeName"]} 等同于 request.getAttribute("")-->
2. Session 用法 参照Request
3. Application 用法 获取Application(ServletContext)对象中的attribute对象
4. RequestParameters 用法 <#--${RequestParameters["attributeName"]} 等同于request.getParameter("")-->

相对应的 Java 可在后台操作 Request、Session、Application、RequestParameters等对象进行读取
</body>
<footer>
    <#include "layout/foot.ftl">
</footer>
</html>


