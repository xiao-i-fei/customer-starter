package com.xiaofeio.api.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: ApiProperties
 * Package: com.xiaofeio.api.autoconfigure.properties
 *
 * @Author: XiaoFei
 * @Create: 2024/2/29 21:43
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@ConfigurationProperties("api.info")
public class ApiProperties {

    private String accessKey;

    private String secretKey;

    /**
     * 网关地址
     */
    private String gatewayUrl;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }
}
