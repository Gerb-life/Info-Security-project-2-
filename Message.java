import java.security.*;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class Message {
public static byte[] Diffie(PrivateKey priv , PublicKey pub) throws Exception {
		
		KeyAgreement key = KeyAgreement.getInstance("DH");
		key.init(priv);
		key.doPhase(pub, true);
		byte[] secret = key.generateSecret();
		return secret ;
		
	}
	    
	public static void main (String[] args) throws Exception {
		Server Bob = new Server();
		Client Alice = new Client();
		
		PublicKey serverPub = Bob.genKeys().getPublic();
		PrivateKey serverPriv = Bob.genKeys().getPrivate();
		
		PublicKey clientPub = Alice.genKeys().getPublic();
		PrivateKey clientPriv = Alice.genKeys().getPrivate();
		
		
		SecretKey sharedKey = Alice.getEncryptionKey();
		
		byte[] cipherText = Alice.Encrypt("aaaaa", sharedKey);
		
		System.out.println(Alice.Decrypt(cipherText, sharedKey));
		
		
	}
}
