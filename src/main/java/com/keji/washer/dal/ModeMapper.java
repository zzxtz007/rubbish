package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.ModeBo;
import com.keji.washer.model.po.ModePo;
import org.apache.ibatis.annotations.Param;

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

	/**
	 * 根据 id 查询 mode
	 *
	 * @param modePo 模型
	 * @return ModeBo 模型
	 */
	ModeBo get(@Param("mode") ModePo modePo);
}
