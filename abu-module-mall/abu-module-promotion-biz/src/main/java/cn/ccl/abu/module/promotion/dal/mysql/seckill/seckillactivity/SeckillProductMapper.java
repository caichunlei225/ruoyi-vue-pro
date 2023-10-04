package cn.ccl.abu.module.promotion.dal.mysql.seckill.seckillactivity;

import cn.ccl.abu.framework.mybatis.core.mapper.BaseMapperX;
import cn.ccl.abu.module.promotion.dal.dataobject.seckill.seckillactivity.SeckillProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 秒杀活动商品 Mapper
 *
 * @author halfninety
 */
@Mapper
public interface SeckillProductMapper extends BaseMapperX<SeckillProductDO> {

    default List<SeckillProductDO> selectListByActivityId(Long id) {
        return selectList(SeckillProductDO::getActivityId, id);
    }

    default List<SeckillProductDO> selectListByActivityId(Collection<Long> ids) {
        return selectList(SeckillProductDO::getActivityId, ids);
    }

}
