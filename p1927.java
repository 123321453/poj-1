
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Area in Triangle Time Limit: 1000MS	Memory Limit: 30000K Total Submissions:
 * 1293	Accepted: 693 Description
 *
 * Given a triangle field and a rope of a certain length (Figure-1), you are
 * required to use the rope to enclose a region within the field and make the
 * region as large as possible.  *
 *
 * Input
 *
 * The input has several sets of test data. Each set is one line containing four
 * numbers separated by a space. The first three indicate the lengths of the
 * edges of the triangle field, and the fourth is the length of the rope. Each
 * of the four numbers have exactly four digits after the decimal point. The
 * line containing four zeros ends the input and should not be processed. You
 * can assume each of the edges are not longer than 100.0000 and the length of
 * the rope is not longer than the perimeter of the field. Output
 *
 * Output one line for each case in the following format:  *
 * Case i: X  *
 * Where i is the case number, and X is the largest area which is rounded to two
 * digits after the decimal point. Sample Input
 *
 * 12.0000 23.0000 17.0000 40.0000 84.0000 35.0000 91.0000 210.0000 100.0000
 * 100.0000 100.0000 181.3800 0 0 0 0 Sample Output
 *
 * Case 1: 89.35 Case 2: 1470.00 Case 3: 2618.00 Source
 *
 * Beijing 2004 Preliminary@POJ
 */
public class p1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = 1;
        double l1, l2, l3, s, c, p, R, ctg1, ctg2, ctg3, len, r, ls, area;

        while (sc.hasNext()) {
            l1 = sc.nextDouble();
            l2 = sc.nextDouble();
            l3 = sc.nextDouble();
            len = sc.nextDouble();
            if (l1 == 0 && l2 == 0 && l3 == 0 && len == 0) {
                break;
            }

            c = l1 + l2 + l3;
            p = (l1 + l2 + l3) / 2;
            s = Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));

            if (len >= c) {
                System.out.printf("Case %d: %.2f\n", k++, s);
                continue;
            }
            R = s * 2 / c;
            if (len <= R * 2 * Math.PI) {
                System.out.printf("Case %d: %.2f\n", k++, len * len / (4 * Math.PI));
                continue;
            }
            ctg1 = (p - l1) / R;
            ctg2 = (p - l2) / R;
            ctg3 = (p - l3) / R;
            r = (c - len) / (2 * (ctg1 + ctg2 + ctg3) - 2 * Math.PI);
            ls = c - 2 * (ctg1 + ctg2 + ctg3) * r;
            l1 -= (ctg2 + ctg3) * r;
            l2 -= (ctg1 + ctg3) * r;
            l3 -= (ctg1 + ctg2) * r;
            p = (l1 + l2 + l3) / 2;
            area = ls * r + Math.sqrt(p * (p - l1) * (p - l2) * (p - l3)) + r * r * Math.PI;
            System.out.printf("Case %d: %.2f\n", k++, area);
        }
    }
}
