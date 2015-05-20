
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Common Subsequence Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 31444	Accepted: 12243 Description
 *
 * A subsequence of a given sequence is the given sequence with some elements
 * (possible none) left out. Given a sequence X = < x1, x2, ..., xm > another
 * sequence Z = < z1, z2, ..., zk > is a subsequence of X if there exists a
 * strictly increasing sequence < i1, i2, ..., ik > of indices of X such that
 * for all j = 1,2,...,k, xij = zj. For example, Z = < a, b, f, c > is a
 * subsequence of X = < a, b, c, f, b, c > with index sequence < 1, 2, 4, 6 >.
 * Given two sequences X and Y the problem is to find the length of the
 * maximum-length common subsequence of X and Y. Input
 *
 * The program input is from the std input. Each data set in the input contains
 * two strings representing the given sequences. The sequences are separated by
 * any number of white spaces. The input data are correct. Output
 *
 * For each set of data the program prints on the standard output the length of
 * the maximum-length common subsequence from the beginning of a separate line.
 * Sample Input
 *
 * abcfbc abfcab programming contest abcd mnp Sample Output
 *
 * 4
 * 2
 * 0
 * Source
 *
 * Southeastern Europe 2003
 */
public class p1458 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String x = in.next();
            String y = in.next();
            int M = x.length();
            int N = y.length();
            int[][] opt = new int[M + 1][N + 1];
            
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (x.charAt(i) == y.charAt(j)) {
                        opt[i][j] = opt[i + 1][j + 1] + 1;
                    } else {
                        opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                    }
                }
            }

            int i = 0, j = 0;
            int cnt = 0;
            while (i < M && j < N) {
                if (x.charAt(i) == y.charAt(j)) {
                 //   System.out.print(x.charAt(i));
                    i++;
                    j++;
                    cnt++;
                } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
            System.out.println(cnt);

        }
    }

}
