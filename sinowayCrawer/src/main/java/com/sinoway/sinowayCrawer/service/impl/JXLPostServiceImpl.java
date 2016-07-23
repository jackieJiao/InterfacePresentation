package com.sinoway.sinowayCrawer.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sinoway.sinowayCrawer.service.JXLPostService;

@Service
public class JXLPostServiceImpl implements JXLPostService{
	private String url        = "https://www.juxinli.com/orgApi/rest/v2/creditInvestigation/message/collect/req/";
	private String orgAccount = "sinowaycredit";
	
	 
    public String sendCreditRequest( 
    		                               String name,
    		                               String cell_phone_num,
    		                               String id_card_num,
    		                               String account,
    		                               String password,
    		                               String captcha){
    	String baseGsonStr = 
		"{" +
		  "\"apply_info\": {" +
		  "\"basic_info\": {" +
			"\"name\": \"name123\"," +
		      "\"cell_phone_num\": \"cell_phone_num123\"," +
		      "\"id_card_num\": \"id_card_num123\" " +
		    "} "+
		  "}, "+
		  "\"account\": \"account123\"," +
		  "\"password\": \"paswd123\"," +
		  "\"captcha\": \"captcha123\"" +
		"}";
    	System.out.println(baseGsonStr);
		String gsonStr = baseGsonStr.replace("name123", name)
				                    .replace("cell_phone_num123", cell_phone_num)
				                    .replace("id_card_num123", id_card_num)
				                    .replace("account123", account)
				                    .replace("paswd123", password)
				                    .replace("captcha123", captcha);
    	System.out.println(gsonStr);
		String content = sendSSLPostRequest(url + orgAccount,gsonStr);
    	System.out.println(content);
    	String process_code = null;
    	if ( null != content ){
    		Gson gson = new Gson();
			JsonObject obj = gson.fromJson(content, JsonObject.class);
			if (obj.has("data")) {
				JsonElement jsonElemen = obj.get("data").getAsJsonObject().get("process_code");
				if (!jsonElemen.isJsonNull()) {
					System.out.println(jsonElemen.toString());
					process_code = jsonElemen.toString();
					if ( !process_code.equals("10008") ){
						process_code += ":";
						process_code += obj.get("data").getAsJsonObject().get("content").toString();
					}
				}
			} else if ( obj.has("message") ) {
				if ( null == process_code ){
					process_code = obj.get("message").toString();
				}
			}
		}
    	return process_code;
    }
    
    @SuppressWarnings("finally")
	private String sendSSLPostRequest(String reqURL, String gsonStr){
    	long responseLength = 0;                         //响应长度 
        String responseContent = null;                   //响应内容 
       /* 创建默认的httpClient实例 */
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例 
        X509TrustManager xtm = new X509TrustManager(){   //创建TrustManager 
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
            public X509Certificate[] getAcceptedIssuers() { return null; } 
        };
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
            public void verify(String arg0, String[] arg1, String[] arg2) throws SSLException {}
            public void verify(String arg0, X509Certificate arg1) throws SSLException {}
			 
			public void verify(String arg0, SSLSocket arg1) throws IOException {
			}
        };
        try {
            SSLContext ctx = SSLContext.getInstance("TLS"); 
            ctx.init(null, new TrustManager[]{xtm}, null); 
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx); 
            socketFactory.setHostnameVerifier(hostnameVerifier); 
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443)); 
            
            HttpPost httpPost = new HttpPost(reqURL);
            httpPost.setHeader("User-Agent",
    				"Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            HttpEntity entitySrc = new StringEntity(gsonStr, "UTF-8");
			httpPost.setEntity(entitySrc);
            HttpResponse response = httpClient.execute(httpPost); 
            HttpEntity entity = response.getEntity();
            if (null != entity) { 
                responseLength = entity.getContentLength(); 
                responseContent = EntityUtils.toString(entity, "UTF-8"); 
                EntityUtils.consume(entity);
            }
            System.out.println("请求地址: " + httpPost.getURI());
            System.out.println("响应状态: " + response.getStatusLine());
            System.out.println("响应长度: " + responseLength);
            System.out.println("响应内容: " + responseContent);
        } catch (KeyManagementException e) {
            e.printStackTrace(); 
        } catch (NoSuchAlgorithmException e) { 
            e.printStackTrace(); 
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        } catch (ClientProtocolException e) { 
            e.printStackTrace(); 
        } catch (ParseException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
            httpClient.getConnectionManager().shutdown();
            return responseContent; 
        }
    }	
	
}
