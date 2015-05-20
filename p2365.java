
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Rope
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 5475		Accepted: 1949
Description

Plotters have barberically hammered N nails into an innocent plane shape, so that one can see now only heads. Moreover, pursuing their mean object, they have hammered all the nails into the vertices of a convex polygon. After that they...it is awful... have roped off the nails, so that the shape felt upset (the rope was very thin). They've done it as it is shown in the figure. 
 
Your task is to find out a length of the rope.
Input

There two numbers in the first line of the standard input: N — a number of nails (1 <= N <= 100), and a real number R — a radius of heads of nails. All the heads have the same radius. Further there are N lines, each of them contains a pair of real coordinates (separated by a space) of centers of nails. An absolute value of the coordinates doesn't exceed 100. The nails are described in a clockwise order starting from an arbitrary nail. Heads of different nails don't adjoin.
Output

The standard output should contain in its only line a real number with two digits precision (after a decimal point) — a length of the rope.
Sample Input

4 1
0.0 0.0
2.0 0.0
2.0 2.0
0.0 2.0
Sample Output

14.28
Source

Ural State University Internal Contest October'2000 Junior Session
 */
public class p2365 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int num = in.nextInt();
        double R = in.nextDouble();
        double[] X = new double[num];
        double[] Y = new double[num];
        int i;
        for(i = 0 ; i < num;i++) {
            X[i] = in.nextDouble();
            Y[i] = in.nextDouble();
        }
        double length = 0.0;
        for(i = 0; i < num ;i++){
            if(i == num-1) {
                length += Math.sqrt(((X[i] - X[0])*(X[i] - X[0]) +(Y[i] - Y[0])*(Y[i] - Y[0])));
            }
            else {
                length += Math.sqrt(((X[i+1] - X[i])*(X[i+1] - X[i]) +(Y[i+1] - Y[i])*(Y[i+1] - Y[i])));
            }
        }
        length += 2*Math.PI*R;
        System.out.printf("%.2f\n",length); 
    }
}
