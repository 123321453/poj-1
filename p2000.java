
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Gold Coins
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 18736		Accepted: 11657
Description

The king pays his loyal knight in gold coins. On the first day of his service, the knight receives one gold coin. On each of the next two days (the second and third days of service), the knight receives two gold coins. On each of the next three days (the fourth, fifth, and sixth days of service), the knight receives three gold coins. On each of the next four days (the seventh, eighth, ninth, and tenth days of service), the knight receives four gold coins. This pattern of payments will continue indefinitely: after receiving N gold coins on each of N consecutive days, the knight will receive N+1 gold coins on each of the next N+1 consecutive days, where N is any positive integer. 

Your program will determine the total number of gold coins paid to the knight in any given number of days (starting from Day 1). 
Input

The input contains at least one, but no more than 21 lines. Each line of the input file (except the last one) contains data for one test case of the problem, consisting of exactly one integer (in the range 1..10000), representing the number of days. The end of the input is signaled by a line containing the number 0.
Output

There is exactly one line of output for each test case. This line contains the number of days from the corresponding line of input, followed by one blank space and the total number of gold coins paid to the knight in the given number of days, starting with Day 1.
Sample Input

10
6
7
11
15
16
100
10000
1000
21
22
0
Sample Output

10 30
6 14
7 18
11 35
15 55
16 61
100 945
10000 942820
1000 29820
21 91
22 98
Source

Rocky Mountain 2004
 */
public class p2000 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int day = in.nextInt();
            if(day == 0)
                break;
            int N = (-1 + (int)Math.sqrt(1+8*day))/2;
            //System.out.println(N);
            int res = 0;
            double tmp = (1+N)*N/2;
           // System.out.println("test "+tmp);
            int remain = day - (int)tmp;
            for(int i = 1; i <= N; i++) {
                res += i*i;
                if(i == N) {
                    res += remain*(N+1);
                }
            }
            System.out.println(day+" "+res);
        }
    }
}
