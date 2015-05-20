
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Power Strings
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 25096		Accepted: 10543
Description

Given two strings a and b we define a*b to be their concatenation. For example, if a = "abc" and b = "def" then a*b = "abcdef". If we think of concatenation as multiplication, exponentiation by a non-negative integer is defined in the normal way: a^0 = "" (the empty string) and a^(n+1) = a*(a^n).
Input

Each test case is a line of input representing s, a string of printable characters. The length of s will be at least 1 and will not exceed 1 million characters. A line containing a period follows the last test case.
Output

For each s you should print the largest n such that s = a^n for some string a.
Sample Input

abcd
aaaa
ababab
.
Sample Output

1
4
3
Hint

This problem has huge input, use scanf instead of cin to avoid time limit exceed.
Source

Waterloo local 2002.07.01
 */
public class p2406 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            char[] lis = in.next().toCharArray();
            HashMap<String,Integer>tab = new HashMap();
            
        }
    }
}
