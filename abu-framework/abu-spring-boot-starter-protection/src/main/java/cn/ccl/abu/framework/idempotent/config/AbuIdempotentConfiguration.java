package cn.ccl.abu.framework.idempotent.config;

import cn.ccl.abu.framework.idempotent.core.aop.IdempotentAspect;
import cn.ccl.abu.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import cn.ccl.abu.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import cn.ccl.abu.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import cn.ccl.abu.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import cn.ccl.abu.framework.redis.config.AbuRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = AbuRedisAutoConfiguration.class)
public class AbuIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
