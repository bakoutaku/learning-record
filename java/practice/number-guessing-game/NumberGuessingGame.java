import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class NumberGuessingGame {
	public static void main(String[] args) throws IOException {
		
		int guess;
		String again;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		System.out.println("１から１００までの数字を試しましょう！");
		System.out.println("（-1を入力して諦める。）");
		System.out.println("（0を入力してパスする。）");
		
		do {
			int answer = rand.nextInt(100) + 1;
			//５回のループ
			for(int i=1; i<=5; i++) {
				//入力範囲を制限する
				while(true) {
					System.out.print(i + "回目の予想を入力してください：");
					
					String input = br.readLine();
					guess = Integer.parseInt(input);
					
					if(guess == -1) {
						System.out.println("ゲームを中止します。");
						break;
					}
					if(guess == 0) {
						break;
					}
					if(guess >=1 && guess <= 100) {
						break;
					}
					
					System.out.println("1～100の数字、0、または -1 を入力してください。");
				}
				//ループを抜ける
				if(guess == -1) {
					break;
				}
				if(guess == 0) {
					System.out.println("パスしました。");
					if(i == 5) {
						System.out.println("残念でした。正解は" + answer +"です。");
					}
					continue;
				}
				//当てるか
				if(guess > answer) {
					System.out.println("大きすぎます。");
				}else if(guess < answer) {
					System.out.println("小さすぎます。");
				}else {
					System.out.println("正解です！");
					break;
				}
				
				if(i == 5) {
					System.out.println("残念でした。正解は" + answer +"です。");
				}
			}
			System.out.print("もう一度遊びますか？ yes / no：");
			again = br.readLine();
		}while(again.equals("yes"));
		
		System.out.println("終了します。");
	}

}
