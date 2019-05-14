<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <base href="<%= basePath%>">
    <link rel="stylesheet" href="assets/css/login.css">
    <%@include file="assets/styleAndscript.jsp"%>
</head>
<body onkeydown="enterSubmit(event)">
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>鲜美果蔬</h2>
            <p>专为果农和水果零售商服务的后台管理系统</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                       for="LAY-user-login-username"></label>
                <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名"
                       class="layui-input" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                       for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required"
                       placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item" style="margin-bottom: 20px;">
                <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                <a href="javascript:void(0);" onclick="x_admin_show('密码重置','retrievePwd.jsp',600,450)" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
            </div>
            <div class="layui-form-item">
                <button id="login" class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
            </div>
        </div>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2018 <a href="http://www.layui.com/" target="_blank">xianmeiguoshu.com</a></p>
        <p>
            <span><a href="http://www.layui.com/admin/#get" target="_blank">获取授权</a></span>
            <span><a href="http://www.layui.com/admin/pro/" target="_blank">在线演示</a></span>
            <span><a href="http://www.layui.com/admin/" target="_blank">前往官网</a></span>
        </p>
    </div>
</div>
</body>
<script>
    function enterSubmit(obj) {
        //当enter 键按下后，需要执行的事件
        var button = document.getElementById('login');
        if (obj.keyCode == 13) {
            button.click();
        }
    }

    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            form = layui.form,
            $ = layui.jquery;

        form.on('submit(LAY-user-login-submit)', function(data){
            console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
            $.ajax({
                url : "user/login",
                type : "post",
                data : data.field,
                success : function(s) {
                    if (s.success) {
                        //加载层-风格3
                        layer.load(2);
                        setTimeout(function(){
                            layer.closeAll('loading');
                        }, 1500);
                        layer.msg("登录成功,等待跳转",function(){
                            location.href = s.msg;
                        });
                    }else{
                        layer.msg(s.msg, function(){});
                    }
                }
            });
        });
    });
</script>
</html>
