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
public class send_ajax_verify_code_account {
    
        private String verify_code;
        
        
        private String setverify_code = setverify_code();
       
       
        
        public String getverify_code() {
		return verify_code = setverify_code;
	}
	public void setverify_code(String verify_code) {
		this.verify_code = verify_code;
	}
    

       
        static EmyeCoDatabase analysis;

        
        
        private String span_verify_code= analysis.getspan_verify_code() ;
        
   
        
                
        
        
        
        public String getspan_verify_code() {
		return span_verify_code;
	}
	public void setspan_verify_code(String span_verify_code) {
		this.span_verify_code = span_verify_code;
	}
        
        
        
        
        @Override
	public String toString() {
            
		return "Account [ forgot_login_password_email=" + verify_code +
                        "]";
	}	
	
        
     
       
        
        
         
        public String setverify_code(){  
            AccountStock.setverify_code(verify_code);
           return verify_code = AccountStock.getverify_code();        
        } 
          
        
        
}
