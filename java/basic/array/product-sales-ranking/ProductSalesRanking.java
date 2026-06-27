import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSalesRanking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] names = new String[5];      // 商品名
		int[] prices = new int[5];           // 単価
		int[] quantities = new int[5];       // 販売数
		int[] sales = new int[5];            // 売上
		int sum = 0;
		
		System.out.println("5個の商品情報を入力してください。");

		// ① 商品名、単価、販売数を入力する
		for (int i = 0; i < names.length; i++) {
			System.out.println((i + 1) + "個目の商品名：");
			names[i] = br.readLine();
			
			System.out.println((i + 1) + "個目の単価：");
			prices[i] = Integer.parseInt(br.readLine());
			
			System.out.println((i + 1) + "個目の販売数：");
			quantities[i] = Integer.parseInt(br.readLine());
		}

		// ② 売上を計算する
		for (int i = 0; i < sales.length; i++) {
			sales[i] = prices[i] * quantities[i];
			sum += sales[i];
		}

		// ③ 売上が高い順に並べ替える
		// 売上が同じ場合は、販売数が多い順にする
		for (int i = 0; i < sales.length; i++) {
			for (int j = i + 1; j < sales.length; j++) {
				if (sales[j] > sales[i] ||
				   (sales[j] == sales[i] && quantities[j] > quantities[i])) {
					
					// sales change
					int tmpSales = sales[i];
					sales[i] = sales[j];
					sales[j] = tmpSales;
					
					// names change
					String tmpName = names[i];
					names[i] = names[j];
					names[j] = tmpName;
					
					// prices change
					int tmpPrice = prices[i];
					prices[i] = prices[j];
					prices[j] = tmpPrice;
					
					// quantities change
					int tmpQuantity = quantities[i];
					quantities[i] = quantities[j];
					quantities[j] = tmpQuantity;
				}
			}
		}

		// ④ ランキングを表示する
		System.out.println("売上が高い順に表示します。");
		
		for (int i = 0; i < names.length; i++) {
			System.out.print((i + 1) + "位：" + names[i]);
			System.out.print("　単価：" + prices[i] + "円　");
			System.out.print("販売数：" + quantities[i] + "個　");
			System.out.println("売上：" + sales[i] + "円");
		}
		
		// average
		double average = (double) sum / sales.length;

		// ⑤ 合計売上、平均売上、最高売上、最低売上を表示する
		System.out.println("合計売上は" + sum + "円です。");
		System.out.println("平均売上は" + average + "円です。");
		System.out.println("最高売上は" + sales[0] + "円です。");
		System.out.println("最低売上は" + sales[sales.length - 1] + "円です。");
	}
}
