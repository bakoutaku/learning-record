import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentScoreAnalyzer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] names = new String[5];
		int[] scores = new int[5];
		int sum = 0;
		
		System.out.println(names.length + "人分の名前と点数を入力してください。");
		
		for (int i = 0; i < names.length; i++) {
			System.out.println((i + 1) + "人目の名前：");
			String inputName = br.readLine();
			names[i] = inputName;
			
			System.out.println((i + 1) + "人目の点数：");
			int inputScores = Integer.parseInt(br.readLine());
			scores[i] = inputScores;
			sum += scores[i];
		}
		
		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {
				if (scores[j] > scores[i]) {
					//scores change
					int tmpScores = scores[i];
					scores[i] = scores[j];
					scores[j] = tmpScores;
					
					//name change
					String tmpName = names[i];
					names[i] = names[j];
					names[j] = tmpName;
				}
			}
		}
		
		int max = scores[0];
		int min = scores[scores.length - 1];
		double average = (double)sum / scores.length;
		
		System.out.println("点数が高い順に表示します。");
		
		for (int i = 0; i < names.length; i++) {
			System.out.println((i + 1) + "番目：" + names[i] + "さん " + scores[i] + "点"); 
		}
		
		System.out.println("最高点は" + max + "点です。");
		System.out.println("最低点は" + min + "点です。");
		System.out.println("平均点は" + average + "点です。");
	}

}
