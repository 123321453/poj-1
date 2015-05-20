
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Crossing River Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 9132	Accepted: 3413 Description
 *
 * A group of N people wishes to go across a river with only one boat, which can
 * at most carry two persons. Therefore some sort of shuttle arrangement must be
 * arranged in order to row the boat back and forth so that all people may
 * cross. Each person has a different rowing speed; the speed of a couple is
 * determined by the speed of the slower one. Your job is to determine a
 * strategy that minimizes the time for these people to get across. Input
 *
 * The first line of the input contains a single integer T (1 <= T <= 20), the
 * number of test cases. Then T cases follow. The first line of each case
 * contains N, and the second line contains N integers giving the time for each
 * people to cross the river. Each case is preceded by a blank line. There won't
 * be more than 1000 people and nobody takes more than 100 seconds to cross.
 * Output
 *
 * For each test case, print a line containing the total number of seconds
 * required for all the N people to cross the river. Sample Input
 *
 * 1
 * 4
 * 1 2 5 10 Sample Output
 *
 * 17 Source
 *
 * POJ Monthly--2004.07.18
 */
public class p1700 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int sum = 0;
            int[] tab = new int[N+1];
            for (int j = 1; j <= N; j++) {
                tab[j] = in.nextInt();
            }
            Arrays.sort(tab);
            while (N > 0) {
                if (N == 1) {
                    sum += tab[1];
                    N = 0;
                } 
                if (N == 2) {
                    sum += tab[2];
                    N = 0;
                } 
                if (N == 3) {
                    sum += (tab[3] + tab[1] + tab[2]);
                    N = 0;
                } 
                if(N >= 4){
                    if(2*tab[2] > (tab[1]+ tab[N-1])) {
                        sum += (2*tab[1] + tab[N] + tab[N-1]); 
                        N -= 2;
                    }
                    else {
                        sum += (2*tab[2] + tab[1] + tab[N]);
                        N -= 2;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
