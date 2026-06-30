import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentSubjectStatistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] subjects = {"国語", "数学", "英語", "Java"};
        int[][] scores = new int[3][4];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print((i + 1) + "人目の" + subjects[j] + "：");
                scores[i][j] = Integer.parseInt(br.readLine());
            }
        }

        double averageStudents = 0;
        double averageSubjects = 0;
        int passStudents = 0;
        int failNum = 0;

        int highestScore = scores[0][0];
        int highestStudent = 1;
        String highestSubject = subjects[0];

        int highestSumStudentCount = 0;
        int highestSumStudentNum = 1;

        // students sum, average, pass
        for (int i = 0; i < scores.length; i++) {
            int sumStudents = 0;
            boolean allPass = true;

            for (int j = 0; j < scores[i].length; j++) {
                sumStudents += scores[i][j];

                if (scores[i][j] > highestScore) {
                    highestScore = scores[i][j];
                    highestStudent = i + 1;
                    highestSubject = subjects[j];
                }

                if (scores[i][j] < 60) {
                    allPass = false;
                    failNum++;
                }
            }

            if (sumStudents > highestSumStudentCount) {
                highestSumStudentCount = sumStudents;
                highestSumStudentNum = i + 1;
            }

            System.out.println((i + 1) + "人目の合計点は" + sumStudents + "です。");

            averageStudents = (double) sumStudents / scores[i].length;
            System.out.println((i + 1) + "人目の平均点は" + averageStudents + "です。");

            if (allPass && averageStudents >= 70) {
                System.out.println((i + 1) + "人目は総合合格です。");
                passStudents++;
            } else {
                System.out.println((i + 1) + "人目は総合不合格です。");
            }

            System.out.println();
        }

        // subjects average
        for (int i = 0; i < subjects.length; i++) {
            int sumSubjects = 0;

            for (int j = 0; j < scores.length; j++) {
                sumSubjects += scores[j][i];
            }

            averageSubjects = (double) sumSubjects / scores.length;
            System.out.println(subjects[i] + "の平均点は" + averageSubjects + "です。");
        }

        // final output
        System.out.println();
        System.out.println("総合合格者数は" + passStudents + "人です。");
        System.out.println("60点未満の点数の数は" + failNum + "個です。");
        System.out.println("最高点は" + highestStudent + "人目の" + highestSubject + "で" + highestScore + "点です。");
        System.out.println("合計点が一番高いのは" + highestSumStudentNum + "人目で" + highestSumStudentCount + "点です。");
    }
}
