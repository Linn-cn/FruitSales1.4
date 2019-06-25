package com.zl.controller;

import com.zl.aop.SystemControllerLog;
import com.zl.pojo.DealerDO;
import com.zl.pojo.PeasantDO;
import com.zl.pojo.UserDO;
import com.zl.pojo.UserDTO;
import com.zl.service.UserService;
import com.zl.util.BeanCopyPropertiesUtil;
import com.zl.util.Constants;
import com.zl.util.MessageBean;
import com.zl.util.MessageException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


/**
 * @program: FruitSales
 * @description: 用户控制类
 * @author: ZhuLlin
 * @create: 2019-01-07 18:39
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserService userService;

    /**
     * @Description: 用户登录验证
     * @Param: [username, password]
     * @return: com.zl.util.MessageBean
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/login")
    @ResponseBody
    public MessageBean userlogin(String username, String password) {
        // Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        boolean flag = false;
        String msg = Constants.ERROR_MSG;
        // 如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        // 如果认证成功，会没有返回，也没有异常，通过。
        // 如果认证失败，会拋出异常
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            System.out.println("用户名不存在。");
            msg = Constants.EMPTY_USER;
            return new MessageBean(flag, msg);
        } catch (IncorrectCredentialsException ice) {
            //Redis做验证次数的缓存
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.increment(username,1);
            redisTemplate.expire(username,1, TimeUnit.HOURS);
            String error_password = valueOperations.get(username);

            System.out.println("密码错误。");
            msg = Constants.ERROR_PASSWORD_BEFORE + error_password + Constants.ERROR_PASSWORD_AFTER;
            return new MessageBean(flag, msg);
        } catch (ExcessiveAttemptsException e){
            System.out.println("输入密码错误五次，锁定账号一小时。");
            msg = Constants.ERROR_COUNT;
            return new MessageBean(flag, msg);
        } catch (LockedAccountException lae) {
            System.out.println("当前账号已锁定。");
            msg = Constants.LOCK_USER;
            return new MessageBean(flag, msg);
        } catch (RuntimeException e) {
            return new MessageBean(flag, msg);
        }

        if (subject.hasRole("admin")) {
            System.out.println("超级管理员登录");
            flag = true;
            msg = "user/admin/navigation";
        }
        if (subject.hasRole("peasant")) {
            System.out.println("农民登录");
            flag = true;
            msg = "user/peasant/navigation";
        }
        if (subject.hasRole("dealer")) {
            System.out.println("零售商登录");
            flag = true;
            msg = "user/dealer/navigation";
        }
        return new MessageBean(flag, msg);
    }

    /**
     * @Description: 显示导航栏
     * @Param: [rolename]
     * @return: java.lang.String
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/{rolename}/navigation")
    public String navigation(@PathVariable String rolename) {
        System.out.println("导航栏验证测试:" + rolename);
        if ("peasant".equals(rolename)) {
            return "peasant/navigation";
        }
        if ("dealer".equals(rolename)) {
            return "dealer/navigation";
        }
        //否则默认以管理员登录
        return "admin/navigation";
    }


    /**
     * @Description: 忘记密码[资料核实], 核实成功则修改成功
     * @Param: [userDTO]
     * @return: com.zl.util.MessageBean
     * @Author: ZhuLin
     * @Date: 2019/1/8
     */
    @RequestMapping("/verify")
    @ResponseBody
    public MessageBean verify(UserDTO userDTO) throws Exception {
        System.out.println(userDTO.toString());
        UserDO user = userService.validateUserName(userDTO.getUsername());
        if (user == null) {
            return new MessageBean(false, Constants.EMPTY_USER);
        }
        UserDTO userinfo = new UserDTO();
        BeanUtils.copyProperties(user, userinfo);
        userinfo = copyUserInfo(user,userinfo);
        System.out.println("用户存在于数据库数据:" + userinfo.toString());
        boolean flag = userinfo.getName().equals(userDTO.getName())
                && userinfo.getPhone().equals(userDTO.getPhone());

        if (flag) {
                userService.updateUserPassword(userinfo.getUserid(), userinfo.getUsername(), userDTO.getPassword());
                return new MessageBean(true, Constants.SUCCESS_RESET_PASSWORD);
        } else {
            return new MessageBean(false, Constants.ERROR_USERINFO);
        }
    }

    /** 
    * @Description: 跳转更改用户信息界面
    * @Param: [model]
    * @return: java.lang.String 
    * @Author: ZhuLin
    * @Date: 2019/1/11 
    */ 
    @RequestMapping("/gotoUpdateUserPwd")
    public String gotoUpdateUserPwd(){
        return "redirect:/views/public/updateUserPwd.jsp";
    }

    /** 
    * @Description: 密码验证
    * @Param: [oldPwd] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/11 
    */ 
    @RequestMapping("/validatePassword")
    @ResponseBody
    public MessageBean validatePassword(String oldPwd){
        UserDTO userinfo = BaseController.getSessionUser();
        Md5Hash md5Hash = new Md5Hash(oldPwd,userinfo.getUsername(),Constants.HASHITERATIONS);
        oldPwd = md5Hash.toString();
        System.out.println("用户输入密码:" + oldPwd);
        System.out.println("数据库密码:" + userinfo.getPassword());
        if (oldPwd.equals(userinfo.getPassword())){
            return new MessageBean(false);
        }
        return new MessageBean(true,Constants.ERROR_PASSWORD_BEFORE);
    }

    /*** 
    * @Description: 验证用户名是否可用
    * @Param: [userName] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/21 
    */ 
    @RequestMapping("/validateUserName")
    @ResponseBody
    public MessageBean validateUserName(String userName){
        UserDO user = userService.validateUserName(userName);

        // 没有该用户名
        if (user == null) {
            return new MessageBean(false);
        }
        return new MessageBean(true);
    }

    /** 
    * @Description: 修改用户密码
    * @Param: [newPwd] 
    * @return: com.zl.util.MessageBean 
    * @Author: ZhuLin
    * @Date: 2019/1/12 
    */
    @SystemControllerLog(description = "修改用户密码")
    @RequestMapping("/updateUserPwd")
    @ResponseBody
    public MessageBean updateUserPwd(String newPwd) throws Exception{
        UserDTO userinfo = BaseController.getSessionUser();
        userService.updateUserPassword(userinfo.getUserid(), userinfo.getUsername(), newPwd);
        return new MessageBean(true, Constants.SUCCESS_UPDATE_PASSWORD);
    }

    /** 
    * @Description: 获取当前登录用户信息
    * @Param: [] 
    * @return: com.zl.pojo.UserDTO 
    * @Author: ZhuLin
    * @Date: 2019/1/14 
    */ 
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserDTO getUserInfo(){
        UserDTO userInfo = BaseController.getSessionUser();
        UserDO user = userService.validateUserName(userInfo.getUsername());
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        userDTO = copyUserInfo(user,userDTO);
        return userDTO;
    }

    /**
     * @Description: 根据农民还是零售商来返回对应的完整userinfo
     * @Param: [user, userDTO]用于判断的user和拷贝到的user
     * @return: com.zl.pojo.UserDTO
     * @date: 2019/2/13 21:28 
     */
    public UserDTO copyUserInfo(UserDO user,UserDTO userDTO){
        switch (user.getRole()){
            case 1:
                PeasantDO peasant = userService.getPeasantInfo(user.getUserid());
                BeanCopyPropertiesUtil.peasantCopyProperties(peasant, userDTO);
                break;
            case 2:
                DealerDO dealer = userService.getDealerInfo(user.getUserid());
                BeanCopyPropertiesUtil.dealerCopyProperties(dealer, userDTO);
                break;
            default:break;
        }
        return userDTO;
    }

}
