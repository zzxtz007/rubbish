package com.keji.washer.service.impl;

import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.WasherMapper;
import com.keji.washer.model.bo.WasherBo;
import com.keji.washer.model.dto.StoriedInfo;
import com.keji.washer.model.dto.WasherInfo;
import com.keji.washer.model.po.WasherPo;
import com.keji.washer.service.WasherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 洗衣机 service 实现类
 *
 * @author ICE_DOG
 */
@Service
public class WasherServiceImpl implements WasherService {
	private static final Logger LOGGER = Logger.getLogger(WasherServiceImpl.class);

	@Resource
	private WasherMapper washerMapper;

	@Override
	public Response listByStoried(Integer storiedId, Integer status, Integer pageNum,
			Integer count) throws Throwable {
		//判断传入的参数是否为空？若为空 返回 3
		if (pageNum == null || count == null) {
			return new Response(3);
		}
		WasherPo washerPo = new WasherPo();
		washerPo.setStoriedId(storiedId);
		washerPo.setStatus(status);
		Integer startIndex = (pageNum - 1) * count;
		List<WasherBo> washerBos = washerMapper.list(washerPo, startIndex, count);
		List<WasherInfo> washerInfos = new ArrayList<>();
		for (WasherBo washerBo : washerBos) {
			StoriedInfo storiedInfo = new StoriedInfo();
			storiedInfo.setId(washerBo.getStoriedId().getId());
			storiedInfo.setNumber(washerBo.getStoriedId().getNumber());
			washerInfos.add(new WasherInfo(washerBo, storiedInfo));
		}
		return new Response(0).add("info", washerInfos);
	}
}
