/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Arithmetic {
    
    public static double percent_change_since_open = 0;
    public static double percent_change_from_day_low = 0;
    public static double percent_change_from_day_high =0;
    
      static double articleprice = 0.0;
      static double articleprice_open = 0.0;
      static double articleday_high= 0.0;
      static double articleday_low= 0.0;
      static String articleoptions = "";
      
      private static double sell  = 0.0;
      private static double static_price = 0.0;
      private static double buy = 0.0;
      private static String your_prediction = "";

      static String stock_data = "" ;

    
   
      
      
      
      
    
 public static void main(String[] args) {
 
     new  Arithmetic();
     
 }
 
 
   public Arithmetic(){
       
       
       
       try {
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
            
       
       
       
       
       
       try{
         // create a reader
   FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\data.json");

    //create JsonObject instance
    JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                articleprice = parser.get("price").getAsDouble();
                articleprice_open = parser.get("price_open").getAsDouble();
                articleday_high = parser.get("day_high").getAsDouble();
                articleday_low = parser.get("day_low").getAsDouble();
                
                articleoptions = parser.get("options").getAsString();
              
                 
    
    //close reader
    reader.close();
     } catch (IOException ex) {
                 ex.printStackTrace();
            }
        
       
       
     main();
     
     
   }
    /**
     * @param args the command line arguments
     */
    public static void main() {
        
        double change_since_opendiff = articleprice_open - articleprice;
        double change_since_opendiv = change_since_opendiff/articleprice;
        percent_change_since_open = change_since_opendiv*100;
        sell  = percent_change_since_open;
        System.out.println("percent_change_since_open " + percent_change_since_open);
       
        double change_from_day_lowdiff = articleprice - articleday_low;
        double change_from_day_lowdiv = change_from_day_lowdiff/articleprice;
        percent_change_from_day_low = change_from_day_lowdiv*100;   
        static_price = percent_change_from_day_low;
        System.out.println("percent_change_from_day_low " + percent_change_from_day_low);
 
        double change_from_day_highdiff = articleprice - articleday_high;
        double change_from_day_highdiv = change_from_day_highdiff/articleprice;
        percent_change_from_day_high = change_from_day_highdiv*100;
        buy = percent_change_from_day_high;
        System.out.println("percent_change_from_day_high " + percent_change_from_day_high + " \narticleoptions " + articleoptions + " stock_data " + stock_data);

        your_prediction = articleoptions;
        stock_data = getstock_data();
        // TODO code application logic here
    }
    
    
      
      
      
      public void setsell(double sell){
          this.sell = sell;
      }
      public void setstatic_price(double static_price){
          this.static_price = static_price;
      }
      public void setbuy(double buy){
          this.buy = buy;
      }
      public void setyour_prediction(String your_prediction){
          this.your_prediction = your_prediction;
      }
      
       
    
    /**
     * @param args the command line arguments
     */
      
     public static String getstock_data(){
      
         mainWrite();
         
         return stock_data;
     
     } 
    public static void mainWrite() {
        // TODO code application logic here
         //Write ARFF file
        
        try (FileWriter file = new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\stock_data.arff")) {
            stock_data = "@relation stock" + "\n" + 
                                "\n" + 
                                "@attribute percent_change_since_open real" + "\n" +
                                "@attribute percent_change_from_day_low real" + "\n" +
                                "@attribute percent_change_from_day_high real" + "\n" +
                                "@attribute action {buy, sell, hold}" + "\n" +
                                "\n" +
                                "@data" + "\n" +
                                sell + "," + static_price + "," + buy + "," + your_prediction ;
            file.write(stock_data);
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
