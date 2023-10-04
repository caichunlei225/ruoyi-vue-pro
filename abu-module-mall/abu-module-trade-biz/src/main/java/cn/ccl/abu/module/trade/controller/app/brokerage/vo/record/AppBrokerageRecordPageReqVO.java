package cn.ccl.abu.module.trade.controller.app.brokerage.vo.record;

import cn.ccl.abu.framework.common.pojo.PageParam;
import cn.ccl.abu.framework.common.validation.InEnum;
import cn.ccl.abu.module.trade.enums.brokerage.BrokerageRecordBizTypeEnum;
import cn.ccl.abu.module.trade.enums.brokerage.BrokerageRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "应用 App - 分销记录分页 Request VO")
@Data
public class AppBrokerageRecordPageReqVO extends PageParam {

    @Schema(description = "业务类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = BrokerageRecordBizTypeEnum.class, message = "业务类型必须是 {value}")
    private Integer bizType;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = BrokerageRecordStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

}
