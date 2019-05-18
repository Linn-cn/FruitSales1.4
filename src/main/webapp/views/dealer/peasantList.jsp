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
    <title>农民列表</title>
    <%@include file="../../assets/styleAndscriptForm.jsp"%>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
            top: 50%;
            transform: translateY(-50%);
        }
        .layui-table-tips-main{display:none}
        .layui-table-tips-c{display:none}
    </style>
</head>
<body class="x-body">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <input type="text" name="peasantName" class="layui-input searchVal" placeholder="请输入用户名" />
                </div>
                <div class="layui-input-inline">
                    <input type="text" name="peasantPhone" class="layui-input searchVal" placeholder="请输入电话号码" />
                </div>
                <div class="layui-input-inline">
                    <select name="peasantIdentity" xm-select="peasantIdentity"
                            xm-select-show-count="1" xm-select-skin="normal">
                        <option value="">请选择农民身份</option>
                        <option value="果农">果农</option>
                        <option value="菜农">菜农</option>
                    </select>
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
            <div class="layui-inline" style="float: right">
                <a class="layui-btn" href="javascript:location.reload();" title="刷新">
                    <i class="layui-icon">&#xe669;</i>
                </a>
            </div>
        </form>
    </blockquote>
    <table id="peasantList" lay-filter="peasantList"></table>

</body>
<!--操作-->
<script type="text/html" id="peasantListBar">
    <a class="layui-btn layui-btn-xs" lay-event="select">查看</a>
</script>
<script>
    layui.use(['form','layer','table'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

        var formSelects = layui.formSelects;
        //配置只显示名称,紧凑型, 适合宽度较窄的情况
        formSelects.btns('peasantIdentity', ['select']);

        //果农列表
        var tableIns = table.render({
            elem: '#peasantList',
            id : "peasantListTable",
            url : 'dealer/getPeasantList',
            where: {peasantStatus : 1},
            title: '农民列表',
            page : true,
            height : "full-110",
            toolbar: true,
            limits: [10],
            cols : [[
                {field: 'peasantName', title: '农民名字', align:"center",unresize:"true"},
                {field: 'peasantPhone', title: '电话号码', align:'center',unresize:"true"},
                {field: 'peasantIdentity', title: '农民身份', align:'center',unresize:"true"},
                {field: 'peasantStatus', title: '账号状态', align:'center',unresize:"true",templet:function (d) {
                        return d.peasantStatus == "1" ? "正常使用" : "限制使用";
                    }},
                {field: 'peasantAddress', title: '居住地址', align:'center',unresize:"true"},
                {field: 'peasantTime', title: '注册时间', align:'center',sort:true,unresize:"true"},
                {title: '操作',align:"center",unresize:"true",toolbar:"#peasantListBar"}
            ]]
        });

        //搜索
        form.on('submit(search_btn)', function(data){
            var datas = data.field;
            if (datas.peasantIdentity != null) {
                if (datas.peasantIdentity == "菜农,果农"){
                    datas.peasantIdentity = "果农,菜农";
                }
            }
            console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
            tableIns.reload({
                where: data.field
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });


        //监听工具条
        table.on('tool(peasantList)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if(layEvent === 'select'){ //编辑
                selectPeasant(data);
            }
        });

        //打开设置农民弹窗
        function selectPeasant(edit){

            var url = "views/dealer/selectPeasant.jsp";
            window.sessionStorage.setItem("peasant",JSON.stringify(edit));
            var index = layui.layer.open({
                title : "农民详情",
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
                    window.sessionStorage.removeItem("peasant");
                }
            });
        }

    });
</script>
</html>
