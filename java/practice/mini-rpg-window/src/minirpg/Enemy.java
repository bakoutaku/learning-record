package minirpg;

/**
 * 勇者と戦う敵クラス。
 * 現在は回復魔法を使用せず、通常攻撃・防御・攻撃魔法で行動する。
 */
public class Enemy extends GameCharacter {

	/**
	 * 敵の初期能力値を親クラスに渡す。
	 *
	 * @param name         名前
	 * @param maxHp        最大HP
	 * @param maxMp        最大MP（画面には表示しない）
	 * @param attackPower  攻撃力
	 * @param defensePower 防御力
	 * @param magicPower   1MPあたりの魔法威力
	 */
	public Enemy(String name, int maxHp, int maxMp,
			int attackPower, int defensePower, int magicPower) {
		super(name, maxHp, maxMp, attackPower, defensePower, magicPower);
	}
}
