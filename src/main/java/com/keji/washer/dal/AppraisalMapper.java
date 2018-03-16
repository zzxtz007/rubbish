package com.keji.washer.dal;

import com.keji.washer.common.annotation.MybatisDao;
import com.keji.washer.model.bo.AppraisalBo;
import com.keji.washer.model.po.AppraisalPo;
import com.keji.washer.model.po.UserPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评价 mapper
 *
 * @author ICE_DOG
 */
@MybatisDao
public interface AppraisalMapper {
	/**
	 * 把评价信息存入数据库
	 *
	 * @param appraisalPo 评价模型
	 * @return 影响行数
	 */
	int insert(@Param("appraisal") AppraisalPo appraisalPo);

	/**
	 * 根据条件查询评价
	 *
	 * @param appraisalPo 评价模型
	 * @param washerId 洗衣机 id
	 * @return 评价结果集
	 */
	List<AppraisalBo> list(@Param("appraisal") AppraisalPo appraisalPo,
			@Param("washerId") Integer washerId);

	/**
	 * 根据条件查询评价
	 * @param appraisalPo 评价模型
	 * @return 评价模型
	 */
	AppraisalBo get(@Param("appraisal") AppraisalPo appraisalPo);
}
