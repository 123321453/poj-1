
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Basic remains
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4306		Accepted: 1812
Description

Given a base b and two non-negative base b integers p and m, compute p mod m and print the result as a base b integer. p mod m is defined as the smallest non-negative integer k such that p = a*m + k for some integer a.
Input

Input consists of a number of cases. Each case is represented by a line containing three unsigned integers. The first, b, is a decimal number between 2 and 10. The second, p, contains up to 1000 digits between 0 and b-1. The third, m, contains up to 9 digits between 0 and b-1. The last case is followed by a line containing 0.
Output

For each test case, print a line giving p mod m as a base-b integer.
Sample Input

2 1100 101
10 123456789123456789123456789 1000
0
Sample Output

10
789
 */
public class p2305 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int b = in.nextInt();
            if(b == 0)
                break;
            BigInteger p = in.nextBigInteger(b);
            BigInteger m = in.nextBigInteger(b);
            System.out.println(p.mod(m).toString(b));
        }
    }
    
}
