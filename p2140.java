
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Herd Sums
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 14114		Accepted: 8405
Description

The cows in farmer John's herd are numbered and branded with consecutive integers from 1 to N (1 <= N <= 10,000,000). When the cows come to the barn for milking, they always come in sequential order from 1 to N. 

Farmer John, who majored in mathematics in college and loves numbers, often looks for patterns. He has noticed that when he has exactly 15 cows in his herd, there are precisely four ways that the numbers on any set of one or more consecutive cows can add up to 15 (the same as the total number of cows). They are: 15, 7+8, 4+5+6, and 1+2+3+4+5. 

When the number of cows in the herd is 10, the number of ways he can sum consecutive cows and get 10 drops to 2: namely 1+2+3+4 and 10. 

Write a program that will compute the number of ways farmer John can sum the numbers on consecutive cows to equal N. Do not use precomputation to solve this problem. 
Input

* Line 1: A single integer: N 
Output

* Line 1: A single integer that is the number of ways consecutive cow brands can sum to N. 
Sample Input

15
Sample Output

4
Source

USACO 2003 March Orange
* 假设a,a+1,a+2...a+k ，为一组符合的答案
有
(k+1)a+0.5*k*(k＋1)=n成立
划成
(a + 0.5*k)(k+1)=n
观察等式发现必须满足
1. 0.5*k为整数. 所以k是偶数
2. (k+1) 为n的因数，并且 (k+1) 为奇数
所以综上
n有多少个奇因数，就是本题的答案
 */
public class p2140 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for(int i = 1; i <= num;i++) {
            if(num%i == 0) {
                if(i%2 !=0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
