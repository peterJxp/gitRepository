<%--
  Created by IntelliJ IDEA.
  User: jxp
  Date: 2018/5/4/004
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/htmleaf-demo.css">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Josefin+Sans:400,700,700italic,600'>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/veryCode.js"></script>
</head>
<body>
<div class="htmleaf-container">
    <div class="cont_principal">
        <div class="cont_join  ">
            <div class="cont_form_join">
                <h2>登陆</h2>

                <p>用户名:</p>
                <input type="text" id="uname" name="uname" class="input_text"  />

                <p>密　码:</p>
                <input type="password" id="password" name="password" class="input_text" />

                <p>验证码:</p>
                <input id="veryCode" name="veryCode" type="text" class="veryCodeInput" value="" />
                <img id="imgObj" style="margin-left: 10px;float: left" alt="" src="${pageContext.request.contextPath}/DrawImage"
                     onclick="changeImg()" />
                <a href="javascript:void(0);" class="veryCodedo" onclick="changeImg()">换一张</a>
                <p id="info" class="veryCodeInfo"></p>
            </div>
            <div class="cont_btn_join">
                <a href="javascript:void(0);" onclick='login()'>登陆</a>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/src/login.js"></script>
</body>
</html>
