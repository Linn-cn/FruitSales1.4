<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--shiro标签--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>鲜美果蔬批发管理系统</title>
    <link rel="stylesheet" href="assets/css/xadmin.css">
    <link rel="stylesheet" href="assets/layui/css/layui.css">
    <script src="assets/layui/layui.js"></script>
    <style>
        .weadmin-text p {
            margin-bottom: 10px;
            text-indent: 2em;
        }
    </style>
</head>
<body>
<div class="x-body">
    <blockquote class="layui-elem-quote">
        欢迎<span class="x-red"> <shiro:principal />！
			</span>当前时间:<span id="time"></span>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据统计</legend>
        <div class="layui-field-box">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                            <div carousel-item="">
                                <ul class="layui-row layui-col-space10 layui-this">
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>已入驻零售商</h3>
                                            <p>
                                                <cite>1</cite></p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>已入驻农民</h3>
                                            <p>
                                                <cite>12</cite></p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>果蔬数量</h3>
                                            <p>
                                                <cite>12</cite></p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>成功签约</h3>
                                            <p>
                                                <cite>1</cite></p>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统通知</legend>
        <div class="layui-field-box">
            <div class="layui-card">
                <div class="layui-card-header">
                    新版本发布:1.4.1全新来袭
                    <i class="layui-icon" style="color: #FF5722;">&#xe756;</i>
                    <span class="layui-badge-rim">
                        <fmt:formatDate value="${SysInfo.sysUpdatetime}"
                                        pattern='yyyy-MM-dd'/></span>
                </div>
                <div class="layui-card-body layui-text weadmin-text">
                    <p>1.全面采用经典模块化前端框架,优化用户交互体验</p>
                    <p>2.程序优化,提升系统流畅性</p>
                    <p>3.更多的疑难解答，建议联系系统管理员QQ:<a href="javascript:;">1320291471</a>或者联系电话<a href="javascript:;">17673169755</a></p>
                </div>
            </div>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>系统信息</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>系统版本</th>
                    <td>${SysInfo.sysVersion}</td>
                </tr>
                <tr>
                    <th>服务器地址</th>
                    <td>${SysInfo.sysUrl}</td>
                </tr>
                <tr>
                    <th>操作系统</th>
                    <td>${SysInfo.sysOperation}</td>
                </tr>
                <tr>
                    <th>运行环境</th>
                    <td>${SysInfo.sysRuntime}</td>
                </tr>
                <tr>
                    <th>JDK版本</th>
                    <td>${SysInfo.sysJdk}</td>
                </tr>
                <tr>
                    <th>MYSQL版本</th>
                    <td>${SysInfo.sysMysql}</td>
                </tr>
                <tr>
                    <th>项目大小</th>
                    <td>${SysInfo.sysItemsize}</td>
                </tr>
                <tr>
                    <th>更新时间</th>
                    <td><fmt:formatDate value="${SysInfo.sysUpdatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>${SysInfo.sysCopyright} <a href="http://www.xxx.com/" class='x-a' target="_blank">访问官网</a></td>
                </tr>
                <tr>
                    <th>开发者</th>
                    <td>${SysInfo.sysAuthor}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
    <blockquote class="layui-elem-quote layui-quote-nm">本系统为毕业设计作品，前端界面为layui提供，不足之处请谅解。</blockquote>
</div>
<script type="text/javascript">
    setInterval("document.getElementById('time').innerHTML = new Date().toLocaleString();", 0);
</script>
</body>
</html>
