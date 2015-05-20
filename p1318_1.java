
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Word Amalgamation Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 7120	Accepted: 3464 Description
 *
 * In millions of newspapers across the United States there is a word game
 * called Jumble. The object of this game is to solve a riddle, but in order to
 * find the letters that appear in the answer it is necessary to unscramble four
 * words. Your task is to write a program that can unscramble words. Input
 *
 * The input contains four parts: 1) a dictionary, which consists of at least
 * one and at most 100 words, one per line; 2) a line containing XXXXXX, which
 * signals the end of the dictionary; 3) one or more scrambled 'words' that you
 * must unscramble, each on a line by itself; and 4) another line containing
 * XXXXXX, which signals the end of the file. All words, including both
 * dictionary words and scrambled words, consist only of lowercase English
 * letters and will be at least one and at most six characters long. (Note that
 * the sentinel XXXXXX contains uppercase X's.) The dictionary is not
 * necessarily in sorted order, but each word in the dictionary is unique.
 * Output
 *
 * For each scrambled word in the input, output an alphabetical list of all
 * dictionary words that can be formed by rearranging the letters in the
 * scrambled word. Each word in this list must appear on a line by itself. If
 * the list is empty (because no dictionary words can be formed), output the
 * line "NOT A VALID WORD" instead. In either case, output a line containing six
 * asterisks to signal the end of the list. Sample Input
 *
 * tarp given score refund only trap work earn course pepper part XXXXXX resco
 * nfudre aptr sett oresuc XXXXXX Sample Output
 *
 * score ***** refund ***** part tarp trap ***** NOT A VALID WORD ***** course
 * ***** Source
 *
 * Mid-Central USA 1998
 */
public class p1318_1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List< String> s1 = new ArrayList< String>();
        List< String> s2 = new ArrayList< String>();
        int indexS1 = 0;
        int indexS2 = 0;
        s1.add(cin.nextLine());
        while (s1.get(indexS1).charAt(0) != 'X') {
            indexS1++;
            s1.add(cin.nextLine());
        }
        s1.remove(indexS1);
        Collections.sort(s1);

        s2.add(cin.nextLine());
        while (s2.get(indexS2).charAt(0) != 'X') {
            indexS2++;
            s2.add(cin.nextLine());
        }
        s2.remove(indexS2);

        for (int i = 0; i < s2.size(); i++) {
            boolean out = false;
            for (int j = 0; j < s1.size(); j++) {
                if (isSame(s2.get(i), s1.get(j))) {
                    System.out.println(s1.get(j));
                    out = true;
                }
            }
            if (!out) {
                System.out.println("NOT A VALID WORD");
            }
            System.out.println("******");
        }

    }

    private static boolean isSame(String n1, String n2) {
        if (n1.length() != n2.length()) {
            return false;
        }
        char[] first = n1.toCharArray();
        char[] secound = n2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(secound);
        for (int i = 0; i < first.length; i++) {
            if (first[i] != secound[i]) {
                return false;
            }
        }
        return true;
    }
}
