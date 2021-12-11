package test;

import java.util.*;
import java.io.*;
import java.net.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.*;



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

public class EmyeCoDatabase{

    
          private static String json;
    
        //pass JSON String;
        public static void read_sign_up_Json_Stirng ( String json){            
		EmyeCoDatabase.json = json;
                
                try {
                // create a writer
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\sign_up.json"));

                // write json to file
                 bw.write(json);

                // close the writer
                 bw.close();
                 
                 //readJsonFile();

            } catch (IOException ex) {
                 ex.printStackTrace();
            }
            
                
                
                  
        try {
           // create a reader
           FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\sign_up.json");

           //create JsonObject instance
           JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                register_first_name = parser.get("register_first_name").getAsString();
                register_last_name = parser.get("register_last_name").getAsString();
                register_email = parser.get("register_email").getAsString();
                register_password = parser.get("register_password").getAsString();
                
    
            //close reader
            reader.close();

            } catch (Exception ex) {
            ex.printStackTrace();
            }
        
            main_span_sign_up();
            

      
            System.out.println(register_first_name + register_last_name + register_email + register_password );
        
            

        }
        
        
          
        public static void  main_span_sign_up(){
       MathRandom_span_verify_code = MathRandom.span_verify_code();
       
       System.out.println(MathRandom_span_verify_code);
       logo = 1;
       
       querry = "String register_first_name,String register_last_name,String register_email,String register_password";
       
       
       span_sign_up = "success..";
    
      }   
       
        
        
        
        //pass JSON String;
        public static void read_login_Json_Stirng ( String json){            
		EmyeCoDatabase.json = json;
                
                try {
                // create a writer
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\login.json"));

                // write json to file
                 bw.write(json);

                // close the writer
                 bw.close();
                 
                 //readJsonFile();

            } catch (IOException ex) {
                 ex.printStackTrace();
            }
            
                
                
                  
        try {
           // create a reader
           FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\login.json");

           //create JsonObject instance
           JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                login_email = parser.get("login_email").getAsString();
                login_password = parser.get("login_password").getAsString();
                 
    
            //close reader
            reader.close();

            } catch (Exception ex) {
            ex.printStackTrace();
            }
        
            main_span_login();
            

      
            System.out.println(login_email + login_password );
        
            

        }
        
        
          
        public static void  main_span_login(){
       
       
       querry = "String register_first_name,String register_last_name,String register_email,String register_password";
       
       
       span_login = "success..";
    
      }  
        
        
        
         //pass JSON String;
        public static void read_forgot_login_password_Json_Stirng ( String json){            
		EmyeCoDatabase.json = json;
                
                try {
                // create a writer
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\forgot_login_password.json"));

                // write json to file
                 bw.write(json);

                // close the writer
                 bw.close();
                 
                 //readJsonFile();

            } catch (IOException ex) {
                 ex.printStackTrace();
            }
            
                
                
                  
        try {
           // create a reader
           FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\forgot_login_password.json");

           //create JsonObject instance
           JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                forgot_login_password_email = parser.get("forgot_login_password_email").getAsString();
                login_password_forgot_login_password = parser.get("login_password_forgot_login_password").getAsString();
                 
    
            //close reader
            reader.close();

            } catch (Exception ex) {
            ex.printStackTrace();
            }
        
            main_span_forgot_login_password();
            

      
            System.out.println(forgot_login_password_email + login_password_forgot_login_password );
        
            

        }
        
        
          
        public static void  main_span_forgot_login_password(){
        MathRandom_span_verify_code = MathRandom.span_verify_code();
       
       System.out.println(MathRandom_span_verify_code);
             
       querry = "String register_first_name,String register_last_name,String register_email,String register_password";
       
       
       span_forgot_login_password_sign_in = "success..";
    
      }   
       
         
      //pass JSON String;
        public static void read_verify_code_Json_Stirng ( String json){            
		EmyeCoDatabase.json = json;
               
              
                try {
                // create a writer
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pavilion\\Documents\\Benn_Co\\verify_code.json"));

                // write json to file
                 bw.write(json);

                // close the writer
                 bw.close();
                 
                 //readJsonFile();

            } catch (IOException ex) {
                 ex.printStackTrace();
            }
            
                
                
                  
        try {
           // create a reader
           FileReader reader = new FileReader("C:\\Users\\Pavilion\\Documents\\Benn_Co\\verify_code.json");

           //create JsonObject instance
           JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

                verify_code = parser.get("verify_code").getAsInt();
          
                
            //close reader
            reader.close();

            } catch (Exception ex) {
            ex.printStackTrace();
            }
        
        
            main_verify_code();
            

      
            System.out.println(verify_code);
        
            

        }
        
        
          
        public static void  main_verify_code(){

           // MathRandom_span_verify_code = MathRandom.span_verify_code();
            System.out.println(MathRandom_span_verify_code);
       
       
       
       
       
       
      
       
       
       
       
       
       

       if (MathRandom_span_verify_code == verify_code){
       
       querry = "String register_first_name,String register_last_name,String register_email,String register_password";
       
       
       span_verify_code = "successful verification";
       }
       else {
              span_verify_code = "verification not successful..";

       }
       
       
       
     
       
       
       
    
      }   
       
        
        
       
      
      
        public static String getspan_verify_code() {
		return span_verify_code;
	}
        public void setspan_verify_code(String span_verify_code) {
		this.span_verify_code = span_verify_code;
	}
        
        
        
        public static String getspan_forgot_login_password_sign_in() {
		return span_forgot_login_password_sign_in;
	}
        public void setspan_forgot_login_password_sign_in(String span_forgot_login_password_sign_in) {
		this.span_forgot_login_password_sign_in = span_forgot_login_password_sign_in;
	}
        
        
        
      
        public static String getspan_sign_up() {
		return span_sign_up;
	}
        public void setspan_sign_up(String span_sign_up) {
		this.span_sign_up = span_sign_up;
	}
        
        
         
        public static String getspan_login() {
		return span_login;
	}
        public void setspan_login(String span_login) {
		this.span_login = span_login;
	}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
         
        static String register_first_name;
        static String register_last_name;
        static String register_email;
        static String register_password;
          
        static String login_email;
        static String login_password;
        
        static String forgot_login_password_email;
        static String login_password_forgot_login_password;
       
        static int verify_code;
        
        
       
         
       
       
    
    
        static  private String span_sign_up = "";
        static  private String  span_login = "";
        static  private String  span_forgot_login_password_sign_in = "";
        static  private String span_verify_code = "";

        
        
        
        
        
        
    static int MathRandom_span_verify_code = MathRandom.span_verify_code();;
    static boolean verify;
    static String querry;
    static int logo = 0;

    public static void querry (String querry){
    
    }




    
   
 
  
   
 public static void main(String []args){


main_span_sign_up();
main_span_login();

 }
    
 
  
  

}