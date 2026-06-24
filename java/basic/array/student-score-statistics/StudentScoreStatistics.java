import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentScoreStatistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] scores = new int[6];
		int sum = 0;
		double average = 0.0;
		int passCount = 0;
		int failCount = 0;
		int over90Count = 0;
		int overAverageCount = 0;
		
		System.out.println("6人の点数を入力してください。");
		
		for (int i = 0; i < scores.length; i++) {
			System.out.print((i + 1) + "人目：");
			int input = Integer.parseInt(br.readLine());
			scores[i] = input;
		}
		
		int max = scores[0];
		int min = scores[0];
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= 90) {
				System.out.println((i + 1) + "番目の点数は" + scores[i] + "です。判定：A");
				over90Count++;
				passCount++;
			}else if (scores[i] >= 80) {
				System.out.println((i + 1) + "番目の点数は" + scores[i] + "です。判定：B");
				passCount++;
			}else if (scores[i] >= 60) {
				System.out.println((i + 1) + "番目の点数は" + scores[i] + "です。判定：C");
				passCount++;
			}else {
				System.out.println((i + 1) + "番目の点数は" + scores[i] + "です。判定：不合格");
				failCount++;
			}
			
			sum += scores[i];
			
			if (scores[i] > max) {
				max = scores[i];
			}
			
			if (scores[i] < min) {
				min = scores[i];
			}
		}
		
		average = (double) sum / scores.length;
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= average) {
				overAverageCount++;
			}
		}
		
		System.out.println("合計点は" + sum + "です。");
		System.out.println("平均点は" + average + "です。");
		System.out.println("最高点は" + max + "です。");
		System.out.println("最低点は" + min + "です。");
		System.out.println("合格者数は" + passCount + "人です。");
		System.out.println("不合格者数は" + failCount + "人です。");
		System.out.println("90点以上の人数は" + over90Count + "人です。");
		System.out.println("平均点以上の人数は" + overAverageCount + "人です。");
	}
	
}
