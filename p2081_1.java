
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
 */
public class p2081_1 {
    private static int[] a;
    private static boolean[] flag;
    public static int dfs(int k) {
        if(k == 0) {
            return 0;
        }
        if(a[k-1] != 0) {
          //  System.out.println("t1");
            int tmp = a[k-1] - k;
            if(tmp > 0 && flag[tmp] == false) {
                flag[tmp] = true;
                a[k] = tmp;
                return tmp;
            }
            else {
                int test = a[k-1] + k;
                flag[test] = true;
                a[k] = test;
                return test;
            }
        }
        else {
           // System.out.println("t2");
            //dfs(a[k-1]);
            
            int test = dfs(k-1) -k;
            if(test > 0 && flag[test] == false) {
                flag[test] = true;
               // System.out.println("t1: "+ test);
                a[k] = test;
                return test;
            }
            else {
                int tst =  test + 2*k ;
               // System.out.println("t2: "+ tst);
                flag[tst] = true;
                a[k] = tst;
                return tst;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        a = new int[500001];
        a[0] = 0;
        flag = new boolean[3012500];
        flag[0] = true;
        while(in.hasNext()) {
            int k = in.nextInt();
            if(k == -1)
                break;
            if(k == 0) {
                System.out.println(0);
                continue;
            }
            if(a[k] != 0) {
              //  System.out.println("t1");
                System.out.println(a[k]);
                continue;
            }
            else {
            //    System.out.println("t2");
                a[k] = dfs(k);
                System.out.println(a[k]);
            }
        }
    }
}
