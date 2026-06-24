import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeSumCalculator 
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("指定した範囲の整数を合計します。");
		
		System.out.println("開始の整数を⼊⼒してください：");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input1 = br.readLine();
		int numStart = Integer.parseInt(input1);
		
		System.out.println("終了の整数を⼊⼒してください：");
		
		String input2 = br.readLine();
		int numFinal = Integer.parseInt(input2);
		
		int sum = 0;
		
		if(numStart > numFinal) {
			for(int i=numFinal; i<=numStart; i++) {
				sum += i;
			}
			System.out.println(numFinal + "~" + numStart + "の合計は" + sum + "です。");
		}else {
			for(int i=numStart; i<=numFinal; i++) {
				sum += i;
			}
			System.out.println(numStart + "~" + numFinal + "の合計は" + sum + "です。");
		}
	}
}
