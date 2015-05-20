
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Gridland
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 6682		Accepted: 3505
Description

Background 

For years, computer scientists have been trying to find efficient solutions to different computing problems. For some of them efficient algorithms are already available, these are the "easy" problems like sorting, evaluating a polynomial or finding the shortest path in a graph. For the "hard" ones only exponential-time algorithms are known. The traveling-salesman problem belongs to this latter group. Given a set of N towns and roads between these towns, the problem is to compute the shortest path allowing a salesman to visit each of the towns once and only once and return to the starting point. 

Problem 

The president of Gridland has hired you to design a program that calculates the length of the shortest traveling-salesman tour for the towns in the country. In Gridland, there is one town at each of the points of a rectangular grid. Roads run from every town in the directions North, Northwest, West, Southwest, South, Southeast, East, and Northeast, provided that there is a neighbouring town in that direction. The distance between neighbouring towns in directions North-South or East-West is 1 unit. The length of the roads is measured by the Euclidean distance. For example, Figure 7 shows 2 * 3-Gridland, i.e., a rectangular grid of dimensions 2 by 3. In 2 * 3-Gridland, the shortest tour has length 6. 
 
Figure 7: A traveling-salesman tour in 2 ? 3-Gridland.


Input

The first line contains the number of scenarios. 

For each scenario, the grid dimensions m and n will be given as two integer numbers in a single line, separated by a single blank, satisfying 1 < m < 50 and 1 < n < 50.
Output

The output for each scenario begins with a line containing "Scenario #i:", where i is the number of the scenario starting at 1. In the next line, print the length of the shortest traveling-salesman tour rounded to two decimal digits. The output for every scenario ends with a blank line.
Sample Input

2
2 2
2 3
Sample Output

Scenario #1:
4.00

Scenario #2:
6.00
Source

Northwestern Europe 2001
* 1.如果n,m有一个为偶数（假设n为偶数）那么我们以n为行,m为列。比如n=6,m=5那么可以这走
a-a-a-a-a
|       |
a a-a-a-a
| |        即(n-1)*2+(m-1)*2+(n-2)*(m-2)=n*m
a a-a-a-a
|       |
a a-a-a-a
| |
a a-a-a-a
|       |
a-a-a-a-a
最优性显然，每个点只进出了一次，而且每一步都是走的最短距离1




2.如果n,m都为奇数，比如n=5,m=5那么可以这走
a-a-a-a-a
|       |
a a-a-a-a
| |        即(n-1)*2+(m-1)+(n-2)*(m-2)+m-2+sqrt(2)=n*m-1+sqrt(2)
a a-a-a-a
|       |
a a a-a a
|/| | | |
a a-a a-a
其中有一步为sqrt(2),其他都为最短距离，除了全部是走最短距离情况，这种就是最优的了。
那n*m都为基数，能不能每个点只进出了一次，而且每一步都是走的最短距离1呢？
答案是不能的，因为一共n*m个点（奇数个），所以每个点只进出一次的话也应该是奇数条边。
如果只能走（上，下，左，右），要从一个点出发，再回到这个点的话，显然应该是偶数条边。（往上走的次数等于往下走的次数，往左走的次数等于往右走的次数）
 */
public class p1450 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int j = 1;
        for(int i = 0; i < num ; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int result =  n*m;
            if(result%2 == 0) {
                System.out.printf("Scenario #%d:\n",j++);
                System.out.printf("%d.00\n",result);
                System.out.println();
            }
            else {
                System.out.printf("Scenario #%d:\n",j++);
                System.out.printf("%d.41\n",result);
                System.out.println();
            }
        }
    }
}
