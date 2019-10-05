package state;

/* testing the jelly bean monitor */

import java.rmi.*;

public class JellyBeanMonitorTest {

	public static void main(String[] args) {
		String[] location = {"rmi://santafe.jellybelly.com/jellyBeanMachine",
		                     "rmi://boulder.jellybelly.com/jellyBeanMachine",
		                     "rmi://seattle.jellybelly.com/jellyBeanMachine"}; 
		
		JellybeanMonitor[] monitor = new JellybeanMonitor[location.length];
		
		
		for (int i=0;i < location.length; i++) {
			try {
           		JellyBeanMachineRemote machine = 
						(JellyBeanMachineRemote) Naming.lookup(location[i]);
           		monitor[i] = new JellybeanMonitor(machine);
				System.out.println(monitor[i]);
        	} catch (Exception e) {
            	e.printStackTrace();
        	}
		}
 
		for(int i=0; i < monitor.length; i++) {
			monitor[i].report();
		}
	}
}
