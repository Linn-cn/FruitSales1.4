<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--shiro标签--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>鲜美果蔬批发管理系统</title>
    <base href="<%=basePath%>">
    <%@include file="../../assets/styleAndscript.jsp"%>
    <link rel="stylesheet" href="assets/css/navigation.css">
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="javascript:;">鲜美果蔬批发管理系统</a>
    </div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <!-- 天气信息 -->
    <div class="weather">
        <div id="tp-weather-widget"></div>
        <script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};T["ThinkPageWeatherWidgetObject"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent("onload",g)}else{T.addEventListener("load",g,false)}}(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))</script>
        <script>tpwidget("init", {
            "flavor": "slim",
            "location": "WT029G15ETRJ",
            "geolocation": "disabled",
            "language": "zh-chs",
            "unit": "c",
            "theme": "chameleon",
            "container": "tp-weather-widget",
            "bubble": "enabled",
            "alarmType": "badge",
            "color": "#FFFFFF",
            "uid": "U8525290FC",
            "hash": "8baeb79cadf07402c6fa6c5c81ece5be"
        });
        tpwidget("show");</script>
    </div>
    <!-- 顶部右侧菜单 -->
    <ul class="layui-nav right right1" lay-filter="">
        <li class="layui-nav-item"><a href="javascript:;"><shiro:principal/></a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="x_admin_show('个人信息','adminUserInfo.jsp',500,300)"><i class="fa fa-address-card-o"
                                                                              aria-hidden="true"></i>个人信息</a>
                </dd>
                <dd>
                    <a class="changeSkin" href="javascript:void(0);"><i class="layui-icon">&#xe66a;</i>更换皮肤<span
                            class="layui-badge-dot"></span></a>
                </dd>
                <dd>
                    <a href="logout"><i class="fa fa-refresh" aria-hidden="true"></i>切换帐号</a>
                </dd>
                <dd>
                    <a href="logout"><i class="fa fa-power-off" aria-hidden="true"></i>退出</a>
                </dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right right2">
        <li class="layui-nav-item">
            <a href="javascript:;" class="clearCache">
                <i class="layui-icon" data-icon="&#xe640;">&#xe640;&nbsp;</i><cite>清除缓存</cite><span
                    class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item showNotice" id="showNotice">
            <a href="javascript:;" class="showNotice"><i class="layui-icon">&#xe645;&nbsp;</i>系统公告<span
                class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item lockcms">
            <a href="javascript:;"><i class="layui-icon">&#xe673;&nbsp;</i><cite>锁屏</cite></a>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li><a href="javascript:;"><i class="layui-icon">&#xe770;</i>
                <cite>用户管理</cite> <i class="iconfont nav_right">&#xe697;</i>
            </a>
                <ul class="sub-menu">
                    <li><a _href="admin/gotoPeasantList"> <i
                            class="iconfont">&#xe6a7;</i> <cite>农民列表</cite>
                    </a></li>
                </ul></li>
            <li><a href="javascript:;"> <i class="layui-icon">&#xe657;</i>
                <cite>果蔬管理</cite> <i class="iconfont nav_right">&#xe697;</i>
            </a>
                <ul class="sub-menu">
                    <li><a _href="admin/gotoCommoditiesList"> <i
                            class="iconfont">&#xe6a7;</i> <cite>果蔬列表</cite>
                    </a></li>
                </ul></li>
            <li><a href="javascript:;"> <i class="layui-icon">&#xe6b2;</i>
                <cite>合同管理</cite> <i class="iconfont nav_right">&#xe697;</i>
            </a>
                <ul class="sub-menu">
                    <li><a _href="admin/gotoContractList"> <i
                            class="iconfont">&#xe6a7;</i> <cite>合同列表</cite>
                    </a></li>
                </ul></li>
            <li><a href="javascript:;"><i class="layui-icon">&#xe66f;</i>
                <cite>用户管理</cite> <i class="iconfont nav_right">&#xe697;</i>
            </a>
                <ul class="sub-menu">
                    <li><a _href="admin/gotoAdminUpdate"> <i
                            class="iconfont">&#xe6a7;</i> <cite>信息修改</cite>
                    </a></li>
                    <li><a _href="user/gotoUpdateUserPwd"> <i
                            class="iconfont">&#xe6a7;</i> <cite>密码修改</cite>
                    </a></li>
                </ul></li>
            <li><a href="javascript:;"><i class="layui-icon">&#xe631;</i>
                <cite>系统管理</cite> <i class="iconfont nav_right">&#xe697;</i>
            </a>
                <ul class="sub-menu">
                    <li><a _href="sys/gotoUpdateSysInfo">
                        <i class="iconfont">&#xe6a7;</i>
                        <cite>系统基本参数</cite>
                    </a></li>
                    <li><a _href="sys/gotoSysLogInfo">
                        <i class="iconfont">&#xe6a7;</i>
                        <cite>系统日志</cite>
                    </a></li>
                </ul></li>
        </ul>
    </div>
