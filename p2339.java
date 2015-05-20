
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Rock, Scissors, Paper Time Limit: 5000MS	Memory Limit: 65536K Total
 * Submissions: 3457	Accepted: 2016 Description
 *
 * Bart's sister Lisa has created a new civilization on a two-dimensional grid.
 * At the outset each grid location may be occupied by one of three life forms:
 * Rocks, Scissors, or Papers. Each day, differing life forms occupying
 * horizontally or vertically adjacent grid locations wage war. In each war,
 * Rocks always defeat Scissors, Scissors always defeat Papers, and Papers
 * always defeat Rocks. At the end of the day, the victor expands its territory
 * to include the loser's grid position. The loser vacates the position. Your
 * job is to determine the territory occupied by each life form after n days.
 * Input
 *
 * The first line of input contains t, the number of test cases. Each test case
 * begins with three integers not greater than 100: r and c, the number of rows
 * and columns in the grid, and n. The grid is represented by the r lines that
 * follow, each with c characters. Each character in the grid is R, S, or P,
 * indicating that it is occupied by Rocks, Scissors, or Papers respectively.
 * Output
 *
 * For each test case, print the grid as it appears at the end of the nth day.
 * Leave an empty line between the output for successive test cases. Sample
 * Input
 *
 * 2
 * 3 3 1
 * RRR RSR RRR 3 4 2 RSPR SPRS PRSP Sample Output
 *
 * RRR RRR RRR
 *
 * RRRS RRSP RSPR Source
 *
 * Waterloo local 2003.01.25
 */
public class p2339 {

