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
    <title>零售商详情</title>
    <%@include file="../../assets/styleAndscript.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" lay-filter="updateDealerForm">
    <input type="hidden" id="dealerId" name="dealerId">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="dealerName" class="layui-input" readonly="readonly" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="dealerPhone" class="layui-input" readonly="readonly" placeholder="请输入电话号码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <select name="dealerStatus" disabled="disabled">
                <option value="">-请选择-</option>
                <option value="1">正常使用</option>
                <option value="0">限制用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <textarea name="dealerAddress" placeholder="请输入居住地址" readonly="readonly" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label" style="margin-top: 5px;">信用星级</label>
        <div class="layui-input-block">
            <div id="grade"></div>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form','layer','rate'],function(){
        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery,
            rate = layui.rate;

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

        //根据签约合同数评级
        var grade = edit.contractCount;
        if (grade >= 0 && grade <= 10){
            grade = 1;
        }else if (grade > 10 && grade <= 20){
            grade = 2;
        }else if (grade > 20 && grade <= 30){
            grade = 3;
        }else if (grade > 30 && grade <= 40){
            grade = 4;
        }else if (grade > 40){
            grade = 5;
        }

        //评级
        rate.render({
            elem: '#grade'
            ,value: 1 //初始值
            ,text: true //开启文本
            ,readonly: true
            ,theme: '#FE0000'
        });

        var tip_index = 0;
        $(document).on('mouseenter', '#grade', function(){
            console.log("1111");
            tip_index = layer.tips('签订&nbsp;&nbsp;0-10份合同为1星级;<br/>签订10-20份合同为2星级;<br/>签订20-30份合同为3星级;<br/>签订30-40份合同为4星级;<br/>签订40份合同以上为5星级', '#grade', {time: 0});
        }).on('mouseleave', '#grade', function(){
            layer.close(tip_index);
        });
    });
</script>
</html>