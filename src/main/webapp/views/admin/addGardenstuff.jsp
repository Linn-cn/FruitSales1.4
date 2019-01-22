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
    <title>添加果蔬</title>
    <%@include file="../../assets/styleAndscriptForm.jsp" %>
</head>
<body class="x-body">
<form class="layui-form" style="width:90%;">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">农民名</label>
        <div class="layui-input-inline">
            <select name="gardenstuff_peasantid" xm-select-search
                    xm-select-radio="" xm-select="gardenstuff_peasantid" xm-select-skin="default">
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
            <input type="text" name="peasantName" class="layui-input" lay-verify="required" placeholder="请输入果蔬名字">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">果蔬类别</label>
        <div class="layui-input-inline">
            <select name="gardenstuffCategory" xm-select="gardenstuffCategory" xm-select-show-count="1" xm-select-skin="default">
                <option value="">请选择果蔬类别</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-inline">
            <input type="text" name="peasantPhone" class="layui-input" lay-verify="required|phone" placeholder="请输入价格">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">库存</label>
        <div class="layui-input-inline">
            <input type="text" name="peasantPhone" class="layui-input" lay-verify="required|phone" placeholder="请输入库存">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs6">
        <label class="layui-form-label">产地</label>
        <div class="layui-input-block">
            <textarea name="peasantAddress" placeholder="请输入果蔬产地" lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <input id="submit" type="button" class="layui-btn" lay-submit lay-filter="addPeasant" value="提交">
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

        //动态加载农民
        formSelects.config('gardenstuff_peasantid',{
            keyName: 'peasantName',
            keyVal: 'peasantId'
        });
        formSelects.data('gardenstuff_peasantid', 'server', {
            url: 'admin/getPeasantList',
            beforeSuccess: function(id, url, searchVal, result){
                //把数据外层的code, msg, data去掉
                result = result.data;
                //去掉多余属性
                $.each(result, function(index, item) {
/*                    delete item['peasantIdentity'];
                    delete item['peasantPhone'];
                    delete item['peasantAddress'];
                    delete item['peasantStatus'];
                    delete item['peasantTime'];*/
                });
                console.log(result);
                //然后返回数据
                return result;
            },
        });
        //动态加载果蔬类别
        formSelects.config('gardenstuffCategory',{
            keyName: 'categoryName',
            keyVal: 'categoryId'
        });
        formSelects.data('gardenstuffCategory', 'server', {
            url: 'admin/getCategoryList'
        });
        //配置只显示名称,紧凑型, 适合宽度较窄的情况
        formSelects.btns('gardenstuffCategory', ['select']);

    });
</script>
</html>