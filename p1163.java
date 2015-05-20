
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Triangle
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 31426		Accepted: 18523
Description

7
3   8
8   1   0
2   7   4   4
4   5   2   6   5

(Figure 1)
Figure 1 shows a number triangle. Write a program that calculates the highest sum of numbers passed on a route that starts at the top and ends somewhere on the base. Each step can go either diagonally down to the left or diagonally down to the right. 
Input

Your program is to read from standard input. The first line contains one integer N: the number of rows in the triangle. The following N lines describe the data of the triangle. The number of rows in the triangle is > 1 but <= 100. The numbers in the triangle, all integers, are between 0 and 99.
Output

Your program is to write to standard output. The highest sum is written as an integer.
Sample Input

5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5
Sample Output

30
Source

IOI 1994
 */
public class p1163 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] tab = new int[num][num];
        int[][] opt = new int [num][num];
        int i,j;
        for(i = 0 ; i < num ; i++) {
            for(j = 0; j <= i; j++) {
                tab[i][j] = in.nextInt();
            }
        }
        opt[0][0] = tab[0][0];
        int max = Integer.MIN_VALUE;
        for(i = 1 ; i < num ; i++) {
            for(j = 0; j <= i; j++) {
                //tab[i][j] = in.nextInt();
                if(j == 0)
                    opt[i][j] = opt[i-1][j] + tab[i][j];
                else if(j == i)
                    opt[i][j] = opt[i-1][j-1] + tab[i][j];
                else {
                    int max1 = (opt[i-1][j-1] > opt[i-1][j])? opt[i-1][j-1]:opt[i-1][j];
                    opt[i][j] = max1 + tab[i][j];
                }
            }
        }
        for(j = 0; j < num; j++) {
            if(opt[num-1][j] > max)
                max = opt[num-1][j];
        }
        System.out.println(max);
        
    }
}
