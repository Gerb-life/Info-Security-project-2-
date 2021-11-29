import java.math.*;
public class Encryption {
	static int prime = 23;
	static int base = 5;
	static double Diffie_Helman (int secret){
		
		
		double key = Math.pow(base,secret);
		double shared_key = key % prime;
		
		return shared_key;
}
	static double Shared_key_Client (){
		
		double key = Math.pow(Server.B, Client.secret_num);
		double shared_key = key % prime;
		return shared_key;
		
	}
	
	static double shared_key_Server(){
		
		double key = Math.pow(Client.A , Server.secret_num);
		double shared_key = key % prime;
		return shared_key;
	}
}