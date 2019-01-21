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
    <title>零售商列表</title>
    <%@include file="../../assets/styleAndscript.jsp"%>
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
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="peasantName" class="layui-input searchVal" placeholder="请输入用户名" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="peasantPhone" class="layui-input searchVal" placeholder="请输入电话号码" />
                </div>
                <div class="layui-input-inline">
                    <select name="peasantStatus">
                        <option value="">选择用户状态</option>
                        <option value="1">正常使用</option>
                        <option value="0">限制使用</option>
                    </select>
                </div>
                <a title="搜索" class="layui-btn" lay-submit lay-filter="search_btn"><i class="layui-icon">&#xe615;</i></a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-normal addNews_btn">添加零售商</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
            </div>
            <div class="layui-inline" style="float: right">
                <a class="layui-btn" href="javascript:location.reload();" title="刷新">
                    <i class="layui-icon">&#xe669;</i>
                </a>
            </div>
        </form>
    </blockquote>
    <table id="dealerList" lay-filter="dealerList"></table>

</body>
<!--操作-->
<script type="text/html" id="dealerListBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="reset">重置</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script>
    layui.use(['form','layer','table','laytpl'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

        //果农列表
        var tableIns = table.render({
            elem: '#dealerList',
            id : "dealerListTable",
            url : 'admin/getDealerList',
            title: '零售商列表',
            page : true,
            height : "full-110",
            toolbar: true,
            limit : 10,
            limits : [10,15,20,25],
            initSort: {
                field: 'dealerTime' //排序字段，对应 cols 设定的各字段名
                ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            },
            cols : [[
                {type: "checkbox", fixed:"left"},
                {field: 'dealerName', title: '零售商名字', align:"center",unresize:"true"},
                {field: 'dealerPhone', title: '电话号码', align:'center',unresize:"true"},
                {field: 'dealerStatus', title: '账号状态', align:'center',unresize:"true",templet:function (d) {
                        return d.peasantStatus == "1" ? "正常使用" : "限制使用";
                    }},
                {field: 'dealerAddress', title: '居住地址', align:'center',unresize:"true"},
                {field: 'dealerTime', title: '注册时间', align:'center',sort:true,unresize:"true"},
                {title: '操作',align:"center",unresize:"true",toolbar:"#dealerListBar"}
            ]]
        });

        //搜索
/*        form.on('submit(search_btn)', function(data){
            console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
            tableIns.reload({
                where: data.field
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });*/

        //打开设置农民弹窗
/*        function updatePeasant(edit){
            if(edit){
                window.sessionStorage.setItem("peasant",JSON.stringify(edit));
            }
            var index = layui.layer.open({
                title : "设置农民",
                type : 2,
                area: ['750px', '450px'],
                content : "views/admin/updatePeasant.jsp",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3,
                            time:2000
                        });
                    },300);
                },
                end: function(){
                    window.sessionStorage.removeItem("peasant");
                }
            });
        }*/

/*        $(".addNews_btn").click(function(){
            console.log("添加农民");
        });*/

        //批量删除
/*        $(".delAll_btn").click(function(){
            var checkStatus = table.checkStatus('peasantListTable'),
                data = checkStatus.data,
                deleteId = [];
            if(data.length > 0) {
                for (var i in data) {
                    deleteId.push(data[i].peasantId);
                }
                layer.confirm('确定删除选中的' + data.length + '个农民？', {icon: 3, title: '提示信息'}, function (index) {
                    $.post("admin/batchesDelPeasant", {
                        deleteId : deleteId
                    }, function (s) {
                        tableIns.reload();
                        layer.close(index);
                        layer.msg(s.msg);
                    });
                });
            }else{
                layer.msg("请选择需要删除的农民");
            }
        });*/

        //监听工具条
/*        table.on('tool(peasantList)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if(layEvent === 'edit'){ //编辑
                updatePeasant(data);
            }else if(layEvent === 'del'){ //编辑
                layer.confirm('确定删除此农民？',{icon:3, title:'提示信息'},function(index){
                    $.get("admin/deletePeasant", {
                        id: data.peasantId  //将需要删除的newsId作为参数传入
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
            }else if(layEvent === 'reset'){
                layer.confirm('确定重置此账号密码？',{icon:3, title:'提示信息'},function(index){
                    $.get("admin/resetPeasantPwd", {
                        id: data.peasantId  //将需要重置的Id作为参数传入
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
        });*/

    });
</script>
</html>
