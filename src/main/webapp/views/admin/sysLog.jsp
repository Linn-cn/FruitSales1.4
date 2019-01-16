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
    <title>系统日志</title>
    <%@include file="../../assets/styleAndscript.jsp"%>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body class="x-body">
    <table id="logs" lay-filter="logs"></table>
</body>
<script>
    layui.use(['table'],function(){
        var table = layui.table;

        //系统日志
        table.render({
            elem: '#logs',
            id : "systemLog",
            url : 'sys/getSysLogInfo',
            title: '系统日志表',
            cellMinWidth : 95,
            page : true,
            height : "full-20",
            toolbar: true,
            limit : 10,
            limits : [10,15,20,25],
            initSort: {
                field: 'operateDate' //排序字段，对应 cols 设定的各字段名
                ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            },
            cols : [[
                {type: 'checkbox', fixed: 'left'},
                {field: 'logId', title: '编号', align:"center"},
                {field: 'title', title: '标题', align:"center", minWidth:120},
                {field: 'requestUri', title: '请求地址', width:350},
                {field: 'method', title: '操作方式', align:'center',templet:function(d){
                        if(d.method.toUpperCase() == "GET" || d.method.toUpperCase() == "get"){
                            return '<span class="x-blue">'+d.method+'</span>'
                        }else{
                            return '<span class="x-red">'+d.method+'</span>'
                        }
                    }},
                {field: 'params', title: '请求参数', width:350},
                {field: 'remoteAddr', title: '操作IP',  align:'center', minWidth:130},
                {field: 'timeout', title: '请求超时', align:'center',templet:function(d){
                        return '<span class="layui-btn layui-btn-normal layui-btn-xs">'+d.timeout+'</span>'
                    }},
                {field: 'type', title: '是否异常', align:'center',templet:function(d){
                        if(d.type == "info"){
                            return '<span class="layui-btn layui-btn-green layui-btn-xs">'+d.type+'</span>'
                        }else{
                            return '<span class="layui-btn layui-btn-danger layui-btn-xs">'+d.type+'</span>'
                        }
                    }},
                {field: 'username',title: '操作人', minWidth:100,align:"center"},
                {field: 'operateDate', title: '操作时间', align:'center', width:170,sort:true}
            ]]
        });

    });

</script>
</html>
