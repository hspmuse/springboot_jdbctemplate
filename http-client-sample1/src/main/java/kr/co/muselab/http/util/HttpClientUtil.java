package kr.co.muselab.http.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.SocketTimeoutException;

/**
 * Created by 1002428 on 15. 6. 25..
 */
public class HttpClientUtil {

    public static String doPost(String url, String jsonParam) {

        String      result = "";

        CloseableHttpClient     client          = HttpClientBuilder.create().build();
        HttpPost                httpPost        = null;
        CloseableHttpResponse   response        = null;
        HttpEntity              resultEntity    = null;

        try {
            httpPost = new HttpPost(url);

            RequestConfig config = RequestConfig.custom().setSocketTimeout(3*1000)
                    .setConnectTimeout(3*1000)
                    .build();
            httpPost.setConfig(config);

            StringEntity entity = new StringEntity(jsonParam);
            entity.setContentType("application/json");
            httpPost.setEntity(entity);

            response = client.execute(httpPost);

            System.out.println("Http status Code=" + response.getStatusLine().getStatusCode());

            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("doPost Failed : [URL:"+url+"] HTTP error code : " + response.getStatusLine().getStatusCode());
            }
            resultEntity  = response.getEntity();
            result      = EntityUtils.toString(resultEntity);

        } catch(ConnectTimeoutException te) {
            System.out.println("doPost Failed : [URL:"+url+"] HTTP error code : " + response.getStatusLine().getStatusCode());
            System.out.println("te=" + te.toString());
        } catch(SocketTimeoutException se) {
            System.out.println("se=" + se.toString());
            System.out.println("doPost Failed : [URL:"+url+"] HTTP error code : " + response.getStatusLine().getStatusCode());
        } catch(Exception e) {
            System.out.println("e=" + e.toString());
            System.out.println("doPost Failed : [URL:"+url+"] HTTP error code : " + response.getStatusLine().getStatusCode());
        }

        return result;
    }

    public static String doGet(String url, String param) {
        String result="";

        CloseableHttpClient     client      = HttpClientBuilder.create().build();
        HttpGet                 httpGet     = null;
        CloseableHttpResponse   response    = null;
        HttpEntity              resultEntity= null;

        try {

            httpGet = new HttpGet(url+param);

            RequestConfig config = RequestConfig.custom().setSocketTimeout(3*1000)
                    .setConnectTimeout(3*1000)
                    .build();
            httpGet.setConfig(config);

            response = client.execute(httpGet);
            System.out.println("Http status Code=" + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("doPost Failed : [URL:"+url+"] HTTP error code : " + response.getStatusLine().getStatusCode());
            }
            resultEntity = response.getEntity();
            result = EntityUtils.toString(resultEntity);
        } catch(Exception e) {

        }


        return result;
    }

    public static String doHttpsGet(String url, String param) {



        return "";
    }

}
