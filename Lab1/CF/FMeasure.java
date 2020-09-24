import java.util.Scanner;

public class FMeasure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] FArray = new double[n];
        double[] precArray = new double[n];
        double[] recallArray = new double[n];
        double macroF;
        int allSum = 0;
        double microF = 0.0;
        double gPrec = 0.0;
        double gRecall = 0.0;
        int[][] confMatrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                confMatrix[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < n; j++){
                rowSum += confMatrix[i][j];
                columnSum += confMatrix[j][i];
            }if (rowSum != 0) {
                recallArray[i] = (double) confMatrix[i][i] / (double) rowSum;
            } else {
                recallArray[i] = 0;
            }
            if (columnSum != 0) {
                precArray[i] = (double) confMatrix[i][i] / (double) columnSum;
            } else{
                precArray[i] = 0;
            }
            if (recallArray[i] + precArray[i] != 0) {
                FArray[i] = 2 * (recallArray[i] * precArray[i]) / (recallArray[i] + precArray[i]);
            } else {
                FArray[i] = 0;
            }
        }
        for (int i = 0; i < n; i++){
            int rowSum = 0;
            for (int j = 0; j < n; j++){
                rowSum += confMatrix[i][j];
            }
            microF += FArray[i] * rowSum;
            gPrec += precArray[i] * rowSum;
            gRecall += recallArray[i] * rowSum;
            allSum += rowSum;
        }
        gPrec = gPrec / allSum;
        gRecall = gRecall / allSum;
        microF = microF / allSum;
        macroF = 2 * (gPrec * gRecall) / (gPrec + gRecall);
        System.out.println(macroF);
        System.out.print(microF);
    }
}
