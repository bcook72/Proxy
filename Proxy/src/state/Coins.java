package state;

/* implements coins class */

import java.util.Random;

public class Coins implements State {
	private static final long serialVersionUID = 2L;
	Random randomWinner = new Random(System.currentTimeMillis());
	transient JellyBeanMachine jellyBeanMachine;
 
	public Coins(JellyBeanMachine jellyBeanMachine) {
		this.jellyBeanMachine = jellyBeanMachine;
	}
  
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}
 
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		jellyBeanMachine.setState(jellyBeanMachine.getNoQuarterState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if (winner == 0) {
			jellyBeanMachine.setState(jellyBeanMachine.getWinnerState());
		} else {
			jellyBeanMachine.setState(jellyBeanMachine.getSoldState());
		}
	}

    public void dispense() {
        System.out.println("No jelly beans dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
	
	public void refill() { }
}
