package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.WasherBo;
import com.keji.washer.model.po.WasherPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 洗衣机 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface WasherMapper {
	/**
	 * 添加洗衣机信息到数据库中
	 *
	 * @param washerPo washer 模型
	 * @return 影响行数
	 */
	int insert(@Param("washer") WasherPo washerPo);

	/**
	 * 在数据库中修改洗衣机信息
	 *
	 * @param washerPo washer 模型
	 * @return 影响行数
	 */
	int update(@Param("washer") WasherPo washerPo);

	/**
	 * 根据条件查询 洗衣机
	 *
	 * @param washerPo   washerPo washer 模型
	 * @param startIndex 起始个数
	 * @param count      查询个数
	 * @return washer bo 结果集
	 */
	List<WasherBo> list(@Param("washer") WasherPo washerPo, @Param("startIndex") Integer startIndex,
			@Param("count") Integer count);
}
