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
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm deleteLog">
            <i class="layui-icon">&#xe640;&nbsp;</i>清除过期日志</button>
    </div>
</script>
<script>
    layui.use(['table','layer'],function(){
        var table = layui.table,
            layer = layui.layer;

        //系统日志
        var tableIns = table.render({
            elem: '#logs',
            id : "systemLog",
            url : 'sys/getSysLogInfo',
            title: '系统日志表',
            cellMinWidth : 95,
            page : true,
            height : "full-20",
            toolbar: '#toolbarDemo',
            cols : [[
                {type: 'checkbox', fixed: 'left'},
                {field: 'logId', title: '编号', align:"center"},
                {field: 'title', title: '标题', align:"center", minWidth:120},
                {field: 'requestUri', title: '请求地址', width:300},
                {field: 'type', title: '是否异常', align:'center',templet:function(d){
                        if(d.type == "info"){
                            return '<span class="layui-btn layui-btn-green layui-btn-xs">'+d.type+'</span>';
                        }else{
                            return '<span class="layui-btn layui-btn-danger layui-btn-xs">'+d.type+'</span>';
                        }
                    }},
                {field: 'params', title: '请求参数', width:350},
                {field: 'remoteAddr', title: '操作IP',  align:'center', minWidth:130},
                {field: 'timeout', title: '请求超时', align:'center',templet:function(d){
                        return '<span class="layui-btn layui-btn-normal layui-btn-xs">'+d.timeout+'</span>';
                    }},
                {field: 'exception', title: '异常信息', align:'center',templet:function(d){
                        return d.exception;
                    }},
                {field: 'username',title: '操作人', minWidth:100,align:"center"},
                {field: 'operateDate', title: '操作时间', align:'center', width:170,sort:true}
            ]]
        });

        $(".deleteLog").click(function(){
            $.post("sys/deleteLog",function(s){
                layer.msg(s.msg);
                tableIns.reload();
            });
        });

    });

</script>
</html>
