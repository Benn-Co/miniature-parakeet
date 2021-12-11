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
public class send_ajax_sign_up_account {
    
        private String register_first_name;
        private String register_last_name;
        private String register_email;
        private String register_password;
        
        
        private String setregister_first_name = setregister_first_name();
        private String setregister_last_name = setregister_last_name();
        private String setregister_email = setregister_email();
        private String setregister_password = setregister_password();
       
       
        
        public String getregister_first_name() {
		return register_first_name = setregister_first_name;
	}
	public void setregister_first_name(String register_first_name) {
		this.register_first_name = register_first_name;
	}public String getregister_last_name() {
		return register_last_name = setregister_last_name;
	}
	public void setregister_last_name(String register_last_name) {
		this.register_last_name = register_last_name;
	}public String getregister_email() {
		return register_email = setregister_email;
	}
	public void setregister_email(String register_email) {
		this.register_email = register_email;
	}public String getregister_password() {
		return register_password = setregister_password;
	}
	public void setregister_password(String register_password) {
		this.register_password = register_password;
	}
    

       
        static EmyeCoDatabase analysis;

        
        
        private String span_sign_up = analysis.getspan_sign_up() ;
        
   
        
                
        
        
        
        public String getspan_sign_up() {
		return span_sign_up;
	}
	public void setspan_sign_up(String span_sign_up) {
		this.span_sign_up = span_sign_up;
	}
        
        
        
        
        @Override
	public String toString() {
            
		return "Account [ register_first_name=" + register_first_name +
                        ", register_last_name=" + register_last_name +
                        ", register_email=" + register_email +
                        ", register_password=" + register_password +
                        ", span_sign_up=" + span_sign_up +
                        "]";
	}	
	
        
     
       
        
        
        public String setregister_first_name(){  
            AccountStock.setregister_first_name(register_first_name);
           return register_first_name = AccountStock.getregister_first_name();        
        } 
        public String setregister_last_name(){  
            AccountStock.setregister_last_name(register_last_name);
           return register_last_name = AccountStock.getregister_last_name();        
        } 
        public String setregister_email(){  
            AccountStock.setregister_email(register_email);
           return register_email = AccountStock.getregister_email();        
        } 
        public String setregister_password(){  
            AccountStock.setregister_password(register_password);
           return register_password = AccountStock.getregister_password();        
        }
        
        
        
}
