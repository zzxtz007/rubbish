package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.OrderBo;
import com.keji.washer.model.po.OrderPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface OrderMapper {
	/**
	 * 插入 order 信息到数据库
	 *
	 * @param orderPo order 模型
	 * @return 影响行数
	 */
	int insert(@Param("order") OrderPo orderPo);

	/**
	 * 修改 order 信息到数据库
	 *
	 * @param orderPo order 模型
	 * @return 影响行数
	 */
	int update(@Param("order") OrderPo orderPo);

	/**
	 * 从数据库查询 order 的信息
	 *
	 * @param orderPo    order 模型
	 * @param startIndex 开始索引
	 * @param count      查询个数
	 * @return order bo 结果集
	 */
	List<OrderBo> list(@Param("order") OrderPo orderPo, @Param("startIndex") Integer startIndex,
			@Param("count") Integer count);

	/**
	 * 从数据库查询 order 的信息
	 *
	 * @param orderPo order 模型
	 * @return order bo 模型
	 */
	OrderBo get(@Param("order") OrderPo orderPo);

}
