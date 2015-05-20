
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Pseudographical recognizer Time Limit: 1000MS	Memory Limit: 65536K Total
 * Submissions: 1788	Accepted: 757 Description
 *
 * Let us define a pseudographical image to be a rectangular matrix of the
 * characters ’.’, ’‑’, ’|’, ’\’, and ’/’.
 *
 * The character ’.’ denotes empty space on the image. A horizontal line segment
 * is given as a set of ’-’ characters in adjacent cells in the same row of the
 * matrix. A vertical line segment is given as a set of ’|’ characters in
 * adjacent cells in the same column of the matrix. Similarly, a diagonal line
 * segment is given as a set of ’/’ or ’\’ characters in adjacent cells in the
 * same diagonal of the matrix. Of course, a line segment going from Northwest
 * to Southeast has to be given using the ’\’ characters and a line segment
 * going from Southwest to Northeast using the ’/’ characters.
 *
 * Write a program that, given a pseudographical image, determines if it
 * contains exactly one line segment – horizontal, vertical, or diagonal.
 *
 * Input
 *
 * The input contains several test cases. The first line contains the number of
 * test cases T (1 ≤ T ≤ 100). Next follow the descriptions of each test case.
 * The first line of the test case description contains two integers N and M (1
 * ≤ N, M ≤ 10), the number of rows and columns of the matrix, respectively.
 * Each of the following N lines of the description contains exactly M symbols
 * ‘.’, ‘‑’, ‘|’, ‘\’, or ‘/’. Output
 *
 * The output consists of T lines, one line per each test case. This line should
 * contain the word CORRECT if the input image contains exactly one line
 * segment, or the word INCORRECT otherwise.
 *
 * Sample Input
 *
 * 5
 * 5 5
 * ..... \.... .\... ..\.. ..... 3 3 /.. ./. ../ 3 6 .|.... .|.--- .|.... 3 3
 * ... ... ... 1 1 / Sample Output
 *
 * CORRECT INCORRECT INCORRECT INCORRECT CORRECT Source
 *
 * Northeastern Europe 2005, Western Subregion
 */
public class p3561 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[][] tab = new char[x][y];
            for (int j = 0; j < x; j++) {
                tab[j] = in.next().toCharArray();
            }
            //  boolean flag = true;
            boolean cntX1 = false;
            boolean cntX2 = false;
            boolean cntH1 = false;
            boolean cntS1 = false;
            int prevXa = 0;
            int prevYa = 0;
            int prevXb = 0;
            int prevYb = 0;
            int prevXH = 0;
            int prevYH = 0;
            int prevXS = 0;
            int prevYS = 0;
            int cnt = 0;
            for (int j = 0; j < x; j++) {
                if(cnt >= 2)
                    break;
                for (int k = 0; k < y; k++) {
                    if (cnt >= 2) {
                        break;
                    }
                    if (tab[j][k] == '.') {
                        continue;
                    }
                    if (tab[j][k] == '\\') {
                        if (!cntX1) {
                            cnt++;
                            cntX1 = true;
                            prevXa = j;
                            prevYa = k;
                            continue;
                        } else {
                            if (j == prevXa + 1 && k == prevYa + 1) {
                                prevXa = j;
                                prevYa = k;
                                continue;
                            } else {
                                prevXa = j;
                                prevYa = k;
                                cnt++;
                                continue;
                            }
                        }

                    }
                    if (tab[j][k] == '/') {
                        if (!cntX2) {
                            cnt++;
                            cntX2 = true;
                            prevXb = j;
                            prevYb = k;
                            continue;
                        } else {
                            if (j == prevXb + 1 && k == prevYb - 1) {
                                prevXb = j;
                                prevYb = k;
                                continue;
                            } // else if(j == prevXb + 1 && k == prevYb - 1) {
                            //  }
                            else {
                                prevXb = j;
                                prevYb = k;
                                cnt++;
                                continue;
                            }
                        }

                    }
                    if (tab[j][k] == '-') {
                        if (!cntH1) {
                            cnt++;
                            cntH1 = true;
                            prevXH = j;
                            prevYH = k;
                            continue;
                        } else {
                            if (j == prevXH && k == prevYH + 1) {
                                prevXH = j;
                                prevYH = k;
                                continue;
                          //  } else if (j == prevXH && k == prevYH - 1) {
                           //     prevXH = j;
                            //    prevYH = k;
                            } else {
                                prevXH = j;
                                prevYH = k;
                                cnt++;
                                continue;
                            }
                        }

                    }
                    if (tab[j][k] == '|') {
                        if (!cntS1) {
                            cnt++;
                            cntS1 = true;
                            prevXS = j;
                            prevYS = k;
                            continue;
                        } else {
                            if (j == prevXS + 1 && k == prevYS) {
                                prevXS = j;
                                prevYS = k;
                                continue;
                            //} //else if (j == prevXS - 1 && k == prevYS) {
                               // prevXS = j;
                               // prevYS = k;
                            } else {
                                prevXS = j;
                                prevYS = k;
                                cnt++;
                                continue;
                            }
                        }

                    }


                }
            }
            if (cnt != 1) {
                System.out.println("INCORRECT");
            } else {
                System.out.println("CORRECT");
            }
        }
    }
}
