
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Ones
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 9910		Accepted: 5636
Description

Given any integer 0 <= n <= 10000 not divisible by 2 or 5, some multiple of n is a number which in decimal notation is a sequence of 1's. How many digits are in the smallest such a multiple of n?
Input

Each line contains a number n.
Output

Output the number of digits.
Sample Input

3 
7 
9901
Sample Output

3
6
12
Source

Waterloo local 2001.06.02
 */
public class p2551 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int r = 1;
            int num = 1;
            while(r%n != 0) {
                r = r%n;
                r = r*10+1;
                num++;
            }
            System.out.println(num);
                    
        }
    }
}
