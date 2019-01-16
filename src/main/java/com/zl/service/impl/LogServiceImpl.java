package com.zl.service.impl;


import com.zl.mapper.LogMapper;
import com.zl.pojo.LogDO;
import com.zl.service.LogService;
import com.zl.util.AjaxPutPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl  implements LogService {

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public int insertLog(LogDO LogDO) {
		System.out.println("日志入库"+ LogDO.toString());
		return logMapper.insertSelective(LogDO);
	}

	@Override
	public int updateLog(LogDO logDO) {
		System.out.println("日志更新"+ logDO.toString());
		return logMapper.updateByPrimaryKeySelective(logDO);
	}

	@Override
	public List<LogDO> listLogDO(AjaxPutPage<LogDO> ajaxPutPage) {
		return logMapper.listLogDO(ajaxPutPage);
	}

	@Override
	public int getLogCount() {
		return logMapper.countByExample(null);
	}


}
