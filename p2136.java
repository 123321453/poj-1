
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Vertical Histogram Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 14812	Accepted: 7188 Description
 *
 * Write a program to read four lines of upper case (i.e., all CAPITAL LETTERS)
 * text input (no more than 72 characters per line) from the input file and
 * print a vertical histogram that shows how many times each letter (but not
 * blanks, digits, or punctuation) appears in the all-upper-case input. Format
 * your output exactly as shown. Input
 *
 * Lines 1..4: Four lines of upper case text, no more than 72 characters per
 * line. Output
 *
 * Lines 1..??: Several lines with asterisks and spaces followed by one line
 * with the upper-case alphabet separated by spaces. Do not print unneeded
 * blanks at the end of any line. Do not print any leading blank lines. Sample
 * Input
 *
 * THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG. THIS IS AN EXAMPLE TO TEST FOR
 * YOUR HISTOGRAM PROGRAM. HELLO! Sample Output
 *
 *
 *
 *                   *
 *                   * * *
 *                   * * *
 *       * * * * *
 *       * * * * * * * * *
 *       * * * * * * * * * * * *
 *     * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 */
public class p2136 {
    /*
     * HashTab way public static void main(String[] args) { Scanner in = new
     * Scanner(System.in); HashMap<Character,Integer> tab = new
     * HashMap<Character,Integer>(); int max = 0; int i,j; char[]arr; String
     * inLine; for(i = 0; i < 4; i++) { inLine = in.nextLine(); arr =
     * inLine.toCharArray(); for(j = 0 ; j < inLine.length() ; j++) { char c =
     * arr[j]; if(tab.containsKey(c)) { tab.put(arr[j], tab.get(c) + 1); } else
     * { tab.put(c, 1); } if(max < tab.get(c)) { max = tab.get(c); } } } char b;
     * for(i = max ; i >=1 ; i--){ for (b = 'A' ; b <= 'Z' ; b++) {
     * if(tab.get(b) < i) { System.out.print(" "); } else { System.out.print("*
     * "); } } System.out.println(); } for(b = 'A' ; b <= 'Z' ; b++ ){
     * System.out.print(b + " "); } }
     *
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //  HashMap<Character, Integer> tab = new HashMap<Character, Integer>();
        int max = 0;
        int i, j;
        char[] arr;
        int[] map = new int[26];
        String inLine;
        for (i = 0; i < 4; i++) {
            inLine = in.nextLine();
            arr = inLine.toCharArray();
            for (j = 0; j < inLine.length(); j++) {
                char c = arr[j];
                if (c >= 'A' && c <= 'Z') {
                    int tmp = c - 'A';
                    map[tmp]++;
                    if (max < map[tmp]) {
                        max = map[tmp];
                    }
                }
            }
        }
        char b;
        for (i = max; i >= 1; i--) {
            for (b = 'A'; b <= 'Z'; b++) {
                if (map[b - 'A'] < i) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        for (b = 'A'; b <= 'Z'; b++) {
            System.out.print(b + " ");
        }
    }
}
