<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>果蔬类别</title>
    <%@include file="../../assets/styleAndscriptForm.jsp" %>
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"] {
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body class="x-body">
<table id="Category" lay-filter="Category"></table>
</body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addCategory">
            <i class="layui-icon">&#xe654;&nbsp;</i>添加果蔬类别
        </button>
        <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteCategory">
            <i class="layui-icon">&#xe640;&nbsp;</i>删除所选类别
        </button>
        <button class="layui-btn layui-btn-sm" lay-event="refresh">
            <i class="layui-icon">&#xe9aa;&nbsp;</i>刷新数据
        </button>
    </div>
</script>

<script>
    layui.use(['layer', 'table'], function () {
        var layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery,
            table = layui.table;

        //果蔬类别
        var tableIns = table.render({
            elem: '#Category',
            id: "Category",
            url: 'admin/getCategoryList',
            title: '果蔬类别表',
            page: true,
            height: "full-20",
            toolbar: '#toolbarDemo',
            defaultToolbar: [], //不显示右侧工具栏
            cols: [[
                {type: "checkbox", fixed: "left"},
                {field: 'categoryId', title: '类别编号', align: "center", unresize: "true"},
                {field: 'categoryName', title: '类别名', align: "center", unresize: "true", edit: "text"}
            ]]
        });

        table.on('edit(Category)', function (obj) {
            console.log(obj.data); //所在行的所有相关数据
            // 提交信息
            $.post("admin/updateCategory", obj.data, function (s) {
                if (!s.success) {
                    layer.msg(s.msg);
                }
            });
        });

        table.on('toolbar(Category)', function (obj) {
            switch(obj.event){
                case 'addCategory':
                    //默认prompt
                    layer.prompt({title: '添加果蔬类别', formType: 0, maxlength: 50}, function (value, index) {
                        $.post("admin/addCategory", {"categoryName": value}, function (s) {
                            layer.msg(s.msg);
                            tableIns.reload();
                        });
                        layer.close(index);
                    });
                    break;
                case 'deleteCategory':
                    //批量删除
                    var checkStatus = table.checkStatus('Category'),
                        data = checkStatus.data,
                        deleteId = [];
                    if (data.length > 0) {
                        for (var i in data) {
                            deleteId.push(data[i].categoryId);
                        }
                        layer.confirm('确定删除选中的' + data.length + '个类别？', {icon: 3, title: '提示信息'}, function (index) {
                            $.post("admin/batchesDelCategory", {
                                deleteId: deleteId
                            }, function (s) {
                                tableIns.reload();
                                layer.close(index);
                                layer.msg(s.msg);
                            });
                        });
                    } else {
                        layer.msg("请选择需要删除的类别");
                    }
                    break;
                case 'refresh':
                    tableIns.reload();
                    break;
            };
        });

    });
</script>
</html>
