
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * LC-Display Time Limit: 1000MS	Memory Limit: 10000K Total Submissions: 13645
 * Accepted: 5394 Description
 *
 * A friend of you has just bought a new computer. Until now, the most powerful
 * computer he ever used has been a pocket calculator. Now, looking at his new
 * computer, he is a bit disappointed, because he liked the LC-display of his
 * calculator so much. So you decide to write a program that displays numbers in
 * an LC-display-like style on his computer. Input
 *
 * The input contains several lines, one for each number to be displayed. Each
 * line contains two integers s, n (1 <= s <= 10, 0 <= n <= 99 999 999), where n
 * is the number to be displayed and s is the size in which it shall be
 * displayed. * The input file will be terminated by a line containing two
 * zeros. This line should not be processed. Output
 *
 * Output the numbers given in the input file in an LC-display-style using s "-"
 * signs for the horizontal segments and s "|" signs for the vertical ones. Each
 * digit occupies exactly s+2 columns and 2s+3 rows. (Be sure to fill all the
 * white space occupied by the digits with blanks, also for the last digit.)
 * There has to be exactly one column of blanks between two digits. * Output a
 * blank line after each number. (You will find a sample of each digit in the
 * sample output.) Sample Input
 *
 * 2 12345 3 67890 0 0 Sample Output
 *
 * -- -- -- | | | | | | | | | | | | -- -- -- -- | | | | | | | | | | -- -- -- *
 * --- --- --- --- --- | | | | | | | | | | | | | | | | | | | | | | | | --- ---
 * --- | | | | | | | | | | | | | | | | | | | | | | | | --- --- --- ---
 */
public class p1102 {

    public static String[][] DisPlay(char c, int a) {
        String[][] tab = new String[a + 2][2 * a + 3];
        int i, j;
        for (i = 0; i < a + 2; i++) {
            for (j = 0; j < 2 * a + 3; j++) {
                tab[i][j] = " ";
            }
        }
        if ((c == 49) || (c == 51) || (c == 52) || (c == 55) || (c == 56) || (c == 57) || (c == 48)) {
            //      tab[a + 1][0] = " ";
            //      tab[a + 1][a + 1] = " ";
            //      tab[a + 1][2 * a + 2] = " ";
            for (i = 1; i <= a; i++) {
                tab[a + 1][i] = "|";
                tab[a + 1][i + a + 1] = "|";
            }
        }
        if (c == 50) {
            //      tab[a + 1][0] = " ";
            //     tab[a + 1][a + 1] = " ";
            //       tab[a + 1][2 * a + 2] = " ";
            for (i = 1; i <= a; i++) {
                tab[a + 1][i] = "|";
                tab[a + 1][i + a + 1] = " ";
            }
        }
        if ((c == 53) || (c == 54)) {
            //      tab[a + 1][0] = " ";
            //     tab[a + 1][a + 1] = " ";
            //     tab[a + 1][2 * a + 2] = " ";
            for (i = 1; i <= a; i++) {
                tab[a + 1][i] = " ";
                tab[a + 1][i + a + 1] = "|";
            }

        }
        if ((c == 50) || (c == 51) || (c == 53) || (c == 54) || (c == 56) || (c == 57) || (c == 48)) {
            //     tab[0][0] = " ";
            //     tab[a+1][0] = " ";
            //     tab[0][2 * a + 2] = " ";
            //    tab[a + 1][2 * a + 2] = " ";
            for (i = 1; i <= a; i++) {
                tab[i][0] = "-";
                tab[i][2 * a + 2] = "-";
            }
        }
        if (c == 55) {
            for (i = 1; i <= a; i++) {
                tab[i][0] = "-";
            }
        }
        if ((c == 50) || (c == 51) || (c == 52) || (c == 53) || (c == 54) || (c == 56) || (c == 57)) {
            //    tab[0][a+1] = " ";
            //    tab[a + 1][a+1] = " ";
            for (i = 1; i <= a; i++) {
                tab[i][a + 1] = "-";
            }
        }
        if ((c == 52) || (c == 53) || (c == 54) || (c == 56) || (c == 57) || (c == 48)) {
            for (i = 1; i <= a; i++) {
                tab[0][i] = "|";
            }
        }
        if ((c == 50) || (c == 54) || (c == 56) || (c == 48)) {
            for (i = a + 2; i < 2 * a + 2; i++) {
                tab[0][i] = "|";
            }
        }
        return tab;

    }

    public static void print(String tab, int a) {
        char[] top_r = {'-', ' ', '-', '-', ' ', '-', '-', '-', '-', '-'};
        char[] mid_r = {' ', ' ', '-', '-', '-', '-', '-', ' ', '-', '-'};
        char[] bot_r = {'-', ' ', '-', '-', ' ', '-', '-', ' ', '-', '-'};
        char[] ul_c = {'|', ' ', ' ', ' ', '|', '|', '|', ' ', '|', '|'};
        char[] dl_c = {'|', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' '};
        char[] ur_c = {'|', '|', '|', '|', '|', ' ', ' ', '|', '|', '|'};
        char[] dr_c = {'|', '|', ' ', '|', '|', '|', '|', '|', '|', '|'};
        int i, j, z;
        for (i = 0; i < tab.length(); i++) {
            System.out.print(" ");
            for (j = 0; j < a; j++) {
                System.out.print(top_r[Integer.parseInt(tab.substring(i, i + 1))]);
            }
            System.out.print(" ");
            System.out.print(" ");
        }
        System.out.println();
        for (j = 0; j < a ; j++) {
            for (i = 0; i < tab.length(); i++) {

                System.out.print(ul_c[Integer.parseInt(tab.substring(i, i + 1))]);
                for (z = i; z < i+a; z++) {
                    System.out.print(" ");
                }
                System.out.print(ur_c[Integer.parseInt(tab.substring(i, i + 1))]);
                System.out.print(" ");
            }
            System.out.println();
        }
        // System.out.println();
        for (i = 0; i < tab.length(); i++) {
            System.out.print(" ");
            for (j = 0; j < a; j++) {
                System.out.print(mid_r[Integer.parseInt(tab.substring(i, i + 1))]);
            }
            System.out.print(" ");
            System.out.print(" ");
        }
        System.out.println();
        for (j = 0; j < a ; j++) {
            for (i = 0; i < tab.length(); i++) {
                System.out.print(dl_c[Integer.parseInt(tab.substring(i, i + 1))]);
                for (z = i; z < i+a; z++) {
                    System.out.print(" ");
                }
                System.out.print(dr_c[Integer.parseInt(tab.substring(i, i + 1))]);
                System.out.print(" ");
            }
            System.out.println();
        }
        for (i = 0; i < tab.length(); i++) {
            System.out.print(" ");
            for (j = 0; j < a; j++) {
                System.out.print(bot_r[Integer.parseInt(tab.substring(i, i + 1))]);
            }
            System.out.print(" ");
            System.out.print(" ");
        }

    }

    public static void main(String[] args) {
        //int[][] tab  = new int[][];
        Scanner in = new Scanner(System.in);
        String[] arr;
        while (in.hasNext()) {
            arr = in.nextLine().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            if ((a == b) && (a == 0)) {
                return;
            }
            print(arr[1], a);
            System.out.println();
            System.out.println();
        }

    }
}
