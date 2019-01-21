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
    <title>编辑零售商</title>
    <%@include file="../../assets/styleAndscript.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" lay-filter="updateDealerForm">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="dealerName" class="layui-input" lay-verify="required" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="dealerPhone" class="layui-input" lay-verify="required|phone" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <select name="dealerStatus" lay-verify="required" lay-filter="dealerStatus">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="dealerAddress" placeholder="请输入居住地址" lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="updateDealer" value="提交">
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

        var edit = JSON.parse(window.sessionStorage.getItem("dealer"));
        if(edit != null && edit != ""){
            form.val('updateDealerForm', {
                "dealerId" : edit.dealerId,
                "dealerName": edit.dealerName, // "name": "value"
                "dealerPhone" : edit.dealerPhone,
                "dealerAddress" : edit.dealerAddress,
                "dealerStatus" : edit.dealerStatus
            });
        }

        form.on("submit(updateDealer)",function(data){
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
            return false;
        });
    });
</script>
</html>