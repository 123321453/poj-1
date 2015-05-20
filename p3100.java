
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Root of the Problem Time Limit: 1000MS	Memory Limit: 65536K Total
 * Submissions: 10673	Accepted: 5723 Description
 *
 * Given positive integers B and N, find an integer A such that AN is as close
 * as possible to B. (The result A is an approximation to the Nth root of B.)
 * Note that AN may be less than, equal to, or greater than B.
 *
 * Input
 *
 * The input consists of one or more pairs of values for B and N. Each pair
 * appears on a single line, delimited by a single space. A line specifying the
 * value zero for both B and N marks the end of the input. The value of B will
 * be in the range 1 to 1,000,000 (inclusive), and the value of N will be in the
 * range 1 to 9 (inclusive).
 *
 * Output
 *
 * For each pair B and N in the input, output A as defined above on a line by
 * itself.
 *
 * Sample Input
 *
 * 4 3
 * 5 3
 * 27 3 750 5 1000 5 2000 5 3000 5 1000000 5 0 0 Sample Output
 *
 * 1
 * 2
 * 3
 * 4
 * 4
 * 4
 * 5
 * 16
 */
public class p3100 {

    public static void main(String[] args) {
        //int[] tab = new int[1000001];
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int B = in.nextInt();
            int N = in.nextInt();
            if ((B | N) == 0) {
                break;
            }

            int A = (int)Math.pow((double) B, (double) 1 / N);
            if(Math.abs(Math.pow(A,N) - B) > Math.abs(Math.pow(A+1, N) - B)) {
                A += 1;
            }
            System.out.println(A);

        }
    }
}
