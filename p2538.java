
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * WERTYU Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 7752
 * Accepted: 3679 Description
 *
 *
 * A common typing error is to place the hands on the keyboard one row to the
 * right of the correct position. So "Q" is typed as "W" and "J" is typed as "K"
 * and so on. You are to decode a message typed in this manner. Input
 *
 * Input consists of several lines of text. Each line may contain digits,
 * spaces, upper case letters (except Q, A, Z), or punctuation shown above
 * [except back-quote (`)]. Keys labelled with words [Tab, BackSp, Control,
 * etc.] are not represented in the input. Output
 *
 * You are to replace each letter or punctuation symbol by the one immediately
 * to its left on the QWERTY keyboard shown above. Spaces in the input should be
 * echoed in the output. Sample Input
 *
 * O S, GOMR YPFSU/ Sample Output
 *
 * I AM FINE TODAY. Source
 *
 * Waterloo local 2001.01.27
 */
public class p2538 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = new char[100];
        s[';'] = 'L';
        s['L'] = 'K';
        s['K'] = 'J';
        s['J'] = 'H';
        s['H'] = 'G';
        s['G'] = 'F';
        s['F'] = 'D';
        s['D'] = 'S';
        s['S'] = 'A';
        s[','] = 'M';
        s['M'] = 'N';
        s['N'] = 'B';
        s['B'] = 'V';
        s['V'] = 'C';
        s['C'] = 'X';
        s['X'] = 'Z';
        s['['] = 'P';
        s['P'] = 'O';
        s['O'] = 'I';
        s['I'] = 'U';
        s['U'] = 'Y';
        s['Y'] = 'T';
        s['T'] = 'R';
        s['R'] = 'E';
        s['E'] = 'W';
        s['W'] = 'Q';
        s['/'] = '.';
        s['\''] = ';';
        s[']'] = '[';
        s['\\'] = ']';
        s['.'] = ',';
        s['='] = '-';
        s['-'] = '0';
        s['0'] = '9';
        s['9'] = '8';
        s['8'] = '7';
        s['7'] = '6';
        s['6'] = '5';
        s['5'] = '4';
        s['4'] = '3';
        s['3'] = '2';
        s['2'] = '1';
        s['1'] = '`';
        s[' '] = ' ';
        while(in.hasNext()) {
            String str = in.nextLine();
            for(int i = 0 ; i < str.length(); i++) {
                System.out.print(s[str.charAt(i)]);
            }
            System.out.println();
        }
    }
}
