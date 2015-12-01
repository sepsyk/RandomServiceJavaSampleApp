package com.web.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.utils.HttpUtils;
import com.utils.RandUtils;;

public class RandomServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String reverseServiceEndpoint = null;		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        
        String requestBody = HttpUtils.readRequestBody(request.getInputStream());
        JSONObject jsonObject = new JSONObject(requestBody);
                
        //read reverse service hostname from properties file (lazy init)
        readReverseServiceHost();
        //send this message to the reverse service         
		String reverseMessage = HttpUtils.sendPost(reverseServiceEndpoint, jsonObject).getString("message");
		        
        JSONObject responseObject = new JSONObject();
        responseObject.append("rand", RandUtils.randomize());
        responseObject.append("message", reverseMessage);
        
        response.getWriter().print(responseObject.toString());
        response.getWriter().flush();
    }		
	
	private String readReverseServiceHost(){
		if(reverseServiceEndpoint == null){					
			Properties properties = new Properties();
			try {			
				properties.load(getServletContext().getResourceAsStream("/WEB-INF/reverseservice.properties"));
				reverseServiceEndpoint = properties.getProperty("service.endpoint");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return reverseServiceEndpoint;
	}
	
	
}
