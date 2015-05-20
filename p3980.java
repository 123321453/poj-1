
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
取模运算
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 8177		Accepted: 5014
Description

编写一个C函数mod(int n, int m),实现取模运算%
Input

输入包含多行数据 

每行数据是两个整数a, b (1 <= a, b <= 32767) 
数据以EOF结束
Output

于输入的每一行输出a%b
Sample Input

5 3
100 2
Sample Output

2
0
 */
public class p3980 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a%b);
        }
    }
}
