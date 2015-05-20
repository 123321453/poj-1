
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
字符串替换
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 7519		Accepted: 3566
Description

编写一个C程序实现将字符串中的所有"you"替换成"we"
Input

输入包含多行数据 

每行数据是一个字符串，长度不超过1000 
数据以EOF结束
Output

对于输入的每一行，输出替换后的字符串
Sample Input

you are what you do
Sample Output

we are what we do
 */
public class p3981 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String tmp = in.nextLine();
            String out = tmp.replace("you", "we");
            System.out.println(out);
        }
    }
}
