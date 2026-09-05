# Doraemon & Pokemon Class Practice

## 概要

Javaのクラス、インスタンス、コンストラクタ、配列、乱数を練習するために作成したプログラムです。  
「ドラえもん」と「ポケモン」を題材にした2種類のプログラムを収録しています。

## 収録内容

### ドラえもん

- `Robot` クラスにID、名前、種類を保持
- setterとgetterを使用してフィールドを操作
- あいさつ、どら焼きへの反応、ひみつ道具の抽選をメソッドで実装
- `UseRobot` クラスからオブジェクトを生成して各メソッドを実行

### ポケモン

- 手持ちポケモンを配列で管理
- 拡張for文を使用して手持ちポケモンを表示
- 野生ポケモンのレベルを乱数で決定
- 手持ちポケモンを順番に戦わせ、勝ち・負け・引き分けを判定

## クラス構成

```text
src
├── doradora
│   ├── Robot.java
│   └── UseRobot.java
└── poke
    ├── Pokemon.java
    ├── Trainer.java
    └── WildPoke.java
```

## 実行方法

### Eclipse

- ドラえもん：`src/doradora/UseRobot.java` をJavaアプリケーションとして実行します。
- ポケモン：`src/poke/Trainer.java` をJavaアプリケーションとして実行します。

### コマンドライン

```bash
javac -encoding UTF-8 -d out src/doradora/*.java src/poke/*.java
java -cp out doradora.UseRobot
java -cp out poke.Trainer
```

## 学習内容

- クラスとインスタンス
- フィールドとメソッド
- setterとgetter
- コンストラクタ
- 配列と拡張for文
- 条件分岐
- 乱数

