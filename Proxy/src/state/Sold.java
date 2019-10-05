package state;

/* implements the sold class */

public class Sold implements State {
	 
	private static final long serialVersionUID = 2L;
    transient JellyBeanMachine jellyBeanMachine;
 
    public Sold(JellyBeanMachine jellyBeanMachine) {
        this.jellyBeanMachine = jellyBeanMachine;
    }
       
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you jelly beans");
	}
 
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
 
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you more jelly beans!");
	}
 
	public void dispense() {
		jellyBeanMachine.releaseBeans();
		if (jellyBeanMachine.getCount() > 0) {
			jellyBeanMachine.setState(jellyBeanMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of jelly beans!");
			jellyBeanMachine.setState(jellyBeanMachine.getSoldOutState());
		}
	}

 
	public String toString() {
		return "dispensing jelly beans";
	}
}