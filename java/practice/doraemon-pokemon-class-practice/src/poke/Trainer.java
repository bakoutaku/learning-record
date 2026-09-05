package poke;

public class Trainer {
	public static void main(String[] args) {
		// pokemon
		Pokemon[] pokemons = {
				new Pokemon(1,"ピカチュウ", 20),
				new Pokemon(2, "フシギダネ", 50),
				new Pokemon(3, "ヒトカゲ", 80)
		};
		
		for (Pokemon pokemon : pokemons) {
			pokemon.hello();
		}
		System.out.println();
		
		//wildPoke
		WildPoke wildPoke1 = new WildPoke("ゼニガメ");
		System.out.println("野生のポケモンが現れた！");
		System.out.println();
		wildPoke1.hello();
		System.out.println();
		
		// fight
		System.out.println("たたかう！");
		
		boolean wildPokemonWon = true;
		
		for (int i = 0; i < pokemons.length; i++) {
			Pokemon fightPokemon = pokemons[i];
			
			if (fightPokemon.getLevel() > wildPoke1.getLevel()) {
				System.out.println("てもちの" + fightPokemon.getPokename() + "の勝ち！");
				wildPokemonWon = false;
				break;
			}else if (fightPokemon.getLevel() == wildPoke1.getLevel()) {
				System.out.println("両方とも同じレベルなので、引き分け！");
				wildPokemonWon = false;
				break;
			}
			
			if (i < pokemons.length - 1) {
				System.out.println(fightPokemon.getPokename() + "がひんし…ポケモン交代！");
			}else {
				System.out.println(fightPokemon.getPokename() + "がひんし…目の前が真っ暗に…");
			}
		}
		
		if (wildPokemonWon) {
			System.out.println("野生の" + wildPoke1.getPokename() + "の勝ち！");
		}
	}

}
