
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
A Bug's Life
Time Limit: 10000MS		Memory Limit: 65536K
Total Submissions: 22676		Accepted: 7392
Description

Background 
Professor Hopper is researching the sexual behavior of a rare species of bugs. He assumes that they feature two different genders and that they only interact with bugs of the opposite gender. In his experiment, individual bugs and their interactions were easy to identify, because numbers were printed on their backs. 
Problem 
Given a list of bug interactions, decide whether the experiment supports his assumption of two genders with no homosexual bugs or if it contains some bug interactions that falsify it.
Input

The first line of the input contains the number of scenarios. Each scenario starts with one line giving the number of bugs (at least one, and up to 2000) and the number of interactions (up to 1000000) separated by a single space. In the following lines, each interaction is given in the form of two distinct bug numbers separated by a single space. Bugs are numbered consecutively starting from one.
Output

The output for every scenario is a line containing "Scenario #i:", where i is the number of the scenario starting at 1, followed by one line saying either "No suspicious bugs found!" if the experiment is consistent with his assumption about the bugs' sexual behavior, or "Suspicious bugs found!" if Professor Hopper's assumption is definitely wrong.
Sample Input

2
3 3
1 2
2 3
1 3
4 2
1 2
3 4
Sample Output

Scenario #1:
Suspicious bugs found!

Scenario #2:
No suspicious bugs found!
Hint

Huge input,scanf is recommended.
Source

TUD Programming Contest 2005, Darmstadt, Germany
 */
public class p2492 {
    private static int[][] root;
    
    public static void init(int n) {
        root = new int[n+1][2];
        for(int i = 0; i <= n ; i++) {
            root[i][0] = i;
            root[i][1] = 0;
        }
    }
    
    public static int findP(int i) {
        if(i == root[i][0])
            return i;
        else {
            root[i][0] = findP(root[i][0]);
            return root[i][0];
        }
    }
    
    public static void union(int x, int y) {
        if(x == y)
            return;
        int pX = findP(x);
        int pY = findP(y);
        root[pY][0] = pX;
    }
    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int num = in.nextInt();
        int j = 1;
        for(int i = 0 ; i < num; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            init(n);
            boolean isSup = false;
            for(int k = 0; k < m; k++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if(root[x][1] != 0) {
                    union(root[y][0],root[x][1]);
                }
                else {
                    root[x][1] = y;
                }
                if(root[y][1] != 0) {
                    union(root[x][0], root[y][1]);
                }
                else {
                    root[y][1] = x;
                }
                
            }
            
            for(int p = 1; p < n ; p++) {
                if(findP(root[p][0]) ==  findP(root[p][1])) {
                    isSup = true;
                    break;
                }
            }
            if(isSup) {
                System.out.printf("Scenario #%d:\n",j++);
                System.out.println("Suspicious bugs found!");
                System.out.println();
            }
            else {
                System.out.printf("Scenario #%d:\n",j++);
                System.out.println("No suspicious bugs found!");
                System.out.println();       
            }
        }
    }
}
