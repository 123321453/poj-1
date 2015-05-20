
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
The Circumference of the Circle
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 6350		Accepted: 4015
Description

To calculate the circumference of a circle seems to be an easy task - provided you know its diameter. But what if you don't? 

You are given the cartesian coordinates of three non-collinear points in the plane. 
Your job is to calculate the circumference of the unique circle that intersects all three points. 
Input

The input will contain one or more test cases. Each test case consists of one line containing six real numbers x1,y1, x2,y2,x3,y3, representing the coordinates of the three points. The diameter of the circle determined by the three points will never exceed a million. Input is terminated by end of file.
Output

For each test case, print one line containing one real number telling the circumference of the circle determined by the three points. The circumference is to be printed accurately rounded to two decimals. The value of pi is approximately 3.141592653589793.
Sample Input

0.0 -0.5 0.5 0.0 0.0 0.5
0.0 0.0 0.0 1.0 1.0 1.0
5.0 5.0 5.0 7.0 4.0 6.0
0.0 0.0 -1.0 7.0 7.0 7.0
50.0 50.0 50.0 70.0 40.0 60.0
0.0 0.0 10.0 0.0 20.0 1.0
0.0 -500000.0 500000.0 0.0 0.0 500000.0
Sample Output

3.14
4.44
6.28
31.42
62.83
632.24
3141592.65
Source

Ulm Local 1996
 */
public class p2242 {

//public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        double[] x, y;
        double k1, k2, b1, b2, ox, oy;
        double r;
        while (scanner.hasNext()) {
            x = new double[3];
            y = new double[3];
            for (int i = 0; i < 3; i++) {
                x[i] = scanner.nextDouble();
                y[i] = scanner.nextDouble();
            }
            if (y[0] == y[1]) {
                double t = y[0];
                y[0] = y[2];
                y[2] = t;
                t = x[0];
                x[0] = x[2];
                x[2] = t;
            }
            if (y[0] == y[2]) {
                double t = y[0];
                y[0] = y[1];
                y[1] = t;
                t = x[0];
                x[0] = x[1];
                x[1] = t;
            }
            k1 = 0 - (x[0] - x[1]) / (y[0] - y[1]);
            b1 = (y[0] + y[1]) / 2 - k1 * (x[0] + x[1]) / 2;
            k2 = 0 - (x[0] - x[2]) / (y[0] - y[2]);
            b2 = (y[0] + y[2]) / 2 - k2 * (x[0] + x[2]) / 2;
            ox = (b2 - b1) / (k1 - k2);
            oy = k1 * ox + b1;
            r = Math.sqrt((ox - x[0]) * (ox - x[0]) + (oy - y[0]) * (oy - y[0]));
            System.out.println(Math.round(2 * 3.141592653589793 * r * 100.0) / 100.0);
        }
    }
//}
}
