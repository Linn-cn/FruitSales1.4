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
    <title>添加农民</title>
    <%@include file="../../assets/styleAndscript.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" autocomplete="off">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" class="layui-input" lay-verify="required|username" placeholder="请输入账号">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>您唯一的登入名
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="peasantName" class="layui-input" lay-verify="required" placeholder="请输入真实姓名">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>您的真实姓名
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="peasantPhone" class="layui-input" lay-verify="required|phone" placeholder="请输入电话号码">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>方便我们及时与你联系
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">身份</label>
        <div class="layui-input-inline">
            <input type="checkbox" name="peasantIdentity[0]" title="果农" value="果农">
            <input type="checkbox" name="peasantIdentity[1]" title="菜农" value="菜农">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>必选,可多选
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-inline">
            <select name="peasantStatus" lay-verify="required">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="peasantAddress" placeholder="请输入居住地址" lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="addPeasant" value="提交">
            </input>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        form.verify({
            username: function(value, item){
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                var flag;
                $.ajax({
                    url : "user/validateUserName",
                    type : "post",
                    async: false,       //关闭异步
                    data : {"userName":value},
                    success : function(s) {
                        flag = s.success;
                    }
                });
                if (flag){
                    return '用户名已存在，请重新输入！';
                }
            }
        });

        form.on("submit(addPeasant)",function(data){
            var datas = data.field;
            if (datas['peasantIdentity[0]'] != null && datas['peasantIdentity[1]'] != null) {
                datas.peasantIdentity = datas['peasantIdentity[0]'] + ',' + datas['peasantIdentity[1]'];
            } else if (datas['peasantIdentity[0]'] != null || datas['peasantIdentity[1]'] != null) {
                datas.peasantIdentity = datas['peasantIdentity[0]'] != null ? datas['peasantIdentity[0]'] : datas['peasantIdentity[1]'];
            }
            delete datas['peasantIdentity[0]'];
            delete datas['peasantIdentity[1]'];
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            // 提交信息
            $.post("admin/addPeasant",datas,function(s){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.alert(s.msg);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },1500);
            });
            return false;
        });
    });
</script>
</html>