    public static char retN(char s, char t) {
        if (s == 'R') {
            if (t == 'R') {
                return 'R';
            } else if (t == 'S') {
                return 'R';
            } else {
                return 'P';
            }
        } else if (s == 'S') {
            if (t == 'R') {
                return 'R';
            } else if (t == 'S') {
                return 'S';
            } else {
                return 'S';
            }
        } else {
            if (t == 'R') {
                return 'P';
            } else if (t == 'S') {
                return 'S';
            } else {
                return 'P';
            }
        }
        //return t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int n = in.nextInt();
            char[][] tab = new char[r][c];
            char[][] tmp = new char[r][c];
            for (int j = 0; j < r; j++) {
                tab[j] = in.next().toCharArray();
                //System.out.println("test1: "+tab[j][0]);
            }
            for (int p = 0; p < n; p++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        boolean flag = false;
                        if (j == 0) {
                            if (k == 0) {
                                /*
                                 * tmp[j + 1][k] = retN(tab[j][k], tmp[j +
                                 * 1][k]); tmp[j][k + 1] = retN(tab[j][k],
                                 * tmp[j][k + 1]);
                                 *
                                 */
                                if (j < r - 1) {
                                    tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                    flag = true;
                                    tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                }
                            } else if (k == c - 1) {
                                /*
                                 * tmp[j + 1][k] = retN(tab[j][k], tmp[j +
                                 * 1][k]); tmp[j][k - 1] = retN(tab[j][k],
                                 * tmp[j][k - 1]);
                                 *
                                 */
                                if (j < r - 1) {
                                    tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k > 0) {
                                    tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                    flag = true;
                                }
                            } else {
                                /*
                                 * tmp[j + 1][k] = retN(tab[j][k], tmp[j +
                                 * 1][k]); tmp[j][k - 1] = retN(tab[j][k],
                                 * tmp[j][k - 1]); tmp[j][k + 1] =
                                 * retN(tab[j][k], tmp[j][k + 1]);
                                 *
                                 */
                                if (j < r - 1) {
                                    tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k > 0) {
                                    tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                    tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                    flag = true;
                                }
                            }
                        } else if (j == r - 1) {
                            if (k == 0) {
                                /*
                                 * tmp[j - 1][k] = retN(tab[j][k], tmp[j -
                                 * 1][k]); tmp[j][k + 1] = retN(tab[j][k],
                                 * tmp[j][k + 1]);
                                 *
                                 *
                                 */
                                if (j > 0) {
                                    tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                    tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                    flag = true;
                                }
                            } else if (k == c - 1) {
                                /*
                                 * tmp[j - 1][k] = retN(tab[j][k], tmp[j -
                                 * 1][k]); tmp[j][k - 1] = retN(tab[j][k],
                                 * tmp[j][k - 1]);
                                 *
                                 */
                                if (j > 0) {
                                    tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k > 0) {
                                    tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                    flag = true;
                                }

                            } else {
                                /*
                                 * tmp[j - 1][k] = retN(tab[j][k], tmp[j -
                                 * 1][k]); tmp[j][k - 1] = retN(tab[j][k],
                                 * tmp[j][k - 1]); tmp[j][k + 1] =
                                 * retN(tab[j][k], tmp[j][k + 1]);
                                 *
                                 */
                                if (j > 0) {
                                    tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k > 0) {
                                    tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                    tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                    flag = true;
                                }
                            }
                        } else if (k == 0) {
                            if (j == 0) {
                                // tmp[j + 1][k] = retN(tab[j][k], tmp[j + 1][k]);
                                // tmp[j][k + 1] = retN(tab[j][k], tmp[j][k + 1]);
                            } else if (j == r - 1) {
                                // tmp[j - 1][k] = retN(tab[j][k], tmp[j - 1][k]);
                                // tmp[j][k + 1] = retN(tab[j][k], tmp[j][k + 1]);
                            } else {
                                /*
                                 * tmp[j + 1][k] = retN(tab[j][k], tmp[j +
                                 * 1][k]); tmp[j - 1][k] = retN(tab[j][k], tmp[j
                                 * - 1][k]); tmp[j][k + 1] = retN(tab[j][k],
                                 * tmp[j][k + 1]);
                                 *
                                 */
                                if (j < r - 1) {
                                    tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && j > 0) {
                                    tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                    tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                    flag = true;
                                }
                            }
                        } else if (k == c - 1) {
                            if (j == 0) {
                                // tmp[j + 1][k] = retN(tab[j][k], tmp[j + 1][k]);
                                // tmp[j][k - 1] = retN(tab[j][k], tmp[j][k - 1]);
                            } else if (j == r - 1) {
                                //  tmp[j - 1][k] = retN(tab[j][k], tmp[j - 1][k]);
                                // tmp[j][k - 1] = retN(tab[j][k], tmp[j][k - 1]);
                            } else {
                                /*
                                 * tmp[j + 1][k] = retN(tab[j][k], tmp[j +
                                 * 1][k]); tmp[j - 1][k] = retN(tab[j][k], tmp[j
                                 * - 1][k]); tmp[j][k - 1] = retN(tab[j][k],
                                 * tmp[j][k - 1]);
                                 *
                                 */
                                if (j < r - 1) {
                                    tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && j > 0) {
                                    tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                    flag = true;
                                }
                                if (tmp[j][k] == tab[j][k] && k > 0) {
                                    tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                    flag = true;
                                }
                            }
                        } else {
                            /*
                             * tmp[j + 1][k] = retN(tab[j][k], tmp[j + 1][k]);
                             * tmp[j - 1][k] = retN(tab[j][k], tmp[j - 1][k]);
                             * tmp[j][k - 1] = retN(tab[j][k], tmp[j][k - 1]);
                             * tmp[j][k + 1] = retN(tab[j][k], tmp[j][k + 1]);
                             *
                             */
                            if (j < r - 1) {
                                tmp[j][k] = retN(tab[j + 1][k], tab[j][k]);
                                flag = true;
                            }
                            if (tmp[j][k] == tab[j][k] && j > 0) {
                                tmp[j][k] = retN(tab[j - 1][k], tab[j][k]);
                                flag = true;
                            }
                            if (tmp[j][k] == tab[j][k] && k < c - 1) {
                                tmp[j][k] = retN(tab[j][k + 1], tab[j][k]);
                                flag = true;
                            }
                            if (tmp[j][k] == tab[j][k] && k > 0) {
                                tmp[j][k] = retN(tab[j][k - 1], tab[j][k]);
                                flag = true;
                            }
                        }
                        if (!flag) {
                            tmp[j][k] = tab[j][k];
                        }
                    }
                }
                // System.out.println("test1:");
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (tmp[j][k] != ' ') {
                            tab[j][k] = tmp[j][k];
                        } else {
                            tab[j][k] = tab[j][k];
                        }
                        //       System.out.print(tab[j][k]);
                    }
                    //  System.out.println();
                }
                // System.out.println("test2:");
            }
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    //tab[j][k] = tmp[j][k];
                    System.out.print(tab[j][k]);
                }
                System.out.println();
            }
            System.out.println();

        }
    }
}
