
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Triangular Sums Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 5777	Accepted: 4108 Description
 *
 * The nth Triangular number, T(n) = 1 + … + n, is the sum of the first n
 * integers. It is the number of points in a triangular array with n points on
 * side. For example T(4):
 *
 * X
 * X X
 * X X X
 * X X X X
 * Write a program to compute the weighted sum of triangular numbers:
 *
 * W(n) = SUM[k = 1…n; k * T(k + 1)]
 *
 * Input
 *
 * The first line of input contains a single integer N, (1 ≤ N ≤ 1000) which is
 * the number of datasets that follow.
 *
 * Each dataset consists of a single line of input containing a single integer
 * n, (1 ≤ n ≤300), which is the number of points on a side of the triangle.
 *
 * Output
 *
 * For each dataset, output on a single line the dataset number (1 through N), a
 * blank, the value of n for the dataset, a blank, and the weighted sum ,W(n),
 * of triangular numbers for n.
 *
 * Sample Input
 *
 * 4
 * 3
 * 4
 * 5
 * 10 Sample Output
 *
 * 1 3 45 2 4 105 3 5 210 4 10 2145
 */
public class p3086 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //int[] T = new int[310];
        int[] re = new int[310];
        re[1] = 3;
        for (int i = 1; i <= N; i++) {
            int n = in.nextInt();
            if(n == 1) {
                System.out.println(i + " " + n + " " + re[1]);
                continue;
            }
            if (re[n] != 0) {
                System.out.println(i + " " + n + " " + re[n]);
                continue;
            }
            for (int k = 2; k <= n; k++) {
                if (re[k] == 0) {
                    re[k] = k * (2 + k) * (k + 1) / 2 + re[k - 1];
                    // re[n] += re[k];
                }

            }
            System.out.println(i + " " + n + " " + re[n]);
        }
    }
}
