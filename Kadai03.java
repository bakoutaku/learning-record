package jp.ac.hal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadai03 
{
	public static void main(String[] args) throws IOException
	{
		//演習１
		System.out.println("「演習１」税額");
		System.out.println("金額を入力してください：");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		int money1 = Integer.parseInt(input1);
		
		int zeikinn1 = money1 / 10;
		int zeikomiMoney = money1 + zeikinn1;
		
		System.out.println("税額：" + zeikinn1 + "円");
		System.out.println("税込金額：" + zeikomiMoney + "円");
		
		//演習２
		System.out.println("「演習２」オークション");
		System.out.println("落札価額を入力してください：");
		
		String input2 = br.readLine();
		int money2 = Integer.parseInt(input2);
		
		if(money2 < 0) { 
			System.out.println("正しい落札価額を入力してください！") ;
		}else if(money2 > 2000) {
			System.out.println("落札！");
		}else {
			System.out.println("落札ならず！");
		}
		
		//演習３
		System.out.println("「演習３」ガチャ");
		System.out.println("カードNoを入力してください：");
		
		String input3 = br.readLine();
		int no1 = Integer.parseInt(input3);
		
		if(no1 <= 0 || no1 >9) {
			System.out.println("カードNoは1-9を入力してください：");
		}else if(no1 == 1) {
			System.out.println("レアリティ：⭐︎");
		}else if(no1 < 4) {
			System.out.println("レアリティ：⭐︎⭐︎︎︎");
		}else if(no1 < 7) {
			System.out.println("レアリティ：⭐︎⭐︎⭐︎︎︎︎");
		}else if(no1 < 9) {
			System.out.println("レアリティ：⭐︎⭐︎⭐︎⭐︎︎");
		}else {
			System.out.println("レアリティ：⭐︎⭐︎⭐︎⭐︎⭐︎︎");
		}
		
		//演習４
		System.out.println("「演習４」評価");
		System.out.println("得点を入力してください：");
		
		String input4 = br.readLine();
		int tennsuu = Integer.parseInt(input4);
		
		if(tennsuu < 0 || tennsuu >100) {
			System.out.println("本当の点数を入力してください");
		}else if(tennsuu == 100) {
			System.out.println("評価：S\n" + "合格！");
		}else if(tennsuu >=80) {
			System.out.println("評価：A\n" + "合格！");
		}else if(tennsuu >= 60) {
			System.out.println("評価：B\n" + "合格！");
		}else {
			System.out.println("評価：C\n" + "不合格");
		}
	}

}
