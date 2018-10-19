package com.xcm.puppy.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jenkins on 4/8/16.
 */
public class ApacheHttpClient {
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private CloseableHttpResponse httpResponse;

    /**
     * 获取Get请求的Response Code
     *
     * @param uri
     * @return
     */
    public int getStatusCode(String uri) {
        int statusCode = 0;
        HttpGet httpGet = new HttpGet(uri);
        try {
            httpResponse = httpClient.execute(httpGet);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return statusCode;
    }

    /**
     * 获取Post请求的Response Code
     *
     * @param uri
     * @param params
     * @return
     */
    public int getStatusCode(String uri, Map<String, String> params) {
        int statusCode = 0;
        HttpPost httpPost = new HttpPost(uri);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpResponse = httpClient.execute(httpPost);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return statusCode;
    }

    /**
     * 获取Post请求的Response Code
     *
     * @param uri
     * @param params
     * @return
     */
    public int getStatusCode(String uri, Map<String, String> params, Map<String, String> headers) {
        int statusCode = 0;
        HttpPost httpPost = new HttpPost(uri);

        Set<String> headerKeys = headers.keySet();
        for (String key : headerKeys) {
            httpPost.addHeader(key, headers.get(key));
        }

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> paramKeys = params.keySet();
        for (String key : paramKeys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpResponse = httpClient.execute(httpPost);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return statusCode;
    }

    /**
     * 获取Get请求的Response
     *
     * @param uri
     * @return
     */
    public String getResponse(String uri) {
        String response = null;
        HttpGet httpGet = new HttpGet(uri);
        try {
            httpResponse = httpClient.execute(httpGet);
            String statusLine = httpResponse.getStatusLine().toString();
            HttpEntity entity = httpResponse.getEntity();
            response = statusLine + EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 获取Post请求的Response
     *
     * @param uri
     * @param params
     * @return
     */
    public String getResponse(String uri, Map<String, String> params) {
        String response = null;
        HttpPost httpPost = new HttpPost(uri);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpResponse = httpClient.execute(httpPost);
            String statusLine = httpResponse.getStatusLine().toString();
            HttpEntity entity = httpResponse.getEntity();
            response = statusLine + EntityUtils.toString(entity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 获取Post请求的Response
     *
     * @param uri
     * @param params
     * @return
     */
    public String getResponse(String uri, Map<String, String> params, Map<String, String> headers) {
        String response = null;
        HttpPost httpPost = new HttpPost(uri);

        Set<String> headerKeys = headers.keySet();
        for (String key : headerKeys) {
            httpPost.addHeader(key, headers.get(key));
        }

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> paramKeys = params.keySet();
        for (String key : paramKeys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpResponse = httpClient.execute(httpPost);
            String statusLine = httpResponse.getStatusLine().toString();
            HttpEntity entity = httpResponse.getEntity();
            response = statusLine + EntityUtils.toString(entity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

}
