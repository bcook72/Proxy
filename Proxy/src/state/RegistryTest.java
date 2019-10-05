package state;

/* Tests the registry */

import java.rmi.*;

public class RegistryTest {
 
	public static void main(String[] args) {
		JellyBeanMachineRemote jellyBeanMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("JellyBeanMachine <name> <inventory>");
 			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);

			jellyBeanMachine = 
				new JellyBeanMachine(args[0], count);
			Naming.rebind("//" + args[0] + "/jellybeanmachine", jellyBeanMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}