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
        <input type="hidden" id="peasantId" name="peasantId">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>登录名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" disabled="disabled"
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
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="peasantName" class="layui-input" lay-verify="required" placeholder="请输入真实姓名">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-inline">
                <input type="text" name="peasantPhone" class="layui-input" lay-verify="required" placeholder="请输入电话号码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份</label>
            <div class="layui-input-inline">
                <input type="checkbox" name="peasantIdentity[0]" title="果农" value="果农">
                <input type="checkbox" name="peasantIdentity[1]" title="菜农" value="菜农">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户状态</label>
            <div class="layui-input-inline">
                <select name="peasantStatus" lay-verify="required">
                    <option value="">-请选择-</option>
                    <option value="1">正常使用</option>
                    <option value="0">限制用户</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">居住地址</label>
            <div class="layui-input-inline">
                <textarea name="peasantAddress" placeholder="请输入居住地址" lay-verify="required" class="layui-textarea peasantAddress"></textarea>
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


        //页面一加载就发送ajax
        $(function () {
            $.ajax({
                url: "user/getUserInfo",
                type: "post",
                success: function (data) {
                    var peasantIdentity = data.identity.split(",");
                    // 判断当前农民所拥有的身份
                    var flag1 = peasantIdentity.indexOf("果农") != -1;
                    var flag2 = peasantIdentity.indexOf("菜农") != -1;
                    //表单初始赋值
                    form.val('userInfo', {
                        "peasantId" : data.userid,
                        "username":data.username,
                        "role": data.role,
                        "peasantName": data.name,
                        "peasantPhone": data.phone,
                        "peasantStatus": data.status,
                        "peasantIdentity[0]" : flag1,
                        "peasantIdentity[1]" : flag2,
                        "peasantAddress" : data.address
                    });
                }
            });
        });

        form.on("submit(update)",function(data){
            var datas = data.field;
            if (datas['peasantIdentity[0]'] != null && datas['peasantIdentity[1]'] != null) {
                datas.peasantIdentity = datas['peasantIdentity[0]'] + ',' + datas['peasantIdentity[1]'];
            } else if (datas['peasantIdentity[0]'] != null || datas['peasantIdentity[1]'] != null) {
                datas.peasantIdentity = datas['peasantIdentity[0]'] != null ? datas['peasantIdentity[0]'] : datas['peasantIdentity[1]'];
            }
            delete datas['peasantIdentity[0]'];
            delete datas['peasantIdentity[1]'];
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            console.log(datas);
            // 提交信息
            $.post("admin/updatePeasant",datas,function(s){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg(s.msg);
                    layer.closeAll("iframe");
                },1500);
            });
            return false;
        });
    });
</script>

</body>

</html>