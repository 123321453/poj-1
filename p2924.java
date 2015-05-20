
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Gauß in Elementary School
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8431		Accepted: 3804
Description

Johann Carl Friedrich Gauß (1777 – 1855) was one of the most important German mathematicians. For those of you who remember the Deutsche Mark, a picture of him was printed on the 10 – DM bill. In elementary school, his teacher J. G. Büttner tried to occupy the pupils by making them add up the integers from 1 to 100. The young Gauß surprised everybody by producing the correct answers (5050) within seconds.

Can you write a computer program that can compute such sums really quickly?

Given two integers n and m, you should compute the sum of all the integers from n to m. In other words, you should compute


Input

The first line contains the number of scenarios. Each scenario consists of a line containing the numbers n and m (−109 ≤ n ≤ m ≤ 109).


Output

The output for every scenario begins with a line containing “Scenario #i:”, where i is the number of the scenario starting at 1. Then print the sum of all integers from n to m. Terminate the output for the scenario with a blank line.

Sample Input

3
1 100
-11 10
-89173 938749341
Sample Output

Scenario #1:
5050

Scenario #2:
-11

Scenario #3:
440625159107385260
Source

TUD Programming Contest 2006, Darmstadt, Germany
 */
public class p2924 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int j = 1;
        for(int i = 0; i < num ;i++) {
            BigInteger n = in.nextBigInteger();
            BigInteger m = in.nextBigInteger();
            BigInteger div = new BigInteger("2");
            BigInteger result = n.add(m).multiply((m.add(n.negate()).add(BigInteger.ONE))).divide(div);
            System.out.printf("Scenario #%d:\n",j++);
            System.out.println(result);
            System.out.println();
            
        }
    }
}
