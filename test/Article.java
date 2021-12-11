/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.*;

import java.io.*;
import java.util.*;

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
public class Article {
        private String title;
        private String symbol;
        private String name;
        private String currency;
        private String price;
        private String price_open;
        private String day_high;
        private String day_low;
        private String week_high;
        private String week_low;
        private String day_change;
        private String change_pct;
        private String close_yesterday;
        private String market_cap;
        private String volume;
        private String volume_avg;
        private String shares;
        private String stock_exchange_long;
        private String stock_exchange_short;
        private String timezone;
        private String timezone_name;
        private String gmt_offset;
        private String last_trade_time;
        private String pe;
        private String eps;
        private String options;
        private String url;
        private String seturl = seturl();
        private String ai_options;
     
      
        
        
        public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
        
        public String getsymbol() {
		return symbol;
	}
	public void setsymbol(String symbol) {
		this.symbol = symbol;
	}
        public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
        public String getcurrency() {
		return currency;
	}
	public void setcurrency(String currency) {
		this.currency = currency;
	}
        public String getprice() {
		return price;
	}
	public void setprice(String price) {
		this.price = price;
	}
        public String getprice_open() {
		return price_open;
	}
	public void setprice_open(String price_open) {
		this.price_open = price_open;
	}
        public String getday_high() {
		return day_high;
	}
	public void setday_high(String day_high) {
		this.day_high = day_high;
	}
        public String getday_low() {
		return day_low;
	}
	public void setday_low(String day_low) {
		this.day_low = day_low;
	}
        public String getweek_high() {
		return week_high;
	}
	public void setweek_high(String week_high) {
		this.week_high = week_high;
	}
        public String getweek_low() {
		return week_low;
	}
	public void setweek_low(String week_low) {
		this.week_low = week_low;
	}
        public String getday_change() {
		return day_change;
	}
	public void setday_change(String day_change) {
		this.day_change = day_change;
	}
        public String getchange_pct() {
		return change_pct;
	}
	public void setchange_pct(String change_pct) {
		this.change_pct = change_pct;
	}
        public String getclose_yesterday() {
		return close_yesterday;
	}
	public void setclose_yesterday(String close_yesterday) {
		this.close_yesterday = close_yesterday;
	}
        public String getmarket_cap() {
		return market_cap;
	}
	public void setmarket_cap(String market_cap) {
		this.market_cap = market_cap;
	}
        public String getvolume() {
		return volume;
	}
	public void setvolume(String volume) {
		this.volume = volume;
	}
        public String getvolume_avg() {
		return volume_avg;
	}
	public void setvolume_avg(String volume_avg) {
		this.volume_avg = volume_avg;
	}
        public String getshares() {
		return shares;
	}
	public void setshares(String shares) {
		this.shares = shares;
	}
        public String getstock_exchange_long() {
		return stock_exchange_long;
	}
	public void setstock_exchange_long(String stock_exchange_long) {
		this.stock_exchange_long = stock_exchange_long;
	}
        public String getstock_exchange_short() {
		return stock_exchange_short;
	}
	public void setstock_exchange_short(String stock_exchange_short) {
		this.stock_exchange_short = stock_exchange_short;
	}
        public String gettimezone() {
		return timezone;
	}
	public void settimezone(String timezone) {
		this.timezone = timezone;
	}
        public String gettimezone_name() {
		return timezone_name;
	}
	public void settimezone_name(String timezone_name) {
		this.timezone_name = timezone_name;
	}
        public String getgmt_offset() {
		return gmt_offset;
	}
	public void setgmt_offset(String gmt_offset) {
		this.gmt_offset = gmt_offset;
	}
        public String getlast_trade_time() {
		return last_trade_time;
	}
	public void setlast_trade_time(String last_trade_time) {
		this.last_trade_time = last_trade_time;
	}
        public String getpe() {
		return pe;
	}
	public void setpe(String pe) {
		this.pe = pe;
	}
        public String geteps() {
		return eps;
	}
	public void seteps(String eps) {
		this.eps = eps;
	}
        public String getoptions() {
		return options;
	}
	public void setoptions(String options) {
		this.options = options;
	}
        public String geturl() {
		return url = seturl;
	}
	public void seturl(String url) {
		this.url = url;
	}
        public String getai_options() {
		return ai_options;
	}
	public void setai_options(String ai_options) {
		this.ai_options = ai_options;
	}
        
        
        
        
        
        
        
