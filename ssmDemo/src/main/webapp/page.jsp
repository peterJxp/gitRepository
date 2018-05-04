<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28/028
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        table tr {
            width: 10%;
        }
        table tr td{
            width: 20%;
        }
    </style>
    <script>
        function show(data) {
            var uap=document.getElementById("updatediv");
            var table=document.getElementById("table");
            var updateId=document.getElementById("updateId").value=data;
            uap.style.display='block';
            table.style.display='none';
        }
    </script>
</head>
<body>
<table id="table" cellspacing="0" align="center" border="1">
    <c:forEach items="${perList}" var="per">
        <tr>
            <td>${per.id}</td>
            <td>${per.name}</td>
            <td>${per.age}</td>
            <td><a href="/per/deletePer?id=${per.id}">delete</a>&nbsp;<a href="#" onclick="show('${per.id}')">update</a></td>
        </tr>
    </c:forEach>
</table>

<div id="updatediv" style="display: none;width: 200px;height: 200px;margin-top: 15%;margin-left: 40%" >
    <form action="/per/update">
        <label>name:</label><input type="text" name="name"/>
        <br/>
        <label>age:</label><input type="text" name="age"/>
        <br/>
        <input id="updateId" name="id" type="hidden" value=""/>
        <br/>
        <button type="submit">go</button>
    </form>
</div>
</body>
</html>
