
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Deli Deli
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3667		Accepted: 2069
Description

Mrs. Deli is running the delicatessen store "Deli Deli". Last year Mrs. Deli has decided to expand her business and build up an online store. She has hired a programmer who has implemented the online store.

Recently some of her new online customers complained about the electronic bills. The programmer had forgotten to use the plural form in case that an item is purchased multiple times. Unfortunaly the programmer of Mrs. Deli is on holiday and now it is your task to implement this feature for Mrs. Deli. Here is a description how to make the plural form:

If the word is in the list of irregular words replace it with the given plural.
Else if the word ends in a consonant followed by "y", replace "y" with "ies".
Else if the word ends in "o", "s", "ch", "sh" or "x", append "es" to the word.
Else append "s" to the word.
Input

The first line of the input file consists of two integers L and N (0 ≤ L ≤ 20, 1 ≤ N ≤ 100). The following L lines contain the description of the irregular words and their plural form. Each line consists of two words separated by a space character, where the first word is the singular, the second word the plural form of some irregular word. After the list of irregular words, the following N lines contain one word each, which you have to make plural. You may assume that each word consists of at most 20 lowercase letters from the English alphabet ('a' to 'z').

Output

Print N lines of output, where the ith line is the plural form of the ith input word.

Sample Input

3 7
rice rice
spaghetti spaghetti
octopus octopi
rice
lobster
spaghetti
strawberry
octopus
peach
turkey
Sample Output

rice
lobsters
spaghetti
strawberries
octopi
peaches
turkeys
Source

Ulm Local 2007
 */
public class p3366 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int N = in.nextInt();
        HashMap<String,String> tab = new HashMap();
        int i;
        for(i = 0; i < L; i++) {
            tab.put(in.next(), in.next());
        }
        for(i = 0; i < N ;i++) {
            String input = in.next();
            StringBuffer buf = new StringBuffer(input);
            char[] tmp = input.toCharArray();
            if(tab.containsKey(input)) {
                System.out.println(tab.get(input));
                continue;
            }
            else if(tmp[tmp.length-1] == 'y' && tmp[tmp.length-2] != 'a' && tmp[tmp.length-2] != 'e' && tmp[tmp.length-2] != 'i' && tmp[tmp.length-2] != 'o' && tmp[tmp.length-2] != 'u') {
                buf.replace(tmp.length-1, tmp.length, "ies");
                System.out.println(buf);
            }
            else if(tmp[tmp.length-1] == 'o' || tmp[tmp.length-1] == 's' || tmp[tmp.length-1] == 'x' || (tmp[tmp.length-2] == 'c' && tmp[tmp.length-1] == 'h') ||(tmp[tmp.length-2] == 's' && tmp[tmp.length-1] == 'h') ) {
                buf.append("es");  
                System.out.println(buf);
            }
            else {
                buf.append('s');
                System.out.println(buf);
            }
        }
        
    }
}
