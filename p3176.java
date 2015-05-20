
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Cow Bowling
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 11034		Accepted: 7226
Description

The cows don't use actual bowling balls when they go bowling. They each take a number (in the range 0..99), though, and line up in a standard bowling-pin-like triangle like this: 

          7



        3   8



      8   1   0



    2   7   4   4



  4   5   2   6   5
Then the other cows traverse the triangle starting from its tip and moving "down" to one of the two diagonally adjacent cows until the "bottom" row is reached. The cow's score is the sum of the numbers of the cows visited along the way. The cow with the highest score wins that frame. 

Given a triangle with N (1 <= N <= 350) rows, determine the highest possible sum achievable.
Input

Line 1: A single integer, N 

Lines 2..N+1: Line i+1 contains i space-separated integers that represent row i of the triangle.
Output

Line 1: The largest sum achievable using the traversal rules
Sample Input

5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
Sample Output

30
 */
public class p3176 {
    private static int[][] map = new int[351][351];
    private static int[][] result = new int[351][351];
    private static int n;
    private static int max(int i, int j){
        return (i > j)? i:j;
    }
    private static void init() {
        for(int i = 0; i < 351; i++){
            for(int j = 0 ; j < 351 ; j++) {
                result[i][j] = -1;
            }
        }
    }
    private static int d(int i,int j){
        if(result[i][j] >= 0)
            return result[i][j];
        result[i][j] = map[i][j] + (i >= n-1 ? 0 : max(d(i+1,j),d(i+1,j+1)));
        return result[i][j];
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        init();
        n = in.nextInt();
        int i,j,k;
        for(i = 0, k = 1 ; i < n ; i++,k++){
            for(j = 0; j < k ; j++) {
                map[i][j] = in.nextInt();
            }
        }
        System.out.println(d(0,0));
    }
}
