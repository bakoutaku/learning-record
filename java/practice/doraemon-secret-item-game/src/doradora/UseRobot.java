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
		System.out.println();
		
		// hello
		robotDora.hello();
		System.out.println();
		
		// Dorayaki,SecretItem
		java.util.Random random = new java.util.Random();
		int ran1 = random.nextInt(11); 
		
		int ran2 = random.nextInt(11);
		while (ran2 == ran1) {
			ran2 = random.nextInt(11);
		}
		
		int ran3 = random.nextInt(11);
		while (ran3 == ran1 || ran3 == ran2) {
			ran3 = random.nextInt(11);
		}
		
		robotDora.giveDorayaki(ran1);
		if (ran1 != 0) {
			System.out.println("じゃあ、" + robotDora.getSecretItem() + "をあげる。");
		}
		System.out.println();
		
		robotDora.giveDorayaki(ran2);
		if (ran2 != 0) {
			System.out.println("じゃあ、" + robotDora.getSecretItem() + "をあげる。");
		}
		System.out.println();
		
		robotDora.giveDorayaki(ran3);
		if (ran3 != 0) {
			System.out.println("じゃあ、" + robotDora.getSecretItem() + "をあげる。");
		}
	}

}
