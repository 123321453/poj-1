
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Lining Up Time Limit: 2000MS	Memory Limit: 32768K Total Submissions: 19193
 * Accepted: 6084 Description
 *
 * "How am I ever going to solve this problem?" said the pilot.  *
 * Indeed, the pilot was not facing an easy task. She had to drop packages at
 * specific points scattered in a dangerous area. Furthermore, the pilot could
 * only fly over the area once in a straight line, and she had to fly over as
 * many points as possible. All points were given by means of integer
 * coordinates in a two-dimensional space. The pilot wanted to know the largest
 * number of points from the given set that all lie on one line. Can you write a
 * program that calculates this number?  *
 *
 * Your program has to be efficient! Input
 *
 * Input consist several case,First line of the each case is an integer N ( 1 <
 * N < 700 ),then follow N pairs of integers. Each pair of integers is separated
 * by one blank and ended by a new-line character. The input ended by N=0.
 * Output
 *
 * output one integer for each input case ,representing the largest number of
 * points that all lie on one line. Sample Input
 *
 * 5
 * 1 1
 * 2 2
 * 3 3
 * 9 10 10 11 0 Sample Output
 *
 * 3
 */
public class p1118_1 {

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
            double[] argT = new double[N];
            for (i = 0; i < N; i++) {
                arrX[i] = in.nextInt();          
                arrY[i] = in.nextInt();
                argT[i] = Math.atan((double)arrX[i] / (double)arrY[i]) + 2*Math.PI;
            }
            /*
            int max = 0;
            int tmp = 0;
            for(i = 0; i < N-2 ; i++){    
                for(int j = i+1 ; j < N-1 ;j++) {
                    tmp = 0;
                    double x = arrX[j] - arrX[i];
                    double y = arrY[j] - arrY[i];
                    for(int k = j+1 ; k < N ; k++) {
                        if(x* (arrY[k] - arrY[i]) == y * (arrX[k] - arrX[i]))
                            tmp++;
                    }
                    if(max < tmp)
                        max = tmp;
                }
            }
            System.out.println(max+2);
            */
            Arrays.sort(argT);
            int max = Integer.MIN_VALUE;
            int tmp = 0;
            for(i = 0; i < N ; i++){
                tmp = 1;
                for(int j = i+1; j < N;j++){
                    if(argT[j] == argT[i])
                        tmp++;
                }
                if(max < tmp)
                    max = tmp;
            }
            System.out.println(max);
       

        }
    
    }
}
