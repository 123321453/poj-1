
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
滑雪
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 61943		Accepted: 22641
Description

Michael喜欢滑雪百这并不奇怪， 因为滑雪的确很刺激。可是为了获得速度，滑的区域必须向下倾斜，而且当你滑到坡底，你不得不再次走上坡或者等待升降机来载你。Michael想知道载一个区域中最长底滑坡。区域由一个二维数组给出。数组的每个数字代表点的高度。下面是一个例子 
 1  2  3  4 5

16 17 18 19 6

15 24 25 20 7

14 23 22 21 8

13 12 11 10 9

一个人可以从某个点滑向上下左右相邻四个点之一，当且仅当高度减小。在上面的例子中，一条可滑行的滑坡为24-17-16-1。当然25-24-23-...-3-2-1更长。事实上，这是最长的一条。
Input

输入的第一行表示区域的行数R和列数C(1 <= R,C <= 100)。下面是R行，每行有C个整数，代表高度h，0<=h<=10000。
Output

输出最长区域的长度。
Sample Input

5 5
1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9
Sample Output

25
* 剪枝 递归 DP
 */
public class p1088 {
    private static int R;
    private static int C;
    private static int[][] route = new int[105][105];
    private static int[][] tab = new int[105][105];
    
  public static int maxLen(int i, int j) {
        if (route[i][j] > 1) {
            return route[i][j];
        }
        if (i == 0) {
            if (j == 0) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j + 1]) {
                        route[i][j] = 1 + maxLen(i, j + 1);
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }
            } else if (j == C - 1) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i, j-1);
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }

            } else {
                if (C > 2) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i, j-1);
                    }
                    if (tab[i][j] > tab[i][j + 1]) {
                        if (route[i][j] < (1 + maxLen(i, j + 1))) {
                            route[i][j] = 1 + route[i][j+1];
                        }
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }

            }
        } else if (i < R - 1) {
            if (j == 0) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j + 1]) {
                        route[i][j] = 1 + maxLen(i, j+1);
                    }
                }
                if (R > 2) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }
                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }

            } else if (j == C - 1) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i , j-1);
                    }
                }
                if (R > 2) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }

                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }
            } else {
                if (C > 2) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i, j - 1);
                    }
                    if (tab[i][j] > tab[i][j + 1]) {
                        if (route[i][j] < (1 + maxLen(i, j + 1))) {
                            route[i][j] = 1 + route[i][j+1];
                        }
                    }
                }
                if (R > 2) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }
                    if (tab[i][j] > tab[i + 1][j]) {
                        if (route[i][j] < (1 + maxLen(i + 1, j))) {
                            route[i][j] = 1 + route[i+1][j];
                        }
                    }
                }

            }
        } else {
            if (j == 0) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j + 1]) {
                        route[i][j] = 1 + maxLen(i, j + 1);
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }
                }

            } else if (j == C - 1) {
                if (C > 1) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i, j - 1);
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }
                }

            } else {
                if (C > 2) {
                    if (tab[i][j] > tab[i][j - 1]) {
                        route[i][j] = 1 + maxLen(i, j - 1);
                    }
                    if (tab[i][j] > tab[i][j + 1]) {
                        if (route[i][j] < (1 + maxLen(i, j + 1))) {
                            route[i][j] = 1 + route[i][j+1];
                        }
                    }
                }
                if (R > 1) {
                    if (tab[i][j] > tab[i - 1][j]) {
                        if (route[i][j] < (1 + maxLen(i - 1, j))) {
                            route[i][j] = 1 + route[i-1][j];
                        }
                    }
                }

            }
        }
        return route[i][j];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        R = in.nextInt();
        C = in.nextInt();
    //    tab = new int[R][C];
      //  route = new int[R][C];
        int i,j;
        
        int maxH;
        maxH = Integer.MIN_VALUE;
        for(i = 0; i < R ; i++) {
            for( j = 0; j < C ; j++ ){
                tab[i][j] = in.nextInt();
                route[i][j] = 1;
            }
        }
        for(i = 0; i < R; i++) {
            for(j = 0 ; j < C ;j++) {
                if(maxH < maxLen(i,j)) {
                    maxH = route[i][j];
                    //maxHR = i;
                    //maxHC = j;
                }
              //  System.out.println(i+" "+j+" "+tab[i][j] +" " +route[i][j]);
            }
        }
      System.out.println(maxH);
    }
}
