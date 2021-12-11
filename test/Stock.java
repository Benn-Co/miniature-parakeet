/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * Stock analysis using benn_co.ai
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
 public class Stock{
     
        
        private static String predicted_value;

        public static String your_prediction;
        
        private static String given_value;
        
        private static String url = "/url";

        private static String json;
        
        
        
        
        
        public static void seturl(){
            url = predict();
        
        }
        
        public static String geturl(){
            return url;
        
        }
        
        
        
        public static String getgiven_value() {
		return given_value;
	}
	public void setgiven_value(String given_value) {
		this.given_value = given_value;
	}
        public static String getpredicted_value() {
		return predicted_value;
	}
	public void setpredicted_value(String predicted_value) {
		this.predicted_value = predicted_value;
	}
        
        static EmyecoStockAnalysis stocks;       
 
        public static String predict(){
               stocks.main();
               predicted_value = stocks.getPredicted_value();
               your_prediction = stocks.getresults();
               given_value = stocks.getGiven_value();
               
               return "/#";
        }
       
        
}