package state;

/* This class sets up QuartLess */

public class QuarterLess implements State {
	private static final long serialVersionUID = 2L;
    transient JellyBeanMachine jellyBeanMachine;
 
    public QuarterLess(JellyBeanMachine jellyBeanMachine) {
        this.jellyBeanMachine = jellyBeanMachine;
    }
 
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		jellyBeanMachine.setState(jellyBeanMachine.getHasQuarterState());
	}
 
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for quarter";
	}
	
}