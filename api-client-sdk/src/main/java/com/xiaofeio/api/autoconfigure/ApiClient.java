package com.xiaofeio.api.autoconfigure;

import cn.hutool.json.JSONUtil;
import com.xiaofeio.api.autoconfigure.properties.ApiProperties;
import com.xiaofeio.api.autoconfigure.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * ClassName: ApiClient
 * Package: com.xiaofeio.api
 *
 * @Author: XiaoFei
 * @Create: 2024/2/29 21:20
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@Component
public class ApiClient {

    @Autowired
    private ApiProperties apiProperties;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据传递的参数进行分页查询
     *
     * @return 指定页的数据
     */
    public String regionListByPage(Map<String, Object> paramsMap) {
        //加密数据
        String encrypt = EncryptionUtils.encrypt(JSONUtil.toJsonStr(paramsMap), apiProperties.getSecretKey());
        // 请求地址
        String requestUrl = apiProperties.getGatewayUrl() + "/interface/region/list/page";

        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accessKey", apiProperties.getAccessKey());
        // 请求体
        HttpEntity<String> requestEntity = new HttpEntity<>(encrypt, headers);
        // 发送 POST 请求
        return restTemplate.postForEntity(requestUrl, requestEntity, String.class).getBody();

    }


}
