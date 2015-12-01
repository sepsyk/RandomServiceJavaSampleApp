package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class HttpUtils {
	
	public static JSONObject sendPost(String url, JSONObject json) throws ServletException {
		try{	
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			StringEntity body =new StringEntity(json.toString());
			post.addHeader("content-type", "application/x-www-form-urlencoded");
			post.setEntity(body);
			
	        HttpResponse response = client.execute(post);		        		
	        String jsonResponse = readRequestBody(response.getEntity().getContent());
	        
	        return new JSONObject(jsonResponse);
		} catch(Exception e){
			throw new ServletException(e);
		}
	}
	
	public static String readRequestBody(InputStream in) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;

        StringBuilder responseData = new StringBuilder();
        while((line = reader.readLine()) != null) {
            responseData.append(line);
        }
        return responseData.toString();
	}

}
