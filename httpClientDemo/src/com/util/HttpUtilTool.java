package com.util;

import com.common.utils.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 基于 httpclient 4.5版本的 http工具类
 */
public class HttpUtilTool {

    //private static Logger logger = LoggerFactory.getLogger(HttpUtilTool.class);

   // private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HttpUtilTool.class.getName());

    private static final CloseableHttpClient httpClient;

    public static final String CHARSET = "UTF-8";

    private static final RequestConfig config;

    private static final String REGEX = "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";

    // 采用静态代码块，初始化超时时间配置，再根据配置生成默认httpClient对象
    static {
        config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, CHARSET);
    }

    public static String doGetSSL(String url, Map<String, String> params) {
        return doGetSSL(url, params, CHARSET);
    }

    public static String doPost(String url, Map<String, String> params) throws IOException {
        return doPost(url, params, CHARSET);
    }

    /**
     * HTTP Post 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return 页面内容
     * @throws IOException
     */
    private static String doPost(String url, Map<String, String> params, String charset) throws IOException {

        urlCheck(url);

        List<NameValuePair> pairList = null;
        if (null != params && !params.isEmpty()) {
            pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String value = entry.getValue();
                if (null != value) {
                    pairList.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
        }
        HttpPost request = new HttpPost(url);
        if (pairList != null && pairList.size() > 0) {
            request.setEntity(new UrlEncodedFormEntity(pairList, CHARSET));
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);

            String result = validateStatusCode(null, request, response);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            close(response);
        }
        return null;
    }

    /**
     * url 校验url是否为空
     *
     * @param url
     * @return
     */
    private static void urlCheck(String url) throws MalformedURLException {
        if (StringUtils.isEmpty(url)) {
            throw new MalformedURLException(notURLMsg(url));
        }
    }


    private static String notURLMsg(String url) {
        return "url cannot be empty :" + url + "=:" + url.length();
    }

    /**
     * HTTPS Get 获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return
     */
    private static String doGetSSL(String url, Map<String, String> params, String charset) {

        try {
            urlCheck(url);

            String param_url = validateParams(url, params);

            HttpGet request = new HttpGet(param_url);
            // https  注意这里获取https内容，使用了忽略证书的方式，当然还有其他的方式来获取https内容
            CloseableHttpClient httpsClient = HttpUtilTool.createSSLClientDefault();
            CloseableHttpResponse response = httpsClient.execute(request);

            String result = validateStatusCode(request, null, response);

            close(response);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 这里创建了忽略整数验证的CloseableHttpClient对象
     *
     * @return
     */
    private static CloseableHttpClient createSSLClientDefault() {

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (x509Certificates, s) -> true).build();
            SSLConnectionSocketFactory sslsFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsFactory).build();

        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    /**
     * HTTP Get         获取内容
     *
     * @param url     请求的url地址 ?之前的地址
     * @param params  请求的参数
     * @param charset 编码格式
     * @return
     */
    private static String doGet(String url, Map<String, String> params, String charset) {
        try {
            urlCheck(url);
            String result = "";
            if (Pattern.matches(REGEX, url)) {

                String param_url = validateParams(url, params);

                HttpGet request = new HttpGet(param_url);
                CloseableHttpResponse response = httpClient.execute(request);

                result = validateStatusCode(request, null, response);

                close(response);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("doGet====:" + e.getMessage());
        }
        return null;
    }

    /**
     * 验证返回状态
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    private static String validateStatusCode(HttpGet requestGet, HttpPost requestPost, CloseableHttpResponse response) throws IOException {
        String result = "";
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            if (requestGet != null) {
                requestGet.abort();
            }
            if (requestPost != null) {
                requestPost.abort();
            }
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();

        if (null != entity) {
            result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        }
        EntityUtils.consume(entity);
        //response.close();
        //close(response);
        return result;
    }


//    private static String validateStatusCode(HttpGet request, CloseableHttpResponse response) throws IOException {
//
//
//        int statusCode = response.getStatusLine().getStatusCode();
//        if (statusCode != HttpStatus.SC_OK) {
//            request.abort();
//            throw new RuntimeException("HttpClient,error status code :" + statusCode);
//        }
//        HttpEntity entity = response.getEntity();
//        String result = null;
//        if (null != entity) {
//            result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
//        }
//        EntityUtils.consume(entity);
//        //response.close();
//        close(response);
//        return result;
//    }

    /**
     * 验证参数,如果参数不为空则将请求参数和url进行拼接
     *
     * @param url    + 参数
     * @param params
     * @return
     * @throws IOException
     */
    private static String validateParams(String url, Map<String, String> params) throws IOException {
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String value = entry.getValue();
                if (null != value) {
                    pairList.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
            // 将请求参数和url进行拼接
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairList, CHARSET));
        }
        return url;
    }


    /**
     * 尝试关闭response
     *
     * @param resp HttpResponse对象
     */
    private static void close(HttpResponse resp) {
        try {
            if (resp == null) return;
            //如果CloseableHttpResponse 是resp的父类，则支持关闭
            if (CloseableHttpResponse.class.isAssignableFrom(resp.getClass())) {
                ((CloseableHttpResponse) resp).close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error(e.getMessage());
        }
    }

}
