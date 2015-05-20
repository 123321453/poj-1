
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Bull Math
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 11013		Accepted: 5691
Description

Bulls are so much better at math than the cows. They can multiply huge integers together and get perfectly precise answers ... or so they say. Farmer John wonders if their answers are correct. Help him check the bulls' answers. Read in two positive integers (no more than 40 digits each) and compute their product. Output it as a normal number (with no extra leading zeros). 

FJ asks that you do this yourself; don't use a special library function for the multiplication.
Input

* Lines 1..2: Each line contains a single decimal number.
Output

* Line 1: The exact product of the two input lines
Sample Input

11111111111111
1111111111
Sample Output

12345679011110987654321
Source
 */
public class p2389 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger x = in.nextBigInteger();
        BigInteger y = in.nextBigInteger();
        BigInteger res = x.multiply(y);
        System.out.println(res);
    }
}
