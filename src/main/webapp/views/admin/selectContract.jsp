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
    <title>合同详情</title>
    <%@include file="../../assets/styleAndscriptForm.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" lay-filter="selectContractForm">
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">合同编号</label>
        <div class="layui-input-inline">
            <input type="text" name="barcode" class="layui-input" disabled="disabled">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>合同的唯一编号
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">合同类型</label>
        <div class="layui-input-inline">
            <select name="type" disabled="disabled">
                <option value="">-请选择-</option>
                <option value="1">省内</option>
                <option value="2">省外</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">零售商信息</label>
        <div class="layui-input-inline">
            <input type="text" name="dealerName" class="layui-input" disabled="disabled">
        </div>
        <div class="layui-form-mid">联系电话：</div>
        <div class="layui-input-inline">
            <input type="text" name="dealerPhone" class="layui-input" disabled="disabled">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">地址：</label>
        <div class="layui-input-block">
            <input type="text" name="dealerAddress" class="layui-input" disabled="disabled">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">农民信息</label>
        <div class="layui-input-inline">
            <input type="text" name="peasantName" class="layui-input" disabled="disabled">
        </div>
        <div class="layui-form-mid">联系电话：</div>
        <div class="layui-input-inline">
            <input type="text" name="peasantPhone" class="layui-input" disabled="disabled">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md12">
        <label class="layui-form-label">地址：</label>
        <div class="layui-input-block">
            <input type="text" name="peasantAddress" class="layui-input" disabled="disabled">
        </div>
    </div>

    <div class="layui-form-item layui-row layui-col-md12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="print" value="打印详情">
            </input>
        </div>
    </div>
    </div>
</form>
</body>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        //用于获取修改数据
        var edit = JSON.parse(window.sessionStorage.getItem("contract"));

        if (edit != null && edit != "") {
            form.val('selectContractForm', {
                "barcode": edit.barcode,
                "type": edit.type,
                "dealerName": edit.dealer.dealerName,
                "dealerPhone": edit.dealer.dealerPhone,
                "dealerAddress": edit.dealer.dealerAddress,
                "peasantName": edit.peasant.peasantName,
                "peasantPhone": edit.peasant.peasantPhone,
                "peasantAddress": edit.peasant.peasantAddress,
            });
        }

        form.on("submit(print)",function(data){
            $('#x-body').jqprint();
        });

    });
</script>
</html>