package cn.ccl.abu.module.promotion.controller.admin.coupon.vo.template;

import cn.ccl.abu.framework.common.pojo.PageParam;
import cn.ccl.abu.framework.common.validation.InEnum;
import cn.ccl.abu.module.promotion.enums.coupon.CouponTakeTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.ccl.abu.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 优惠劵模板分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CouponTemplatePageReqVO extends PageParam {

    @Schema(description = "优惠劵名", example = "你好")
    private String name;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "优惠类型", example = "1")
    private Integer discountType;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "可以领取的类型", example = "[1,2, 3]")
    @InEnum(value = CouponTakeTypeEnum.class, message = "可以领取的类型，必须是 {value}")
    private List<Integer> canTakeTypes;

}