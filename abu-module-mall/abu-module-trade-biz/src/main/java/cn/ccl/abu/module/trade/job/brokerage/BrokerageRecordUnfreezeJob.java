package cn.ccl.abu.module.trade.job.brokerage;

import cn.hutool.core.util.StrUtil;
import cn.ccl.abu.framework.quartz.core.handler.JobHandler;
import cn.ccl.abu.framework.tenant.core.job.TenantJob;
import cn.ccl.abu.module.trade.service.brokerage.record.BrokerageRecordService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 佣金解冻 Job
 *
 * @author owen
 */
@Component
@TenantJob
public class BrokerageRecordUnfreezeJob implements JobHandler {

    @Resource
    private BrokerageRecordService brokerageRecordService;

    @Override
    public String execute(String param) {
        int count = brokerageRecordService.unfreezeRecord();
        return StrUtil.format("解冻佣金 {} 个", count);
    }

}
