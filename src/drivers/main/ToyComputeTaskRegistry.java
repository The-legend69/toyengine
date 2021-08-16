package drivers.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ToyComputeTaskRegistry {
	private static  final String SERVER_NAME = "COMPUTE_ENGINE";
	
	public static void main(String[] args) {
		
		try {
		  Registry registry = LocateRegistry.getRegistry();
		  registry.lookup(SERVER_NAME);
		  System.out.println("Response: Connected to server");
	  
		} catch (Exception err) {
		 
		  System.err.println("Client exception: " + err);
	  
		}
  }
}
