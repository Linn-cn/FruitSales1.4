<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>忘记密码</title>
    <%@include file="assets/styleAndscript.jsp" %>
</head>
<body>
<div class="x-body">
    <form class="layui-form">

        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>登录名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layu
            0i-word-aux">
                <span class="x-red">*</span>您唯一的登入名
            </div>
        </div>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>您的真实姓名
            </div>
        </div>
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>手机
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>用于核实的手机号
            </div>
        </div>
<%--        <div class="layui-form-item">
            <label for="address" class="layui-form-label">
                <span class="x-red">*</span>地址
            </label>
            <div class="layui-input-inline">
                <input type="text" id="address" name="address" required=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red">*</span>角色</label>
            <div class="layui-input-block">
                <input type="checkbox" name="role" value="1" lay-skin="primary" title="农民">
                <input type="checkbox" name="role" value="2" lay-skin="primary" title="零售商">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_pass" name="password" required="" lay-verify="pass"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span>确认密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="submit" class="layui-form-label">
            </label>
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="update" value="提交">
            </input>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        var layer = layui.layer,
            form = layui.form,
            $ = layui.jquery;

        //自定义验证规则
        form.verify({
            pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ],
            repass: function (value) {
                if ($('#L_pass').val() != value) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(update)', function (data) {
            console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
            $.ajax({
                url: "user/verify",
                type: "post",
                data: data.field,
                success: function (s) {
                    if (s.success) {
                        layer.alert(s.msg, {icon: 1},function () {
                            x_admin_close();
                        });
                    } else {
                        layer.alert(s.msg, {icon: 2});
                    }
                }
            });
            return false;
        });
    });
</script>

</body>

</html>