	@Override
	public String toString() {
            
		return "Article [ title=" + title +
                        ", symbol=" + symbol +
                        ", name=" + name +
                        ", currency=" + currency +
                        ", price=" + price +
                        ", price_open=" + price_open +
                        ", day_high=" + day_high +
                        ", day_low=" + day_low +
                        ", week_high=" + week_high +
                        ", week_low=" + week_low +
                        ", day_change=" + day_change +
                        ", change_pct=" + change_pct +
                        ", close_yesterday=" + close_yesterday +
                        ", market_cap=" + market_cap +
                        ", volume=" + volume +
                        ", volume_avg=" + volume_avg +
                        ", shares=" + shares +
                        ", stock_exchange_long=" + stock_exchange_long +
                        ", stock_exchange_short=" + stock_exchange_short +
                        ", timezone=" + timezone +
                        ", timezone_name=" + timezone_name +
                        ", gmt_offset=" + gmt_offset +
                        ", last_trade_time=" + last_trade_time +
                        ", pe=" + pe +
                        ", eps=" + eps +
                        ", options=" + given_value +
                        ", url=" + url +                       
                        ", ai_options=" + predicted_value +
                        "]";
	}	
	
        
       static Stock analysis;
        
        private String predicted_value = analysis.getpredicted_value();
               
        public String your_prediction = analysis.your_prediction;//stocks.results;
        
        private String given_value = analysis.getgiven_value();
        
        
        
        
        
        public String getgiven_value() {
		return given_value;
	}
	public void setgiven_value(String given_value) {
		this.given_value = given_value;
	}
        public String getpredicted_value() {
		return predicted_value;
	}
	public void setpredicted_value(String predicted_value) {
		this.predicted_value = predicted_value;
	}
        
        
     
        
        //Replace duplicate url
        public String seturl(){  
           Stock.seturl();
           return url = Stock.geturl();        
        }
        
        
        
        
        
        
        
        
        
      static String articlesymbol;
      static String articlename;
      static String articlecurrency;
      static int articleprice =5;
      static int articleprice_open =21;
      static int articleday_high=21;
      static int articleday_low=21;
      static String articleweek_high;
      static String articleweek_low;
      static String articleday_change;
      static String articlechange_pct;
      static String articleclose_yesterday;// ="-0.2";
      static String articlemarket_cap;
      static String articlevolume;
      static String articlevolume_avg;
      static String articleshares;
      static String articlestock_exchange_long;
      static String articlestock_exchange_short;
      static String articletimezone;
      static String articletimezone_name;
      static String articlegmt_offset;
      static String articlelast_trade_time;
      static String articlepe;
      static String articleeps;
      static String articleoptions ="sell";
      static String articleai_options;
      static String articleurl;
   
        
        
        
        
        
        
        
        
        
        
       static String json;
    
        //pass JSON String;
        public static void read_Json_Stirng ( String json){            
		Article.json = json;
                
              /**  try {
                // create a writer
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\data.json"));

                // write json to file
                 bw.write(Article.json);

                // close the writer
                 bw.close();
                 
                 //readJsonFile();

            } catch (IOException ex) {
                 ex.printStackTrace();
            }
            
                
           */     
           /**       
           try {
           // create a reader
           FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\data.json");

          //create JsonObject instance
           JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                articlesymbol = parser.get("symbol").getAsString();
                articlename = parser.get("name").getAsString();
                articlecurrency = parser.get("currency").getAsString();
                articleprice = parser.get("price").getAsInt();
                articleprice_open = parser.get("price_open").getAsInt();
                articleday_high = parser.get("day_high").getAsInt();
                articleday_low = parser.get("day_low").getAsInt();
                articleweek_high = parser.get("week_high").getAsString();
                articleweek_low = parser.get("week_low").getAsString();
                articleday_change = parser.get("day_change").getAsString();
                articlechange_pct = parser.get("change_pct").getAsString();
                articleclose_yesterday = parser.get("close_yesterday").getAsString();
                articlemarket_cap = parser.get("market_cap").getAsString();
                articlevolume = parser.get("volume").getAsString();
                articlevolume_avg = parser.get("volume_avg").getAsString();
                articleshares = parser.get("shares").getAsString();
                articlestock_exchange_long = parser.get("stock_exchange_long").getAsString();
                articlestock_exchange_short = parser.get("stock_exchange_short").getAsString();
                articletimezone = parser.get("timezone").getAsString();
                articletimezone_name = parser.get("timezone_name").getAsString();
                articlegmt_offset = parser.get("gmt_offset").getAsString();
                articlelast_trade_time = parser.get("last_trade_time").getAsString();
                articlepe = parser.get("pe").getAsString();
                articleeps = parser.get("eps").getAsString();
                articleoptions = parser.get("options").getAsString();
                articleai_options = parser.get("ai_options").getAsString();
                articleurl = parser.get("url").getAsString();
    
              //close reader
              reader.close();

            } catch (Exception ex) {
            ex.printStackTrace();
            }
           */
           
        }
      
      
      
        
        
}
