
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author taofeng
 */
public class p2606 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            if (N == 0) {
                break;
            }
            int i;
            int[] arrX = new int[N];
            int[] arrY = new int[N];
            // double[] argT = new double[N];
            for (i = 0; i < N; i++) {
                arrX[i] = in.nextInt();
                arrY[i] = in.nextInt();
                //   argT[i] = Math.atan((double)arrX[i] / (double)arrY[i]) + 2*Math.PI;
            }
            int max = 0;
            int tmp = 0;
            for (i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    tmp = 0;
                    double x = arrX[j] - arrX[i];
                    double y = arrY[j] - arrY[i];
                    for (int k = j + 1; k < N; k++) {
                        if (x * (arrY[k] - arrY[i]) == y * (arrX[k] - arrX[i])) {
                            tmp++;
                        }
                    }
                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
            System.out.println(max + 2);
        }
    }
}
