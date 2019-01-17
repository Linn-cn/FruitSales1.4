package com.zl.service.impl;

import com.zl.mapper.DealerMapper;
import com.zl.mapper.PeasantMapper;
import com.zl.mapper.RoleMapper;
import com.zl.mapper.UserMapper;
import com.zl.pojo.*;
import com.zl.service.UserService;
import com.zl.util.Constants;
import com.zl.util.MessageException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-07 23:15
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PeasantMapper peasantMapper;

    @Autowired
    private DealerMapper dealerMapper;

    @Autowired
    private RoleMapper roleMapper;

    public UserDO validateUserName(String username) {
        UserDOExample userExample = new UserDOExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<UserDO> list = userMapper.selectByExample(userExample);
        UserDO user = null;
        if(list.size() == 1){
            user =  list.get(0);
        }
        return user;
    }

    public PeasantDO getPeasantInfo(String userid) {
        PeasantDO peasant = peasantMapper.selectByPrimaryKey(userid);
        return peasant;
    }

    public DealerDO getDealerInfo(String userid) {
        DealerDO dealer = dealerMapper.selectByPrimaryKey(userid);
        return dealer;
    }

    public RoleDO getRoleById(Integer roleid) {
        RoleDO role = roleMapper.selectByPrimaryKey(roleid);
        return role;
    }

    public void updateUserPassword(String userid,String username,String password) throws MessageException {
        Md5Hash md5Hash = new Md5Hash(password,username,Constants.HASHITERATIONS);
        password = md5Hash.toString();
        System.out.println("加密后的密码:" + password);
        UserDO userDO = new UserDO();
        userDO.setUserid(userid);
        userDO.setPassword(password);
        userMapper.updateByPrimaryKeySelective(userDO);
    }


}
