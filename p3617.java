
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Best Cow Line Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 5416
 * Accepted: 1764 Description
 *
 * FJ is about to take his N (1 ≤ N ≤ 2,000) cows to the annual"Farmer of the
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
 */
public class p3617 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        List<Character> oldL = new ArrayList();
        List<Character> newL = new ArrayList();
        int i;
        int index;
        for (i = 0; i < num; i++) {
            String tmp = in.nextLine();
            oldL.add(tmp.charAt(0));
        }
        for (i = 0; i < num; i++) {
            char first = oldL.get(0);
            char last = oldL.get(oldL.size() - 1);
            if (first > last) {
                index = (oldL.size() - 1);
            } else if (first < last) {
                index = 0;
            } else {
                /*
                 * index = oldL.size() - 1; for(int j = 1 ; j < oldL.size() - 1
                 * ; j++) { if (oldL.get(j) > oldL.get(oldL.size() - j)) { index
                 * = (oldL.size() - 1); } else if (oldL.get(j) <
                 * oldL.get(oldL.size() - j)){ index = 0; } else { continue; } }
                 *
                 */
                if (oldL.size() == 1) {
                    index = 0;
                } else {
                    int x = 1, y = oldL.size() - 2;
                    while (x < y) {
                        if (oldL.get(x) == oldL.get(y)) {
                            x++;
                            y--;
                        } else {
                            break;
                        }

                    }
                    //System.out.println("x: y: size(): " + x +" "+ y + " "+ oldL.size());
                    if ((x < oldL.size()) && (y < oldL.size()) && oldL.get(x) < oldL.get(y)) {
                        index = 0;
                    } else {
                        index = oldL.size() - 1;
                    }
                }

            }
            char c = oldL.remove(index);
            newL.add(c);
            //System.out.print(c);
        }
        // System.out.println();
        int count = 0;
        for (i = 0; i < newL.size(); i++) {
            System.out.print(newL.get(i));
            count++;
            if (count % 80 == 0 && i < (num - 1)) {
                System.out.println();
                count = 0;
            }
        }

    }
}
