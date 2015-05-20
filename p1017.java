
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Packets
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 37872		Accepted: 12619
Description

A factory produces products packed in square packets of the same height h and of the sizes 1*1, 2*2, 3*3, 4*4, 5*5, 6*6. These products are always delivered to customers in the square parcels of the same height h as the products have and of the size 6*6. Because of the expenses it is the interest of the factory as well as of the customer to minimize the number of parcels necessary to deliver the ordered products from the factory to the customer. A good program solving the problem of finding the minimal number of parcels necessary to deliver the given products according to an order would save a lot of money. You are asked to make such a program.
Input

The input file consists of several lines specifying orders. Each line specifies one order. Orders are described by six integers separated by one space representing successively the number of packets of individual size from the smallest size 1*1 to the biggest size 6*6. The end of the input file is indicated by the line containing six zeros.
Output

The output file contains one line for each line in the input file. This line contains the minimal number of parcels into which the order from the corresponding line of the input file can be packed. There is no line in the output file corresponding to the last ``null'' line of the input file.
Sample Input

0 0 4 0 0 1 
7 5 1 0 0 0 
0 0 0 0 0 0 
Sample Output

2 
1 
Source

Central Europe 1996
 */
public class p1017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int e = in.nextInt();
            int f = in.nextInt();
            if(a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f== 0)
                break;
            int tot = a + b * 4 + c * 9 + d * 16 + e * 25 + f * 36;
            int result = 0;
            int remain = tot;
            result += remain/36;
            remain = remain%36;
            result += remain/25;
            remain = remain % 25;
            result += remain / 16;
            remain = remain % 16;
            result += remain / 9;
            remain = remain % 9;
            result += remain / 4;
            remain = remain % 4;
            result += remain / 1;
            remain = remain % 1;
            System.out.println(result);
        }
    }
}
