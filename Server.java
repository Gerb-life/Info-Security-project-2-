import java.security.*;
import javax.crypto.*;


public class Server {
	
	public static KeyPair genKeys() throws Exception {
        try {
 
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA"); 
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            
            return kp;
            
        }
 
        catch (NoSuchAlgorithmException e) {
 
            System.out.println("Exception thrown : " + e);
        }
		return null;
		
        
    }
	public static void main (String[] args) throws Exception {
		
		Server Bob = new Server();
		PrivateKey privateKey = Bob.genKeys().getPrivate();
		PublicKey publicKey = Bob.genKeys().getPublic();
		System.out.println(publicKey);
		System.out.println(privateKey);
	}
	
	
}
