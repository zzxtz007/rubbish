package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.ModeBo;

import java.util.List;

/**
 * 模式 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface ModeMapper {
	/**
	 * 查询所有 mode
	 *
	 * @return Mode 模型的集合
	 */
	List<ModeBo> list();
}
