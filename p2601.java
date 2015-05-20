
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Simple calculations
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6152		Accepted: 3117
Description

There is a sequence of n+2 elements a0, a1, ..., an+1 (n <= 3000, -1000 <= ai <=1000). It is known that ai = (ai-1 + ai+1)/2 - ci for each i=1, 2, ..., n. 
You are given a0, an+1, c1, ... , cn. Write a program which calculates a1.
Input

The first line of an input contains an integer n. The next two lines consist of numbers a0 and an+1 each having two digits after decimal point, and the next n lines contain numbers ci (also with two digits after decimal point), one number per line.
Output

The output file should contain a1 in the same format as a0 and an+1.
Sample Input

1
50.50
25.50
10.15
Sample Output

27.85
Source

Ural State University collegiate programming contest 2000
* a1=(n*a[0]+a[n+1]-2*(n*c1+(n-1)*c2+...+cn))/(n+1)
 */
public class p2601 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double a0 = in.nextDouble();
        double an_1 = in.nextDouble();
        double[] c = new double[n+1];
        double a1 = n*a0 + an_1;
        double res = 0.0;
        for(int i = 1; i <= n ; i++) {
            c[i] = in.nextDouble();
            res += (n-i+1)*c[i];
        }
        a1 = (a1- 2*res)/(n+1);
        System.out.printf("%.2f\n",a1);
        
    }
}
