
import java.util.HashMap;
import java.util.Scanner;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * P,MTHBGWB Time Limit: 1000MS	Memory Limit: 10000K Total Submissions: 6625
 * Accepted: 3808 Description
 *
 * Morse code represents characters as variable length sequences of dots and
 * dashes. In practice, characters in a message are delimited by short pauses.
 * The following table shows the Morse code sequences: A	.-	H	....	O	---	V	...-
 * B	-...	I	..	P	.--.	W	.-- C	-.-.	J	.---	Q	--.-	X	-..- D	-..	K	-.-	R	.-.	Y	-.--
 * E	.	L	.-..	S	...	Z	--.. F	..-.	M	--	T	- G	--.	N	-.	U	..-	* Note that four
 * dot-dash combinations are unassigned. For the purposes of this problem we
 * will assign them as follows (these are not the assignments for actual Morse
 * code): underscore	..--	period	---. comma	.-.-	question mark	----
 *
 * Thus, the message "ACM_GREATER_NY_REGION" is encoded as: .- -.-. -- ..-- --.
 * .-. . .- - . .-. ..-- -. -.-- ..-- .-. . --. .. --- -. M.E. Ohaver proposed
 * an encryption scheme based on mutilating Morse code. Her scheme replaces the
 * pauses between letters, necessary because Morse is a variable-length encoding
 * that is not prefix-free, with a string that identifies the number of dots and
 * dashes in each. For example, consider the message ".--.-.--". Without knowing
 * where the pauses should be, this could be "ACM", "ANK", or several other
 * possibilities. If we add length information, however, ".--.-.--242", then the
 * code is unabiguous. Ohaver's scheme has three steps, the same for encryption
 * and decryption: 1.	Convert the text to Morse code without pauses but with a
 * string of numbers to indicate code lengths 2.	Reverse the string of numbers
 * 3.	Convert the dots and dashes back into to text using the reversed string of
 * numbers as code lengths As an example, consider the encrypted message
 * "AKADTOF_IBOETATUK_IJN". Converting to Morse code with a length string yields
 * ".--.-.--..----..-...--..-...---.-.--..--.-..--...----.232313442431121334242".
 * Reversing the numbers and decoding yields the original message
 * "ACM_GREATER_NY_REGION". Input
 *
 * This problem requires that you implement Ohaver's encoding algorithm. The
 * input will consist of several messages encoded with Ohaver's algorithm. The
 * first line of the input is an integer n that specifies the number of test
 * cases. The following n lines contain one message per line. Each message will
 * use only the twenty-six capital letters, underscores, commas, periods, and
 * question marks. Messages will not exceed 100 characters in length. Output
 *
 * For each message in the input, output the line number starting in column one,
 * a colon, a space, and then the decoded message. The output format must be
 * adhered to precisely. Sample Input
 *
 * 5
 * AKADTOF_IBOETATUK_IJN PUEL QEWOISE.EIVCAEFNRXTBELYTGD. ?EJHUT.TSMYGW?EJHOT
 * DSU.XFNCJEVE.OE_UJDXNO_YHU?VIDWDHPDJIKXZT?E Sample Output
 *
 * 1: ACM_GREATER_NY_REGION 2: PERL 3: QUOTH_THE_RAVEN,_NEVERMORE. 4:
 * TO_BE_OR_NOT_TO_BE? 5: THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG Source
 *
 * Greater New York 2001
 */
public class p1051 {

    static HashMap< String, String> codeMap = new HashMap< String, String>();
    static HashMap< String, String> ref = new HashMap< String, String>();

    static void initMap() {
        codeMap.put("A", ".-");
        codeMap.put("B", "-...");
        codeMap.put("C", "-.-.");
        codeMap.put("D", "-..");
        codeMap.put("E", ".");
        codeMap.put("F", "..-.");
        codeMap.put("G", "--.");
        codeMap.put("H", "....");
        codeMap.put("I", "..");
        codeMap.put("J", ".---");
        codeMap.put("K", "-.-");
        codeMap.put("L", ".-..");
        codeMap.put("M", "--");
        codeMap.put("N", "-.");
        codeMap.put("O", "---");
        codeMap.put("P", ".--.");
        codeMap.put("Q", "--.-");
        codeMap.put("R", ".-.");
        codeMap.put("S", "...");
        codeMap.put("T", "-");
        codeMap.put("U", "..-");
        codeMap.put("V", "...-");
        codeMap.put("W", ".--");
        codeMap.put("X", "-..-");
        codeMap.put("Y", "-.--");
        codeMap.put("Z", "--..");
        codeMap.put("_", "..--");
        codeMap.put(".", "---.");
        codeMap.put(",", ".-.-");
        codeMap.put("?", "----");

        ref.put(".-", "A");
        ref.put("-...", "B");
        ref.put("-.-.", "C");
        ref.put("-..", "D");
        ref.put(".", "E");
        ref.put("..-.", "F");
        ref.put("--.", "G");
        ref.put("....", "H");
        ref.put("..", "I");
        ref.put(".---", "J");
        ref.put("-.-", "K");
        ref.put(".-..", "L");
        ref.put("--", "M");
        ref.put("-.", "N");
        ref.put("---", "O");
        ref.put(".--.", "P");
        ref.put("--.-", "Q");
        ref.put(".-.", "R");
        ref.put("...", "S");
        ref.put("-", "T");
        ref.put("..-", "U");
        ref.put("...-", "V");
        ref.put(".--", "W");
        ref.put("-..-", "X");
        ref.put("-.--", "Y");
        ref.put("--..", "Z");
        ref.put("..--", "_");
        ref.put("---.", ".");
        ref.put(".-.-", ",");
        ref.put("----", "?");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        initMap();
        int N = in.nextInt();
        for (int i = 1; i <= N; i++) {
            StringBuffer encry =  new StringBuffer(in.next());
            StringBuffer inter = new StringBuffer();
            StringBuffer num = new StringBuffer();
            
            StringBuffer org = new StringBuffer();
            String tmp =  new String(encry);
            for(int j = 0; j < tmp.length(); j++) {
                inter.append(codeMap.get(tmp.substring(j, j+1)));
                num.append(codeMap.get(tmp.substring(j, j+1)).length());       
            }
            num = num.reverse();
            int index = 0;
            for(int j = 0; j < num.length(); j++) {
                int t1 = Integer.valueOf(num.substring(j, j+1));
                StringBuffer con = new StringBuffer();
                for(int k = index; k < index+t1;k++) {
                    con.append(inter.substring(k, k+1));
                }
                org.append(ref.get(new String(con)));
                index += t1;
            }
            System.out.printf("%d: %s\n",i,org);
        }
    }
}
