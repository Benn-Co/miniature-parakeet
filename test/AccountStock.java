
package test;
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
 public class AccountStock{
    // static Article data;
     
     
        private static String register_first_name;
        private static String register_last_name;
        private static String register_email;
        private static String register_password;
        private static String forgot_login_password_email;
        private static String login_password_forgot_login_password;
        private static String login_email;
        private static String login_password;
        private static String verify_code;
        
        
        
        public static void setregister_first_name(String register_first_name){
            AccountStock.register_first_name = register_first_name;
        
        }
        
        public static String getregister_first_name(){
            return register_first_name;
        
        }
        public static void setregister_last_name(String register_last_name){
            AccountStock.register_last_name = register_last_name;
        
        }
        
        public static String getregister_last_name(){
            return register_last_name;
        
        }
        public static void setregister_email(String register_email){
            AccountStock.register_email = register_email;
        
        }
        
        public static String getregister_email(){
            return register_email;
        
        }
        public static void setregister_password(String register_password){
            AccountStock.register_password = register_password;
        
        }
        
        public static String getregister_password(){
            return register_password;
        
        }
        
        
        
        
        public static void setlogin_email(String login_email){
            AccountStock.login_email = login_email;
        
        }
        
        public static String getlogin_email(){
            return login_email;
        
        }
        public static void setlogin_password(String login_password){
            AccountStock.login_password = login_password;
        
        }
        
        public static String getlogin_password(){
            return login_password;
        
        }
        
        
        
           
        
        
       public static void setforgot_login_password_email(String forgot_login_password_email){
            AccountStock.forgot_login_password_email = forgot_login_password_email;
        
        }
        
        public static String getforgot_login_password_email(){
            return forgot_login_password_email;
        
        }
        public static void setlogin_password_forgot_login_password(String login_password_forgot_login_password){
            AccountStock.login_password_forgot_login_password = login_password_forgot_login_password;
        
        }
        
        public static String getlogin_password_forgot_login_password(){
            return login_password_forgot_login_password;
        
        }
        
        
        
        
        public static void setverify_code(String verify_code){
            AccountStock.verify_code = verify_code;
        
        }
        
        public static String getverify_code(){
            return verify_code;
        
        }
        
        
        
        
        
        
        
        
        
       static private String span_sign_up;// = analysis.getpredicted_value();
       
        
        
        
         static EmyeCoDatabase emyeco_database_stocks;       
 
         
        
        
          
          
           public static String span_sign_up_predict(){
               emyeco_database_stocks.main_span_sign_up();
               span_sign_up = emyeco_database_stocks.getspan_sign_up();
               
               return span_sign_up;
        }
           
           
           
        
        
        
        
        
        public static String getspan_sign_up() {
		return span_sign_up;
	}
        public void setspan_sign_up(String span_sign_up) {
		this.span_sign_up = span_sign_up_predict();
	}
	
        
     
        
       
       
}