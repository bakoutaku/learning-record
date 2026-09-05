package minirpg;

/**
 * 勇者と敵に共通する能力値と処理を管理するクラス。
 */
public class GameCharacter {
	// キャラクターの基本能力値
	private String name;
	private int maxHp;
	private int hp;
	private int maxMp;
	private int mp;
	private int magicPower;
	private int attackPower;
	private int defensePower;

	// 次に受ける攻撃を防御する状態かどうか
	private boolean guarding = false;

	/**
	 * キャラクターの初期能力値を設定する。
	 *
	 * @param name         名前
	 * @param maxHp        最大HP
	 * @param maxMp        最大MP
	 * @param attackPower  攻撃力
	 * @param defensePower 防御力
	 * @param magicPower   1MPあたりの魔法威力
	 */
	public GameCharacter(String name, int maxHp, int maxMp,
			int attackPower, int defensePower, int magicPower) {
		this.name = name;

		this.maxHp = maxHp;
		this.hp = maxHp;
		this.maxMp = maxMp;
		this.mp = maxMp;

		this.magicPower = magicPower;
		this.attackPower = attackPower;
		this.defensePower = defensePower;
	}

	/**
	 * キャラクターが生きているかを判定する。
	 *
	 * @return HPが1以上ならtrue、0ならfalse
	 */
	public boolean isAlive() {
		return this.hp > 0;
	}

	/**
	 * ダメージを受けてHPを減らす。
	 * 防御中の場合は受けるダメージを半分にし、防御状態を解除する。
	 *
	 * @param damage 防御力などを計算した後のダメージ
	 */
	public void takeDamage(int damage) {
		if (damage <= 0) {
			return;
		}

		int actualDamage = damage;

		if (this.guarding) {
			actualDamage = actualDamage / 2;
			this.guarding = false;
		}

		this.hp = this.hp - actualDamage;

		// HPが0より小さくならないようにする
		if (this.hp < 0) {
			this.hp = 0;
		}
	}

	/**
	 * 指定された量のMPを消費する。
	 *
	 * @param amount 消費するMP
	 * @return MPを消費できた場合はtrue、足りない場合はfalse
	 */
	public boolean consumeMp(int amount) {
		if (amount <= 0 || this.mp < amount) {
			return false;
		}

		this.mp = this.mp - amount;
		return true;
	}

	/**
	 * MPを消費して攻撃魔法の威力を計算する。
	 *
	 * @param mpCost 魔法に使用するMP
	 * @return 魔法の基本ダメージ。使用できない場合は0
	 */
	public int useAttackMagic(int mpCost) {
		if (mpCost <= 0) {
			return 0;
		}

		if (!consumeMp(mpCost)) {
			return 0;
		}

		int magicDamage = mpCost * this.magicPower;
		return magicDamage;
	}

	/**
	 * 次に受ける攻撃に備えて防御状態にする。
	 */
	public void guard() {
		this.guarding = true;
	}

	/**
	 * HPを回復する。最大HPを超えた分は切り捨てる。
	 *
	 * @param amount 回復するHP
	 */
	protected void heal(int amount) {
		if (amount <= 0) {
			return;
		}

		this.hp = this.hp + amount;

		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
	}

	/**
	 * HP・MP・防御状態を戦闘開始時の状態に戻す。
	 */
	public void reset() {
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.guarding = false;
	}

	// 以下は能力値を外部から参照するためのgetter
	public String getName() {
		return this.name;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxMp() {
		return this.maxMp;
	}

	public int getMp() {
		return this.mp;
	}

	public int getMagicPower() {
		return this.magicPower;
	}

	public int getAttackPower() {
		return this.attackPower;
	}

	public int getDefensePower() {
		return this.defensePower;
	}

	public boolean isGuarding() {
		return this.guarding;
	}
}
