package com.zl.service.impl;

import com.zl.mapper.AccessoryMapper;
import com.zl.mapper.ContractMapper;
import com.zl.mapper.GardenStuffMapper;
import com.zl.mapper.MiddleMapper;
import com.zl.pojo.*;
import com.zl.service.ContractService;
import com.zl.util.AjaxPutPage;
import com.zl.util.AjaxResultPage;
import com.zl.util.MessageException;
import com.zl.util.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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

    @Autowired
    private GardenStuffMapper gardenStuffMapper;

    @Autowired
    private AccessoryMapper accessoryMapper;

    @Override
    public AjaxResultPage<ContractDTO> listContract(AjaxPutPage<ContractDTO> ajaxPutPage) {
        AjaxResultPage<ContractDTO> result = new AjaxResultPage<ContractDTO>();
        List<ContractDTO> list = contractMapper.listContract(ajaxPutPage);
        result.setData(list);
        result.setCount(contractMapper.listContractCount(ajaxPutPage));
        return result;
    }

    @Cacheable(value = "welcome")
    @Override
    public Integer getContractCount() {
        ContractDOExample contractDOExample = new ContractDOExample();
        contractDOExample.createCriteria().andCheckEqualTo(1);
        return contractMapper.countByExample(contractDOExample);
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
    public void updateContractByCheck(String id,Integer check) throws MessageException {
        ContractDO contractDO = new ContractDO();
        contractDO.setContractId(id);
        contractDO.setCheck(check);
        contractMapper.updateByPrimaryKeySelective(contractDO);
    }

    @Override
    public Integer contractCountByDealerID(String dealerid) {
        ContractDOExample example = new ContractDOExample();
        example.createCriteria().andDealerIdEqualTo(dealerid);
        return contractMapper.countByExample(example);
    }

    @Override
    public void insertContractAndMiddle(ContractDO contractDO, List<String> TCdataId,List<BigDecimal> TCNumber)throws MessageException {
        String contractId = UuidUtils.creatUUID();
        contractDO.setContractId(contractId);
        contractDO.setCreatetime(new Timestamp(new Date().getTime()));
        BigDecimal contractPrice = new BigDecimal("0");
        for (int i = 0; i < TCdataId.size() && i<TCNumber.size();i++){
            BigDecimal price = new BigDecimal(TCNumber.get(i).toString());
            GardenStuffDO gardenStuffDO = gardenStuffMapper.selectByPrimaryKey(TCdataId.get(i));
            price = price.multiply(gardenStuffDO.getGardenstuffPrice());
            contractPrice = contractPrice.add(price);
            AccessoryDOExample example = new AccessoryDOExample();
            example.createCriteria().andGardenstuffIdEqualTo(TCdataId.get(i));
            List<AccessoryDO> accessoryDOList = accessoryMapper.selectByExample(example);
            for (AccessoryDO accessoryDO : accessoryDOList){
                price = new BigDecimal(TCNumber.get(i).toString());
                price = price.multiply(accessoryDO.getAccessoryPrice());
                contractPrice = contractPrice.add(price);
            }
        }
        contractDO.setContractPrice(contractPrice);
        contractMapper.insertSelective(contractDO);
        for (int i = 0; i < TCdataId.size() && i<TCNumber.size();i++){
            MiddleDO middleDO = new MiddleDO();
            middleDO.setMiddleId(UuidUtils.creatUUID());
            middleDO.setContractId(contractId);
            middleDO.setGardenstuffId(TCdataId.get(i));
            middleDO.setNumber(TCNumber.get(i).intValue());
            middleMapper.insertSelective(middleDO);
        }
    }
}
