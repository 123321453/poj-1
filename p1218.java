
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
THE DRUNK JAILER
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 19383		Accepted: 12242
Description

A certain prison contains a long hall of n cells, each right next to each other. Each cell has a prisoner in it, and each cell is locked. 
One night, the jailer gets bored and decides to play a game. For round 1 of the game, he takes a drink of whiskey,and then runs down the hall unlocking each cell. For round 2, he takes a drink of whiskey, and then runs down the 
hall locking every other cell (cells 2, 4, 6, ?). For round 3, he takes a drink of whiskey, and then runs down the hall. He visits every third cell (cells 3, 6, 9, ?). If the cell is locked, he unlocks it; if it is unlocked, he locks it. He 
repeats this for n rounds, takes a final drink, and passes out. 
Some number of prisoners, possibly zero, realizes that their cells are unlocked and the jailer is incapacitated. They immediately escape. 
Given the number of cells, determine how many prisoners escape jail.
Input

The first line of input contains a single positive integer. This is the number of lines that follow. Each of the following lines contains a single integer between 5 and 100, inclusive, which is the number of cells n. 
Output

For each line, you must print out the number of prisoners that escape when the prison has n cells. 
Sample Input

2
5
100
Sample Output

2
10
* 
* 
* comment:
* 9=1*9=3*3，9的约数有1，3，9，能影响到的round只有1，3，9，奇数，所以是开的
10=1*10=2*5，10的约数有1，2，5，10，能影响到的round只有1，2，5，10，偶数，所以是关的
除了完全平方数，它的约数都是成双的，完全平方数还多了一个算术平方根，约数的数量就是奇数了。
 */
public class p1218 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int j;
        for(int i = 0; i < n;i++) {
            j = Integer.parseInt(in.nextLine());
            System.out.println((int)Math.sqrt(j));
        }
    }
}
