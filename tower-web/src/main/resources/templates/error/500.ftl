<h1>Exception:</h1>
<h3>${url!}</h3>
<h3>${errorMessage!}</h3>
<code>
    <#list stackTrace! as line>
        ${line}
    </#list>
</code>
