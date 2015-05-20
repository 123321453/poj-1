
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Panda's Birthday Present
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 1364		Accepted: 914
Description

On Panda's Birthday party, he received a strange present from Jason. The present is a black box with 4 dices in it which is used to play a game. The dice in the box is unusual. Instead of the digits, only red or blue is painted on each side of the dice. Before the first round of the game, the box can repaint every side of every dice red or blue with equal probability. Then for each round of the game, the box will roll the 4 dices and tell the player the number of red side facing up, which is the point the player get. Now, Panda has play it for two rounds and he tell you the point he has got for each round. Can you tell him the expected point he can get for next round.
Input

The first line of the input is number of test case. Each test case contains two integers, pand q, which are the points Panda has got for the first two rounds.(0≤p,q≤4)
Output

For each test case, output the expected point panda can get for the third round. Round the answer to the third digit after the decimal point.
Sample Input

2
2 2
4 4
Sample Output

2.000
2.571
Source

POJ Monthly Contest – 2009.02.22, Simon
* http://hi.baidu.com/bfcdygoporbjuxr/item/569897ddc1fc561d21e2503f
 */
public class p3716 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            int p = in.nextInt();
            int q = in.nextInt();
            double result = ((double)p+(double)q+10.0)/7;
            System.out.printf("%.3f\n",result);
        }
    }
}
