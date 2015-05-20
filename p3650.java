
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Seven Percent Solution
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6764		Accepted: 4535
Description

Uniform Resource Identifiers (or URIs) are strings like http://icpc.baylor.edu/icpc/, mailto:foo@bar.org, ftp://127.0.0.1/pub/linux, or even just readme.txt that are used to identify a resource, usually on the Internet or a local computer. Certain characters are reserved within URIs, and if a reserved character is part of an identifier then it must be percent-encoded by replacing it with a percent sign followed by two hexadecimal digits representing the ASCII code of the character. A table of seven reserved characters and their encodings is shown below. Your job is to write a program that can percent-encode a string of characters.

Character	Encoding
" " (space)	%20
"!" (exclamation point)	%21
"$" (dollar sign)	%24
"%" (percent sign)	%25
"(" (left parenthesis)	%28
")" (right parenthesis)	%29
"*" (asterisk)	%2a
Input

The input consists of one or more strings, each 1–79 characters long and on a line by itself, followed by a line containing only "#" that signals the end of the input. The character "#" is used only as an end-of-input marker and will not appear anywhere else in the input. A string may contain spaces, but not at the beginning or end of the string, and there will never be two or more consecutive spaces.

Output

For each input string, replace every occurrence of a reserved character in the table above by its percent-encoding, exactly as shown, and output the resulting string on a line by itself. Note that the percent-encoding for an asterisk is %2a (with a lowercase "a") rather than %2A (with an uppercase "A").

Sample Input

Happy Joy Joy!
http://icpc.baylor.edu/icpc/
plain_vanilla
(**)
?
the 7% solution
#
Sample Output

Happy%20Joy%20Joy%21
http://icpc.baylor.edu/icpc/
plain_vanilla
%28%2a%2a%29
?
the%207%25%20solution
Source

Mid-Central USA 2007
 */
public class p3650 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, String> tab = new HashMap();
        tab.put(' ', "%20");
        tab.put('!',"%21");
        tab.put('$',"%24");
        tab.put('%',"%25");
        tab.put('(',"%28");
        tab.put(')',"%29");
        tab.put('*',"%2a");
        while(in.hasNext()) {
            String test = in.nextLine();
            if(test.equals("#"))
                break;
            char[] tmp = test.toCharArray();
            for(int i = 0 ; i < tmp.length ; i++) {
                if(!tab.containsKey(tmp[i])) {
                    System.out.print(tmp[i]);
                }
                else {
                    System.out.print(tab.get(tmp[i]));
                }
            }
            System.out.println();
        }
    }
}
