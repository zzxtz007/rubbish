package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.UserBo;
import com.keji.washer.model.po.UserPo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface UserMapper {
	/**
	 * 添加 user 信息到数据库中
	 *
	 * @param userPo 用户 po 模型
	 * @return 影响行数
	 */
	int insert(@Param("user") UserPo userPo);

	/**
	 * 到表中修改 user 信息
	 *
	 * @param userPo 用户 po 模型
	 * @return 影响行数
	 */
	int update(@Param("user") UserPo userPo);

	/**
	 * 查询 user 信息
	 *
	 * @param userPo 用户 po 模型
	 * @return 用户 bo 模型
	 */
	UserBo get(@Param("user") UserPo userPo);
}
