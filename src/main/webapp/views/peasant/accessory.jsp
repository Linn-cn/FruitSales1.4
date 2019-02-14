<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>附属品管理</title>
    <%@include file="../../assets/styleAndscript.jsp"%>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body class="x-body">
    <table id="accessory" lay-filter="accessory"></table>
</body>
<!--右侧工具栏-->
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addAccessory">
            <i class="layui-icon">&#xe654;&nbsp;</i>添加附属品</button>
    </div>
</script>
<!--操作-->
<script type="text/html" id="accessoryListBar">
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','layer','form'],function(){
        var table = layui.table,
            layer = layui.layer,
            form = layui.form;

        //附属品
        var tableIns = table.render({
            elem: '#accessory',
            id : "accessory",
            url : 'peasant/getAccessoryList?gardenstuffId='+window.sessionStorage.getItem("gardenStuffId"),
            title: '附属品表',
            page : true,
            height : "full-40",
            toolbar: '#toolbarDemo',
            size: 'sm',
            defaultToolbar: [], //不显示右侧工具栏
            cols : [[
                {field: 'accessoryName', title: '附属品名字', align:"center",edit:"text"},
                {field: 'accessoryPrice', title: '附属品单价', align:'center',edit:"text"},
                {field: 'accessoryTime', title: '创建时间', align:'center',},
                {title: '操作',align:"center",toolbar:"#accessoryListBar"}
            ]]
        });

        table.on('edit(accessory)', function(obj){
            console.log(obj.data); //所在行的所有相关数据
            // 提交信息
            $.post("peasant/updateAccessory",obj.data,function(s){
                if(!s.success){
                    layer.msg(s.msg);
                }
            });
        });

        //监听工具条
        table.on('tool(accessory)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if(layEvent === 'del'){ //删除
                layer.confirm('确定删除此附属品？',{icon:3, title:'提示信息'},function(index){
                    $.get("peasant/deleteAccessory", {
                        id: data.accessoryId
                    }, function (s) {
                        if (s.success){
                            layer.msg(s.msg);
                            tableIns.reload();
                        }else{
                            layer.msg(s.msg);
                        }
                    });
                    layer.close(index);
                });
            }
        });

        table.on('toolbar(accessory)', function (obj) {
            switch(obj.event){
                case 'addAccessory':
                    layer.open({
                        type: 1
                        ,title: '添加附属品'
                        ,content: "<form class='layui-form' style='margin-top:10px;'>"
                        + "<div class='layui-form-item layui-row layui-col-xs12'>"
                        + "<label class='layui-form-label'>附属品名</label>"
                        + "<div class='layui-input-inline'>"
                        + "<input type='text' name='accessoryName' lay-verify=\"required\" class='layui-input' placeholder='请输入名字'>"
                        + "</div></div>"
                        + "<div class='layui-form-item layui-row layui-col-xs12'>"
                        + "<label class='layui-form-label'>单价</label>"
                        + "<div class='layui-input-inline'>"
                        + "<input type='text' name='accessoryPrice' lay-verify=\"required\" class='layui-input' placeholder='请输入价格'>"
                        + "</div></div>"
                        + "<div class='layui-form-item layui-row layui-col-xs12'>"
                        + "<div class='layui-input-block'>"
                        + "<input id='submit' type='button' class='layui-btn' lay-submit lay-filter='addAccessory' value='提交' />"
                        + "</div></div>"
                        + "</from>"
                    });
                    break;
                default:break;
            };
        });

        form.on("submit(addAccessory)",function(data){
            var datas = data.field;
            datas.gardenstuffId = window.sessionStorage.getItem("gardenStuffId");
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            // 提交信息
            $.post("peasant/addAccessory",datas,function(s){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg(s.msg);
                    layer.closeAll();
                    //刷新表格
                    tableIns.reload();
                },1500);
            });
            return false;
        });

    });

</script>
</html>
