package com.xiaofeio.api.autoconfigure;

import cn.hutool.http.HttpUtil;
import com.xiaofeio.api.autoconfigure.properties.ApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /**
     * 根据传递的参数进行分页查询
     *
     * @return 指定页的数据
     */
    public String regionListByPage(Map<String, Object> paramsMap) {

        // 请求地址
        String requestUrl = apiProperties.getGatewayUrl() + "/xiaofei-utils/region/list/page";
        return HttpUtil.get(requestUrl, paramsMap);

    }


}
