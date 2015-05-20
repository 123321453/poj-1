
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Lake Counting
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 15038		Accepted: 7607
Description

Due to recent rains, water has pooled in various places in Farmer John's field, which is represented by a rectangle of N x M (1 <= N <= 100; 1 <= M <= 100) squares. Each square contains either water ('W') or dry land ('.'). Farmer John would like to figure out how many ponds have formed in his field. A pond is a connected set of squares with water in them, where a square is considered adjacent to all eight of its neighbors. 

Given a diagram of Farmer John's field, determine how many ponds he has.
Input

* Line 1: Two space-separated integers: N and M 

* Lines 2..N+1: M characters per line representing one row of Farmer John's field. Each character is either 'W' or '.'. The characters do not have spaces between them.
Output

* Line 1: The number of ponds in Farmer John's field.
Sample Input

10 12
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.
Sample Output

3
Hint

OUTPUT DETAILS: 

There are three ponds: one in the upper left, one in the lower left,and one along the right side.
Source

USACO 2004 November
 */
public class p2386 {
    private static char[][] tab;
    private static int N;
    private static int M;
    public static void dfs(int x, int y) {
        int dx = 1;
        int dy = 1;
        //if(x < 0 || y < 0|| x >= N || y >= M)
         //   return;
        tab[x][y] = '.';
        for(int i = x-dx; i <= x+dx; i++) {
            for(int j = y-dy; j <= y+dy; j++) {
                if(i >= 0 && j >= 0 && i < N && j < M && tab[i][j] == 'W')
                        dfs(i,j);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] t1 = in.nextLine().split("\\s+");
        N = Integer.valueOf(t1[0]);
        M = Integer.valueOf(t1[1]);
        tab = new char[N][M]; //N:row; M:col
        int i,j;
        //System.out.println();
        for(i = 0; i < N; i++) {
            char[]tmp = in.nextLine().toCharArray();
           // System.out.println(tmp.length);
            for(j = 0; j < tmp.length ; j++) {
                tab[i][j] = tmp[j];
               // if(i == 0 && j == 11)
                //    System.out.println(tab[i][j]);
                //System.out.println(tab[i][j]);
            }
        }
        
        int num = 0;
        for(i = 0 ; i < N ; i++) {
            for(j = 0; j < M ; j++) {
              //  if(i == 0 && j == 11)
                //    System.out.println(tab[i][j] == 'W');
                if(tab[i][j] == 'W') {
                   // System.out.println(i +" "+j);
                    dfs(i,j);
                    num++;
                }
            }
        }
        System.out.println(num);
        /*
        for(i = 0; i < N; i++) {
            for(j = 0; j < M ; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
        * 
        */
    }
}
