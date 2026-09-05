//野生のポケモン
package poke;

public class WildPoke {
	private String pokename;
	private int level; 
	
	public WildPoke(String pokename) {
		this.pokename = pokename;
		
		java.util.Random random = new java.util.Random();
		this.level = random.nextInt(100);
		
	}
		
	// get
	public String getPokename() {
		return this.pokename;
	}
		
	public int getLevel() {
		return this.level;
	}
	
	// hello
	public void hello() {
		System.out.println("野生の" + pokename + "、レベルは" + level + "です#'_'#");
	}
	

}
