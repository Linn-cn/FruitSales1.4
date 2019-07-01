package com.zl.realm;

import com.zl.pojo.*;
import com.zl.service.UserService;
import com.zl.util.BeanCopyPropertiesUtil;
import com.zl.util.Constants;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @Title: LoginRealm
 * @Description: 登录验证类
 * @author: zhuLin
 * @date: 2018年10月15日 上午11:32:05
 */
@Component
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    RedisTemplate<String,Integer> redisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息 当调用权限验证时，就会调用此方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        System.out.println("权限验证username:" + username);
        UserDO user = userService.validateUserName(username);
        // 获取角色权限对象
        RoleDO role = userService.getRoleById(user.getRole());
        // 通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (role != null) {
            r.add(role.getRolename());
            info.setRoles(r);
        }
        return info;
    }

    /**
     * 在这个方法中，进行身份验证 login时调用 认证的基本步骤 1. 收集Subjects
     * 提交的Principals(身份)和Credentials(凭证)；
     *
     * 2. 提交Principals(身份)和Credentials(凭证)进行身份验证；
     *
     * 3. 如果提交成功，则允许访问，否则重新进行身份验证或者阻止访问。
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 用户名Principals(身份)
        String username = (String) token.getPrincipal();

        System.out.println("身份验证username:" + username);

        UserDO user = userService.validateUserName(username);

        // 没有该用户名
        if (user == null) {
            throw new UnknownAccountException();
        }

        ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
        String redisName = UserDO.getRedisName() + username;
        if(redisTemplate.hasKey(redisName)){
            Integer errorCount = valueOperations.get(redisName);
            if (errorCount >= Constants.ERROR_COUNT_MAX){
                throw new ExcessiveAttemptsException();
            }
        }


        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);

        switch (user.getRole()){
            case 1:
                PeasantDO peasant = userService.getPeasantInfo(user.getUserid());
                if (peasant.getPeasantStatus() == 0) {
                    // 抛出帐号锁定异常
                    throw new LockedAccountException();
                }
                BeanCopyPropertiesUtil.peasantCopyProperties(peasant, userDTO);
                break;
            case 2:
                DealerDO dealer = userService.getDealerInfo(user.getUserid());
                if (dealer.getDealerStatus() == 0) {
                    throw new LockedAccountException();
                }
                BeanCopyPropertiesUtil.dealerCopyProperties(dealer, userDTO);
                break;
            default:break;
        }


        // 存入用户信息
        List<Object> principals = new ArrayList<Object>();
        principals.add(userDTO.getUsername());
        principals.add(userDTO);

        // info对象表示realm登录比对信息：参数1：用户信息(真实登录中是登录user对象)，参数2：密码，参数3:表示盐，参数4：当前realm名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principals, userDTO.getPassword(),
                ByteSource.Util.bytes(userDTO.getUsername()), getName());
        return info;
    }
}
