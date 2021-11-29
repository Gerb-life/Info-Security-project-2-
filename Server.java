
public class Server {
	static int secret_num = 3;
	static Encryption bob = new Encryption();
	
	public static double B = bob.Diffie_Helman(secret_num);
	
	public static void main (String [] args){
		System.out.println(B);
	}
}
