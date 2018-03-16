package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.OperatorBo;
import com.keji.washer.model.po.OperatorPo;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface OperatorMapper {
	/**
	 * 根据管理员信息 查询管理员信息 一般用于登陆
	 *
	 * @param operator 管理员 Po 模型
	 * @return 管理员 Bo 模型
	 */
	OperatorBo get(@Param("operator") OperatorPo operator);
}
