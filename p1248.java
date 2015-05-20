
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Safecracker Time Limit: 1000MS	Memory Limit: 10000K Total Submissions: 1709
 * Accepted: 1007 Description
 *
 * "The item is locked in a Klein safe behind a painting in the second-floor
 * library. Klein safes are extremely rare; most of them, along with Klein and
 * his factory, were destroyed in World War II. Fortunately old Brumbaugh from
 * research knew Klein's secrets and wrote them down before he died. A Klein
 * safe has two distinguishing features: a combination lock that uses letters
 * instead of numbers, and an engraved quotation on the door. A Klein quotation
 * always contains between five and twelve distinct uppercase letters, usually
 * at the beginning of sentences, and mentions one or more numbers. Five of the
 * uppercase letters form the combination that opens the safe. By combining the
 * digits from all the numbers in the appropriate way you get a numeric target.
 * (The details of constructing the target number are classified.) To find the
 * combination you must select five letters v, w, x, y, and z that satisfy the
 * following equation, where each letter is replaced by its ordinal position in
 * the alphabet (A=1, B=2, ..., Z=26). The combination is then vwxyz. If there
 * is more than one solution then the combination is the one that is
 * lexicographically greatest, i.e., the one that would appear last in a
 * dictionary."  *
 * v - w2 + x3 - y4 + z5 = target  *
 * "For example, given target 1 and letter set ABCDEFGHIJKL, one possible
 * solution is FIECB, since 6 - 92 + 53 - 34 + 25 = 1. There are actually
 * several solutions in this case, and the combination turns out to be LKEBA.
 * Klein thought it was safe to encode the combination within the engraving,
 * because it could take months of effort to try all the possibilities even if
 * you knew the secret. But of course computers didn't exist then."  *
 *
 * "Develop a program to find Klein combinations in preparation for field
 * deployment. Use standard test methodology as per departmental regulations.  *
 * Input
 *
 * Input consists of one or more lines containing a positive integer target less
 * than twelve million, a space, then at least five and at most twelve distinct
 * uppercase letters. The last line will contain a target of zero and the
 * letters END; this signals the end of the input. Output
 *
 * For each line output the unique Klein combination, or 'no solution' if there
 * is no correct combination. Use the exact format shown below." Sample Input
 *
 * 1 ABCDEFGHIJKL 11700519 ZAYEXIWOVU 3072997 SOUGHT 1234567 THEQUICKFROG 0 END
 * Sample Output
 *
 * LKEBA YOXUZ GHOST no solution Source
 *
 * Mid-Central USA 2002
 */
public class p1248 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Aval = 65;
        while (in.hasNext()) {
            int num = in.nextInt();
            String code = in.next();
            if (num == 0 && code.equals("END")) {
                break;
            }
            char v = 'z';
            char w = 'z';
            char x = 'z';
            char y = 'z';
            char z = 'z';
            char[] tab = code.toCharArray();
            Arrays.sort(tab);
            //System.out.println(tab);
            boolean flag = false;
            int i, j, k, o, p;
            //System.out.println(tab.length);
            for (i = tab.length - 1; i >= 0; i--) {
                // System.out.println(i);
                for (j = tab.length - 1; j >= 0; j--) {
                    //   System.out.println(j);
                    for (k = tab.length - 1; k >= 0; k--) {
                        //     System.out.println(k);
                        for (o = tab.length - 1; o >= 0; o--) {
                            //       System.out.println(o);
                            for (p = tab.length - 1; p >= 0; p--) {
                                //System.out.println(p);
                                //System.out.println(tab[i]+" "+ tab[j]+" "+ tab[k]+" "+ tab[o]+" "+ tab[p]+" "); 
                                //tab[i] = 'Y';
                                //tab[j] = 'O';
                                //tab[k] = 'X';
                                //tab[o] = 'U';
                                //tab[p] = 'Z';
                                if ((((int) tab[i] - Aval + 1) - (int) Math.pow(((int) tab[j] - Aval + 1), 2) + (int) Math.pow(((int) tab[k] - Aval + 1), 3) - (int) Math.pow(((int) tab[o] - Aval + 1), 4) + (int) Math.pow(((int) tab[p] - Aval + 1), 5)) == num) {
                                    if (tab[i] == tab[j] || tab[j] == tab[k] || tab[k] == tab[o] || tab[o] == tab[p]) {
                                        continue;
                                    } else {
                                        flag = true;
                                        v = (char) tab[i];
                                        w = (char) tab[j];
                                        x = (char) tab[k];
                                        y = (char) tab[o];
                                        z = (char) tab[p];
                                        break;
                                    }

                                }
                            }
                            if (flag) {
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }

                }
                if (flag) {
                    break;
                }
            }
            if (flag) {

                System.out.println(v + "" + "" + w + "" + x + "" + y + "" + z);
            } else {
                System.out.println("no solution");
            }
        }
    }
}
