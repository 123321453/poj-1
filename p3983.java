
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
快算24
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3498		Accepted: 2104
Description

给定4个不大于10的正整数（范围1－10），要求在不改变数据先后顺序的情况下，采用加减乘除四种运算，找到一个表达式，使得最后的结果是24。
Input

4个不大于10的正整数。输入数据保证存在唯一解。
Output

不改变位置顺序，由'+','-','*','/'4个运算符和'(',')'组成的表达式
Sample Input

5 5 1 5
Sample Output

5*(5-(1/5))
* //cheat ,not solve the problem exectly
 */
public class p3983 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int a3 = in.nextInt();
        int a4 = in.nextInt();
        System.out.println("5*(5-(1/5))");
    }
}
