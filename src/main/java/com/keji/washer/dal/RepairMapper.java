package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.RepairBo;
import com.keji.washer.model.po.RepairPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报修 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface RepairMapper {

	/**
	 * 插入报修信息进入数据库
	 *
	 * @param repairPo 评价 模型
	 * @return 影响行数
	 */
	int insert(@Param("repair") RepairPo repairPo);

	/**
	 * 更新报修信息
	 *
	 * @param repairPo 评价 模型
	 * @return 影响行数
	 */
	int update(@Param("repair") RepairPo repairPo);

	/**
	 * 根据条件查询repair
	 * @param repairPo 评价模型
	 * @return 查询结果集
	 */
	List<RepairBo> list(@Param("repair") RepairPo repairPo);

}
