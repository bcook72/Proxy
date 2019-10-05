package state;

/* This estailishes the Jelly bean machine monitor */

import java.rmi.*;

public class JellybeanMonitor {
	JellyBeanMachineRemote jellyBeanMachine;
 
	public JellybeanMonitor(JellyBeanMachineRemote jellyBeanMachine) {
		this.jellyBeanMachine = jellyBeanMachine;
	}
 
	public void report() {
		try {
			System.out.println("Jelly Bean Machine: " + jellyBeanMachine.getLocation());
			System.out.println("Current inventory: " + jellyBeanMachine.getCount() + " jelly beans");
			System.out.println("Current state: " + jellyBeanMachine.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
