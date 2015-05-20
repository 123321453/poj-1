
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Tri Tiling
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6537		Accepted: 3486
Description

In how many ways can you tile a 3xn rectangle with 2x1 dominoes? 
Here is a sample tiling of a 3x12 rectangle. 

Input

Input consists of several test cases followed by a line containing -1. Each test case is a line containing an integer 0 <= n <= 30.
Output

For each test case, output one integer number giving the number of possible tilings.
Sample Input

2
8
12
-1
Sample Output

3
153
2131
Source

Waterloo local 2005.09.24Tri Tiling
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6537		Accepted: 3486
Description

In how many ways can you tile a 3xn rectangle with 2x1 dominoes? 
Here is a sample tiling of a 3x12 rectangle. 

Input

Input consists of several test cases followed by a line containing -1. Each test case is a line containing an integer 0 <= n <= 30.
Output

For each test case, output one integer number giving the number of possible tilings.
Sample Input

2
8
12
-1
Sample Output

3
153
2131
Source

Waterloo local 2005.09.24
 */
public class p2663 {
    public static void main(String[] args) {
        int i,j;
        int[] dp = new int[16];
        dp[0] = 1;
        for(i = 1; i <=15; i++) {
            dp[i] = 3*dp[i-1];
            for(j = i-2; j >= 0; j--)
                dp[i] += 2*dp[j];
        }
        Scanner in =  new Scanner(System.in);
        while(in.hasNext()) {
            int t = in.nextInt();
            if(t == -1)
                break;
            if(t%2 == 1)
                System.out.println(0);
            else
                System.out.println(dp[t/2]);
        }
        
    }
}
