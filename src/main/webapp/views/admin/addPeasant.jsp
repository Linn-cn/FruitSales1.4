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
<form class="layui-form" style="width:90%;" lay-filter="addPeasantForm">
    <input type="hidden" id="peasantId" name="peasantId">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="peasantName" class="layui-input peasantName" lay-verify="required" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="peasantPhone" class="layui-input peasantPhone" lay-verify="required" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">身份</label>
        <div class="layui-input-block peasantIdentity">
            <input type="checkbox" name="peasantIdentity[0]" title="果农" value="果农">
            <input type="checkbox" name="peasantIdentity[1]" title="菜农" value="菜农">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <select name="peasantStatus" class="peasantStatus" lay-verify="required" lay-filter="peasantStatus">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="peasantAddress" placeholder="请输入居住地址" lay-verify="required" class="layui-textarea peasantAddress"></textarea>
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

        var edit = JSON.parse(window.sessionStorage.getItem("peasant"));
        if(edit != null && edit != ""){
            var peasantIdentity = edit.peasantIdentity.split("、");
            // 判断当前农民所拥有的身份
            var flag1 = peasantIdentity.indexOf("果农") != -1;
            var flag2 = peasantIdentity.indexOf("菜农") != -1;
            form.val('addPeasantForm', {
                "peasantId" : edit.peasantId,
                "peasantName": edit.peasantName, // "name": "value"
                "peasantIdentity[0]" : flag1,
                "peasantIdentity[1]" : flag2,
                "peasantPhone" : edit.peasantPhone,
                "peasantStatus" : edit.peasantStatus,
                "peasantAddress" : edit.peasantAddress
            });
        }

            form.on("submit(addPeasant)",function(data){
                var datas = data.field;
                if (datas['peasantIdentity[0]'] != null && datas['peasantIdentity[1]'] != null) {
                    datas.peasantIdentity = datas['peasantIdentity[0]'] + '、' + datas['peasantIdentity[1]'];
                } else if (datas['peasantIdentity[0]'] != null || datas['peasantIdentity[1]'] != null) {
                    datas.peasantIdentity = datas['peasantIdentity[0]'] != null ? datas['peasantIdentity[0]'] : datas['peasantIdentity[1]'];
                }
                delete datas['peasantIdentity[0]'];
                delete datas['peasantIdentity[1]'];
                var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
                // 提交信息
                $.post("admin/updatePeasant",datas,function(s){
                    setTimeout(function(){
                        top.layer.close(index);
                        top.layer.msg(s.msg);
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    },2000);
                });
                // setTimeout(function(){
                //     top.layer.close(index);
                //     top.layer.msg("修改成功");
                //     layer.closeAll("iframe");
                //     //刷新父页面
                //     parent.location.reload();
                // },2000);
                return false;
            });
    });
</script>
</html>