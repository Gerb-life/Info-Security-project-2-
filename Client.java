
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;


public class Client {
	
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
	/**
	public static SecretKey Diffie(PrivateKey priv , PublicKey pub) throws Exception {
		
		KeyAgreement key = KeyAgreement.getInstance("DiffieHellman");
		key.init(priv);
		key.doPhase(pub, true);
		SecretKey secret = key.generateSecret("RSA");
		return secret ;
		
	}
	 */       
	    
	public static byte[] genSig(String string) throws  Exception {
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initSign(genKeys().getPrivate());
		
		byte[] bytes = string.getBytes();
		
		sig.update(bytes);
		byte[] signature = sig.sign();
		return signature;
		
	}
	
	public static SecretKey getEncryptionKey() throws Exception { 
		KeyGenerator gen = KeyGenerator.getInstance("AES");
		gen.init(128);
		SecretKey secKey = gen.generateKey();
		return secKey;
	}
	
	public static byte []  Encrypt(String string, SecretKey secKey) throws Exception {
		
		Cipher c = Cipher.getInstance("AES");
		
		c.init(Cipher.ENCRYPT_MODE, secKey);
		byte [] plainText = string.getBytes();
		byte [] cipherText = c.doFinal(plainText);
		
		return cipherText;
	
		
	
}
	public static String Decrypt(byte[] cipherText , SecretKey secKey) throws Exception{
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, secKey);
		byte[] plainText = c.doFinal(cipherText);
		return new String(plainText);
	}
	
	

	
}
