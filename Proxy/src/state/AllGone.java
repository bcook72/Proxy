package state;

/*implements the all gone class */

public class AllGone implements State {
	private static final long serialVersionUID = 2L;
    transient JellyBeanMachine jellyBeanMachine;
 
    public AllGone(JellyBeanMachine jellyBeanMachine) {
        this.jellyBeanMachine = jellyBeanMachine;
    }
 
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
 
	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no jelly beans");
	}
 
	public void dispense() {
		System.out.println("No jelly beans dispensed");
	}
 
	public String toString() {
		return "sold out";
	}
	
	
}