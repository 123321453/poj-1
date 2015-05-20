
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
BST
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 7518		Accepted: 4564
Description

Consider an infinite full binary search tree (see the figure below), the numbers in the nodes are 1, 2, 3, .... In a subtree whose root node is X, we can get the minimum number in this subtree by repeating going down the left node until the last level, and we can also find the maximum number by going down the right node. Now you are given some queries as "What are the minimum and maximum numbers in the subtree whose root node is X?" Please try to find answers for there queries. 

Input

In the input, the first line contains an integer N, which represents the number of queries. In the next N lines, each contains a number representing a subtree with root number X (1 <= X <= 231 - 1).
Output

There are N lines in total, the i-th of which contains the answer for the i-th query.
Sample Input

2
8
10
Sample Output

1 15
9 11
Source

POJ Monthly,Minkerui
 */
public class p2309 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int a = in.nextInt();
            int low = a & -a;
            int min = a - low + 1;
            int max = a+ low -1;
            System.out.println(min+" "+max);
        }
    }
}
