package drivers.main;

import drivers.interfaces.Compute;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ToyComputeEngine extends UnicastRemoteObject implements Compute {
	
	public ToyComputeEngine() throws RemoteException {
		super();
	}

  public static void main(String[] args) throws RemoteException {
	  final String SERVER_NAME = "COMPUTE_ENGINE";
	  
	  LocateRegistry.createRegistry(1099);
	
	  try {
		  ToyComputeEngine engine = new ToyComputeEngine();
		  Registry registry = LocateRegistry.getRegistry();
		  registry.rebind(SERVER_NAME, engine);
		  System.out.println("Server ready");
	  } catch (Exception err) {
		  System.out.println("Server exception: " + err);
	  }
  }
}
