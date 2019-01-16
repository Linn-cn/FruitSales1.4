package com.zl.service.impl;

import com.zl.mapper.SysMapper;
import com.zl.pojo.SysDO;
import com.zl.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @description:
 * @author: ZhuLlin
 * @create: 2019-01-08 22:40
 **/
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysMapper sysMapper;

    public SysDO getSysInfo() {
        List<SysDO> sysDOs = sysMapper.selectByExample(null);
        SysDO sysDO = null;
        if (sysDOs.size() == 1){
            sysDO = sysDOs.get(0);
        }
        return sysDO;
    }

    public boolean updateSysInfo(SysDO sysDO) {
        sysDO.setSysId(1);
        try {
            sysMapper.updateByPrimaryKeySelective(sysDO);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return true;
    }
}
