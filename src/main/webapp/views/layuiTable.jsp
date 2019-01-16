<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/2
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>LayuiTable案例测试</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="assets/layui/css/layui.css" media="all">
</head>
<body>

<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table id="demo" lay-filter="test"></table>

<script src="assets/layui/layui.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    </div>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,id: 'TableTest'
            ,height: 500
            ,width: 1350
            ,toolbar:'#toolbarDemo'   //开启表格头部工具栏区域
            ,url: 'LayUiTable/listUserByPage' //数据接口
            ,page: true //开启分页
            ,limit: 5
            ,limits: [5,10,15]
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'userid', title: 'ID', width:80, sort: true}
                ,{field: 'username', title: '用户名', width:80, event:'username'}
                ,{field: 'password', title: '密码', width:80}
                ,{fixed: 'right', width: 178, align:'center', toolbar: '#barDemo'}
            ]]
        });
        //监听工具条
        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'detail'){ //查看
                var checkStatus = table.checkStatus('TableTest');
                console.LogDO(checkStatus.data); //获取选中行的数据
                var data = checkStatus.data;
                console.LogDO(data[0]);   //获取行数据里面具体值
                console.LogDO(checkStatus.data.length); //获取选中行数量，可作为是否有选中行的条件
                console.LogDO(checkStatus.isAll ); //表格是否全选
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something

                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            } else if(layEvent === 'username'){
                layer.prompt({
                    formType:2
                    ,title:'修改ID为['+ data.userid + ']的用户名'
                    ,value:data.username
                });
            }
        });

        //监听事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    layer.msg('添加');
                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            };
        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('TableTest', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        userid: demoReload.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>
