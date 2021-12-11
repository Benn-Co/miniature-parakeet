/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Stock analysis using Emye Co
 *
 * <p/>
 * 
 *
 * @author Karitu Pavilion
 *
 * Copyright 2019 @author Karitu . All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
@WebServlet(name = "send_ajax_sign_up_Servlet", urlPatterns = {"/send_ajax_sign_up_Servlet"})
public class send_ajax_sign_up_Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	// This will store all received articles
	List<send_ajax_sign_up_account> articles = new LinkedList<send_ajax_sign_up_account>();
	
	/***************************************************
	 * URL: /JSONservlet
	 * doPost(): receives JSON data, parse it, map it and send back as JSON
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
			System.out.println(json);
                     //   EmyeCoDatabase.read_sign_up_Json_Stirng(json);
		}
		
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
    	
		// 3. Convert received JSON to Article
		send_ajax_sign_up_account article = mapper.readValue(json, send_ajax_sign_up_account.class);

		// 4. Set response type to JSON
		response.setContentType("application/json");		    
    	
		// 5. Add article to List<Article>
		articles.add(article);

		// 6. Send List<Article> as JSON to client
		mapper.writeValue(response.getOutputStream(), articles);
	}
}
