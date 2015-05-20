
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Soundex
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8701		Accepted: 4311
Description

Soundex coding groups together words that appear to sound alike based on their spelling. For example, "can" and "khawn", "con" and "gone" would be equivalent under Soundex coding. 
Soundex coding involves translating each word into a series of digits in which each digit represents a letter: 
      1 represents B, F, P, or V

      2 represents C, G, J, K, Q, S, X,  or Z

      3 represents D or T

      4 represents L

      5 represents M or N

      6 represents R

The letters A, E, I, O, U, H, W, and Y are not represented in Soundex coding, and repeated letters with the same code digit are represented by a single instance of that digit. Words with the same Soundex coding are considered equivalent.
Input

Each line of input contains a single word, all upper case, less than 20 letters long.
Output

For each line of input, produce a line of output giving the Soundex code. 
Sample Input

KHAWN
PFISTER
BOBBY
Sample Output

25
1236
11
Source

Waterloo local 1999.09.25
 */
public class p2608 {
    public static void main(String[] args) {
        HashMap<Character,Character> tab = new HashMap();
        tab.put('B', '1');
        tab.put('F', '1');
        tab.put('P', '1');
        tab.put('V', '1');
        tab.put('C', '2');
        tab.put('G', '2');
        tab.put('J', '2');
        tab.put('K', '2');
        tab.put('Q', '2');
        tab.put('S', '2');
        tab.put('X', '2');
        tab.put('Z', '2');
        tab.put('D', '3');
        tab.put('T', '3');
        tab.put('L', '4');
        tab.put('M', '5');
        tab.put('N', '5');
        tab.put('R', '6');
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            StringBuffer lis =  new StringBuffer();
            char[] tmp = in.next().toCharArray();
            char prev = '_';
            for(int i = 0; i < tmp.length;i++) {
                if(prev == '_') {
                    if(tab.get(tmp[i]) != null) {
                        lis.append(tab.get(tmp[i]));
                        prev = tmp[i];
                    }
                    else {
                        prev = tmp[i];
                    }
                }
                else {
                    if(tab.get(tmp[i]) != null && tab.get(tmp[i]) != tab.get(prev)) {
                        lis.append(tab.get(tmp[i]));
                        prev = tmp[i];
                    }
                    else {
                        prev = tmp[i];
                    }
                }
            }
            System.out.println(lis);
        }
    }
}
