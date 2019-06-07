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
    <title>系统基本参数</title>
    <%@include file="../../assets/styleAndscript.jsp"%>
    <style type="text/css">
        .layui-table td, .layui-table th {
            text-align: center;
        }

        .layui-table td {
            padding: 5px;
        }
    </style>
</head>
<body class="x-body">
<form class="layui-form" lay-filter="sysForm" autocomplete="off">
    <table class="layui-table">
        <colgroup>
            <col width="20%">
            <col width="50%">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th><b>参数说明</b></th>
            <th><b>参数值</b></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>系统版本</td>
            <td><input name="sysVersion" type="text" class="layui-input cmsName" lay-verify="required" placeholder="请输入系统版本"/></td>
        </tr>
        <tr>
            <td>服务器地址</td>
            <td><input name="sysUrl" type="text" class="layui-input version" placeholder="请输入服务器地址"/></td>
        </tr>
        <tr>
            <td>操作系统</td>
            <td><input name="sysOperation" type="text" class="layui-input author" placeholder="请输入操作系统"/></td>
        </tr>
        <tr>
            <td>运行环境</td>
            <td><input name="sysRuntime" type="text" class="layui-input homePage" placeholder="请输入运行环境"/></td>
        </tr>
        <tr>
            <td>JDK版本</td>
            <td><input name="sysJdk" type="text" class="layui-input server" placeholder="请输入JDK版本"/></td>
        </tr>
        <tr>
            <td>MYSQL版本</td>
            <td><input name="sysMysql" type="text" class="layui-input dataBase" placeholder="MYSQL版本"/></td>
        </tr>
        <tr>
            <td>项目大小</td>
            <td><input name="sysItemsize" type="text" class="layui-input maxUpload" placeholder="请输入项目大小"/></td>
        </tr>
        <tr>
            <td>更新时间</td>
            <td>
                <input class="layui-input" placeholder="开始时间"
                       id="find_ContractVo_startTime"
                       name="sysUpdatetime" /></td>
        </tr>
        <tr>
            <td>版权所有</td>
            <td><input name="sysCopyright" type="text" class="layui-input keywords" placeholder="请输入默认关键字"/></td>
        </tr>
        <tr>
            <td>开发者</td>
            <td><input name="sysAuthor" type="text" class="layui-input powerby" placeholder="请输入网站版权信息"/></td>
        </tr>
        </tbody>
    </table>
    <div class="layui-form-item" style="text-align: right;">
        <div class="layui-input-block">
            <input type="button" class="layui-btn" lay-submit lay-filter="systemParameter" value="立即提交">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript">
    layui.use(['form','layer','jquery','laydate'],function() {
        var layer = layui.layer,
            form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;

        form.on('submit(systemParameter)', function(data){
            console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
            $.ajax({
                url : "sys/updateSysInfo",
                type : "post",
                data : data.field,
                success : function(s) {
                    if (s.success) {
                        //弹出loading
                        var index = layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
                        setTimeout(function(){
                            layer.close(index);
                            layer.msg(s.msg);
                        },500);
                    }else{
                        layer.alert(s.msg);
                    }
                }
            });
        });

        //页面一加载就发送ajax
        $(function () {
            $.ajax({
                url: "sys/getSysInfo",
                type: "post",
                success: function (data) {
                    //表单初始赋值
                    form.val('sysForm', {
                        "sysVersion": data.sysVersion,
                        "sysUrl": data.sysUrl,
                        "sysOperation": data.sysOperation,
                        "sysRuntime": data.sysRuntime,
                        "sysJdk": data.sysJdk,
                        "sysMysql": data.sysMysql,
                        "sysItemsize": data.sysItemsize,
                        "sysCopyright": data.sysCopyright,
                        "sysAuthor": data.sysAuthor
                    });
                    //实例化时间插件
                    laydate.render({
                        elem: '#find_ContractVo_startTime' // 指定元素
                        ,type: 'datetime'
                        ,value: new Date(data.sysUpdatetime)
                    });
                }
            });
        });
    });
</script>
</body>
</html>
