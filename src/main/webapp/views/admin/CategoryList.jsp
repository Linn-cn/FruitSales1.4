<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>果蔬类别</title>
    <%@include file="../../assets/styleAndscriptForm.jsp"%>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body class="x-body">
<table id="Category" lay-filter="Category"></table>
</body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm addCategory">
            <i class="layui-icon">&#xe640;&nbsp;</i>添加果蔬类别</button>
    </div>
</script>

<script>
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

        //果蔬类别
        var tableIns = table.render({
            elem: '#Category',
            id : "systemLog",
            url : 'admin/getCategoryList',
            title: '果蔬类别表',
            page : true,
            height : "full-20",
            toolbar: '#toolbarDemo',
            cols : [[
                {field: 'categoryId', title: '类别编号', align:"center",unresize:"true"},
                {field: 'categoryName', title: '类别名', align:"center",unresize:"true",edit:"text"}
            ]]
        });

        table.on('edit(Category)', function(obj){
            console.log(obj.data); //所在行的所有相关数据
            // 提交信息
            $.post("admin/updateCategory",obj.data,function(s){
                if(!s.success){
                    layer.msg(s.msg);
                }
            });
        });

    });
</script>
</html>
