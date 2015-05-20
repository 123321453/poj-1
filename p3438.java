
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Look and Say
Time Limit: 5000MS		Memory Limit: 65536K
Total Submissions: 8444		Accepted: 5104
Description

The look and say sequence is defined as follows. Start with any string of digits as the first element in the sequence. Each subsequent element is defined from the previous one by "verbally" describing the previous element. For example, the string 122344111 can be described as "one 1, two 2's, one 3, two 4's, three 1's". Therefore, the element that comes after 122344111 in the sequence is 1122132431. Similarly, the string 101 comes after 1111111111. Notice that it is generally not possible to uniquely identify the previous element of a particular element. For example, a string of 112213243 1's also yields 1122132431 as the next element.
Input

The input consists of a number of cases. The first line gives the number of cases to follow. Each case consists of a line of up to 1000 digits.
Output

For each test case, print the string that follows the given string.
Sample Input

3
122344111
1111111111
12345
Sample Output

1122132431
101
1112131415
Source

Rocky Mountain 2007
 */
public class p3438 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N ; i++) {
            char[] tmp = in.next().toCharArray();
            StringBuffer tab = new StringBuffer();
            int cnt = 0;
            char c = '-';
            boolean flag = false;
            for(int j = 0; j < tmp.length ; j++) {
                if(tmp.length == 1) {
                    flag = true;
                    c = tmp[j];
                    break;
                }
                if(c == '-') {
                    c = tmp[j];
                    cnt++;
                    continue;
                }
                else {
                    if(tmp[j] == c) {
                        cnt++;
                        //continue;
                    }
                    else {
                        tab.append(cnt);
                        tab.append(c);
                        cnt = 1;
                        c = tmp[j];
                    }
                }
                if(j == tmp.length - 1 && tmp[j] == c) {
                    //cnt++;
                    tab.append(cnt);
                    tab.append(c);
                    break;
                }
                
            }
            if(flag)
                System.out.println("1"+c);
            else
                System.out.println(tab);
        }
        
    }
}