</div>
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的主页</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='sys/welcome' frameborder="0"
                        scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">
        Copyright &copy;2018 <strong>鲜美果蔬批发管理平台</strong>
    </div>
</div>
<!-- 底部结束 -->
</body>

<!-- 更换皮肤窗口 -->
<div class="skins_box" id="ChangeSkin">
    <form class="layui-form">
        <div class="layui-form-item">
            <input type="radio" name="skin" value="默认" title="默认" lay-filter="default" checked="">
            <input type="radio" name="skin" value="浅绿色" title="浅绿色" lay-filter="reseda">
            <input type="radio" name="skin" value="实木色" title="实木色" lay-filter="burlywood">
        </div>
        <div class="layui-form-item layui-text weadmin-text">
            <p>更多主题敬请期待。</p>
        </div>
        <div class="layui-form-item skinBtn">
            <a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="changeSkin">确定更换</a>
            <a href="javascript:;" class="layui-btn layui-btn-sm layui-btn-primary" lay-submit="" lay-filter="noChangeSkin">朕再想想</a>
        </div>
    </form>
</div>
<script>
    layui.use(['form','jquery',"layer"],function() {
        var form = layui.form,
            $ = layui.jquery,
            layer = layui.layer;

        //清除缓存
        $(".clearCache").click(function(){
            window.sessionStorage.clear();
            window.localStorage.clear();
            var index = layer.msg('清除缓存中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
                layer.close(index);
                layer.msg("缓存清除成功！");
            },1000);
        });

        //判断是否浏览器第一次打开
        if (window.sessionStorage.getItem("systemPrompt") != "true") {
            layer.alert("本项目建议以Firefox或Google Chrome浏览器打开,其他浏览器可能出现部分不兼容现象,十分抱歉");
            window.sessionStorage.setItem("systemPrompt","true");
        }

        //公告层
        function showNotice(){
            layer.open({
                type: 1,
                title: "系统公告",
                area: '300px',
                shade: 0.8,
                id: 'LAY_layuipro',
                btn: ['已知晓'],
                moveType: 1,
                content: '<div style="padding:15px 20px; text-align:justify; line-height: 22px; text-indent:2em;border-bottom:1px solid #e2e2e2;"><p>欢迎使用鲜美果蔬批发管理系统，此产品主要服务于农民和果蔬零售商。</p><p>基本介绍:本产品属于一款网络销售平台，通过与零售商在线上建立合作关系，以电子订单来代替传统纸质订单，对水果商品的销售价格，运费及包装费进行 自动计算和总结，从而解决果农产品滞销的问题。</p><p class="x-red">如有疑问请及时联系系统管理员QQ:1320291471</p></div>',
                success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.css('text-align', 'center');
                    btn.on("click",function(){
                        tipsShow();
                    });
                },
                cancel: function(index, layero){
                    tipsShow();
                }
            });
        }
        function tipsShow(){
            if($(window).width() > 432){  //如果页面宽度不足以显示顶部“系统公告”按钮，则不提示
                layer.tips('系统公告躲在了这里', '#showNotice', {
                    tips: 3,
                    time : 1000
                });
            }
        }
        $(".showNotice").on("click",function(){
            showNotice();
        });

        //锁屏
        function lockPage(){
            layer.open({
                title : false,
                type : 1,
                content : '<div class="admin-header-lock" id="lock-box">'+
                '<div class="admin-header-lock-name" id="lockUserName">当前用户:<shiro:principal/></div>'+
                '<div class="input_btn">'+
                '<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />'+
                '<button class="layui-btn" id="unlock">解锁</button>'+
                '</div>'+
                '<p>请输入用户密码进行解锁</p>'+
                '</div>',
                closeBtn : 0,
                shade : 0.9,
            });
            $(".admin-header-lock-input").focus();
        }
        $(".lockcms").on("click",function(){
            window.sessionStorage.setItem("lockcms",true);
            lockPage();
        });

        // 防止刷新不显示锁屏,判断是否显示锁屏
        if(window.sessionStorage.getItem("lockcms") == "true"){
            lockPage();
        }
        // 解锁
        $("body").on("click","#unlock",function(){
            if($(this).siblings(".admin-header-lock-input").val() == ''){
                layer.msg("请输入解锁密码！");
                $(this).siblings(".admin-header-lock-input").focus();
            }else{
                var oldPwd = $(this).siblings(".admin-header-lock-input").val();
                $.ajax({
                    url : "user/validatePassword",
                    type : "post",
                    data : {"oldPwd":oldPwd},
                    success : function(s) {
                        if (s.success) {
                            layer.msg("密码错误，请重新输入！");
                            $(this).siblings(".admin-header-lock-input").val('').focus();
                        }else{
                            window.sessionStorage.setItem("lockcms",false);
                            $(this).siblings(".admin-header-lock-input").val('');
                            layer.closeAll("page");
                        }
                    }
                });
            }
        });
        $(document).on('keydown', function(event) {
            var event = event || window.event;
            if(event.keyCode == 13) {
                $("#unlock").click();
            }
        });

        //更换皮肤
        skins();

        function deleteClass(){
            $(".container").removeClass("reseda burlywood");
            $(".left-nav").removeClass("reseda burlywood");
        }
        function skins(){
            var skin = window.sessionStorage.getItem("skin");
            if(skin != undefined){  //如果更换过皮肤
                deleteClass();
                $(".container").addClass(skin);
                $(".left-nav").addClass(skin);
            }else{
                deleteClass();
            }
        }

        $(".changeSkin").click(function(){
            layer.open({
                title : "更换皮肤",
                type : "1",
                content : $('#ChangeSkin'),
                success: function(index, layero){
                    if(window.sessionStorage.getItem("skinValue")){
                        console.log('默认选中');
                        $(".skins_box input[value="+window.sessionStorage.getItem("skinValue")+"]").attr("checked","checked");
                    };
                    form.render();
                    var skinColor;
                    form.on("submit(changeSkin)",function(data){
                        if (data.field.skin == "浅绿色") {
                            skinColor = "reseda";
                            window.sessionStorage.setItem("skin", skinColor);
                            window.sessionStorage.setItem("skinValue", data.field.skin);
                        } else if (data.field.skin == "实木色") {
                            skinColor = "burlywood";
                            window.sessionStorage.setItem("skin", skinColor);
                            window.sessionStorage.setItem("skinValue", data.field.skin);
                        } else if (data.field.skin == "默认") {
                            window.sessionStorage.removeItem("skin");
                            window.sessionStorage.removeItem("skinValue");
                        }
                        skins();
                        layer.closeAll("page");
                    });

                    form.on("submit(noChangeSkin)",function(){
                        layer.closeAll("page");
                    });
                }
            });
        });

    });
</script>
</html>