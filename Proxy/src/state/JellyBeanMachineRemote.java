package state;

/* this establishes the jelly bean machine remote interface */

import java.rmi.*;

public interface JellyBeanMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}



