package com.xiaofeio.api.autoconfigure.properties;

import lombok.Data;
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
@Data
@ConfigurationProperties("api.info")
public class ApiProperties {

    private String accessKey;

    private String secretKey;

    /**
     * 网关地址
     */
    private String gatewayUrl;
}
