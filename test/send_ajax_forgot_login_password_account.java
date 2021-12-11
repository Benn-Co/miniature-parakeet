/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class send_ajax_forgot_login_password_account {
    
        private String forgot_login_password_email;
        private String login_password_forgot_login_password;
        
        
        private String setforgot_login_password_email = setforgot_login_password_email();
        private String setlogin_password_forgot_login_password = setlogin_password_forgot_login_password();
       
       
        
        public String getforgot_login_password_email() {
		return forgot_login_password_email = setforgot_login_password_email;
	}
	public void setforgot_login_password_email(String forgot_login_password_email) {
		this.forgot_login_password_email = forgot_login_password_email;
	}public String getlogin_password_forgot_login_password() {
		return login_password_forgot_login_password = setlogin_password_forgot_login_password;
	}
	public void setlogin_password(String login_password_forgot_login_password) {
		this.login_password_forgot_login_password = login_password_forgot_login_password;
	}
    

       
        static EmyeCoDatabase analysis;

        
        
        private String span_forgot_login_password_sign_in = analysis.getspan_forgot_login_password_sign_in() ;
        
   
        
                
        
        
        
        public String getspan_forgot_login_password_sign_in() {
		return span_forgot_login_password_sign_in;
	}
	public void setspan_forgot_login_password_sign_in(String span_forgot_login_password_sign_in) {
		this.span_forgot_login_password_sign_in = span_forgot_login_password_sign_in;
	}
        
        
        
        
        @Override
	public String toString() {
            
		return "Account [ forgot_login_password_email=" + forgot_login_password_email +
                        ", login_password_forgot_login_password=" + login_password_forgot_login_password +
                        "]";
	}	
	
        
     
       
        
        
         
        public String setforgot_login_password_email(){  
            AccountStock.setforgot_login_password_email(forgot_login_password_email);
           return forgot_login_password_email = AccountStock.getforgot_login_password_email();        
        } 
        public String setlogin_password_forgot_login_password(){  
            AccountStock.setlogin_password_forgot_login_password(login_password_forgot_login_password);
           return login_password_forgot_login_password = AccountStock.getlogin_password_forgot_login_password();        
        }
        
        
        
}
