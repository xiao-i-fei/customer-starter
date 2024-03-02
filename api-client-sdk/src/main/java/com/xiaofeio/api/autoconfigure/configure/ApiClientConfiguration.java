package com.xiaofeio.api.autoconfigure.configure;

import com.xiaofeio.api.autoconfigure.ApiClient;
import com.xiaofeio.api.autoconfigure.properties.ApiProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

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

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)//当容器中没有该Bean的时候才创建
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        // 支持中文编码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    @ConditionalOnMissingBean(ClientHttpRequestFactory.class)//当容器中没有该Bean的时候才创建
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
