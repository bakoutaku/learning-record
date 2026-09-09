# Java

## 概要

HAL東京の授業課題や個人練習で作成したJavaプログラムをまとめています。
基本文法、入力処理、配列などの基礎から始め、現在はクラス、カプセル化、継承を使ったプログラムまで段階的に学習しています。

## 内容

このフォルダでは、Javaの基礎練習と小さなプログラムを分類して管理しています。

```text
java
├── basic
│   ├── range-sum
│   └── array
└── practice
    ├── checkout-point-calculator
    ├── doraemon-pokemon-class-practice
    ├── doraemon-secret-item-game
    ├── mini-rpg-window
    ├── number-guessing-game
    └── student-score-analyzer
```

## 学習内容

主に以下の内容を学習しています。

* 標準出力
* 変数
* データ型
* 条件分岐
* 繰り返し処理
* 配列
* 入力処理
* 最大値・最小値の判定
* 合計・平均の計算
* break / continue
* Randomクラス
* クラスとインスタンス
* コンストラクタ
* setter / getterとカプセル化
* 継承
* 機能ごとのクラス分割

## プログラム一覧

| フォルダ | 内容 |
| --- | --- |
| [`basic/range-sum`](basic/range-sum/) | 指定した範囲の整数を合計するプログラム |
| [`basic/array`](basic/array/) | 配列を使った点数集計、並べ替え、商品販売数の集計 |
| [`practice/student-score-analyzer`](practice/student-score-analyzer/) | 合格人数・最高点・合格者平均を表示するプログラム |
| [`practice/checkout-point-calculator`](practice/checkout-point-calculator/) | 合計金額・ポイント・最高金額を計算するプログラム |
| [`practice/number-guessing-game`](practice/number-guessing-game/) | ランダムな数字を当てるゲーム |
| [`practice/doraemon-pokemon-class-practice`](practice/doraemon-pokemon-class-practice/) | クラス、インスタンス、配列、乱数を使った練習 |
| [`practice/doraemon-secret-item-game`](practice/doraemon-secret-item-game/) | オブジェクト指向と重複しない乱数生成の練習 |
| [`practice/mini-rpg-window`](practice/mini-rpg-window/) | クラスを役割ごとに分けて作成したターン制MiniRPG |

## 使用技術

* Java
* BufferedReader
* InputStreamReader
* Random
* Java Swing（一部、生成AIの支援を利用）

## 学習ポイント

このフォルダでは、Javaの基本文法を使った小さなコンソールプログラムから学習を始めました。
入力値のチェック、集計処理、繰り返し実行、途中終了などを練習した後、クラス、インスタンス、コンストラクタ、カプセル化、継承へ学習範囲を広げています。

MiniRPGでは、キャラクターの状態管理、戦闘処理、画面表示を別々のクラスに分け、処理の役割を意識して設計しました。

## 生成AIの利用について

MiniRPGのJava Swingによる画面表示とボタン操作は、まだ授業で学んでいない内容だったため、生成AIの支援を受けて作成しました。ゲームの仕様、キャラクター管理、ダメージ計算、ターン進行、勝敗判定などの戦闘ロジックは自分で考えて実装しています。

AIの支援を受けた範囲と現在の理解度については、[MiniRPGのREADME](practice/mini-rpg-window/README.md#生成aiの利用について)に記載しています。

## 備考

このフォルダは学習記録として作成しています。
授業で学んだ内容を整理し、Javaの基礎理解を深めることを目的としています。
