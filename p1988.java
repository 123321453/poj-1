
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Cube Stacking
Time Limit: 2000MS		Memory Limit: 30000K
Total Submissions: 15518		Accepted: 5253
Case Time Limit: 1000MS
Description

Farmer John and Betsy are playing a game with N (1 <= N <= 30,000)identical cubes labeled 1 through N. They start with N stacks, each containing a single cube. Farmer John asks Betsy to perform P (1<= P <= 100,000) operation. There are two types of operations: 
moves and counts. 
* In a move operation, Farmer John asks Bessie to move the stack containing cube X on top of the stack containing cube Y. 
* In a count operation, Farmer John asks Bessie to count the number of cubes on the stack with cube X that are under the cube X and report that value. 

Write a program that can verify the results of the game. 
Input

* Line 1: A single integer, P 

* Lines 2..P+1: Each of these lines describes a legal operation. Line 2 describes the first operation, etc. Each line begins with a 'M' for a move operation or a 'C' for a count operation. For move operations, the line also contains two integers: X and Y.For count operations, the line also contains a single integer: X. 

Note that the value for N does not appear in the input file. No move operation will request a move a stack onto itself. 
Output

Print the output from each of the count operations in the same order as the input file. 
Sample Input

6
M 1 6
C 1
M 2 4
M 2 6
C 3
C 4
Sample Output

1
0
2
Source

USACO 2004 U S Open
 */
public class p1988 {
    private static int[] root;
    private static int[] rank;
    private static int[] bot;
    
    public static void init() {
        root = new int[30001];
        rank = new int[30001];
        bot = new int[30001];
        for(int i = 1; i < 30000; i++) {
            root[i] = i;
            rank[i] = 0;
            bot[i] = i;
        }
    }
    
    public static int findP(int i) {
        if(i == root[i])
            return i;
        root[i] = findP(root[i]);
        return root[i];
    }
    
    public static int findB(int i,int ran) {
        if(i == bot[i]) {
            rank[i] += ran;
            return i ;
        }
        bot[i] = findB(bot[i],ran);
        return bot[i];
    }
    
    public static void union(int x, int y) {
        //put x's bot on top of y's root
        //increase x's rank with all rank y
        int pY = findP(y);
        int bX = findB(x,rank[pY]);
        int pX = findP(x);
        root[pY] = bX;
        
        //rank[pX] += rank[pY]; 
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        init();
        for(int i = 0; i < P ; i++) {
            String w = in.next();
            //int X = in.nextInt();
            //int Y = in.nextInt();
            int X,Y;
            if(w.equals("C")) {
                X = in.nextInt();
                System.out.println(rank[X]);
            }
            else {
                X = in.nextInt();
                Y = in.nextInt();
                
            }
        }
    }
}
