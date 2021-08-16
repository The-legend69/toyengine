package drivers.main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ToyComputeTaskRegistry {
  public static void main(String[] args) {
	  final String SERVER_NAME = "COMPUTE_ENGINE";
	
	  try {
		  Registry registry = LocateRegistry.getRegistry();
		  registry.lookup(SERVER_NAME);
		  System.out.println("Response: Connected to server");
	  } catch (Exception err) {
		  System.err.println("Client exception: " + err);
	  }
  }
}
