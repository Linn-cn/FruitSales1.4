# FruitSales1.4
鲜美果蔬1.4版本
# 简介：
这个项目是一个毕业设计作品，基于我初期几次修改后逐渐完善的批发管理系统，用来巩固SSM和部分工具的整合开发

# 使用技术
IOC容器：Spring

Web框架：SpringMVC

ORM框架：Mybatis

安全框架：Shiro

数据源：druid

日志：slf4j

前端框架：layui

1.全面采用经典模块化前端框架,优化用户交互体验
2.程序优化,提升系统流畅性

编译器:IDEA

使用Maven构建
# 快速上手
### 1、运行环境和所需工具
* 编译器：IDEA
* 数据库：Mysql5.7
* JDK版本：jdk1.8
* Tomcat版本：Tomcat8.5
### 2、初始化项目
* 在你的Mysql中，创建一个数据库名称为 fruitsales 的数据库，并导入我提供的 .sql 文件；
* 进入src/main/resources修改jdbc.properties配置文件,把数据库登录名和密码，改为你本地的；
* 下载之后使用 IDEA 导入项目,选择Maven项目选项,一路点击next就行,或者复制Github的url去IDEA上面clone；
* 配置我们的IDEA设置,如Tomcat、打包war等；
* 运行；
