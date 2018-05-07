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
</head>
<body>
<div class="htmleaf-container">
    <div class="cont_principal">
        <%--<header class="htmleaf-header">--%>
            <%--<div class="htmleaf-links">--%>
                <%--<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家" target="_blank"><span> jQuery之家</span></a>--%>
                <%--<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/css3/ui-design/201603013167.html" title="返回下载页" target="_blank"><span> 返回下载页</span></a>--%>
            <%--</div>--%>
        <%--</header>--%>
        <div class="cont_join  ">
            <%--<div class="cont_letras">--%>
                <%--<p>LET 'S</p>--%>
                <%--<p>GET</p>--%>
                <%--<p>LOST</p>--%>
            <%--</div>--%>

            <div class="cont_form_join">
                <h2>登陆</h2>

                <p>用户名:</p>
                <input type="text" id="uname" name="uname" class="input_text"  />

                <p>密　码:</p>
                <input type="password" id="password" name="password" class="input_text" />

                <p>验证码:</p>
                <input type="password" class="input_text" />
            </div>

            <%--<div class="cont_join_form_finish" style="position: absolute;width: -50px;">--%>
                    <%--<h2>Finish <i class="material-icons">&#xE5CA;</i></h2>--%>
            <%--</div>--%>

            <div class="cont_btn_join">
                <a href="javascript:void(0);" onclick='join_1()'>登陆</a>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/src/login.js"></script>
</body>
</html>
