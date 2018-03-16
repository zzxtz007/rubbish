package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.StoriedBo;
import com.keji.washer.model.po.StoriedPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 楼号
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface StoriedMapper {
	/**
	 * 查询所有楼号
	 *
	 * @return 楼号 Bo 结果集
	 */
	List<StoriedBo> list();

	/**
	 * 根据给出的条件查询楼号
	 * @param storiedPo 楼号 po 模型
	 * @return 楼号 bo 模型
	 */
	StoriedBo get(@Param("storied")StoriedPo storiedPo);
}
