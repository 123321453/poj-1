
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
How much did the businessman lose
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 9345		Accepted: 6292
Description

Businessmen, of course, can make much money. However, sometimes, they would lose money in trading. For example, Jame, a businessman, brought in some goods each cost him 40 yuan and he decided to sell at the price of 70 yuan. Then a customer came to buy one, gave Jame 100 yuan, and of course got back 30 yuan. You may said, "Jame earned 30 yuan." But unfortunately, Jame found the 100 yuan from the customer was fake. What a poor man! In this case Jame lost 70 yuan (40 (the goods price) + 30 (the money paid back to the customer)). 

Now your task is to calculate how much Jame would lose in this kind of trade. Of course in this case, sometimes Jame may still earn. 
Input

The input consists of several instances. Each instance contains four integers N, M, P and C, which are all in the range [0, 50000], separated by a single space. 

N is the cost price of Jame good. 
M is the sell price. 
P is the total fake money the customer gave Jame. 
C is how much Jame paid back to the customer. 

Here N < M. And P may be less than M, as customer may pay with some fake money and some true money. 

The input is terminated by a line containing 4 zeros. 
Output

For one instance, output one line contains exactly one integer, which tells how much Jame lost in the trade. If Jame still earned, just output a negative integer, the absolute value of which tells the money Jame earned.
Sample Input

40 70 100 30
40 70 50 20
14604 32391 3902 153
0 0 0 0
Sample Output

70
20
-13885
 */
public class p2521 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N,M,P,C;
        String[] arr;
        int out;
        while(in.hasNext()){
            arr = in.nextLine().split("\\s+");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            P = Integer.parseInt(arr[2]);
            C = Integer.parseInt(arr[3]);
            if((N == M) && (M == P) &&  (P == C) &&(C == 0) )
                break;
            out = N+C-(M+C-P);
            System.out.println(out);
        }
    }
    
}
