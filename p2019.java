
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Cornfields
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 4580		Accepted: 2220
Description

FJ has decided to grow his own corn hybrid in order to help the cows make the best possible milk. To that end, he's looking to build the cornfield on the flattest piece of land he can find. 

FJ has, at great expense, surveyed his square farm of N x N hectares (1 <= N <= 250). Each hectare has an integer elevation (0 <= elevation <= 250) associated with it. 

FJ will present your program with the elevations and a set of K (1 <= K <= 100,000) queries of the form "in this B x B submatrix, what is the maximum and minimum elevation?". The integer B (1 <= B <= N) is the size of one edge of the square cornfield and is a constant for every inquiry. Help FJ find the best place to put his cornfield. 
Input

* Line 1: Three space-separated integers: N, B, and K. 

* Lines 2..N+1: Each line contains N space-separated integers. Line 2 represents row 1; line 3 represents row 2, etc. The first integer on each line represents column 1; the second integer represents column 2; etc. 

* Lines N+2..N+K+1: Each line contains two space-separated integers representing a query. The first integer is the top row of the query; the second integer is the left column of the query. The integers are in the range 1..N-B+1. 
Output

* Lines 1..K: A single integer per line representing the difference between the max and the min in each query. 
Sample Input

5 3 1
5 1 2 6 3
1 3 5 2 7
7 2 4 6 1
9 9 8 6 5
0 6 9 3 9
1 2
Sample Output

5
Source

USACO 2003 March Green
 */
public class p2019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B = in.nextInt();
        int K = in.nextInt();
        int[][] matrix = new int[N][N];
        int i,j,t;
        for(i = 0; i < N; i++) {
            for(j =0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for(t = 0; t < K ;t++) {
            int tR = in.nextInt();
            int lC = in.nextInt();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(i = (tR-1) ; i < (tR + B-1) ; i++) {
                for(j = (lC-1) ; j < (lC + B-1) ; j++) {
                    //int tmp = matrix[i][j];
                    //System.out.println("test" + " "+ i+" "+j+" "+tmp);
                    if(matrix[i][j] > max)
                        max = matrix[i][j];
                    if(matrix[i][j] < min)
                        min = matrix[i][j];
                }
            }
            System.out.println(max-min); 
            
        }
    }
}
