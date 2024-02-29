package com.xiaofeio.api.autoconfigure.configure;

import com.xiaofeio.api.autoconfigure.ApiClient;
import com.xiaofeio.api.autoconfigure.properties.ApiProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ApiClientConfiguration
 * Package: com.xiaofeio.api.autoconfigure.configure
 *
 * @Author: XiaoFei
 * @Create: 2024/2/29 23:24
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(ApiProperties.class)//默认会将ThreadPoolProperties放在容器中
public class ApiClientConfiguration {

    @Bean
    @ConditionalOnMissingBean(ApiClient.class)//当容器中没有该Bean的时候才创建
    public ApiClient apiClient() {
        //使用ThreadPoolExecutor创建一个线程池
        return new ApiClient();
    }
}
