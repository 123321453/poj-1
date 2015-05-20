
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Beer Refrigerator
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 4315		Accepted: 1675		Special Judge
Description

Beer Lovers Club makes regular parties. They hate warm beer, but club’s refrigerator is too small to store enough beer for the whole company. So they decided to order a special super-big beer refrigerator. The new refrigerator should be a parallelepiped a × b × c and store exactly n cubical 1 × 1 × 1 beer boxes (the club has n members). To decrease losses of cold, the total area of the surface of the refrigerator must be as small as possible.

For example, if the capacity of the refrigerator must be 12, the possible variants are:

Dimensions		Surface Area
3 × 2 × 2		32
4 × 3 × 1		38
6 × 2 × 1		40
12 × 1 × 1		50
The best variant in this case is 3 × 2 × 2.

Help the beer lovers to find the optimal dimensions of their new refrigerator.

Input

The input file contains single integer number n (1 ≤ n ≤ 106) — the capacity of the refrigerator. Help the beer lovers to find the optimal dimensions of their new refrigerator.

Output

Output three integer numbers: a, b and c — the optimal dimensions of the refrigerator. If there are several solutions, output any of them.

Sample Input

#1	12
#2	13
#3	1000000
Sample Output

#1	3 2 2
#2	1 13 1
#3	100 100 100
Source

Northeastern Europe 2007, Northern Subregion
 */
public class p3536 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int x1 =1;
            int y1 = 1;
            int z1 = n;
            int x,y,z;
            for(int i = (int)Math.pow(n, 1.0/3)+1; i > 0;i --) {
                if(n%i == 0) {
                    x = i;
                    for(int j = (int)Math.sqrt(n/i) ; j > 0 ; j--) {
                        if((n/i)%j == 0 ) {
                            y = j;
                            z = n/(i*j);
                            if(x1*y1 + x1* z1 + y1*z1 > x*y + x*z + y*z) {
                                x1 = x;
                                y1 = y;
                                z1 = z;
                            }
                        }
                    }
                }
            }
            System.out.println(x1+" "+y1+" "+z1);
        }
    }
}
