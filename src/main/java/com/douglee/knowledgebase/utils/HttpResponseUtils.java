package com.douglee.knowledgebase.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Created by Douglee on 2018/12/6.
 * HttpClient 连接池
 */
public class HttpResponseUtils {

    private static final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

    static {
        // 项目中读取配置文件为宜
        connManager.setMaxTotal(500);
        connManager.setDefaultMaxPerRoute(20);
    }

    public static CloseableHttpClient getHttpClient(Integer timeout){
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeout)
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connManager)
                .build();
    }

}
