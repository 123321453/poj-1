
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Bank Interest Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 12800	Accepted: 7653 Description
 *
 * Farmer John made a profit last year! He would like to invest it well but
 * wonders how much money he will make. He knows the interest rate R (an integer
 * between 0 and 20) that is compounded annually at his bank. He has an integer
 * amount of money M in the range 100..1,000,000. He knows how many years Y
 * (range: 0..400) he intends to invest the money in the bank. Help him learn
 * how much money he will have in the future by compounding the interest for
 * each year he saves. Print an integer answer without rounding. Answers for the
 * test data are guaranteed to fit into a signed 32 bit integer. Input
 *
 * Line 1: Three space-separated integers: R, M, and Y Output
 *
 * Line 1: A single integer that is the number of dollars FJ will have after Y
 * years. Sample Input
 *
 * 5 5000 4 Sample Output
 *
 * 6077 Hint
 *
 * INPUT DETAILS:  *
 * 5% annual interest, 5000 money, 4 years  *
 * OUTPUT DETAILS:  *
 * Year 1: 1.05 * 5000 = 5250 Year 2: 1.05 * 5250 = 5512.5 Year 3: 1.05 *
 * 5512.50 = 5788.125 Year 4: 1.05 * 5788.125 = 6077.53125 The integer part of
 * 6077.53125 is 6077.
 */
public class p2390 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int R = in.nextInt();
            long M = in.nextLong();
            int Y = in.nextInt();
            double tmp = (double) R / (double) 100.0;
            double result = M;
            for (int i = 0; i < Y; i++) {
                result = (1 + tmp) * result;
            }
            System.out.println((long) Math.floor(result));
        }
    }
}
