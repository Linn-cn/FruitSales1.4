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
                <select name="dealerId" xm-select="checkDealer" xm-select-radio=""
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
        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="addContract" value="提交">
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
            id : "GardenStuffList",
            url : 'peasant/getGardenStuffList',
            title: '果蔬列表',
            cols : [[
                {type: "checkbox", fixed:"left"},
                {field: 'gardenstuffName', title: '果蔬名', align:'center',unresize:"true"},
                {field: 'gardenstuffPrice', title: '价格', align:'center',unresize:"true"},
                {field: 'gardenstuffCategoryname', title: '类别', align:'center',unresize:"true"},
                {field: 'gardenstuffNumber', title: '库存', align:'center',unresize:"true",edit: "text"},
                {field: 'gardenstuffAddress', title: '产地', align:'center',unresize:"true"},
            ]]
        });


        table.on('edit(GardenStuffList)', function (obj) {
            var that = this;
            var tdElem = $(that).closest('td');
            // 提交信息
            $.post("peasant/gardenstuffNumberCheck", obj.data, function (s) {
                if (!s.success) {
                    setTimeout(function () {
                        layer.msg(s.msg, {anim: 6});
                        tdElem.click();
                    }, 100);
                }
            });
        });

        form.on("submit(addContract)",function(data){
            var checkStatus = table.checkStatus('GardenStuffList'),
                TCdata = checkStatus.data,
                TCdataId = [],
                TCNumber = [];
            if(TCdata.length > 0) {
                for (var i in TCdata) {
                    TCdataId.push(TCdata[i].gardenstuffId);
                    TCNumber.push(TCdata[i].gardenstuffNumber);
                }
            }
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            var datas = data.field;
            datas.TCdataId = TCdataId;
            datas.TCNumber = TCNumber;
            // 提交信息
            $.post("peasant/addContract",datas,function(s){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.alert(s.msg);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },1500);
            });
            console.log(datas);
            return false;
        });

    });
</script>
</html>