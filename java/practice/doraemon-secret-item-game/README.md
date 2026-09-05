# Doraemon Secret Item Game

## 概要

Javaのクラスとオブジェクト指向を練習するために作成した、ドラえもんを題材にしたコンソールプログラムです。  
ランダムに選ばれた異なる3つのどら焼きの個数に応じて、ドラえもんの反応と受け取れるひみつ道具が変わります。

## 主な機能

- `Robot` オブジェクトにID、名前、種類を設定
- setterとgetterによるフィールド操作
- どら焼きの個数に応じたメッセージ表示
- 1～10個のどら焼きに対応する10種類のひみつ道具
- 0～10の範囲から重複しない3つの数をランダムに生成
- どら焼きが0個の場合は、ひみつ道具を受け取らない

## クラス構成

```text
src
└── doradora
    ├── Robot.java
    └── UseRobot.java
```

| クラス | 役割 |
| --- | --- |
| `Robot` | ドラえもんの情報、どら焼きへの反応、ひみつ道具を管理する |
| `UseRobot` | オブジェクトを生成し、ランダムな個数でプログラムを実行する |

## 実行方法

### Eclipse

`src/doradora/UseRobot.java` をJavaアプリケーションとして実行します。

### コマンドライン

```bash
javac -encoding UTF-8 -d out src/doradora/*.java
java -cp out doradora.UseRobot
```

## 学習内容

- クラスとインスタンス
- フィールドとメソッド
- setterとgetter
- 配列
- 条件分岐
- `Random` クラス
- `while` 文による重複チェック

