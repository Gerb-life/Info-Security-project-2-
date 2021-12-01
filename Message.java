import java.security.*;


public class Message {
	public static void main (String[] args) throws Exception {
		Server Bob = new Server();
		Client Alice = new Client();
		
		
		PrivateKey serverPrivateKey = Bob.genKeys().getPrivate();
		PublicKey serverPublicKey = Bob.genKeys().getPublic();
		
		PrivateKey clientPrivateKey = Alice.genKeys().getPrivate();
		PublicKey clientPublicKey = Alice.genKeys().getPublic();
		
		
		PublicKey sharedKey = Alice.Diffie().getPublic();
		
		String clientMessage = "aaaaaaaaaa";
		System.out.println(Alice.genSig(clientMessage));
		
		String serverMessage = "bbbbb";
		System.out.println(Bob.genSig(serverMessage));
		
		System.out.println(Alice.Encrypt(clientMessage, clientPrivateKey));
		
	}	
}
