package drivers.main;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ToyComputeTaskRegistry {
	private static  final String SERVER_NAME = "COMPUTE_ENGINE";
	
	public static void main(String[] args) {
		
		try {
		  Registry registry = LocateRegistry.getRegistry();
		  ToyComputeEngine engine = new ToyComputeEngine();
		  registry.lookup(SERVER_NAME);
		  System.out.println("Response: Connected to server");
			
		  AddToyPrice task = new AddToyPrice();
		  BigDecimal pi = engine.executeTask(task);
			
		  System.out.println(pi);
	  
		} catch (Exception err) {
		 
		  System.err.println("Client exception: " + err);
	  
		}
  }
}
