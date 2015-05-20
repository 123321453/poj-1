
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
All in All
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 24284		Accepted: 9738
Description

You have devised a new encryption technique which encodes a message by inserting between its characters randomly generated strings in a clever way. Because of pending patent issues we will not discuss in detail how the strings are generated and inserted into the original message. To validate your method, however, it is necessary to write a program that checks if the message is really encoded in the final string. 

Given two strings s and t, you have to decide whether s is a subsequence of t, i.e. if you can remove characters from t such that the concatenation of the remaining characters is s. 
Input

The input contains several testcases. Each is specified by two strings s, t of alphanumeric ASCII characters separated by whitespace.The length of s and t will no more than 100000.
Output

For each test case output "Yes", if s is a subsequence of t,otherwise output "No".
Sample Input

sequence subsequence
person compression
VERDI vivaVittorioEmanueleReDiItalia
caseDoesMatter CaseDoesMatter
Sample Output

Yes
No
Yes
No
Source

Ulm Local 2002
 */
public class p1936 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.next();
            String t = in.next();
            char[] sTab = s.toCharArray();
            char[] tTab = t.toCharArray();
            boolean flag = true;
            int jTmp = 0;
            for(int i = 0; i < sTab.length; i++) {
                for(int j = jTmp; j < tTab.length; j++) {
                    if(tTab[j] == sTab[i]) {
                        jTmp = j+1;
                        break;
                    }   
                    else {
                        if(j == tTab.length-1) {
                            flag = false;
                            break;
                        }
                        else {
                            continue;
                        }                       
                       // flag = false;
                       // break;
                    }
                }
                if(!flag)
                    break;
            }
            if(flag) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}
