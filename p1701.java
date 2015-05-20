
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Dissatisfying Lift Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 5111	Accepted: 1126 Description
 *
 * There's a building with M floors. The amounts of tenants of every floor are
 * K1, K2, K3, ..., Km. One day all the tenants went home together and they took
 * the same lift (suppose the lift was large enough). Because of some reason the
 * lift could only stop on one floor and the tenants must go upstairs or
 * downstairs to their houses. Every tenant went up N floors would make the
 * dissatisfied degree rise N * a + 0.5 * N * (N - 1) degrees, and every tenant
 * went down N floors would make the dissatisfied degree rise N * b + 0.5 * N *
 * (N - 1) degrees. Your task is to tell which floor the lift should stop, in
 * order to make the dissatisfied degree as low as possible. Input
 *
 * The first line of the input contains a single integer T (1 <= T <= 20), the
 * number of test cases. Then T cases follow. The first line of each test
 * contains M (1 <= M <= 10000), a and b (0 <= a, b <= 100). The second line
 * contains K1, K2, K3, ..., Km (0 <= Ki <= 20, i = 1..M). Output
 *
 * For each test case, print a line containing a single integer, indicating
 * which floor the lift should stop. Sample Input
 *
 * 1
 * 5 3 2
 * 1 1 1 1 1
 * Sample Output
 *
 * 3
 * Source
 *
 * POJ Monthly--2004.07.18
 */
public class p1701 {

    public static void main(String[] args) {
        /*
         * Scanner in = new Scanner(System.in); int t = in.nextInt(); for (int i
         * = 0; i < t; i++) { int M = in.nextInt(); int a = in.nextInt(); int b
         * = in.nextInt(); int[] K = new int[M + 1]; for (int j = 1; j <= M;
         * j++) { K[j] = in.nextInt(); } int[] degree = new int[M + 1]; int min
         * = Integer.MAX_VALUE; int index = -1; for (int j = 1; j <= M; j++) {
         * for (int k = j + 1; k <= M; k++) { degree[j] += (k - j) * a + 0.5 *
         * (k - j * (k - j - 1)); } for (int k = j - 1; k >= 1; k--) { degree[j]
         * += (j - k) * b + 0.5 * (j - k * (j - k - 1)); } if(min > degree[j]) {
         * min = degree[j]; index = j; } } System.out.println(index); }
         *
         */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int M = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int[] K = new int[M + 1];
            for (int j = 1; j < M; j++) {
                K[i] = in.nextInt();
            }
            

        }

    }
}
