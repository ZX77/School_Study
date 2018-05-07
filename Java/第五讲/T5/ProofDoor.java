package T5;

public class ProofDoor extends Door{

	public void closeDoor() {
		System.out.println("关门");
		
	}

	public void openDoor() {
		System.out.println("开门");
	}
	@Override
	public void theftproof() {
		System.out.println("我是高大上的防盗门...");
	}

}
