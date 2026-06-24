import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckoutPointCalculator {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String again;			//もう一度か
		
		do {
			
			int itemCount;			//商品数量
			int price;				//今の商品金額
			int pointMoney = 100;	//ポイントの基準金額
			int point;				//今の商品のポイント
			int buyCount = 0;		//実際買った商品数
			int totalPrice = 0;		//合計金額
			int totalPoint = 0;		//合計ポイント
			int maxPrice = -1;		//最高金額
			
			while(true) {
				System.out.print("商品数を入力してください：");
				
				String input = br.readLine();
				itemCount = Integer.parseInt(input);
				
				if(itemCount < 1 || itemCount > 20) {
					System.out.println("1～20の商品数を入力してください。");
				}else {
					break;
				}
			}
			
			for(int i=1; i<=itemCount; i++) {
				while(true) {
					System.out.print(i + "個目の金額を入力してください：");
					
					String input = br.readLine();
					price = Integer.parseInt(input);
					
					if(price == -1) {
						System.out.println("会計を中止します。");
						break;
					}
					
					if(price >= 0 && price <= 50000) {
						break;
					}
					
					System.out.println("0～50000の金額、または -1 を入力してください。");
				}
				
				if(price == -1) {
					break;
				}
				
				if(price > maxPrice) {
					maxPrice = price;
				}
				
				buyCount ++;
				totalPrice += price;
				
				if(price < 100) {
					System.out.println("ポイント対象外です。");
					continue;
				}
				
				point = price / pointMoney;
				System.out.println(point + "ポイント追加しました。");
				totalPoint += point;
			}
			
			System.out.println("購入商品数：" + buyCount + "個");
			System.out.println("合計金額：" + totalPrice + "円");
			System.out.println("合計ポイント：" + totalPoint + "ポイント");
			
			if(buyCount > 0) {
				System.out.println("最高金額：" + maxPrice + "円");
			}else {
				System.out.println("最高金額：なし");
			}
			
			System.out.print("もう一度会計しますか？ yes / no：");
			again = br.readLine();
		}while(again.equals("yes"));
		
		System.out.println("終了します。");
	}

}
