
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Optimal Parking
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6993		Accepted: 4083
Description

When shopping on Long Street, Michael usually parks his car at some random location, and then walks to the stores he needs. Can you help Michael choose a place to park which minimises the distance he needs to walk on his shopping round? Long Street is a straight line, where all positions are integer. You pay for parking in a specific slot, which is an integer position on Long Street. Michael does not want to pay for more than one parking though. He is very strong, and does not mind carrying all the bags around.

Input

The first line of input gives the number of test cases, 1 ≤ t ≤ 100. There are two lines for each test case. The first gives the number of stores Michael wants to visit, 1 ≤ n ≤ 20, and the second gives their n integer positions on Long Street, 0 ≤ xi ≤ 99.

Output

Output for each test case a line with the minimal distance Michael must walk given optimal parking.

Sample Input

2
4
24 13 89 37
6
7 30 41 14 39 42
Sample Output

152
70
Source

Nordic 2007
 */
public class p3632 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0 ; i < num ; i++) {
            int N = in.nextInt();
            int[] tab = new int[N];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N ; j++) {
                tab[j] = in.nextInt();
                if(max < tab[j])
                    max = tab[j];
                if(min > tab[j])
                    min = tab[j];
            }
            System.out.println((max-min)*2);
        }
    }
}
