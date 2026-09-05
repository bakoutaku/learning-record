//手持ちのポケモン
package poke;

public class Pokemon {
	private int id;
	private String pokename;
	private int level;
	
	public Pokemon(int id, String pokename, int level) {
		this.id = id;
		
		this.pokename = pokename;
		
		this.level = level;
	}
	
	
	// get
	public int getId() {
		return this.id;
	}
	
	public String getPokename() {
		return this.pokename;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	// hello
	public void hello() {
		System.out.println("てもち" + id + "番" + pokename + "、レベルは" + level + "です^_^");
	}

}
