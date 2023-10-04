package cn.ccl.abu.module.promotion.dal.mysql.discount;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.framework.mybatis.core.mapper.BaseMapperX;
import cn.ccl.abu.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ccl.abu.module.promotion.controller.admin.discount.vo.DiscountActivityPageReqVO;
import cn.ccl.abu.module.promotion.dal.dataobject.discount.DiscountActivityDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 限时折扣活动 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DiscountActivityMapper extends BaseMapperX<DiscountActivityDO> {

    default PageResult<DiscountActivityDO> selectPage(DiscountActivityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DiscountActivityDO>()
                .likeIfPresent(DiscountActivityDO::getName, reqVO.getName())
                .eqIfPresent(DiscountActivityDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DiscountActivityDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DiscountActivityDO::getId));
    }

}
