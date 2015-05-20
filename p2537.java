
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Tight words
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 2431		Accepted: 1184
Description

Given is an alphabet {0, 1, ... , k}, 0 <= k <= 9 . We say that a word of length n over this alphabet is tight if any two neighbour digits in the word do not differ by more than 1.
Input

Input is a sequence of lines, each line contains two integer numbers k and n, 1 <= n <= 100.
Output

For each line of input, output the percentage of tight words of length n over the alphabet {0, 1, ... , k} with 5 fractional digits.
Sample Input

4 1
2 5
3 5
8 7
Sample Output

100.00000
40.74074
17.38281
0.10130
Source

Waterloo local 2001.01.27
 */
public class p2537 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int[][] tab = new int[10][101];
        double[][] ans = new double[10][101];
        int i;
       // for(i = 0; i <= 9; i++) {
         //       tab[i][1] = 1;
       // }

        while(in.hasNext()) {
            int k = in.nextInt();
            int n = in.nextInt();
            double s = 1;
            //int i; 
            double sum = 0;

               // ans[i][1] = tab[i][1] / total;
                //sum += tab[i][1];
            for(i = 0; i < n; i++)
                s *= (k+1);
            for(int  j=0; j<=k; j++ )
                ans[j][1] = 1/s;
            if(k == 0) {
                System.out.println("100.00000");
                continue;
            }
            //if(n >= 15) {
            //    System.out.println("0.00000");
            //    continue;
           // }
            //System.out.println(s);
            for(int j = 2; j <= n; j++) {
                for(i = 0; i <= k; i++) {
                    if(i != k && i != 0) {
                      //  tab[i][j] = tab[i-1][j-1] + tab[i][j-1] + tab[i+1][j-1];
                        ans[i][j] = ans[i-1][j-1] + ans[i][j-1] + ans[i+1][j-1];
                    }
                    else {
                        if(i == k) {
                         //   tab[i][j] = tab[i-1][j-1] + tab[i][j-1];
                            ans[i][j] = ans[i-1][j-1] + ans[i][j-1];
                        }
                        if(i == 0) {
                          //  tab[i][j] = tab[i][j-1] + tab[i+1][j-1];
                            ans[i][j] = ans[i][j-1] + ans[i+1][j-1];
                        }
                    }
                    //sum += tab[i][j];
                }
            }
            for(i = 0; i <= k; i++) {
                sum += ans[i][n];
            }
            //System.out.println(sum+" "+s);
            sum *= 100;
            System.out.printf("%.5f\n",(sum));
        }
    }
}
