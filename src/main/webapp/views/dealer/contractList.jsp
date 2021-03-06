<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html><fmt:setBundle basename="i18n/i18n_zn_CN"/>
<head>
    <base href="<%=basePath%>">
    <title>合同列表</title>
    <%@include file="../../assets/styleAndscriptForm.jsp"%>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body class="x-body">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <input type="text" name="peasantName" class="layui-input searchVal" placeholder="请输入农民名" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="dealerName" class="layui-input searchVal" placeholder="请输入零售商名" />
                </div>
                <div class="layui-input-inline">
                    <select name="check">
                        <option value="">选择合同状态</option>
                        <option value="1">已确认</option>
                        <option value="2">未确认</option>
                    </select>
                </div>
                <a title="搜索" class="layui-btn" lay-submit lay-filter="search_btn"><i class="layui-icon">&#xe615;</i></a>
            </div>
            <div class="layui-inline" style="float: right">
                <a class="layui-btn" href="javascript:location.reload();" title="刷新">
                    <i class="layui-icon">&#xe669;</i>
                </a>
            </div>
        </form>
    </blockquote>
    <table id="ContractList" lay-filter="ContractList"></table>

</body>
<!--操作-->
<script type="text/html" id="ContractListBar">
    <a class="layui-btn layui-btn-xs" lay-event="info">查看详情</a>
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="confirm">确认合同</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="cancel">取消合同</a>
</script>
<script>
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;


        //合同列表
        var tableIns = table.render({
            elem: '#ContractList',
            id : "ContractListTable",
            url : 'dealer/getContractList',
            title: '合同列表',
            page : true,
            height : "full-110",
            toolbar: true,
            limits: [10],
            cols : [[
                {type: "checkbox", fixed:"left"},
                {field: 'peasantName', title: '农民名字', align:"center",unresize:"true"},
                {field: 'dealerName', title: '零售商名', align:'center',unresize:"true"},
                {field: 'barcode', title: '合同编号', align:'center',unresize:"true"},
                {field: 'type', title: '合同类型', align:'center',unresize:"true",templet:function(d){
                        return d.type == "1" ? "省内" : "省外";
                    }},
                {field: 'check', title: '合同状态', align:'center',unresize:"true",templet:function (d) {
                        return d.check == "1" ? "<span style='color: #009688;'>已签约</span>" : "<span style='color: red;'>待确认</span>";
                    }},
                {field: 'createtime', title: '创建时间', align:'center',unresize:"true"},
                {title: '操作',width:"20%",align:"center",unresize:"true",toolbar:"#ContractListBar"}
            ]]
        });

        //搜索
        form.on('submit(search_btn)', function(data){
            var datas = data.field;
            tableIns.reload({
                where: datas
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });

       //打开合同详情
        function selectContract(edit){
            url = "views/public/selectContract.jsp";
            window.sessionStorage.setItem("contract",JSON.stringify(edit));
            var index = layui.layer.open({
                title : "合同详情",
                type : 2,
                area: ['750px', '450px'],
                content : url,
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处关闭窗口', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3,
                            time:2000
                        });
                    },300);
                },
                end: function(){
                    window.sessionStorage.removeItem("contract");
                }
            });
        }

        //监听工具条
        table.on('tool(ContractList)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            switch(layEvent){
                case 'info':    //查看详情
                    $.get("dealer/getContractInfo", {
                        contractId : data.contractId
                    }, function (s) {
                        if (s.success){
                            selectContract(s.data);
                        }else{
                            layer.alert(s.msg);
                        }
                    });
                    break;
                case 'cancel':     //删除
                    layer.confirm('确定取消签约此合同？',{icon:3, title:'提示信息'},function(index){
                        $.get("dealer/cancelContract", {
                            id: data.contractId  //将需要删除的Id作为参数传入
                        }, function (s) {
                            if (s.success){
                                layer.msg(s.msg);
                                tableIns.reload();
                            }else{
                                layer.alert(s.msg);
                            }
                        });
                        layer.close(index);
                    });
                    break;
                case 'confirm':
                    if(data.check == "1"){
                        layer.alert("已经签约，无须再进行操作!");
                    }else{
                        layer.confirm('确定签约此合同？',{icon:3, title:'提示信息'},function(index){
                            $.get("dealer/confirmContract", {
                                id: data.contractId  //将需要签约的Id作为参数传入
                            }, function (s) {
                                if (s.success){
                                    layer.msg(s.msg);
                                    tableIns.reload();
                                }else{
                                    layer.alert(s.msg);
                                }
                            });
                            layer.close(index);
                        });
                    }
                    break;
                default:
                    layer.alert("<fmt:message key='common.msg'/>");
                    break;
            }
        });

    });
</script>
</html>
