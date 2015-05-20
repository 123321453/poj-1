
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Recaman's Sequence Time Limit: 3000MS	Memory Limit: 60000K Total Submissions:
 * 19119	Accepted: 8016 Description
 *
 * The Recaman's sequence is defined by a0 = 0 ; for m > 0, am = am−1 − m if the
 * rsulting am is positive and not already in the sequence, otherwise am = am−1
 * + m. The first few numbers in the Recaman's Sequence is 0, 1, 3, 6, 2, 7, 13,
 * 20, 12, 21, 11, 22, 10, 23, 9 ... Given k, your task is to calculate ak.
 * Input
 *
 * The input consists of several test cases. Each line of the input contains an
 * integer k where 0 <= k <= 500000. The last line contains an integer −1, which
 * should not be processed. Output
 *
 * For each k given in the input, print one line containing ak to the output.
 * Sample Input
 *
 * 7
 * 10000 -1 Sample Output
 *
 * 20 18658 Source
 *
 * Shanghai 2004 Preliminary
 *
 */
public class p2081 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[500001];
        a[0] = 0;
        HashMap<Integer,Boolean> tab = new HashMap();
        tab.put(0, true);
        for(int i = 1; i <= 500000; i++) {
            if(a[i-1] - i > 0 && tab.get(a[i-1] - i) == null) {
                a[i] = a[i-1] - i;
                tab.put(a[i], Boolean.TRUE);
            }
            else {
                a[i] = a[i-1] + i;
                tab.put(a[i], Boolean.TRUE);
            }
        }
        while(in.hasNext()) {
            int k = in.nextInt();
            if(k == -1)
                break;
            System.out.println(a[k]);
        }
    }
}
