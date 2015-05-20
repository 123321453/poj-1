
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Binary Clock Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 446
 * Accepted: 309 Description
 *
 * A binary clock is a clock which displays traditional sexagesimal time
 * (military format) in a binary format. The most common binary clock uses three
 * columns or three rows of LEDs to represent zeros and ones. Each column (or
 * row) represents a time-unit value.  *
 * When three columns are used (vertically), the bottom row in each column
 * represents 1 (or 20), with each row above representing higher powers of two,
 * up to 25 (or 32). To read each individual unit (hours, minutes or seconds) in
 * the time, the user adds the values that each illuminated LED represents, and
 * then reads the time from left to right. The first column represents the hour,
 * the next column represents the minute, and the last column represents the
 * second.  *
 * When three rows are used (horizontally), the right column in each row
 * represents 1 (or 20), with each column left representing higher powers of
 * two, up to 25 (or 32). To read each individual unit (hours, minutes or
 * seconds) in the time, the user adds the values that each illuminated LED
 * represents, and then reads the time from top to bottom. The top row
 * represents the hour, the next row represents the minute, and the bottom row
 * represents the second.  *
 * For example:  *
 *
 *
 *
 * For this problem you will r ead a time in sexagesimal time format, and output
 * both the vertical and horizontal binary clock values. The output will be
 * formed by concatenating together the bits in each column (or row) to form two
 * 18 character strings of 1’s and 0’s as shown below.  *
 * 10:37:49 would be written vertically as 011001100010100011 and horizontally
 * as 001010100101110001. Input
 *
 * The first line of input contains a single integer N, (1 <= N <= 1000) which
 * is the number of data sets that follow. Each data set consists of a single
 * line of input containing the time in sexagesimal format. Output
 *
 * For each data set, you should generate one line of output with the following
 * values: The data set number as a decimal integer (start counting at one), a
 * space, the binary time in vertical format (18 binary digits), a space and the
 * binary time in horizontal format (18 binary digits). Sample Input
 *
 * 2
 * 10:37:49 00:00:01 Sample Output
 *
 * 1 011001100010100011 001010100101110001 2 000000000000000001
 * 000000000000000001 Source
 *
 * Greater New York Regional 2008
 */
public class p3789 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 1; i <= N; i++) {
            String[] tab = in.next().split(":");
            int hr = Integer.valueOf(tab[0]);
            int mn = Integer.valueOf(tab[1]);
            int se = Integer.valueOf(tab[2]);
            // System.out.println(hr+" "+mn+" "+se);
            //System.out.println(se+" "+Integer.toBinaryString(se));
            String h1l = Integer.toBinaryString(hr);
            String m1l = Integer.toBinaryString(mn);
            String s1l = Integer.toBinaryString(se);
            StringBuffer h1t = new StringBuffer(h1l);
            StringBuffer m1t = new StringBuffer(m1l);
            StringBuffer s1t = new StringBuffer(s1l);
            for(int j = h1l.length(); j < 6; j++) {
                h1t.insert(0, '0');
            }
            for (int j = m1l.length(); j < 6; j++) {
                m1t.insert(0, '0');
            }
            for (int j = s1l.length(); j < 6; j++) {
                s1t.insert(0, '0');
            }
            char[] h1 = h1t.toString().toCharArray();
            //System.out.println(h1.length);
            //System.out.println(Integer.toBinaryString(hr));
            char[] m1 = m1t.toString().toCharArray();
            char[] s1 = s1t.toString().toCharArray();
            //System.out.println(s1.length);
            StringBuffer ver = new StringBuffer();
            StringBuffer hor = new StringBuffer();
            //System.out.println("test1: "+Integer.toBinaryString(hr)+" "+Integer.toBinaryString(mn)+" "+Integer.toBinaryString(se));
            for (int j = 0; j <=5 ; j++) {
                ver.append(h1[j]);
                ver.append(m1[j]);
                ver.append(s1[j]);
            }
            for (int j = 0; j <=5 ; j++) {
                hor.append(h1[j]);
            }
            for (int j = 0; j <=5 ; j++) {
                //ver.append(h1[j]);
                hor.append(m1[j]);
               // ver.append(s1[j]);
            }
            for (int j = 0; j <=5 ; j++) {
              //  ver.append(h1[j]);
             //   ver.append(m1[j]);
                hor.append(s1[j]);
            }
            System.out.println(i+" "+ver+" "+hor);
        }
    }
}
