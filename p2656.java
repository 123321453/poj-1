
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Unhappy Jinjin
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 9571		Accepted: 7034
Description

Jinjin is a junior school student. Besides the classes in school, Jinjin's mother also arranges some supplementary classes for her. However, if Jinjin studies for more than eight hours a day, she will be unhappy on that day. On any day she gets unhappy, the more time she studies, the unhappier she will be. Now we got Jinjin's class schedule for the next several days and your task is to find out whether she will be unhappy on these days; if she will be unhappy, on which day she will be the unhappiest.
Input

There may be several test cases. In the first line of each test case, there is an integer N (1 <= N <= 7), which represents the number of days you should analyze. Then there comes N lines, each contains two non-negative integers (each smaller than 10). The first integer represents how many hours Jinjin studies at school on the day, and the second represents how many hours she studies in the supplementary classes on the same day. 

A case with N = 0 indicates the end of the input, and this case should not be processed.
Output

For each test case, output a line contains a single integer. If Jinjin will always be happy, the integer should be 0; otherwise, the integer should be a positive integer K, which means that Jinjin will be the unhappiest on the K-th day. If the unhappiest day is not unique, just output the earliest one among these unhappiest days.
Sample Input

7
5 3
6 2
7 2
5 3
5 4
0 4
0 6
1
4 4
0
Sample Output

3
0
 */
public class p2656 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            if(n == 0)
                break;
            int maxDay = -1;
            int maxH = -1;
            String[] arr;
            int a,b;
            for(int i = 1; i<= n; i++) {
                arr = in.nextLine().split("\\s+");
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[1]);
                if((a + b) > 8) {
                    if(a+b > maxH){
                        maxH =a+b;
                        maxDay = i;
                    }
                }
            }
            if(maxH > 8)
                System.out.println(maxDay);
            else
                System.out.println("0");
        }
    }
}
