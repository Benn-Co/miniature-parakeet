/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;

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

public class EmyecoStockAnalysis {
    
    public static double percent_change_since_open = 0.2;
    public static double percent_change_from_day_low = 0.4;
    public static double percent_change_from_day_high =0.1;
    
    String stock_data ="";
    
    
    
   
    
    
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
   
     // static String nae;
      private static String price_open;
      private static String price;
      private static String close_yesterday;
      private static String options;
    
      private static String given_value = "option";
      private static String predicted_value ="AI option";
      private static String error = "";
      
      static private String results = "Option " + getGiven_value() + " : " + "AI option " + getPredicted_value();
      
      
      
      
      
      
      public static void main(){
          
       
          new EmyecoStockAnalysis();
      
      }
      
      
      
      
      
      
      
      
        
        
        
        
        
        public static void main(String[] args){
        
            new EmyecoStockAnalysis();
        
        }
        
      
        
        
        //pass JSON String;
      //  public static void readJsonStirng ( String json){            
        
       //     new EmyecoStockAnalysis(json);            
       // }
       
        
        
      
      
      
      
      public EmyecoStockAnalysis(){
          
         // writeJsonFile();
          //readJsonFile();
          
          //options = action;
          
          new Arithmetic();

          predict();
          
          System.out.println(Arithmetic.percent_change_since_open + Arithmetic.percent_change_from_day_low + Arithmetic.percent_change_from_day_high + Arithmetic.articleoptions + "\nstock data " + Arithmetic.stock_data);
      
      }
      
      
      
      
      
      
      
      public void predict(){
           // this.setsell(percent_change_since_open);
           // this.setstatic_price (percent_change_from_day_low);
           // this.setbuy(percent_change_from_day_high);
           // this.setyour_prediction(action);
          
          try{
              
           // this.mainWrite();
            
            //stock_data = this.getstock_data();
             mainRead();
              
          }
          catch(Exception e){
              
              System.out.println(e);
          }
           

      }
      
      
      
     
      public static String getGiven_value(){
      
          return given_value;
      }
      public static String getPredicted_value(){
      
          return predicted_value;
      }
      public static String getError(){
      
          return error;
      }
      
      
      
      public static String getresults(){
      
          return results;
      }
      
      
      
      public  void setGiven_value(String given_value){
      
          this.given_value = given_value;
      }
      public void setPredicted_value(String predicted_value){
      
          this.predicted_value = predicted_value;
      }
      public void setError(String error){
      
          this.error = error;
      }
      
    

	/**
	// * @param args
	 * @throws Exception 
	 */
     // EmyecoWriteJson writeJson = new EmyecoWriteJson(); 
      
      
      
          
      

	public void mainRead() throws Exception {
            //this.mainWrite();
                
           // System.out.println(stock_data);


		Instances training_data = new Instances(
                new BufferedReader(                      
                         
                      new FileReader("C:\\Users\\Pavilion\\Documents\\GitHub\\emyeco\\test_data\\stock_training_data.arff")));
		training_data.setClassIndex(training_data.numAttributes() - 1);

		Instances testing_data = new Instances(
                new BufferedReader(
                      new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\stock_data.arff")));
		testing_data.setClassIndex(training_data.numAttributes() - 1);

		String summary = training_data.toSummaryString();
		int number_samples = training_data.numInstances();
		int number_attributes_per_sample = training_data.numAttributes();
        System.out.println("Number of attributes in model = " + number_attributes_per_sample);
        System.out.println("Number of samples = " + number_samples);
        System.out.println("Summary: " + summary);
        System.out.println();
        
        // a classifier for decision trees:
        J48 j48 = new J48();
        
        // filter for removing samples:
        Remove rm = new Remove();
        rm.setAttributeIndices("1");  // remove 1st attribute

        // filtered classifier
        FilteredClassifier fc = new FilteredClassifier();
       
        fc.setFilter(rm);
        fc.setClassifier(j48);
        // train using stock_training_data.arff:
        fc.buildClassifier(training_data);
        // test using stock_testing_data.arff:
        for (int i = 0; i < testing_data.numInstances(); i++) {
          double pred = fc.classifyInstance(testing_data.instance(i));
         // given_value = "given value: " + testing_data.classAttribute().value((int)testing_data.instance(i).classValue());
         //setGiven_value(testing_data.classAttribute().value((int)testing_data.instance(i).classValue())); 
         given_value = testing_data.classAttribute().value((int)testing_data.instance(i).classValue());
          System.out.print("given value: " + getGiven_value());
         // predicted_value = ". predicted value: " + testing_data.classAttribute().value((int) pred);
         //setPredicted_value(testing_data.classAttribute().value((int) pred)); 
         predicted_value =testing_data.classAttribute().value((int) pred);
          System.out.println(" predicted value: " + getPredicted_value());
          //value.setpredicted_value(getPredicted_value());
         // value.setgiven_value(getGiven_value());
         // new JsonWrite();
          
          //writeJson.writeEmyecoStockPredictions(predicted_value, given_value);
        }

	}

}

