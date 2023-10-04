package cn.ccl.abu.framework.social.config;

import cn.ccl.abu.framework.social.core.AbuAuthRequestFactory;
import com.xingyuv.http.HttpUtil;
import com.xingyuv.http.support.hutool.HutoolImpl;
import com.xingyuv.jushauth.cache.AuthStateCache;
import com.xingyuv.justauth.autoconfigure.JustAuthProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 社交自动装配类
 *
 * @author timfruit
 * @date 2021-10-30
 */
@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(JustAuthProperties.class)
public class AbuSocialAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "justauth", value = "enabled", havingValue = "true", matchIfMissing = true)
    public AbuAuthRequestFactory abuAuthRequestFactory(JustAuthProperties properties, AuthStateCache authStateCache) {
        // 需要修改 HttpUtil 使用的实现，避免类报错
        HttpUtil.setHttp(new HutoolImpl());
        // 创建 AbuAuthRequestFactory
        return new AbuAuthRequestFactory(properties, authStateCache);
    }

}
