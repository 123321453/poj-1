
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
A Modular Arithmetic Challenge
Time Limit: 1000MS		Memory Limit: 131072K
Total Submissions: 1712		Accepted: 202
Description

Given four positive integers M, D, L, R, your task is to find the minimal non-negative integer x which satisfies L ≤ ( D × x mod M ) ≤ R, where mod is the remainder operation

Input

The first line contains one number N -- the number of test cases.(1 ≤ N ≤ 100)
Each of the following N lines contains four integers M, D, L, R ( 1≤ M, D, L, R ≤ 2,000,000,000)

Output

For each test case, print the minimal x. If there is no such x, print "-1" instead.

Sample Input

4
4 3 1 1
4 2 1 1
4 2 2 4
4 4 4 4
Sample Output

3
-1
1
-1
Source

POJ Founder Monthly Contest – 2008.03.16, Gao Yihan
 */
public class p3530 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N;i++) {
            int M = in.nextInt();
            int D = in.nextInt();
            int L = in.nextInt();
            int R = in.nextInt();
            int j = 1;
            boolean flag = false;
            for(j = 1;; j++) {
                int t = (D * j)% M;
                if(t >= L && t <= R) {
                    flag = true;
                    break;
                }
            }
            
        }
    }
}
