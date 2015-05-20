
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Random Gap
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 4841		Accepted: 1281
Description

The pseudo-random number genegators (or RNGs for short) are widely used in statistical calculations. One of the simplest and ubiquitious is the linear congruence RNG, that calculates the n-th random number Rn as Rn = (aRn - 1 + c) mod m, where a, c and m are constants. For example, the sequence for a = 15, c = 7, m = 100 and starting value R0 = 1 is 1, 22, 37, 62, 37, 62, ... 

Linear RNG is very fast, and can yield surprisinly good sequence of random numbers, given the right choice of constants. There are various measures of RNG quality, and your task is to calculate one of them, namely the longest gap between members of the sequence. More precisely, given the values of a, c, m, and R0, find such two elements Ri < Rj that: 
there are no other Rk that Ri ≤ Rk ≤ Rj, 
the difference Rj − Ri is maximal.
Input

Input contains integer numbers a c m R0. 
0 ≤ a, c, R0 ≤ 107, 1 ≤ m ≤ 16000000, am + c < 232.
Output

Output should contain the single number -- the maximal difference found.
Sample Input

15 7 100 1
Sample Output

25
Source

Northeastern Europe 2004, Far-Eastern Subregion
* java 无法实现限时内完成，算法不难，要用c++
 */
public class p2381 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long c = in.nextLong();
        long m = in.nextLong();
        long r0 = in.nextLong();
        //ArrayList<Long> tab =  new ArrayList();
        long[] tab1 = new long[16000000];
        //long[] flag = new long[16000000];
        //tab.add(r0);
        int j =0;
        tab1[j++] = r0;
        long r = r0;
        int num = 1;
        while(true) {
            r = (a*r+c)%m;
            boolean flag = false;
            //if(r == r0)
             //   flag = true;
            if(!flag) {
                //tab.add(r);
                tab1[j++] = r;
                num++;
            }
            else {
                break;
            }
        }
        
        if(tab1.length == 1)
            System.out.println(0);
        else {
            Arrays.sort(tab1);
            long max = Long.MIN_VALUE;
            //Long[] arr = tab.toArray();
            for(int i = 0; i < (num-1); i++) {
                long tmp = tab1[i+1] - tab1[i];
                if(tmp > max) 
                    max = tmp;
            }
            System.out.println(max);
        }
    }
    
}
