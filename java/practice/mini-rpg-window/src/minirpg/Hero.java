package minirpg;

/**
 * プレイヤーが操作する勇者クラス。
 */
public class Hero extends GameCharacter {
	// 回復魔法で消費するMPと回復するHP
	private static final int HEAL_MP_COST = 1;
	private static final int HEAL_AMOUNT = 25;

	/**
	 * 勇者の初期能力値を親クラスに渡す。
	 *
	 * @param name         名前
	 * @param maxHp        最大HP
	 * @param maxMp        最大MP
	 * @param attackPower  攻撃力
	 * @param defensePower 防御力
	 * @param magicPower   1MPあたりの魔法威力
	 */
	public Hero(String name, int maxHp, int maxMp,
			int attackPower, int defensePower, int magicPower) {
		super(name, maxHp, maxMp, attackPower, defensePower, magicPower);
	}

	/**
	 * 1MPを消費してHPを25回復する。
	 * 戦闘不能、HP満タン、MP不足の場合は使用できない。
	 *
	 * @return 回復魔法を使用できた場合はtrue、それ以外はfalse
	 */
	public boolean useHealMagic() {
		if (!isAlive()) {
			return false;
		}

		if (getHp() >= getMaxHp()) {
			return false;
		}

		if (!consumeMp(HEAL_MP_COST)) {
			return false;
		}

		heal(HEAL_AMOUNT);
		return true;
	}
}
