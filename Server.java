import java.security.*;
import javax.crypto.*;


public class Server {
	
	public static KeyPair genKeys() throws Exception {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA"); 
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            
            return kp;      
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown : " + e);
        }
		return null;     
    }
	
	public static KeyPair Diffie() {
		 try {
	            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH"); 
	            kpg.initialize(1024);
	            KeyPair kp = kpg.generateKeyPair();
	            
	            return kp;       
		 }
	        catch (NoSuchAlgorithmException e) {
	        	System.out.println("Exception thrown : " + e);
	        }
			return null;      
	    }
	
	public static byte[] genSig(String string) throws InvalidKeyException, Exception {
		Signature sig = Signature.getInstance("SHA256withRSA");
		
		sig.initSign(genKeys().getPrivate());
		
		
		
		byte[] bytes = string.getBytes();
		
		sig.update(bytes);
		
		byte[] signature = sig.sign();
		
		return signature;
		
	}
	
	
}
