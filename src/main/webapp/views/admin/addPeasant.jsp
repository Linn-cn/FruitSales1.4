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
    <title>设置农民</title>
    <%@include file="../../assets/styleAndscript.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="peasantName" class="layui-input peasantName" lay-verify="required" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="peasantPhone" class="layui-input peasantPhone" lay-verify="email" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">身份</label>
        <div class="layui-input-block peasantIdentity">
            <input type="checkbox" name="peasantIdentity" title="果农" value="果农">
            <input type="checkbox" name="peasantIdentity" title="菜农" value="菜农">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <select name="peasantStatus" class="peasantStatus" lay-filter="userStatus">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="peasantAddress" placeholder="请输入居住地址" class="layui-textarea peasantAddress"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="addPeasant" value="提交">
            </input>
        </div>
    </div>
</form>
<script>

</script>

</body>

</html>