
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Message Decowding
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 10663		Accepted: 5891
Description

The cows are thrilled because they've just learned about encrypting messages. They think they will be able to use secret messages to plot meetings with cows on other farms. 

Cows are not known for their intelligence. Their encryption method is nothing like DES or BlowFish or any of those really good secret coding methods. No, they are using a simple substitution cipher. 

The cows have a decryption key and a secret message. Help them decode it. The key looks like this: 
        yrwhsoujgcxqbativndfezmlpk

Which means that an 'a' in the secret message really means 'y'; a 'b' in the secret message really means 'r'; a 'c' decrypts to 'w'; and so on. Blanks are not encrypted; they are simply kept in place. 

Input text is in upper or lower case, both decrypt using the same decryption key, keeping the appropriate case, of course. 
Input

* Line 1: 26 lower case characters representing the decryption key 

* Line 2: As many as 80 characters that are the message to be decoded 
Output

* Line 1: A single line that is the decoded message. It should have the same length as the second line of input. 
Sample Input

eydbkmiqugjxlvtzpnwohracsf
Kifq oua zarxa suar bti yaagrj fa xtfgrj
Sample Output

Jump the fence when you seeing me coming
Source

USACO 2003 March Orange
 */
public class p2141 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();
        char[] tmp = key.toCharArray();
        HashMap<Character,Character> tab = new HashMap();
        char c;
        int i;
        for(i = 0,c='a'; i < 26; i++,c++) {
            tab.put(c, tmp[i]);
           // System.out.println(tmp[i]+" "+c);
        }
        String input = in.nextLine();
        char[] out = input.toCharArray();
        for(int j = 0; j < out.length; j++) {
            char b = out[j];
            if(b == ' ') {
                System.out.print(" ");
            }
            else {
                if(Character.isUpperCase(b)) {
                    System.out.print(Character.toUpperCase(tab.get(Character.toLowerCase(b))));
                }
                else
                    System.out.print(tab.get(out[j]));
            }
        }
        System.out.println();
    }
}
