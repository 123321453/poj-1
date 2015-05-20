
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Numeral System Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 2037	Accepted: 1565 Description
 *
 * Prof. Hachioji has devised a new numeral system of integral numbers with four
 * lowercase letters "m", "c", "x", "i" and with eight digits "2", "3", "4",
 * "5", "6", "7", "8", "9". He doesn't use digit "0" nor digit "1" in this
 * system. * The letters "m", "c", "x" and "i" correspond to 1000, 100, 10 and
 * 1, respectively, and the digits "2", ...,"9" correspond to 2, ..., 9,
 * respectively. This system has nothing to do with the Roman numeral system. *
 * For example, character strings * "5m2c3x4i", "m2c4i" and "5m2c3x" correspond
 * to the integral numbers 5234 (=5*1000+2*100+3*10+4*1), 1204
 * (=1000+2*100+4*1), and 5230 (=5*1000+2*100+3*10), respectively. The parts of
 * strings in the above example, "5m", "2c", "3x" and "4i" represent 5000
 * (=5*1000), 200 (=2*100), 30 (=3*10) and 4 (=4*1), respectively. * Each of the
 * letters "m", "c", "x" and "i" may be prefixed by one of the digits "2", "3",
 * ..., "9". In that case, the prefix digit and the letter are regarded as a
 * pair. A pair that consists of a prefix digit and a letter corresponds to an
 * integer that is equal to the original value of the letter multiplied by the
 * value of the prefix digit. * For each letter "m", "c", "x" and "i", the
 * number of its occurrence in a string is at most one. When it has a prefix
 * digit, it should appear together with the prefix digit. The letters "m", "c",
 * "x" and "i" must appear in this order, from left to right. Moreover, when a
 * digit exists in a string, it should appear as the prefix digit of the
 * following letter. Each letter may be omitted in a string, but the whole
 * string must not be empty. A string made in this manner is called an
 * MCXI-string. * An MCXI-string corresponds to a positive integer that is the
 * sum of the values of the letters and those of the pairs contained in it as
 * mentioned above. The positive integer corresponding to an MCXI-string is
 * called its MCXI-value. Moreover, given an integer from 1 to 9999, there is a
 * unique MCXI-string whose MCXI-value is equal to the given integer. For
 * example, the MCXI-value of an MCXI-string "m2c4i" is 1204 that is equal to
 * 1000 + 2*100 + 4*1. There are no MCXI-strings but "m2c4i" that correspond to
 * 1204. Note that strings "1m2c4i", "mcc4i", "m2c0x4i", and "2cm4i" are not
 * valid MCXI-strings. The reasons are use of "1", multiple occurrences of "c",
 * use of "0", and the wrong order of "c" and "m", respectively. * Your job is
 * to write a program for Prof. Hachioji that reads two MCXI-strings, computes
 * the sum of their MCXI-values, and prints the MCXI-string corresponding to the
 * result. Input
 *
 * The input is as follows. The first line contains a positive integer n (<=
 * 500) that indicates the number of the following lines. The k+1 th line is the
 * specification of the k th computation (k=1, ..., n). * n specification1
 * specification2 ... specificationn * Each specification is described in a
 * line: * MCXI-string1 MCXI-string2 The two MCXI-strings are separated by a
 * space. * You may assume that the sum of the two MCXI-values of the two
 * MCXI-strings in each specification is less than or equal to 9999. Output
 *
 * For each specification, your program should print an MCXI-string in a line.
 * Its MCXI-value should be the sum of the two MCXI-values of the MCXI-strings
 * in the specification. No other characters should appear in the output. Sample
 * Input
 *
 * 10 xi x9i i 9i c2x2i 4c8x8i m2ci 4m7c9x8i 9c9x9i i i 9m9c9x8i m i i m m9i i
 * 9m8c7xi c2x8i Sample Output
 *
 * 3x x 6cx 5m9c9x9i m 9m9c9x9i mi mi mx 9m9c9x9i
 */
public class p2685 {

    static HashMap<Character, Integer> ref = new HashMap();
    static HashMap<Integer, Character> codeC = new HashMap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ref.put('m', 1000);
        ref.put('c', 100);
        ref.put('x', 10);
        ref.put('i', 1);
        for (int i = 0; i < N; i++) {
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            StringBuffer sumB = new StringBuffer();
            int opa = 0;
            int opb = 0;
            for (int j = 0; j < a.length; j++) {
                if (ref.containsKey(a[j])) {
                    if (j != 0) {
                        if (a[j - 1] > '9' || a[j - 1] < '1') {
                            opa += 1 * ref.get(a[j]);
                        } else {
                            opa += Integer.valueOf(new String(a[j - 1] + "")) * ref.get(a[j]);
                        }
                    } else {
                        opa += 1 * ref.get(a[j]);
                    }
                } else {
                    continue;
                }
            }
            for (int j = 0; j < b.length; j++) {
                if (ref.containsKey(b[j])) {
                    if (j != 0) {
                        if (b[j - 1] > '9' || b[j - 1] < '1') {
                            opb += 1 * ref.get(b[j]);
                        } else {
                            opb += Integer.valueOf(new String(b[j - 1] + "")) * ref.get(b[j]);
                        }
                    } else {
                        opb += 1 * ref.get(b[j]);
                    }
                } else {
                    continue;
                }
            }
            // System.out.println(opa+" "+opb);
            int sum = opa + opb;
            int tmp = 0;
            tmp = sum / 1000;
            if (tmp == 1) {
                sumB.append('m');
            } else {
                if (tmp != 0) {
                    sumB.append(tmp);
                    sumB.append('m');
                }

            }
            sum = sum % 1000;
            tmp = sum / 100;
            if (tmp == 1) {
                sumB.append('c');
            } else {
                if (tmp != 0) {
                    sumB.append(tmp);
                    sumB.append('c');
                }

            }
            sum = sum % 100;
            tmp = sum / 10;
            if (tmp == 1) {
                sumB.append('x');
            } else {
                if (tmp != 0) {
                    sumB.append(tmp);
                    sumB.append('x');
                }

            }
            sum = sum % 10;
            tmp = sum;
            if (tmp == 1) {
                sumB.append('i');
            } else {
                if (tmp != 0) {
                    sumB.append(tmp);
                    sumB.append('i');
                }

            }
            System.out.println(sumB);
        }
    }
}
