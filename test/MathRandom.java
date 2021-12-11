
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
public class MathRandom {

    /**
     * @return port number in five significant figures
     */
    public static int port() {
        double port = Math.random()*10000;
        int portNo = (int)port;
        return portNo;
       
        // TODO code application logic here
    }
    
    public static int span_verify_code(){
        
        double code = Math.random()*10000;
        int verify_code = (int)code;
        return verify_code;
    
    }    
}
