
public class Client {
	static int secret_num = 4 ;
	static Encryption alice = new Encryption();
	
	public static double A = alice.Diffie_Helman(secret_num);
	
	public static void main (String [] args){
		System.out.println(alice.Shared_key_Client());
	}
}
