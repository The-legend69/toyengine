package drivers.main;

import drivers.interfaces.Compute;
import drivers.interfaces.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ToyComputeEngine extends UnicastRemoteObject implements Compute {
	private static  final String SERVER_NAME = "COMPUTE_ENGINE";
	
	public ToyComputeEngine() throws RemoteException {
		super();
	}
	
	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

  	public static void main(String[] args) throws RemoteException {
	  
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
