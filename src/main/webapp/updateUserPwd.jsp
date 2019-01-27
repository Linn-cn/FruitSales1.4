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
    <title>修改密码</title>
    <%@include file="assets/styleAndscript.jsp" %>
    <style>
        .pwdTips {
            min-height: auto;
            margin: 40px 0 15px 110px;
        }
    </style>
</head>
<body class="x-body">
<form class="layui-form layui-row changePwd">
    <div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
        <div class="layui-input-block x-red pwdTips">旧密码请输入用户当前登录密码，新密码必须两次输入一致才能提交</div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" value="<shiro:principal />" disabled class="layui-input layui-disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-block">
                <input type="password" value="" placeholder="请输入旧密码" lay-verify="required|oldPwd" name="oldPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="password" value="" placeholder="请输入新密码" lay-verify="required|newPwd" name="newPwd" id="newPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-block">
                <input type="password" value="" placeholder="请确认密码" lay-verify="required|confirmPwd" class="layui-input pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="button" class="layui-btn" lay-submit="" lay-filter="changePwd" value="立即修改" />
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        //添加验证规则
        form.verify({
            oldPwd : function(value, item){
                var flag;
                $.ajax({
                    url : "user/validatePassword",
                    type : "post",
                    async: false,       //关闭异步
                    data : {"oldPwd":value},
                    success : function(s) {
                            flag = s.success;
                    }
                });
                if (flag){
                    return '旧密码错误，请重新输入！';
                }
            },
            newPwd : function(value, item){
                if(value.length < 6){
                    return "密码长度不能小于6位";
                }
            },
            confirmPwd : function(value, item){
                if(!new RegExp($("#newPwd").val()).test(value)){
                    return "两次输入密码不一致，请重新输入！";
                }
            }
        });

        form.on('submit(changePwd)', function(data){
            var datas = data.field;
            var newPwd = datas.newPwd;
            $.ajax({
                url : "user/updateUserPwd",
                type : "post",
                data : {"newPwd":newPwd},
                success : function(s) {
                    if (s.success) {
                        layer.alert(s.msg, {icon: 1});
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