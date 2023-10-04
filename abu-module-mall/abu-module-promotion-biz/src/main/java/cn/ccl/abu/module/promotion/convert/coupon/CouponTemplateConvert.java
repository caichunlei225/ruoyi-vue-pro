package cn.ccl.abu.module.promotion.convert.coupon;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import cn.ccl.abu.module.promotion.controller.admin.coupon.vo.template.CouponTemplateRespVO;
import cn.ccl.abu.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import cn.ccl.abu.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵模板 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface CouponTemplateConvert {

    CouponTemplateConvert INSTANCE = Mappers.getMapper(CouponTemplateConvert.class);

    CouponTemplateDO convert(CouponTemplateCreateReqVO bean);

    CouponTemplateDO convert(CouponTemplateUpdateReqVO bean);

    CouponTemplateRespVO convert(CouponTemplateDO bean);

    PageResult<CouponTemplateRespVO> convertPage(PageResult<CouponTemplateDO> page);

}
