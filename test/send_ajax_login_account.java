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
public class send_ajax_login_account {
    
        private String login_email;
        private String login_password;
        
        
        private String setlogin_email = setlogin_email();
        private String setlogin_password = setlogin_password();
       
       
        
        public String getlogin_email() {
		return login_email = setlogin_email;
	}
	public void setlogin_email(String login_email) {
		this.login_email = login_email;
	}public String getlogin_password() {
		return login_password = setlogin_password;
	}
	public void setlogin_password(String login_password) {
		this.login_password = login_password;
	}
    

       
        static EmyeCoDatabase analysis;

        
        
        private String span_login = analysis.getspan_login() ;
        
   
        
                
        
        
        
        public String getspan_login() {
		return span_login;
	}
	public void setspan_login(String span_login) {
		this.span_login = span_login;
	}
        
        
        
        
        @Override
	public String toString() {
            
		return "Account [ register_email=" + login_email +
                        ", register_password=" + login_password +
                        "]";
	}	
	
        
     
       
        
        
         
        public String setlogin_email(){  
            AccountStock.setlogin_email(login_email);
           return login_email = AccountStock.getlogin_email();        
        } 
        public String setlogin_password(){  
            AccountStock.setlogin_password(login_password);
           return login_password = AccountStock.getlogin_password();        
        }
        
        
        
}
