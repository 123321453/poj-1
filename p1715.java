
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Hexadecimal Numbers
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 2059		Accepted: 558
Description

The base of the hexadecimal system is 16. In order to write down numbers in this system one uses 16 digits 0,1,...,9,A,B,C,D,E,F. The capital letters A,..,F stands for 10,..,15, respectively. For instance the value of the hexadecimal number CF2 is 12 * 162 + 15 * 16 + 2 = 3314 in the decimal system. Let X be the set of all positive integers whose hexadecimal representations have at most 8 digits and do not contain repetitions of any digit. The most significant digit in such a representation is not zero. The largest element in X is the number with the hexadecimal representation FEDCBA98, the second largest is the number FEDCBA97, the third is FEDCBA96 and so forth. 
Write a program that: finds the n-th largest element of X;
Input

The first line of the file standard input contains integer n in the decimal representation. n does not exceed the number of elements of X.
Output

Your program should output the n-th largest element in X in the hexadecimal representation.
Sample Input

11
Sample Output

FEDCBA87
Source

CEOI 1997
 */
public class p1715 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String start = "FEDCBA98";
        //char[] t1 = tmp.toCharArray();
        int val = Integer.valueOf(start, 16);
        System.out.println(val);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++) {
            
        }
    }
}
