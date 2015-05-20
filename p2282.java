
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Counting Problem
Time Limit: 3000MS		Memory Limit: 65536K
Total Submissions: 2970		Accepted: 1581
Description

Given two integers a and b, we write the numbers between a and b, inclusive, in a list. Your task is to calculate the number of occurrences of each digit. For example, if a = 1024 and b = 1032, the list will be 
1024 1025 1026 1027 1028 1029 1030 1031 1032

there are ten 0's in the list, ten 1's, seven 2's, three 3's, and etc.
Input

The input consists of up to 500 lines. Each line contains two numbers a and b where 0 < a, b < 100000000. The input is terminated by a line `0 0', which is not considered as part of the input.
Output

For each pair of input, output a line containing ten numbers separated by single spaces. The first number is the number of occurrences of the digit 0, the second is the number of occurrences of the digit 1, etc.
Sample Input

1 10
44 497
346 542
1199 1748
1496 1403
1004 503
1714 190
1317 854
1976 494
1001 1960
0 0
Sample Output

1 2 1 1 1 1 1 1 1 1
85 185 185 185 190 96 96 96 95 93
40 40 40 93 136 82 40 40 40 40
115 666 215 215 214 205 205 154 105 106
16 113 19 20 114 20 20 19 19 16
107 105 100 101 101 197 200 200 200 200
413 1133 503 503 503 502 502 417 402 412
196 512 186 104 87 93 97 97 142 196
398 1375 398 398 405 499 499 495 488 471
294 1256 296 296 296 296 287 286 286 247
Source

Shanghai 2004
 */
public class p2282 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == 0 && b == 0)
                break;
            int t1 = 0;
            if(a > b) {
                t1 = a;
                a = b;
                b = t1;
            }
            int[] tab = new int[10];
            for(int i = a; i <= b; i++) {
                char[] tmp = String.valueOf(i).toCharArray();
                
                for(int j = 0; j < tmp.length; j++) {
                    //System.out.println("test: "+tmp[j]);
                    if (tmp[j] == '0') {
                        tab[0]++;
                    }
                    if (tmp[j] == '1') {
                        tab[1]++;
                    }
                    if (tmp[j] == '2') {
                        tab[2]++;
                    }
                    if (tmp[j] == '3') {
                        tab[3]++;
                    }
                    if (tmp[j] == '4') {
                        tab[4]++;
                    }
                    if (tmp[j] == '5') {
                        tab[5]++;
                    }
                    if (tmp[j] == '6') {
                        tab[6]++;
                    }
                    if (tmp[j] == '7') {
                        tab[7]++;
                    }
                    if (tmp[j] == '8') {
                        tab[8]++;
                    }
                    if (tmp[j] == '9') {
                        tab[9]++;
                    }
                }
            }
            for(int i = 0; i <= 9; i++) {
                System.out.print(tab[i]+" ");
            }
            System.out.println();
        }
    }
}
