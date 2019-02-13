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
    <style type="text/css">
        @media print {
            #check{
                display:none;
            }
        }
        .layui-table-cell {
            height: auto;
        }
    </style>
</head>
<body class="x-body">
    <form class="layui-form" style="width:90%;" lay-filter="selectContractForm">
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">合同编号</label>
            <div class="layui-input-inline">
                <input type="text" name="barcode" class="layui-input" readonly="readonly">
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
                <input type="text" name="dealerName" class="layui-input" readonly="readonly">
            </div>
            <div class="layui-form-mid">联系电话：</div>
            <div class="layui-input-inline">
                <input type="text" name="dealerPhone" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">地址：</label>
            <div class="layui-input-block">
                <input type="text" name="dealerAddress" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">农民信息</label>
            <div class="layui-input-inline">
                <input type="text" name="peasantName" class="layui-input" readonly="readonly">
            </div>
            <div class="layui-form-mid">联系电话：</div>
            <div class="layui-input-inline">
                <input type="text" name="peasantPhone" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">地址：</label>
            <div class="layui-input-block">
                <input type="text" name="peasantAddress" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">果蔬信息：</label>
            <div class="layui-input-block">
                <table id="GardenStuffList" lay-filter="GardenStuffList"></table>
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">合同状态：</label>
            <div class="layui-input-inline" style="padding-top: 8px;">
                <input type="checkbox" name="check" lay-skin="switch" lay-text="已确认|未确认">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label"></label>
            <div id="check" class="layui-input-block">
                <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="print" value="打印详情">
                </input>
            </div>
        </div>
    </form>
</body>
<script>
    layui.use(['form', 'layer','table'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

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
                "check" : edit.check == '1' ? true : false,
            });
        }

        //合同列表
        var tableIns = table.render({
            elem: '#GardenStuffList',
            id : "GardenStuffListTable",
            url : 'admin/getGardenStuffInfoList?contractId=' + edit.contractId,
            title: '果蔬列表',
            page : true,
            limit : 2,
            limits : [2,4],
            cols : [[
                {field: 'gardenstuffName', title: '果蔬名字', align:"center",unresize:"true"},
                {field: 'gardenstuffPrice', title: '单价', align:'center',unresize:"true"},
                {field: 'accessoryList', title: '附属品', align:'center',unresize:"true",templet:function (d) {
                    console.log(d.accessoryList);
                        var datahtml = "";
                        if(d.accessoryList.length == 0){
                            datahtml = "<p>无</p>";
                            return datahtml;
                        }
                        for (var data of d.accessoryList){
                            datahtml += "<p>" + data.accessoryName + ":" + data.accessoryPrice + "</p>";
                        }
                        return datahtml;
                    }},
                {field: 'gardenstuffNumber', title: '数量', align:'center',unresize:"true"},
            ]]
        });

        form.on("submit(print)", function (data) {
            window.print();
        });

    });
</script>
</html>