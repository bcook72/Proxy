package state;

/* Implements the winner */

public class Winner implements State {
	
	private static final long serialVersionUID = 2L;
    transient JellyBeanMachine jellyBeanMachine;
 
    public Winner(JellyBeanMachine jellyBeanMachine) {
        this.jellyBeanMachine = jellyBeanMachine;
    }
 
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you jelly beans");
	}
 
	public void ejectQuarter() {
		System.out.println("Please wait, we're already giving you jelly beans");
	}
 
	public void turnCrank() {
		System.out.println("Turning again doesn't get you more jelly beans!");
	}
 
	public void dispense() {
		jellyBeanMachine.releaseBeans();
		if (jellyBeanMachine.getCount() == 0) {
			jellyBeanMachine.setState(jellyBeanMachine.getSoldOutState());
		} else {
			jellyBeanMachine.releaseBeans();
			System.out.println("YOU'RE A WINNER!");
			if (jellyBeanMachine.getCount() > 0) {
				jellyBeanMachine.setState(jellyBeanMachine.getNoQuarterState());
			} else {
            	System.out.println("Oops, out of gumballs!");
				jellyBeanMachine.setState(jellyBeanMachine.getSoldOutState());
			}
		}
	}
 
	public void refill() { }
	
	public String toString() {
		return "YOU'RE A WINNER!";
	}
}