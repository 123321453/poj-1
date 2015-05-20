
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Function Run Fun Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 13396	Accepted: 6973 Description
 *
 * We all love recursion! Don't we? * Consider a three-parameter recursive
 * function w(a, b, c): * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c)
 * returns: 1 * if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20,
 * 20, 20) * if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a,
 * b-1, c-1) - w(a, b-1, c) * otherwise it returns: w(a-1, b, c) + w(a-1, b-1,
 * c) + w(a-1, b, c-1) - w(a-1, b-1, c-1) * This is an easy function to
 * implement. The problem is, if implemented directly, for moderate values of a,
 * b and c (for example, a = 15, b = 15, c = 15), the program takes hours to run
 * because of the massive recursion. Input
 *
 * The input for your program will be a series of integer triples, one per line,
 * until the end-of-file flag of -1 -1 -1. Using the above technique, you are to
 * calculate w(a, b, c) efficiently and print the result. Output
 *
 * Print the value for w(a,b,c) for each triple. Sample Input
 *
 * 1 1 1
 * 2 2 2
 * 10 4 6 50 50 50 -1 7 18 -1 -1 -1 Sample Output
 *
 * w(1, 1, 1) = 2 w(2, 2, 2) = 4 w(10, 4, 6) = 523 w(50, 50, 50) = 1048576 w(-1,
 * 7, 18) = 1
 */
public class p1579 {
    public static void main(String[] args) {
        int[][][] tab = new int[21][21][21];
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21;j++) {
                for(int k = 0;k < 21 ; k++){
                    if(i==0 || j==0 || k ==0) {
                        tab[i][j][k] = 1;
                    }
                    else {
                        if(i < j && j < k)
                            tab[i][j][k] = tab[i][j][k-1] + + tab[i][j-1][k-1] - tab[i][j-1][k];
                        else
                            tab[i][j][k] = tab[i-1][j][k] + tab[i-1][j-1][k] + tab[i-1][j][k-1] - tab[i-1][j-1][k-1];
                    }
                }
            }
        }
        while (in.hasNext()) {
            String[] arr = in.nextLine().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            if ((a == b) && (b == c) && (c == -1)) {
                break;
            }
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, tab[0][0][0]);
            } else if (a > 20 || b > 20 || c > 20) {
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, tab[20][20][20]);
            } else {
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, tab[a][b][c]);
            }
        }
    }
}
