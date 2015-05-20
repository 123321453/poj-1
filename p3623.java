
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Best Cow Line, Gold Time Limit: 5000MS	Memory Limit: 65536K Total
 * Submissions: 3709	Accepted: 1380 Description
 *
 * FJ is about to take his N (1 ≤ N ≤ 30,000) cows to the annual"Farmer of the
 * Year" competition. In this contest every farmer arranges his cows in a line
 * and herds them past the judges.
 *
 * The contest organizers adopted a new registration scheme this year: simply
 * register the initial letter of every cow in the order they will appear (i.e.,
 * If FJ takes Bessie, Sylvia, and Dora in that order he just registers BSD).
 * After the registration phase ends, every group is judged in increasing
 * lexicographic order according to the string of the initials of the cows'
 * names.
 *
 * FJ is very busy this year and has to hurry back to his farm, so he wants to
 * be judged as early as possible. He decides to rearrange his cows, who have
 * already lined up, before registering them.
 *
 * FJ marks a location for a new line of the competing cows. He then proceeds to
 * marshal the cows from the old line to the new one by repeatedly sending
 * either the first or last cow in the (remainder of the) original line to the
 * end of the new line. When he's finished, FJ takes his cows for registration
 * in this new order.
 *
 * Given the initial order of his cows, determine the least lexicographic string
 * of initials he can make this way.
 *
 * Input
 *
 * Line 1: A single integer: N Lines 2..N+1: Line i+1 contains a single initial
 * ('A'..'Z') of the cow in the ith position in the original line
 *
 * Output
 *
 * The least lexicographic string he can make. Every line (except perhaps the
 * last one) contains the initials of 80 cows ('A'..'Z') in the new line.
 *
 * Sample Input
 *
 * 6
 * A
 * C
 * D
 * B
 * C
 * B
 * Sample Output
 *
 * ABCBCD
 * //not solve yet
 * 用后续数组
 */
public class p3623 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        char[] oldL = new char[num];
        char[] newL = new char[num];
        int i,j;
        int k = 0;
        int index;
        //System.out.println();
        for (i = 0; i < num; i++) {
            String tmp = in.nextLine();
            oldL[i] = tmp.charAt(0);
          //  System.out.println("Old: "+oldL[i]);
        }
        for (i = 0, j = (num -1),k =0; k < num;k++) {
           // char first = oldL[i];
           // char last = oldL[j];
            if (oldL[i] > oldL[j]) {
                index = j;
                j--;
            } else if (oldL[i] < oldL[j]) {
                index = i;
                i++;
            } else {
                if (oldL.length == 1) {
                    index = i;
                    i++;
                } else {
                    int x = i+1, y = j - 1;
                    while (x < y) {
                        if (oldL[x] == oldL[y]) {
                            x++;
                            y--;
                        } else {
                            break;
                        }

                    }
                    //System.out.println("x: y: size(): " + x +" "+ y + " "+ oldL.size());
                    if (oldL[x] < oldL[y]) {
                        index = i;
                        i++;
                    } else {
                        index = j;
                        j--;
                    }
                }

            }
            newL[k] = oldL[index];
        }
        // System.out.println();
        int count = 0;
        for (i = 0; i < num; i++) {
            System.out.print(newL[i]);
            count++;
            if (count % 80 == 0 && i < (num - 1)) {
                System.out.println();
                count = 0;
            }
        }

    }
}
