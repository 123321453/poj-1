
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Babelfish
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 26259		Accepted: 11273
Description

You have just moved from Waterloo to a big city. The people here speak an incomprehensible dialect of a foreign language. Fortunately, you have a dictionary to help you understand them.
Input

Input consists of up to 100,000 dictionary entries, followed by a blank line, followed by a message of up to 100,000 words. Each dictionary entry is a line containing an English word, followed by a space and a foreign language word. No foreign word appears more than once in the dictionary. The message is a sequence of words in the foreign language, one word on each line. Each word in the input is a sequence of at most 10 lowercase letters.
Output

Output is the message translated to English, one word per line. Foreign words not in the dictionary should be translated as "eh".
Sample Input

dog ogday
cat atcay
pig igpay
froot ootfray
loops oopslay

atcay
ittenkay
oopslay
Sample Output

cat
eh
loops
Hint

Huge input and output,scanf and printf are recommended.
Source

Waterloo local 2001.09.22
 */
public class p2503 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,String> map = new HashMap();
        
        while(true) {
            String tmp = in.nextLine();
            if(tmp.equals(""))
                break;
            String[] tab = tmp.split("\\s+");
            map.put(tab[1], tab[0]);
        }
        while(in.hasNext()) {
            String test = in.next();
            if(map.containsKey(test)) {
                System.out.println(map.get(test));
            }
            else {
                System.out.println("eh");
            }
        }
    }
}
