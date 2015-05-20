
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Factoring a Polynomial
Time Limit: 2000MS		Memory Limit: 65536K
Total Submissions: 2170		Accepted: 1149
Description

Recently Georgie has learned about polynomials. A polynomial in one variable can be viewed as a formal sum anxn + an-1xn-1 + . . . + a1x + a0 , where x is the formal variable and a i are the coefficients of the polynomial. The greatest i such that ai != 0 is called the degree of the polynomial. If ai = 0 for all i, the degree of the polynomial is considered to be -∞. If the degree of the polynomial is zero or -∞, it is called trivial, otherwise it is called non-trivial. 
What really impressed Georgie while studying polynomials was the fact that in some cases one can apply different algorithms and techniques developed for integer numbers to polynomials. For example, given two polynomials, one may sum them up, multiply them, or even divide one of them by the other. 
The most interesting property of polynomials, at Georgie's point of view, was the fact that a polynomial, just like an integer number, can be factorized. We say that the polynomial is irreducible if it cannot be represented as the product of two or more non-trivial polynomials with real coefficients. Otherwise the polynomial is called reducible. For example, the polynomial x2 - 2x + 1 is reducible because it can be represented as (x - 1)(x - 1), while the polynomial x2 + 1 is not. It is well known that any polynomial can be represented as the product of one or more irreducible polynomials. 
Given a polynomial with integer coefficients, Georgie would like to know whether it is irreducible. Of course, he would also like to know its factorization, but such problem seems to be too difficult for him now, so he just wants to know about reducibility. 
Input

The first line of the input contains n --- the degree of the polynomial (0 <= n <= 20). Next line contains n + 1 integer numbers, an , an-1 , . . . , a1 , a0 --- polynomial coefficients (-1000 <= ai <= 1000, an != 0).
Output

Output YES if the polynomial given in the input file is irreducible and NO in the other case.
Sample Input

2 
1 -2 1 
Sample Output

NO
Source

Northeastern Europe 2003, Northern Subregion
 */
public class p2126 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 2) {
            System.out.println("YES");
        }
        else if(n == 2) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if(b*b-4*a*c >= 0) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
        else {
            System.out.println("NO");
        }
    }
}
