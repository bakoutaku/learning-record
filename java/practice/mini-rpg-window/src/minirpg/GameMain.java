package minirpg;

import javax.swing.SwingUtilities;

/**
 * ミニRPGを起動するためのクラス。
 */
public class GameMain {

	/**
	 * 勇者、敵、戦闘管理クラス、画面を順番に作成してゲームを開始する。
	 *
	 * @param args コマンドライン引数（このプログラムでは使用しない）
	 */
	public static void main(String[] args) {
		// Swingの画面はイベントディスパッチスレッド上で作成する
		SwingUtilities.invokeLater(() -> {
			Hero hero = new Hero("アレン", 100, 10, 15, 5, 6);
			Enemy enemy = new Enemy("スライム", 80, 6, 12, 3, 4);

			BattleManager battleManager = new BattleManager(hero, enemy);
			GameWindow gameWindow = new GameWindow(battleManager);

			// 作成したゲーム画面を表示する
			gameWindow.setVisible(true);
		});
	}
}
