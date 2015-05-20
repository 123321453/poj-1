
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
public class p1318 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] Alist = new String[105];
        //ArrayList<String> dic = new ArrayList();
        int k = 0;
        while(in.hasNext()){
            String tmp = in.next();
            if(tmp.equals("XXXXXX"))
                break;
            Alist[k] = tmp;
            k++;
        }
        String[] Blist = new String[Alist.length];
        Arrays.sort((String[])Alist);
        int i;
        for(i = 0; i < Alist.length;i++) {
            Blist[i] = Alist[i];
            char[] tmp1 = Alist[i].toCharArray();
            Arrays.sort(tmp1);
            String newStr = new String(tmp1);
            Alist[i] = newStr;
        }
        while(in.hasNext()) {
            String tmp2 = in.next();
            if(tmp2.equals("XXXXXX"))
                break;
            char[] word = tmp2.toCharArray();
            Arrays.sort(word);
            String newStr2 = new String(word);
            boolean flag = false;
            for(i = 0; i < Alist.length;i++) {
                if(Alist[i].equals(newStr2)) {
                    System.out.println(Blist[i]);
                    flag = true;
                }
            }
            if(!flag)
                System.out.println("NOT A VALID WORD");
            System.out.println("******");
        }
    }
}
