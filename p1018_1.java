
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Communication System
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 19931		Accepted: 7080
Description

We have received an order from Pizoor Communications Inc. for a special communication system. The system consists of several devices. For each device, we are free to choose from several manufacturers. Same devices from two manufacturers differ in their maximum bandwidths and prices. 
By overall bandwidth (B) we mean the minimum of the bandwidths of the chosen devices in the communication system and the total price (P) is the sum of the prices of all chosen devices. Our goal is to choose a manufacturer for each device to maximize B/P. 
Input

The first line of the input file contains a single integer t (1 ≤ t ≤ 10), the number of test cases, followed by the input data for each test case. Each test case starts with a line containing a single integer n (1 ≤ n ≤ 100), the number of devices in the communication system, followed by n lines in the following format: the i-th line (1 ≤ i ≤ n) starts with mi (1 ≤ mi ≤ 100), the number of manufacturers for the i-th device, followed by mi pairs of positive integers in the same line, each indicating the bandwidth and the price of the device respectively, corresponding to a manufacturer.
Output

Your program should produce a single line for each test case containing a single number which is the maximum possible B/P for the test case. Round the numbers in the output to 3 digits after decimal point. 
Sample Input

1 3
3 100 25 150 35 80 25
2 120 80 155 40
2 100 100 120 110
Sample Output

0.649
Source

Tehran 2002, First Iran Nationwide Internet Programming Contest
 */
public class p1018_1 {

    class node {
       // node[] child;
        public node() {
            
        }
        int b;
        int p;
    }
    public static class Comp implements Comparator<node> {

        @Override
        public int compare(node arg0, node arg1) {
            if(arg0.b > arg1.b)
                return 1;
            else if (arg0.b == arg1.b) {
                if(arg0.p < arg1.p)
                    return 1;
                else if(arg0.p == arg1.p)
                    return 0;
                else
                    return -1;
                            
            }
            else {
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0 ; i < t ; i++) {
            Comp c = new Comp();
            int n = in.nextInt();
           // int[] minB = new int[n];
           // for(int j = 0; j < n; j++)
             //   minB[j] = Integer.MAX_VALUE;
            int[] num = new int[n];
            int max = Integer.MIN_VALUE;
            node[][] tab = new node[n][];
            for(int j = 0; j < n ; j++) {
                num[j] = in.nextInt();
              //  tab[j].child = new node[num[j]];
                tab[j] = new node[num[j]]; 
                
                for(int k = 0; k < num[j]; k++) {
                   //System.out.println(tab[j][k]);
                  //  tab[j].child[k].b = in.nextInt();
                   // tab[j].child[k].p = in.nextInt();
                   tab[j][k] = new node();
                  //  tab[j][k].b = new int();
                    
                    tab[j][k].b = in.nextInt();
                    tab[j][k].p = in.nextInt();
                //    if(minB[j] > tab[j].child[k].b)
                  //      minB[j] = tab[j].child[k].b;
                } 
                Arrays.sort(tab[j],c);
            }
            int cnt = 0;
            for(int j = 1; j < n ; j++)
                cnt += num[j];
            int[] result = new int[num[0]];
            
            for(int j = 0; j < num[0] ; j++)
                result[j] = tab[0][j].p;
               // result[j] = tab[0].child[j].p;
            for(int j = 0; j < num[0] ; j++) {
               // int b0 = tab[0].child[j].b;
               // int p0 = tab[0].child[j].p;
                int b0 = tab[0][j].b;
                int p0 = tab[0][j].p;
                for(int k = 1; k < n; k++) {
                    int tmp = Integer.MAX_VALUE;
                    int mark = 0;
                    for(int p = 0; p < num[k]; p++) {
                        //int b1 = tab[k].child[p].b;
                        //int p1 = tab[k].child[p].p;
                        int b1 = tab[k][j].b;
                        int p1 = tab[k][j].p;
                        if(b1 < b0)
                            continue;
                        else {
                            if(p0+p1 < tmp) {
                                tmp = p0+p1;
                                mark = p1;
                            }
                        }
                    }
                    result[j] += mark;
                }
                if(max < b0/result[j])
                    max = b0/result[j];
            }
            System.out.printf("%.3f\n",max);
            
            
        }
    }
}
