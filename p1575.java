
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Easier Done Than Said? Time Limit: 1000MS	Memory Limit: 10000K Total
 * Submissions: 3836	Accepted: 2131 Description
 *
 * Password security is a tricky thing. Users prefer simple passwords that are
 * easy to remember (like buddy), but such passwords are often insecure. Some
 * sites use random computer-generated passwords (like xvtpzyo), but users have
 * a hard time remembering them and sometimes leave them written on notes stuck
 * to their computer. One potential solution is to generate "pronounceable"
 * passwords that are relatively secure but still easy to remember.  *
 * FnordCom is developing such a password generator. You work in the quality
 * control department, and it's your job to test the generator and make sure
 * that the passwords are acceptable. To be acceptable, a password must satisfy
 * these three rules:  *
 * It must contain at least one vowel.  *
 * It cannot contain three consecutive vowels or three consecutive consonants.  *
 * It cannot contain two consecutive occurrences of the same letter, except for
 * 'ee' or 'oo'.  *
 * (For the purposes of this problem, the vowels are 'a', 'e', 'i', 'o', and
 * 'u'; all other letters are consonants.) Note that these rules are not
 * perfect; there are many common/pronounceable words that are not acceptable.  *
 * Input
 *
 * The input consists of one or more potential passwords, one per line, followed
 * by a line containing only the word 'end' that signals the end of the file.
 * Each password is at least one and at most twenty letters long and consists
 * only of lowercase letters. Output
 *
 * For each password, output whether or not it is acceptable, using the precise
 * format shown in the example. Sample Input
 *
 * a
 * tv ptoui bontres zoggax wiinq eep houctuh end Sample Output
 *
 * <a> is acceptable. <tv> is not acceptable. <ptoui> is not acceptable.
 * <bontres> is not acceptable. <zoggax> is not acceptable. <wiinq> is not
 * acceptable. <eep> is acceptable. <houctuh> is acceptable. Source
 *
 * Mid-Central USA 2000
 */
public class p1575 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String name = in.next();
            if (name.equals("end")) {
                break;
            }
            boolean accFlag = false;
            boolean hasVol = false;
            boolean con3 = true;
            boolean con2 = true;
            int VolCnt = 0;
            int ConCnt = 0;
            char[] tmp = name.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 'a' || tmp[i] == 'e' || tmp[i] == 'i' || tmp[i] == 'o' || tmp[i] == 'u') {
                    hasVol = true;
                    VolCnt++;
                    ConCnt=0;
                    if(VolCnt == 3)
                        con3 = false;
                }
                else {
                    ConCnt++;
                    VolCnt=0;
                    if(ConCnt == 3)
                        con3 = false;
                }
                if(i >= 1) {
                    if(tmp[i] == tmp[i-1] && tmp[i] != 'e' && tmp[i] != 'o') 
                        con2 = false;
                }
                
            }
            if(hasVol && con3 && con2)
                accFlag = true;
            if(accFlag) {
                System.out.printf("<%s> is acceptable.\n",name);
            }
            else {
                System.out.printf("<%s> is not acceptable.\n",name);
            }
        }
    }
}
