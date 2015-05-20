
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
小孩报数问题
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 7950		Accepted: 3747
Description

有N个小孩围成一圈，给他们从1开始依次编号，现指定从第W个开始报数，报到第S个时，该小孩出列，然后从下一个小孩开始报数，仍是报到S个出列，如此重复下去，直到所有的小孩都出列（总人数不足S个时将循环报数），求小孩出列的顺序。
Input

第一行输入小孩的人数N（N<=64） 
接下来每行输入一个小孩的名字(人名不超过15个字符) 
最后一行输入W,S (W < N)，用逗号","间隔
Output

按人名输出小孩按顺序出列的顺序，每行输出一个人名
Sample Input

5
Xiaoming
Xiaohua
Xiaowang
Zhangsan
Lisi
2,3
Sample Output

Zhangsan
Xiaohua
Xiaoming
Xiaowang
Lisi
Source
 */
public class p3750 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        //String[] tab = new String[N];
        ArrayList<String> tab = new ArrayList();
        for(int i = 0; i < N ; i++) {
            tab.add(in.next());
        }
        String[] tmp = in.next().split(",");
        int W = Integer.valueOf(tmp[0])-1;
        int S = Integer.valueOf(tmp[1]);
        int start = W;
        while(!tab.isEmpty()) {
            start = (start+S-1)%tab.size();
            String tmp1 = tab.remove(start);
            System.out.println(tmp1);
        }
    }
}
