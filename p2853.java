
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Sequence Sum Possibilities Time Limit: 1000MS	Memory Limit: 65536K Total
 * Submissions: 5377	Accepted: 3538 Description
 *
 * Most positive integers may be written as a sum of a sequence of at least two
 * consecutive positive integers. For instance,
 *
 * 6 = 1 + 2 + 3
 * 9 = 5 + 4 = 2 + 3 + 4
 * but 8 cannot be so written. Write a program which will compute how many
 * different ways an input number may be written as a sum of a sequence of at
 * least two consecutive positive integers.
 *
 * Input
 *
 * The first line of input will contain the number of problem instances N on a
 * line by itself, (1 ≤ N ≤ 1000) . This will be followed by N lines, one for
 * each problem instance. Each problem line will have the problem number, a
 * single space and the number to be written as a sequence of consecutive
 * positive integers. The second number will be less than 231 (so will fit in a
 * 32-bit integer).
 *
 * Output
 *
 * The output for each problem instance will be a single line containing the
 * problem number, a single space and the number of ways the input number can be
 * written as a sequence of consecutive positive integers.
 *
 * Sample Input
 *
 * 7
 * 1 6
 * 2 9
 * 3 8
 * 4 1800 5 987654321 6 987654323 7 987654325 Sample Output
 *
 * 1 1
 * 2 2
 * 3 0
 * 4 8
 * 5 17 6 1 7 23 Source
 *
 * Greater New York 2005
 */
public class p2853 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int j = 1; j <= num; j++) {
            int index = in.nextInt();
            int N = in.nextInt();
            int cnt = 0;
            int sum = 0;
            for (int i = 1; sum <= N; i++) {
                sum += i;
                if ((N-sum)%(i+1)==0&&(N-sum)/(i+1)!=0) {
                    cnt++;
                }
            }
            System.out.println(index + " " + cnt);
        }
    }
}
