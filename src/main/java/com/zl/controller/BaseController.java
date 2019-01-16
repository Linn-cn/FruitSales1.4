package com.zl.controller;

import com.zl.pojo.UserDTO;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Fruits
 * @description: 存取用户对象的Controller
 * @author: ZhuLlin
 * @create: 2019-01-07 15:17
 **/
public class BaseController {

    /**
     * 获取保存在Session中的用户对象
     *
     * @return
     */
    public static UserDTO getSessionUser() {
        UserDTO user = SecurityUtils.getSubject().getPrincipals().oneByType(UserDTO.class);
        return user;
    }

    /**
     * 保存用户对象到Session中
     * @param request
     * @param user
     */
/*    protected void setSessionUser(HttpServletRequest request, UserDTO user) {
        request.getSession().setAttribute(Constants.USER_CONTEXT,user);
    }*/

}
