/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Self Numbers
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 18156		Accepted: 10222
Description

In 1949 the Indian mathematician D.R. Kaprekar discovered a class of numbers called self-numbers. For any positive integer n, define d(n) to be n plus the sum of the digits of n. (The d stands for digitadition, a term coined by Kaprekar.) For example, d(75) = 75 + 7 + 5 = 87. Given any positive integer n as a starting point, you can construct the infinite increasing sequence of integers n, d(n), d(d(n)), d(d(d(n))), .... For example, if you start with 33, the next number is 33 + 3 + 3 = 39, the next is 39 + 3 + 9 = 51, the next is 51 + 5 + 1 = 57, and so you generate the sequence 

33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ... 
The number n is called a generator of d(n). In the sequence above, 33 is a generator of 39, 39 is a generator of 51, 51 is a generator of 57, and so on. Some numbers have more than one generator: for example, 101 has two generators, 91 and 100. A number with no generators is a self-number. There are thirteen self-numbers less than 100: 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, and 97. 

Input

No input for this problem.
Output

Write a program to output all positive self-numbers less than 10000 in increasing order, one per line.
Sample Input

Sample Output

1
3
5
7
9
20
31
42
53
64
 |
 |       <-- a lot more numbers
 |
9903
9914
9925
9927
9938
9949
9960
9971
9982
9993
* //如果某数有generator，它一定可以拆成：i*1001 + j*101 + k*11 + m*2   0<=i,j,k,m<=9
 */
public class p1316 {
    /*
    public static boolean d(int i) {
        int m,n,o,p,q,s,t;
        if((m = i%1001) == 0) {
           
            return true;
        }
        if((n = m%101) == 0) {
            
            return true;
        }
        if((o = n%11) == 0) {
            return true;
        }
        if((p = o%2) == 0 ) {
            return true;
        }
        else {
            return false;
        }
    }
    * 
    */
    public static void main(String[] args) {
        boolean[] f = new boolean[10050];
        int i,j,o,p;
        for(i = 0 ; i < 10 ; i++) {
            for(j = 0; j < 10 ; j++) {
                for(o = 0 ; o < 10 ; o++) {
                    for(p = 0 ; p < 10 ;p++) {
                        f[1001*i + 101*j + 11*o+2*p] = true;
                    }
                }
            }
        }
        for(i = 1; i < 10000 ; i++) {
            if(!f[i]) 
                System.out.println(i);
        }
    }
}
