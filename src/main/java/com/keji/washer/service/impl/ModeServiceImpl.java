package com.keji.washer.service.impl;

import com.keji.washer.common.exception.IllegalAccessException;
import com.keji.washer.common.utils.Response;
import com.keji.washer.dal.ModeMapper;
import com.keji.washer.model.bo.ModeBo;
import com.keji.washer.model.dto.ModeInfo;
import com.keji.washer.service.ModeService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 模式 service 实现
 *
 * @author Ice_Dog
 */
public class ModeServiceImpl implements ModeService {
	private static final Logger LOGGER = Logger.getLogger(ModeServiceImpl.class);

	@Resource
	private ModeMapper modeMapper;

	@Override
	public Response list() throws Throwable {
		List<ModeBo> modeBoList = modeMapper.list();
		if (modeBoList.isEmpty()) {
			throw new IllegalAccessException("数据库出错");
		}
		List<ModeInfo> modeInfos = new ArrayList<>();
		for (ModeBo modeBo : modeBoList) {
			ModeInfo modeInfo = new ModeInfo(modeBo.getId(), modeBo.getType(), modeBo.getPrice(),
					modeBo.getWasherTime());
			modeInfos.add(modeInfo);
		}
		return new Response(0).add("info", modeInfos);
	}
}
