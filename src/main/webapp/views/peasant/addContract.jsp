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
    <title>添加合同</title>
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
                <select name="type">
                    <option value="">-请选择-</option>
                    <option value="1">省内</option>
                    <option value="2">省外</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">零售商：</label>
            <div class="layui-input-inline">
                <select name="dealer" xm-select="checkDealer" xm-select-radio=""
                        xm-select-show-count="1" xm-select-skin="normal">
                    <option value="">请选择零售商</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-md12">
            <label class="layui-form-label">选择果蔬：</label>
            <div class="layui-input-block">
                <table id="GardenStuffList" lay-filter="GardenStuffList"></table>
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

        var formSelects = layui.formSelects;

        formSelects.config('checkDealer',{
            data:{"peasantStatus" : 1}, //禁用状态的农民不显示
            keyName: 'dealerName',
            keyVal: 'dealerId'
        });
        formSelects.data('checkDealer', 'server', {
            url: 'peasant/getDealerList'
        });

        //初始化合同编号
        $(function(){
            var barcode = Createbarcode();
            $("input[name='barcode']").val(barcode);
        });

        //个位补零的函数
        function Appendzero(obj){
            if (obj < 10){
                return "0" + obj;	//小于10则补零
            }else{
                return obj;			//否则返回本身
            }
        }

        //自动生成合同编号
        function Createbarcode(){
            var myDate = new Date();
            var getYear = myDate.getFullYear();
            var getMonth = myDate.getMonth()+1;
            var getDate = myDate.getDate();

            var getHours = myDate.getHours();
            var getMinutes = myDate.getMinutes();

            //日期
            var riqi = Appendzero(getYear) + "" + Appendzero(getMonth) + "" + Appendzero(getDate);
            //时间
            var shijian = Appendzero(getHours) + "" + Appendzero(getMinutes);
            var alltime = riqi + "" + shijian;

            //生成一个从 m - n 之间的随机整数
            return alltime + parseInt(Math.random()*(99-10+1)+10);
        }

        //果蔬列表
        var tableIns = table.render({
            elem: '#GardenStuffList',
            id : "gardenStuffListTable",
            url : 'peasant/getGardenStuffList',
            title: '果蔬列表',
            page : true,
            limits: [5],
            cols : [[
                {type: "checkbox", fixed:"left"},
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