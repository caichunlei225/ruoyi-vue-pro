package cn.ccl.abu.framework.operatelog.config;

import cn.ccl.abu.framework.operatelog.core.aop.OperateLogAspect;
import cn.ccl.abu.framework.operatelog.core.service.OperateLogFrameworkService;
import cn.ccl.abu.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import cn.ccl.abu.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class AbuOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
