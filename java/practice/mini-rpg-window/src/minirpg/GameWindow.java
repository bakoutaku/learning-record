package minirpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * ゲーム画面の表示とボタン操作を担当するクラス。
 */
public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	// 戦闘ログで使用する文字色
	private static final Color HERO_COLOR = new Color(21, 101, 192);
	private static final Color ENEMY_COLOR = new Color(198, 40, 40);
	private static final Color HP_COLOR = new Color(211, 47, 47);
	private static final Color MP_COLOR = new Color(123, 31, 162);
	private static final Color NUMBER_COLOR = new Color(239, 108, 0);
	private static final Color NORMAL_TEXT_COLOR = Color.BLACK;
	private static final Font DISPLAY_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

	private BattleManager battleManager;

	// キャラクターの状態と戦闘ログを表示する部品
	private JLabel heroStatusLabel;
	private JLabel enemyStatusLabel;
	private JTextPane logArea;

	// プレイヤーが操作するボタンとMP入力欄
	private JButton attackButton;
	private JButton magicButton;
	private JButton guardButton;
	private JButton healButton;
	private JButton resetButton;
	private JSpinner mpCostSpinner;

	/**
	 * ゲーム画面を作成する。
	 *
	 * @param battleManager 戦闘処理を管理するオブジェクト
	 */
	public GameWindow(BattleManager battleManager) {
		this.battleManager = battleManager;

		setTitle("ミニRPG");
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createComponents();
		updateStatus();
		updateButtons();

		appendBattleText(this.battleManager.getEnemy().getName() + "が現れた！\n\n");

		// ウィンドウを画面中央に表示する
		setLocationRelativeTo(null);
	}

	/**
	 * ラベル、ログ欄、操作ボタンを作成して画面に配置する。
	 */
	private void createComponents() {
		setLayout(new BorderLayout(10, 10));

		// 画面上部：勇者と敵の現在の状態
		JPanel statusPanel = new JPanel(new GridLayout(2, 1, 5, 5));
		this.heroStatusLabel = new JLabel();
		this.enemyStatusLabel = new JLabel();
		this.heroStatusLabel.setFont(DISPLAY_FONT);
		this.enemyStatusLabel.setFont(DISPLAY_FONT);
		statusPanel.add(this.heroStatusLabel);
		statusPanel.add(this.enemyStatusLabel);
		add(statusPanel, BorderLayout.NORTH);

		// 画面中央：複数の色を使える戦闘ログ
		this.logArea = new JTextPane();
		this.logArea.setEditable(false);
		this.logArea.setFont(DISPLAY_FONT);
		JScrollPane scrollPane = new JScrollPane(this.logArea);
		add(scrollPane, BorderLayout.CENTER);

		// 画面下部：プレイヤーの操作ボタン
		JPanel commandPanel = new JPanel(new FlowLayout());
		this.attackButton = new JButton("攻撃");
		this.magicButton = new JButton("攻撃魔法");
		this.guardButton = new JButton("防御");
		this.healButton = new JButton("回復魔法");
		this.resetButton = new JButton("再スタート");

		// 攻撃魔法に使用するMPを1～最大MPの範囲で選択する
		int maxMagicCost = Math.max(1, this.battleManager.getHero().getMaxMp());
		this.mpCostSpinner = new JSpinner(new SpinnerNumberModel(1, 1, maxMagicCost, 1));

		commandPanel.add(this.attackButton);
		commandPanel.add(this.guardButton);
		commandPanel.add(this.healButton);
		JLabel mpCostLabel = new JLabel("消費MP：");
		mpCostLabel.setFont(DISPLAY_FONT);
		commandPanel.add(mpCostLabel);
		commandPanel.add(this.mpCostSpinner);
		commandPanel.add(this.magicButton);
		commandPanel.add(this.resetButton);
		add(commandPanel, BorderLayout.SOUTH);

		addButtonActions();
	}

	/**
	 * 各ボタンが押されたときの処理を登録する。
	 */
	private void addButtonActions() {
		this.attackButton.addActionListener(event -> {
			String result = this.battleManager.playerAttack();
			showResult(result);
		});

		this.guardButton.addActionListener(event -> {
			String result = this.battleManager.playerGuard();
			showResult(result);
		});

		this.healButton.addActionListener(event -> {
			String result = this.battleManager.playerHeal();
			showResult(result);
		});

		this.magicButton.addActionListener(event -> {
			int mpCost = (Integer) this.mpCostSpinner.getValue();
			String result = this.battleManager.playerMagicAttack(mpCost);
			showResult(result);
		});

		this.resetButton.addActionListener(event -> {
			String result = this.battleManager.resetBattle();

			// 再スタート時は以前の戦闘ログを消去する
			this.logArea.setText("");
			appendBattleText(result + "\n\n");

			updateStatus();
			updateButtons();
		});
	}

	/**
	 * 戦闘結果をログに追加し、画面上の能力値とボタンを更新する。
	 */
	private void showResult(String result) {
		appendBattleText(result + "\n\n");
		updateStatus();
		updateButtons();
	}

	/**
	 * 戦闘ログの名前と数字を判別し、それぞれ異なる色で追加する。
	 */
	private void appendBattleText(String text) {
		String heroName = this.battleManager.getHero().getName();
		String enemyName = this.battleManager.getEnemy().getName();

		Pattern pattern = Pattern.compile(
				Pattern.quote(heroName) + "|" + Pattern.quote(enemyName) + "|HP|MP|\\d+");
		Matcher matcher = pattern.matcher(text);

		int position = 0;

		while (matcher.find()) {
			// 名前や数字より前にある通常の文章を追加する
			appendStyledText(text.substring(position, matcher.start()), NORMAL_TEXT_COLOR, false);

			String matchedText = matcher.group();

			if (matchedText.equals(heroName)) {
				appendStyledText(matchedText, HERO_COLOR, true);
			} else if (matchedText.equals(enemyName)) {
				appendStyledText(matchedText, ENEMY_COLOR, true);
			} else if (matchedText.equals("HP")) {
				appendStyledText(matchedText, HP_COLOR, true);
			} else if (matchedText.equals("MP")) {
				appendStyledText(matchedText, MP_COLOR, true);
			} else {
				appendStyledText(matchedText, NUMBER_COLOR, true);
			}

			position = matcher.end();
		}

		// 最後に残った通常の文章を追加する
		appendStyledText(text.substring(position), NORMAL_TEXT_COLOR, false);

		// 新しいメッセージを表示するため、カーソルをログの末尾へ移動する
		this.logArea.setCaretPosition(this.logArea.getDocument().getLength());
	}

	/**
	 * 指定された色と太さで文字列を戦闘ログの末尾に追加する。
	 */
	private void appendStyledText(String text, Color color, boolean bold) {
		StyledDocument document = this.logArea.getStyledDocument();
		SimpleAttributeSet style = new SimpleAttributeSet();
		StyleConstants.setForeground(style, color);
		StyleConstants.setBold(style, bold);
		StyleConstants.setFontFamily(style, DISPLAY_FONT.getFamily());
		StyleConstants.setFontSize(style, DISPLAY_FONT.getSize());

		try {
			document.insertString(document.getLength(), text, style);
		} catch (BadLocationException exception) {
			throw new IllegalStateException("戦闘ログへの文字追加に失敗しました。", exception);
		}
	}

	/**
	 * 勇者のHP・MPと敵のHPを最新の値に更新する。
	 * 敵のMPはプレイヤーに表示しない。
	 */
	private void updateStatus() {
		Hero hero = this.battleManager.getHero();
		Enemy enemy = this.battleManager.getEnemy();

		this.heroStatusLabel.setText(
				"<html>"
						+ "<b><font color='#1565C0'>" + hero.getName() + "</font></b>"
						+ "　<b><font color='#D32F2F'>HP</font></b>：<font color='#D32F2F'>"
						+ hero.getHp() + "</font> / " + hero.getMaxHp()
						+ "　<b><font color='#7B1FA2'>MP</font></b>：<font color='#7B1FA2'>"
						+ hero.getMp() + "</font> / " + hero.getMaxMp()
						+ "</html>");

		this.enemyStatusLabel.setText(
				"<html>"
						+ "<b><font color='#C62828'>" + enemy.getName() + "</font></b>"
						+ "　<b><font color='#D32F2F'>HP</font></b>：<font color='#D32F2F'>"
						+ enemy.getHp() + "</font> / " + enemy.getMaxHp()
						+ "</html>");
	}

	/**
	 * 戦闘終了後は再スタート以外の操作を無効にする。
	 */
	private void updateButtons() {
		boolean canAct = !this.battleManager.isBattleOver();

		this.attackButton.setEnabled(canAct);
		this.magicButton.setEnabled(canAct);
		this.guardButton.setEnabled(canAct);
		this.healButton.setEnabled(canAct);
		this.mpCostSpinner.setEnabled(canAct);
	}
}
