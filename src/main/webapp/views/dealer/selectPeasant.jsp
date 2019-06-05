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
    <title>查看农民详情</title>
    <%@include file="../../assets/styleAndscript.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" lay-filter="updatePeasantForm">
    <input type="hidden" id="peasantId" name="peasantId">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="peasantName" class="layui-input peasantName" readonly="readonly" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="peasantPhone" class="layui-input peasantPhone" readonly="readonly" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">身份</label>
        <div class="layui-input-block peasantIdentity">
            <input type="checkbox" name="peasantIdentity[0]" title="果农" value="果农" disabled>
            <input type="checkbox" name="peasantIdentity[1]" title="菜农" value="菜农" disabled>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <select name="peasantStatus" class="peasantStatus" disabled="disabled" lay-filter="peasantStatus">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="peasantAddress" placeholder="请输入居住地址" readonly="readonly" class="layui-textarea peasantAddress"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">发布果蔬：</label>
        <div class="layui-input-block">
            <table id="GardenStuffList" lay-filter="GardenStuffList"></table>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

        var edit = JSON.parse(window.sessionStorage.getItem("peasant"));
        if(edit != null && edit != ""){
            var peasantIdentity = edit.peasantIdentity.split(",");
            // 判断当前农民所拥有的身份
            var flag1 = peasantIdentity.indexOf("果农") != -1;
            var flag2 = peasantIdentity.indexOf("菜农") != -1;
            form.val('updatePeasantForm', {
                "peasantId" : edit.peasantId,
                "peasantName": edit.peasantName, // "name": "value"
                "peasantIdentity[0]" : flag1,
                "peasantIdentity[1]" : flag2,
                "peasantPhone" : edit.peasantPhone,
                "peasantStatus" : edit.peasantStatus,
                "peasantAddress" : edit.peasantAddress
            });
        }

        //果蔬列表
        var tableIns = table.render({
            elem: '#GardenStuffList',
            id : "GardenStuffList",
            url : 'dealer/getGardenStuffList',
            where : {gardenstuffPeasantid : edit.peasantId},
            title: '果蔬列表',
            page : true,
            limit:5,
            limits: [5],
            cols : [[
                {field: 'gardenstuffName', title: '果蔬名', align:'center',unresize:"true"},
                {field: 'gardenstuffPrice', title: '价格', align:'center',unresize:"true"},
                {field: 'gardenstuffCategoryname', title: '类别', align:'center',unresize:"true"},
                {field: 'gardenstuffNumber', title: '库存', align:'center',unresize:"true"},
                {field: 'gardenstuffAddress', title: '产地', align:'center',unresize:"true"},
            ]]
        });

    });
</script>
</html>