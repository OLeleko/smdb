<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

    <head>
        <meta charset="UTF-8">
        <title>Employee list admin</title>

        <style>
            table {
                border-collapse: collapse;
            }

            table, td, th {
                border: 1px solid #999;
                padding: 5px;
            }
        </style>
    </head>
    <body>
    <!--<div>
        <h2>Список работников кампании</h2>
    </div>-->
    <table>
        <caption>Список працівників кампанії</caption>
        <tr>
            <th>inn</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>position</th>
            <th>department</th>
            <th>phone_number</th>
            <th>email</th>
        </tr>
        <#list employees as emp>
            <tr>
                <td>${emp.inn}</td>
                <td>${emp.first_name}</td>
                <td>${emp.last_name}</td>
                <td>${emp.position}</td>
                <td>${emp.department}</td>
                <td>${emp.phone_number}</td>
                <td>${emp.email}</td>
            </tr>
        </#list>
    </table>
    <br />
    <div>
        <form method="post">
            <input type="text" name="inn" placeholder="ИНН" />
            <input type="text" name="first_name" placeholder="Имя" />
            <input type="text" name="last_name" placeholder="Фамилия" />
            <input type="text" name="position" placeholder="Должность" />
            <input type="text" name="department" placeholder="Подразделение" />
            <input type="text" name="phone_number" placeholder="Мобильный" />
            <input type="text" name="email" placeholder="E-mail" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить </button>

        </form>
    </div>
    <br />

    <div>
        <@l.logout />
    </div>
    <br />
    <a href="/users">List of users</a>

    </body>
</@c.page>