package com.keji.washer.service.impl;

import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.StoriedMapper;
import com.keji.washer.dal.WasherMapper;
import com.keji.washer.model.bo.StoriedBo;
import com.keji.washer.model.dto.StoriedInfo;
import com.keji.washer.model.po.WasherPo;
import com.keji.washer.service.StoriedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 楼号 service 实现类
 *
 * @author ICE_DOG
 */
@Service
public class StoriedServiceImpl implements StoriedService {
	@Resource
	private StoriedMapper storiedMapper;

	@Resource
	private WasherMapper washerMapper;

	@Override
	public Response list() throws Throwable {
		List<StoriedBo> storiedBos = storiedMapper.list();
		if (storiedBos.isEmpty()) {
			return new Response(1);
		}
		//把 bo 转换为 dto 传到视图层
		List<StoriedInfo> storiedInfos = new ArrayList<>();
		for (StoriedBo storiedBo : storiedBos) {
			StoriedInfo storiedInfo = new StoriedInfo(storiedBo);
			//查询每栋楼有几个洗衣机空闲
			WasherPo washerPo = new WasherPo();
			washerPo.setStatus(0);
			washerPo.setStoriedId(storiedBo.getId());
			int left = washerMapper.list(washerPo, 0, 9999).size();
			storiedInfo.setLeft(left);
			storiedInfos.add(storiedInfo);
		}
		return new Response(0).add("info", storiedInfos);
	}
}
