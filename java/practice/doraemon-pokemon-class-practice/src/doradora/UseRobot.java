package doradora;

public class UseRobot {
	public static void main(String[] args) {
		Robot robotDora = new Robot();
		
		// set
		robotDora.setId(1);
		robotDora.setName("ドラえもん");
		robotDora.setType("猫");
		
		// get
		System.out.println(robotDora.getId());
		System.out.println(robotDora.getName());
		System.out.println(robotDora.getType());
		
		// Hello
		robotDora.hello();
		
		// giveDorayaki
		robotDora.giveDorayaki(1);
		robotDora.giveDorayaki(5);
		robotDora.giveDorayaki(10);
		
		// getSecretItem
		System.out.println(robotDora.getSecretItem());
	}
}