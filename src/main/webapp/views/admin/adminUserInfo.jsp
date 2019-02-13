<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--shiro标签--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>个人信息</title>
    <%@include file="../../assets/styleAndscript.jsp"%>
</head>
<body>
<div class="x-body">
    <form class="layui-form" lay-filter="userInfo">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>登录名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>您唯一的登入名
            </div>
        </div>
        <div class="layui-form-item">
            <label for="role" class="layui-form-label">
                <span class="x-red">*</span>权限
            </label>
            <div class="layui-input-inline">
                <select id="role" name="role" lay-filter="aihao" disabled="disabled">
                    <option value=""></option>
                    <option value="0">管理员</option>
                    <option value="1">农民</option>
                    <option value="2">零售商</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="submit" class="layui-form-label">
            </label>
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="close" value="关闭">
            </input>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        var layer = layui.layer,
            form = layui.form,
            $ = layui.jquery;


        //页面一加载就发送ajax
        $(function () {
            $.ajax({
                url: "user/getUserInfo",
                type: "post",
                success: function (data) {
                    //表单初始赋值
                    form.val('userInfo', {
                        "username":data.username,
                        "role": data.role
                    });
                }
            });
        });
    });
</script>

</body>

</html>