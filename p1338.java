
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Ugly Numbers
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 16777		Accepted: 7475
Description

Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ... 
shows the first 10 ugly numbers. By convention, 1 is included. 
Given the integer n,write a program to find and print the n'th ugly number. 
Input

Each line of the input contains a postisive integer n (n <= 1500).Input is terminated by a line with n=0.
Output

For each line, output the n’th ugly number .:Don’t deal with the line with n=0.
Sample Input

1
2
9
0
Sample Output

1
2
10
 */
public class p1338 {
    public static void main(String[] args) {
        int[] ugly = new int[1501];
        int ug_2 = 0;
        int ug_3 = 0;
        int ug_5 = 0;
        ugly[0] = 1;
        for(int i= 1; i < 1500 ; i++){
            int p2 = 2*ugly[ug_2];
            int p3 = 3*ugly[ug_3];
            int p5 = 5*ugly[ug_5];
            ugly[i] = (p2 < p3) ? ((p2 < p5) ? p2:p5) :((p3 < p5) ? p3 : p5);
            if (ugly[i] == p2) {
                ug_2++;
            }
            if (ugly[i] == p3) {
                ug_3++;
            }
            if (ugly[i] == p5) {
                ug_5++;
            }
            //System.out.print(" " + ugly[i]);
        }
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            if(n == 0)
                break;
            else {
                System.out.println(ugly[n-1]);
            }
        }
    }
}
