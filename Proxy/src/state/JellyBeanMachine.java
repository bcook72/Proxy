package state;

/* This class sets up the candy machine */

import java.rmi.*;
import java.rmi.server.*;

public class JellyBeanMachine extends UnicastRemoteObject implements JellyBeanMachineRemote  {
	 
	private static final long serialVersionUID = 2L;

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
 
	State state = soldOutState;
	int count = 0;
	String location;
 
	public JellyBeanMachine(String location, int numberJellybeans) throws RemoteException {
		soldOutState = new AllGone(this);
		noQuarterState = new QuarterLess(this);
		hasQuarterState = new Coins(this);
		soldState = new Sold(this);
		winnerState = new Winner(this);

		this.count = numberJellybeans;
 		if (numberJellybeans > 0) {
			state = noQuarterState;
		} 
		this.location = location;
	}
 
 
	public void insertQuarter() {
		state.insertQuarter();
	}
 
	public void ejectQuarter() {
		state.ejectQuarter();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBeans() {
		System.out.println("Jelly beans comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}
 
	public int getCount() {
		return count;
	}
 
    public State getState() {
        return state;
    }
 
    public String getLocation() {
        return location;
    }
  
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nJelly Belly Co, Inc.");
		result.append("\nJava-enabled Jelly Belly Model #24");
		result.append("\nInventory: " + count + " Jelly beans");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}