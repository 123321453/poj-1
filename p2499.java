
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Binary Tree
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 5186		Accepted: 2406
Description

Background 
Binary trees are a common data structure in computer science. In this problem we will look at an infinite binary tree where the nodes contain a pair of integers. The tree is constructed like this: 
The root contains the pair (1, 1). 
If a node contains (a, b) then its left child contains (a + b, b) and its right child (a, a + b)

Problem 
Given the contents (a, b) of some node of the binary tree described above, suppose you are walking from the root of the tree to the given node along the shortest possible path. Can you find out how often you have to go to a left child and how often to a right child?
Input

The first line contains the number of scenarios. 
Every scenario consists of a single line containing two integers i and j (1 <= i, j <= 2*109) that represent 
a node (i, j). You can assume that this is a valid node in the binary tree described above.
Output

The output for every scenario begins with a line containing "Scenario #i:", where i is the number of the scenario starting at 1. Then print a single line containing two numbers l and r separated by a single space, where l is how often you have to go left and r is how often you have to go right when traversing the tree from the root to the node given in the input. Print an empty line after every scenario.
Sample Input

3
42 1
3 4
17 73
Sample Output

Scenario #1:
41 0

Scenario #2:
2 1

Scenario #3:
4 6
Source

TUD Programming Contest 2005 (Training Session), Darmstadt, Germany
 */
public class p2499 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 1; i <= N ; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int l = 0; 
            int d = 0;
            while(true) {
                if(m > n) {
                    l += m/n;
                    m = m%n;
                    if(m == 0)
                        break;
                }
                else {
                    d += n/m;
                    n = n%m;
                    if(n == 0)
                        break;
                }
            }
            if(m == 0)
                l--;
            if(n == 0)
                d--;
            System.out.printf("Scenario #%d:\n",i);
            System.out.println(l+" "+d);
            System.out.println();
        }
    }
}
