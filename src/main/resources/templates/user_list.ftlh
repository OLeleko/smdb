
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<head>
    <meta charset="UTF-8">
    <title>User list</title>
<body>
<!--<div>
    <h2>Список работников кампании</h2>
</div>-->
<table>
    <caption>List of users</caption>
    <tr>
        <th>id</th>
        <th>User name</th>
        <th>Role</th>
    </tr>
    <#list user_list as ul>
        <tr>
            <td>${ul.id}</td>
            <td>${ul.username}</td>
           <td><#list ul.roles as role>${role}<#sep>, </#list></td>
            <td><a href = "/users/${ul.id}">edit</a></td>
        </tr>
    </#list>
</table>
<div>
    <@l.logout />
</div>

</body>
</@c.page>