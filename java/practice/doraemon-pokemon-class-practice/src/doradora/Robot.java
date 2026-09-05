package doradora;

public class Robot {
	private int id;
	private String name;
	private String type;
	private String[] secretItems = {
		"どこでもドア",
		"タケコプター",
		"タイムマシン",
		"もしもボックス",
		"タイムふろしき"
	};
	
	// set
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	// get
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	// hello
	public void hello() {
		System.out.println("僕、" + type + "型ロボットNo" + id + "の" + name + "！よろしくね！");
	}
	
	// giveDorayaki
	public void giveDorayaki(int number) {
		if (number <= 1) {
			System.out.println("どら焼き、一個だけ？");
		} else if (number <= 5) {
			System.out.println("ありがとう！うれしいな！");
		} else {
			System.out.println("こんなにたくさん？ありがとう！");
		}
	}
	
	// getSecretItem
	public String getSecretItem() {
		java.util.Random random = new java.util.Random();
		int index = random.nextInt(secretItems.length);
		
		return secretItems[index];
	}
}
