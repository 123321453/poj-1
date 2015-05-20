
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Aggressive cows
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4422		Accepted: 2158
Description

Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000). 

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input

* Line 1: Two space-separated integers: N and C 

* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output

* Line 1: One integer: the largest minimum distance
Sample Input

5 3
1
2
8
4
9
Sample Output

3
Hint

OUTPUT DETAILS: 

FJ can put his 3 cows in the stalls at positions 1, 4 and 8, resulting in a minimum distance of 3. 

Huge input data,scanf is recommended.
Source

USACO 2005 February Gold
 */
public class p2456 {
    private static int[] tab;
    private static int N;
    private static int C;
    public static boolean can(int m) {
        int j = 0;
        int i = C-1;
        boolean flag = false;
        while(j <= (N-1) && i > 0) {
            flag = false;
            for(int k = j; k <= N-1 ;k++) {
                if((tab[k] - tab[j]) >= m) {
                    j = k;
                    flag = true;
                    break;
                }
                else
                    continue;
            }
           // System.out.println("test1: "+ j + " "+tab[j]+" i: "+i);
            if(flag)
                i-- ;
            else
                break;
        }
       // System.out.println("goal: "+m+" i: " +i);
        if(i > 0) {
            return false;
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        C = in.nextInt();
        tab = new int[N];
        for(int i = 0; i < N ; i++)
            tab[i] = in.nextInt();
        Arrays.sort(tab);
        int r = (tab[N-1] - tab[0])/(C - 1);
        int l = 0;
        while(l <= r) {
            int m = (l+r)/2;
            if(can(m))
                l = m+1;
            else
                r = m-1;
        }
        System.out.println(r);
        
        
    }
}
