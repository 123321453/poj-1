
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Max Sequence
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 14036		Accepted: 5883
Description

Give you N integers a1, a2 ... aN (|ai| <=1000, 1 <= i <= N). 


You should output S. 
Input

The input will consist of several test cases. For each test case, one integer N (2 <= N <= 100000) is given in the first line. Second line contains N integers. The input is terminated by a single line with N = 0.
Output

For each test of the input, print a line containing S.
Sample Input

5
-5 9 -5 11 20
0
Sample Output

40
Source

POJ Monthly--2005.08.28,Li Haoyuan
 */
public class p2593 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)
                break;
            int[] tab = new int[n];
            for(int i = 0; i < n ; i++) {
                tab[i] = in.nextInt();
            }
            int[] result1 = new int[n];
            int[] result2 = new int[n];
            int max = Integer.MIN_VALUE;
            int i, t,j;
            for(i = 0, t = n-1-i ; i < n; i++, t--) {
                max = Integer.MIN_VALUE;
                boolean flag = false;
                int sum = 0;
                for(j = 0; j <= i; j++) {
                    sum = 0;
                    for(int k = j; k <= i; k++) {
                        sum += tab[k]; 
                    }
                    if(max < sum) {
                        if(j == i) {
                            flag = true;
                        }
                        max = sum;
                    }
                }
                result1[i] = max;
                for(int j = i+1)
            }
            
        }
    }
}
