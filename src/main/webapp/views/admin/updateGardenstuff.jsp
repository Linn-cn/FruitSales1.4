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
    <title>修改果蔬</title>
    <%@include file="../../assets/styleAndscriptForm.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;" lay-filter="updateGardenStuffForm">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">农民名</label>
        <div class="layui-input-inline">
            <select name="gardenstuffPeasantid" xm-select-search
                    xm-select-radio="" xm-select="gardenstuffPeasantid" xm-select-skin="normal">
                <option value="">请选择农民</option>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>已登记入库的果农
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">果蔬名</label>
        <div class="layui-input-inline">
            <input type="text" name="gardenstuffName" class="layui-input" lay-verify="required" placeholder="请输入果蔬名字">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">果蔬类别</label>
        <div class="layui-input-inline">
            <select name="gardenstuffCategory" xm-select-max="3"
                    xm-select="gardenstuffCategory" xm-select-show-count="1" xm-select-skin="normal">
                <option value="">请选择果蔬类别</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-inline">
            <input type="text" name="gardenstuffPrice" class="layui-input" lay-verify="required" placeholder="请输入价格">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>按公斤算
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">库存</label>
        <div class="layui-input-inline">
            <input type="text" name="gardenstuffNumber" class="layui-input" lay-verify="required" placeholder="请输入库存">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">产地</label>
        <div class="layui-input-block">
            <textarea name="gardenstuffAddress" placeholder="请输入果蔬产地" lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="updateGardenStuff" value="提交">
            </input>
        </div>
    </div>
</form>
</body>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        var formSelects = layui.formSelects;

        //用于获取修改数据
        var edit = JSON.parse(window.sessionStorage.getItem("gardenStuff"));

        //动态加载农民
        formSelects.config('gardenstuffPeasantid',{
            data:{"peasantStatus" : 1}, //禁用状态的农民不显示
            keyName: 'peasantName',
            keyVal: 'peasantId'
        });
        formSelects.data('gardenstuffPeasantid', 'server', {
            url: 'admin/getPeasantList',
            success: function(id, url, searchVal, result){
                formSelects.value('gardenstuffPeasantid',edit.gardenstuffPeasantid.split(","),true);
            }
        });
        //动态加载果蔬类别
        formSelects.config('gardenstuffCategory',{
            keyName: 'categoryName',
            keyVal: 'categoryId'
        });
        formSelects.data('gardenstuffCategory', 'server', {
            url: 'admin/getCategoryList',
            success: function(id, url, searchVal, result){
                formSelects.value('gardenstuffCategory',edit.gardenstuffCategory.split(","),true);
            }
        });
        //配置只显示名称,紧凑型, 适合宽度较窄的情况
        formSelects.btns('gardenstuffCategory', ['select']);

        if(edit != null && edit != ""){
            form.val('updateGardenStuffForm', {
                "gardenstuffName": edit.gardenstuffName,
                "gardenstuffPrice" : edit.gardenstuffPrice,
                "gardenstuffNumber" : edit.gardenstuffNumber,
                "gardenstuffAddress" : edit.gardenstuffAddress
            });
        }


        form.on("submit(updateGardenStuff)",function(data){
            var datas = data.field;
            datas.gardenstuffId = edit.gardenstuffId;
            datas.gardenstuffCategoryname = formSelects.value('gardenstuffCategory', 'nameStr');
            var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            console.log(datas);
            // 提交信息
            $.post("admin/updateGardenStuff",datas,function(s){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.alert(s.msg);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },1500);
            });
            return false;
        });
    });
</script>
</html>