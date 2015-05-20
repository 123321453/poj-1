
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Subsequence Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 7709
 * Accepted: 4439 Description
 *
 * Given a string s of length n, a subsequence of it, is defined as another
 * string s' = su1su2...sum where 1 ≤ u1 < u2 < ... < um ≤ n and si is the ith
 * character of s. Your task is to write a program that, given two strings s1
 * and s2, checks whether either s2 or its reverse is a subsequence of s1 or
 * not.
 *
 * Input
 *
 * The first line of input contains an integer T, which is the number of test
 * cases. Each of the next T lines contains two non-empty strings s1 and s2
 * (with length at most 100) consisted of only alpha-numeric characters and
 * separated from each other by a single space.
 *
 * Output
 *
 * For each test case, your program must output "YES", in a single line, if
 * either s2 or its reverse is a subsequence of s1. Otherwise your program
 * should write "NO".
 *
 * Sample Input
 *
 * 5
 * arash aah arash hsr kick kkc A a a12340b b31 Sample Output
 *
 * YES YES NO NO YES Source
 *
 * Amirkabir University of Technology Local Contest 2006
 */
public class p3302 {
    public static char[] reverS(String tmp) {
        char[] t1 = tmp.toCharArray();
        char[] t2 = new char[t1.length];
        int i,j;
        for(i = t1.length-1, j = 0; i >= 0;i--,j++) {
            t2[j] = t1[i];
        }
        return t2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int k = 0; k < N; k++) {
            String t = in.next();
            String s = in.next();
            
            char[] sTab = s.toCharArray();
            char[] tTab = t.toCharArray();
            boolean flag1 = true;
            boolean flag2 = true;
            char[] rsTab = reverS(s);
            //System.out.println("test2: "+new String(rsTab));
            int jTmp = 0;
            for (int i = 0; i < sTab.length; i++) {
                for (int j = jTmp; j < tTab.length; j++) {
                  //  System.out.println("test1: "+jTmp);
                    if (tTab[j] == sTab[i]) {
                        jTmp = j + 1;
                        break;
                    } else {
                        if (j == tTab.length - 1) {
                            flag1 = false;
                            break;
                        } else {
                            continue;
                        }
                        // flag = false;
                        // break;
                    }
                }
                if(i != (sTab.length-1) && jTmp == tTab.length)
                    flag1 = false;
                if (!flag1) {
                    break;
                }
            }
            jTmp = 0;
            for (int i = 0; i < rsTab.length; i++) {
                for (int j = jTmp; j < tTab.length; j++) {
                   // System.out.println("test2: "+jTmp);
                    if (tTab[j] == rsTab[i]) {
                        jTmp = j + 1;
                        break;
                    } else {
                     //   System.out.println("enter: "+i+" "+j +" "+tTab.length);
                        if (j == tTab.length - 1) {
                            flag2 = false;
                            break;
                        } else {
                            continue;
                        }
                        // flag = false;
                        // break;
                    }
                }
                if(i != (rsTab.length-1) && jTmp == tTab.length)
                    flag2 = false;
                if (!flag2) {
                    break;
                }
            }
          //  System.out.println(flag1+" "+flag2);
            if (flag1 || flag2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
