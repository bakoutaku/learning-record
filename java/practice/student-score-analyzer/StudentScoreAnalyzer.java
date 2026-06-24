import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentScoreAnalyzer {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String again;

		do {
			int studentCount;
			int score;
			int inputCount = 0;
			int passCount = 0;
			int passSum = 0;
			int maxScore = -1;

			// 学生人数入力
			while (true) {
				System.out.print("学生人数を入力してください：");

				String input = br.readLine();
				studentCount = Integer.parseInt(input);

				if (studentCount >= 1 && studentCount <= 30) {
					break;
				} else {
					System.out.println("1～30の人数を入力してください。");
				}
			}

			// 点数入力
			for (int i = 1; i <= studentCount; i++) {

				while (true) {
					System.out.print(i + "人目の点数を入力してください：");

					String input = br.readLine();
					score = Integer.parseInt(input);

					if (score == -1) {
						System.out.println("入力を終了します。");
						break;
					}

					if (score >= 0 && score <= 100) {
						break;
					}

					System.out.println("0～100の点数、または -1 を入力してください。");
				}

				if (score == -1) {
					break;
				}

				inputCount++;

				if (score > maxScore) {
					maxScore = score;
				}

				if (score < 60) {
					System.out.println(i + "人目：不合格です。");
					continue;
				}

				System.out.println(i + "人目：合格です。");
				passCount++;
				passSum += score;
			}

			// 結果出力
			System.out.println();
			System.out.println("入力人数：" + inputCount + "人");
			System.out.println("合格人数：" + passCount + "人");

			if (inputCount > 0) {
				System.out.println("最高点：" + maxScore + "点");
			} else {
				System.out.println("最高点：なし");
			}

			if (passCount > 0) {
				int average = passSum / passCount;
				System.out.println("合格者平均：" + average + "点");
			} else {
				System.out.println("合格者はいません。");
			}

			System.out.print("もう一度実行しますか？ yes / no：");
			again = br.readLine();

		} while (again.equals("yes"));

		System.out.println("終了します。");
	}
}
