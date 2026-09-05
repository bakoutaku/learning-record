package minirpg;

import java.util.Random;

/**
 * ターン進行、ダメージ計算、勝敗判定、再スタートを管理するクラス。
 */
public class BattleManager {
	private Hero hero;
	private Enemy enemy;
	private boolean battleOver = false;
	private Random random = new Random();

	/**
	 * 戦闘に参加する勇者と敵を設定する。
	 *
	 * @param hero  プレイヤーが操作する勇者
	 * @param enemy 戦闘する敵
	 */
	public BattleManager(Hero hero, Enemy enemy) {
		this.hero = hero;
		this.enemy = enemy;
	}

	/**
	 * 通常攻撃のダメージを計算する。最低ダメージは1とする。
	 */
	private int calculateNormalDamage(GameCharacter attacker, GameCharacter defender) {
		int damage = attacker.getAttackPower() - defender.getDefensePower();

		if (damage < 1) {
			damage = 1;
		}

		return damage;
	}

	/**
	 * 敵にダメージを与え、勝敗を判定する。
	 * 敵が生きている場合は、そのまま敵のターンを実行する。
	 */
	private String damageEnemy(int damage, String actionMessage) {
		int hpBefore = this.enemy.getHp();
		this.enemy.takeDamage(damage);

		// 防御や残りHPを考慮した実際のダメージを求める
		int actualDamage = hpBefore - this.enemy.getHp();

		String result = actionMessage + "\n";
		result += this.enemy.getName() + "に" + actualDamage + "ダメージ！";

		if (!this.enemy.isAlive()) {
			this.battleOver = true;
			result += "\n" + this.enemy.getName() + "を倒した！";
			result += "\n勇者の勝利！";
			return result;
		}

		result += "\n" + enemyTurn();
		return result;
	}

	/**
	 * 勇者が通常攻撃を行う。
	 *
	 * @return 画面に表示する戦闘メッセージ
	 */
	public String playerAttack() {
		if (this.battleOver) {
			return "戦闘はすでに終了しています。";
		}

		int damage = calculateNormalDamage(this.hero, this.enemy);
		String message = this.hero.getName() + "の攻撃！";

		return damageEnemy(damage, message);
	}

	/**
	 * 勇者が指定したMPを消費して攻撃魔法を使う。
	 *
	 * @param mpCost 使用するMP
	 * @return 画面に表示する戦闘メッセージ
	 */
	public String playerMagicAttack(int mpCost) {
		if (this.battleOver) {
			return "戦闘はすでに終了しています。";
		}

		int magicDamage = this.hero.useAttackMagic(mpCost);

		if (magicDamage == 0) {
			return "MPが足りない、または消費MPが正しくありません。";
		}

		int damage = magicDamage - this.enemy.getDefensePower();

		if (damage < 1) {
			damage = 1;
		}

		String message = this.hero.getName()
				+ "は攻撃魔法を使った！"
				+ "\nMPを" + mpCost + "消費した！";

		return damageEnemy(damage, message);
	}

	/**
	 * 勇者を防御状態にしてから敵のターンを実行する。
	 *
	 * @return 画面に表示する戦闘メッセージ
	 */
	public String playerGuard() {
		if (this.battleOver) {
			return "戦闘はすでに終了しています。";
		}

		this.hero.guard();

		String result = this.hero.getName() + "は身を守っている！";
		result += "\n" + enemyTurn();

		return result;
	}

	/**
	 * 勇者が回復魔法を使用してから敵のターンを実行する。
	 * 回復できない場合は敵のターンに進まない。
	 *
	 * @return 画面に表示する戦闘メッセージ
	 */
	public String playerHeal() {
		if (this.battleOver) {
			return "戦闘はすでに終了しています。";
		}

		int hpBefore = this.hero.getHp();
		int mpBefore = this.hero.getMp();

		boolean success = this.hero.useHealMagic();

		if (!success) {
			if (this.hero.getHp() >= this.hero.getMaxHp()) {
				return "HPはすでに満タンです。";
			}

			if (this.hero.getMp() <= 0) {
				return "MPが足りません。";
			}

			return "回復魔法を使えません。";
		}

		int actualHeal = this.hero.getHp() - hpBefore;
		int usedMp = mpBefore - this.hero.getMp();

		String result = this.hero.getName() + "は回復魔法を使った！";
		result += "\nMPを" + usedMp + "消費した！";
		result += "\nHPが" + actualHeal + "回復した！";
		result += "\n" + enemyTurn();

		return result;
	}

	/**
	 * 敵の行動をランダムに決める。
	 * 通常攻撃50%、防御25%、攻撃魔法25%の確率で行動する。
	 */
	private String enemyTurn() {
		if (this.battleOver) {
			return "";
		}

		int action = this.random.nextInt(100);

		if (action < 50) {
			return enemyNormalAttack();
		} else if (action < 75) {
			this.enemy.guard();
			return this.enemy.getName() + "は身を守っている！";
		} else {
			// MPがない場合は攻撃魔法の代わりに通常攻撃を行う
			if (this.enemy.getMp() <= 0) {
				return enemyNormalAttack();
			}

			// 現在MPを超えない範囲で1～3MPをランダムに使用する
			int maxCost = Math.min(3, this.enemy.getMp());
			int mpCost = this.random.nextInt(maxCost) + 1;

			int magicDamage = this.enemy.useAttackMagic(mpCost);
			int damage = magicDamage - this.hero.getDefensePower();

			if (damage < 1) {
				damage = 1;
			}

			String message = this.enemy.getName()
					+ "は攻撃魔法を使った！"
					+ "\nMPを" + mpCost + "消費した！";

			return damageHero(damage, message);
		}
	}

	/**
	 * 敵が勇者に通常攻撃を行う。
	 */
	private String enemyNormalAttack() {
		int damage = calculateNormalDamage(this.enemy, this.hero);
		String message = this.enemy.getName() + "の攻撃！";
		return damageHero(damage, message);
	}

	/**
	 * 勇者にダメージを与え、敗北したかを判定する。
	 */
	private String damageHero(int damage, String actionMessage) {
		int hpBefore = this.hero.getHp();
		this.hero.takeDamage(damage);

		// 防御や残りHPを考慮した実際のダメージを求める
		int actualDamage = hpBefore - this.hero.getHp();

		String result = actionMessage + "\n";
		result += this.hero.getName() + "は" + actualDamage + "ダメージを受けた！";

		if (!this.hero.isAlive()) {
			this.battleOver = true;
			result += "\n" + this.hero.getName() + "は倒れた……";
			result += "\n敗北……";
		}

		return result;
	}

	/**
	 * 勇者と敵を初期状態に戻し、戦闘を再開する。
	 *
	 * @return 再スタート時に表示するメッセージ
	 */
	public String resetBattle() {
		this.hero.reset();
		this.enemy.reset();
		this.battleOver = false;

		String result = "戦闘を最初からやり直します！";
		result += "\n" + this.enemy.getName() + "が現れた！";

		return result;
	}

	// GameWindowが画面表示を更新するためのgetter
	public Hero getHero() {
		return this.hero;
	}

	public Enemy getEnemy() {
		return this.enemy;
	}

	public boolean isBattleOver() {
		return this.battleOver;
	}
}
