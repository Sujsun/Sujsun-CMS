package com.sujsun.cms.util;

import java.security.MessageDigest;
import java.util.logging.Logger;

import com.sujsun.cms.services.ContactService;

public class MD5HashUtil {
	
	private static final Logger log = Logger.getLogger( MD5HashUtil.class.getName() );
	
	public static String encode( String plainString ) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update( plainString.getBytes() );
            byte[] bytes = md.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
            	stringBuilder.append( Integer.toString( ( bytes[i] & 0xff ) + 0x100, 16 ).substring( 1 ) );
            }
            generatedPassword = stringBuilder.toString();
        }
        catch( Exception exception ) {
        	log.severe( "Exception while encoding to MD5 Hash. Exception message : " + exception.getMessage() );
        	exception.printStackTrace();
        }
        return generatedPassword;
    }
	
}
