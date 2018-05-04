<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2/002
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入Jquery文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
    <!-- 引入EasyUI的样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/default/easyui.css"/>
    <!-- 引入EasyUI的图标样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/icon.css"/>
    <!-- 引入EasyUI -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>

<center>
    <table id="datagrid" title="学生信息" class="easyui-datagrid" style="width:95%;height:auto;"
           url="" fitColumns="true" toolbar="#tb"
           data-options="
                rownumbers:true,
                singleSelect:true,
                autoRowHeight:false,
                pagination:true,
                pageSize:10">
        <thead>
            <th field="id" width="10" align="center">学号</th>
            <th field="name" width="10" align="center">姓名</th>
            <th field="age" width="10" align="center">年龄</th>
            <th field="toSchoolDate" width="10" align="center" formatter="forMatToSchoolDate">报道日期</th>
        </tr>
        </thead>
    </table>
</center>
<!-- 工具栏 -->
<div id="tb" style="padding:3px;">
    <span>姓名</span>
    <input id="name" style="line-height:26px;border:1px solid #ccc">
    <span>时间</span>
    <input id="time" type="text" class="easyui-datebox" required="required">
    <a href="#" class="easyui-linkbutton" onclick="doSerach()">查询</a><br>
    增加：<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'"></a>
    删除：<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'"></a>
    修改：<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"></a>
    帮助：<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help'"></a>
</div>

</body>
</html>
