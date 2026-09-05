package doradora;

public class Robot {
	private int id;
	private String name;
	private String type;
	private int numDorayaki;
	private String[] secretItems =  {
			"アンキパン",
			"きせかえカメラ",
			"ほんやくコンニャク",
			"グルメテーブルかけ",
			"スモールライト",
			"タケコプター",
			"タイムふろしき",
			"どこでもドア",
			"タイムマシン",
			"もしもボックス"
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
	
	// Hello
	public void hello() {
		System.out.println("僕、"+ type + "型ロボットNo"+ id + "の" + name + "！よろしくね！");
	}
	
	// giveDorayaki
	public void giveDorayaki(int i) {
		if (i <= 0) {
			System.out.println("一つもないか？どら焼き食べたい・・・");
		}else if (i == 1) {
			System.out.println("どら焼き、1個だけ？");
		}else if (i < 5) {
			System.out.println("どら焼き" + i + "個か、ちょっと足りないな・・・");
		}else if (i < 10) {
			System.out.println("どら焼き" + i + "個！十分だ！ありがとう〜");
		}else {
			System.out.println("どら焼き" + i + "個！？多すぎるじゃない？");
		}
		this.numDorayaki = i;
	}
	
	// secretItems
	public String getSecretItem() {
		String newItem = secretItems[numDorayaki - 1];
		return newItem;
	}
	
	
}
