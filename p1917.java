
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Automatic Poetry Time Limit: 1000MS	Memory Limit: 30000K Total Submissions:
 * 1826	Accepted: 957 Description
 *
 * Background "Oh God", Lara Croft exclaims, "it's one of these dumb riddles
 * again!" In Tomb Raider XIV, Lara is, as ever, gunning her way through ancient
 * Egyptian pyramids, prehistoric caves and medival hallways. Now she is
 * standing in front of some important Germanic looking doorway and has to solve
 * a linguistic riddle to pass. As usual, the riddle is not very intellectually
 * challenging. This time, the riddle involves poems containing a
 * "Schuttelreim". An example of a Schuttelreim is the following short poem: Ein
 * Kind halt seinen Schnabel nur, wenn es hangt an der Nabelschnur.
 *
 * The Problem A Schuttelreim seems to be a typical German invention. The funny
 * thing about this strange type of poetry is that if somebody gives you the
 * first line and the beginning of the second one, you can complete the poem
 * yourself. Well, even a computer can do that, and your task is to write a
 * program which completes them automatically. This will help Lara concentrate
 * on the "action" part of Tomb Raider and not on the "intellectual" part. Input
 *
 * The input will begin with a line containing a single number n. After this
 * line follow n pairs of lines containing Schuttelreims. The first line of each
 * pair will be of the form s1<s2>s3<s4>s5
 *
 * where the si are possibly empty strings of lowercase characters or blanks.
 * The second line will be a string of lowercase characters or blanks ending
 * with three dots "...". Lines will we at most 100 characters long. Output
 *
 * For each pair of Schuttelreim lines l1 and l2 you are to output two lines c1
 * and c2 in the following way: c1 is the same as l1 only that the bracket marks
 * "<" and ">" are removed. Line c2 is the same as l2, except that instead of
 * the three dots the string s4s3s2s5
 *
 * should appear. Sample Input
 *
 * 3
 * ein kind haelt seinen <schn>abel <n>ur wenn es haengt an der ... weil wir zu
 * spaet zur <>oma <k>amen verpassten wir das ... <d>u <b>ist ... Sample Output
 *
 * ein kind haelt seinen schnabel nur wenn es haengt an der nabel schnur weil
 * wir zu spaet zur oma kamen verpassten wir das koma amen du bist bu dist
 * Source
 *
 * TUD Programming Contest 2001, Darmstadt, Germany
 */
public class p1917 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        for (int i = 0; i < num; i++) {
            StringBuffer s1 = new StringBuffer();
            StringBuffer s2 = new StringBuffer();
            StringBuffer s3 = new StringBuffer();
            StringBuffer s4 = new StringBuffer();
            StringBuffer s5 = new StringBuffer();
            char[] tmp1 = in.nextLine().toCharArray();
            int cnt = 0;
            int j;
            for (j = 0; j < tmp1.length; j++) {
                if (cnt == 0) {
                    if (tmp1[j] != '<') {
                        s1.append(tmp1[j]);
                        //System.out.print(tmp1[j]);
                    } else {
                        cnt++;
                    }
                } else if (cnt == 1) {
                    if (tmp1[j] != '>') {
                        s2.append(tmp1[j]);
                        //System.out.print(tmp1[j]);
                    } else {
                        cnt++;
                    }
                } else if (cnt == 2) {
                    if (tmp1[j] != '<') {
                        s3.append(tmp1[j]);
                        //System.out.print(tmp1[j]);
                    } else {
                        cnt++;
                    }
                } else if (cnt == 3) {
                    if (tmp1[j] != '>') {
                        s4.append(tmp1[j]);
                        //System.out.print(tmp1[j]);
                    } else {
                        cnt++;
                    }
                } else {
                    s5.append(tmp1[j]);
                }

            }
            StringBuffer s0 = new StringBuffer();
            s0.append(s1);
            s0.append(s2);
            s0.append(s3);
            s0.append(s4);
            s0.append(s5);
            System.out.println(s0);
            StringBuffer s6 = new StringBuffer();
            char[] tmp2 = in.nextLine().toCharArray();
            for(j = 0 ; j  <tmp2.length;j++) {
                if(tmp2[j] != '.') {
                    s6.append(tmp2[j]);
                }
                else {
                    s6.append(s4);
                    s6.append(s3);
                    s6.append(s2);
                    s6.append(s5);
                    break;
                }
            }
            System.out.println(s6);
        }
    }
}
