package com.zl.service.impl;

import com.zl.mapper.ContractMapper;
import com.zl.mapper.MiddleMapper;
import com.zl.pojo.*;
import com.zl.service.ContractService;
import com.zl.util.AjaxPutPage;
import com.zl.util.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: FruitSales
 * @classname: ContractServiceImpl
 * @description:
 * @author: 朱林
 * @create: 2019-02-05 15:41
 **/
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private MiddleMapper middleMapper;

    @Override
    public List<ContractDTO> listContract(AjaxPutPage<ContractDTO> ajaxPutPage) {
        return contractMapper.listContract(ajaxPutPage);
    }

    @Override
    public Integer getContractCount() {
        return contractMapper.countByExample(null);
    }

    @Override
    public ContractVO getContractInfo(String contractId) {
        return contractMapper.getContractInfo(contractId);
    }

    @Override
    public List<GardenStuffVO> listGardenStuffInfoByContractID(String contractId) {
        return contractMapper.listGardenStuffInfoByContractID(contractId);
    }

    @Override
    public void deleteContractByKey(String id) throws MessageException {
        contractMapper.deleteByPrimaryKey(id);
        MiddleDOExample example = new MiddleDOExample();
        example.createCriteria().andContractIdEqualTo(id);
        middleMapper.deleteByExample(example);
    }

    @Override
    public Integer contractCountByDealerID(String dealerid) {
        ContractDOExample example = new ContractDOExample();
        example.createCriteria().andDealerIdEqualTo(dealerid);
        return contractMapper.countByExample(example);
    }
}
