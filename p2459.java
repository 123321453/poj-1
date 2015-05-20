
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Feed Accounting Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 1649	Accepted: 908 Description
 *
 * Farmer John is trying to figure out when his last shipment of feed arrived.
 * Starting with an empty grain bin, he ordered and received F1 (1 <= F1 <=
 * 1,000,000) kilograms of feed. Regrettably, he is not certain exactly when the
 * feed arrived. Of the F1 kilograms, F2 (1 <= F2 <= F1) kilograms of feed
 * remain on day D (1 <= D <= 2,000). He must determine the most recent day that
 * his shipment could have arrived. * Each of his C (1 <= C <= 100) cows eats
 * exactly 1 kilogram of feed each day. For various reasons, cows arrive on a
 * certain day and depart on another, so two days might have very different feed
 * consumption. The input data tells which days each cow was present. Every cow
 * ate feed from Farmer John's bin on the day she arrived and also on the day
 * she left. * Given that today is day D, determine the minimum number of days
 * that must have passed since his last shipment. The cows have already eaten
 * today, and the shipment arrived before the cows had eaten. Input
 *
 * Line 1: Four space-separated integers: C, F1, F2, and D * Lines 2..C+1: Line
 * i+1 contains two space-separated integers describing the presence of a cow.
 * The first integer tells the first day the cow was on the farm; the second
 * tells the final day of the cow's presence. Each day is in the range 1..2,000.
 * Output
 *
 * The last day that the shipment might have arrived, an integer that will
 * always be positive. Sample Input
 *
 * 3 14 4 10 1 9 5 8 8 12 Sample Output
 *
 * 6
 * Hint
 *
 * INPUT DETAILS: * The shipment was 14 kilograms of feed, and Farmer John has 4
 * kilograms left. He had three cows that ate feed for some amount of time in
 * the last 10 days. * OUTPUT DETAILS: * If Farmer John started with 14 kg of
 * feed on day 6, then on days 6 and 7, two kilograms would be eaten each day.
 * On day 8, three kilograms would be eaten. On day 9, two kilograms would be
 * eaten. On day 10, one kilogram would be eaten. Thus, the total eaten would be
 * 2 + 2 + 3 + 2 + 1 = 10, leaving him with 4 kilograms. Source
 *
 * USACO 2005 February Silver
 */
public class p2459 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        int F1 = in.nextInt();
        int F2 = in.nextInt();
        int D = in.nextInt();
        int j;
        int[] acc = new int[D+1];
        for (int i = 0; i < C; i++) {
            int d1 = in.nextInt();
            int d2 = in.nextInt();
            if (d2 < D) {
                for (j = d1; j <= d2; j++) {
                    acc[j]++;
                }
            } else {
                for (j = d1; j <= D; j++) {
                    acc[j]++;
                }
            }
        }
        int tmp = F1 - F2;
        int k;
        for (k = D; k > 1 && tmp > 0; k--) {
           // System.out.println("k "+k+" "+acc[k]+" "+tmp);
            tmp -= acc[k];
        }
        System.out.println(k+1);
    }
}
