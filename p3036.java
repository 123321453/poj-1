
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Honeycomb Walk
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 2001		Accepted: 1389
Description


A bee larva living in a hexagonal cell of a large honeycomb decides to creep for a walk. In each “step” the larva may move into any of the six adjacent cells and after n steps, it is to end up in its original cell.

Your program has to compute, for a given n, the number of different such larva walks.

Input

The first line contains an integer giving the number of test cases to follow. Each case consists of one line containing an integer n, where 1 ≤ n ≤ 14.

Output

For each test case, output one line containing the number of walks. Under the assumption 1 ≤ n ≤ 14, the answer will be less than 231.

Sample Input

2
2
4
Sample Output

6
90
Source

Nordic 2006
* dont know how
 */
public class p3036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][][] tab = new int[15][32][32];
        for(int i = 0; i <= 30; i++) {
            for(int j = 0; j <= 30; j++) {
                tab[0][i][j] = 0;
            }
        }
        tab[0][15][15] = 1;
        for(int i = 1; i < 15; i++) {
            for(int j = 1; j <= 30; j++) {
                for(int k = 1; k <= 30; k++) {
                    tab[i][j][k] = tab[i-1][j-1][k-1] + tab[i-1][j][k-1] + tab[i-1][j][k+1] + tab[i-1][j+1][k] + tab[i-1][j-1][k] + tab[i-1][j+1][k+1];
                    //tab[i][j][k] = tab[i-1][j+1][k] + tab[i-1][j-1][k] + tab[i-1][j][k+1] + tab[i-1][j][k-1] + tab[i-1][j-1][k+1] + tab[i-1][j+1][k-1];
                }
            }
        }
        for(int i = 0; i < num ; i++) {
            int N = in.nextInt();
            System.out.println(tab[N][15][15]);
        }
    }
}
