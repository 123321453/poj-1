
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Dog & Gopher
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 3967		Accepted: 1672
Description

A large field has a dog and a gopher. The dog wants to eat the gopher, while the gopher wants to run to safety through one of several gopher holes dug in the surface of the field. 
Neither the dog nor the gopher is a math major; however, neither is entirely stupid. The gopher decides on a particular gopher hole and heads for that hole in a straight line at a fixed speed. The dog, which is very good at reading body language, anticipates which hole the gopher has chosen, and heads at double the speed of the gopher to the hole, where it intends to gobble up the gopher. If the dog reaches the hole first, the gopher gets gobbled; otherwise, the gopher escapes. 

You have been retained by the gopher to select a hole through which it can escape, if such a hole exists. 
Input

The first line of input contains four floating point numbers: the (x,y) coordinates of the gopher followed by the (x,y) coordinates of the dog. Subsequent lines of input each contain two floating point numbers: the (x,y) coordinates of a gopher hole. All distances are in metres, to the nearest mm.
Output

Your output should consist of a single line. If the gopher can escape the line should read "The gopher can escape through the hole at (x,y)." identifying the appropriate hole to the nearest mm. Otherwise the output line should read "The gopher cannot escape." If the gopher may escape through more than one hole, choose the first one in the input. If the gopher and dog reach the hole at the same time, the gopher gets gobbled. There are not more than 1000 gopher holes and all coordinates are between -10000 and +10000.
Sample Input

1.000 1.000 2.000 2.000
1.500 1.500
Sample Output

The gopher cannot escape.
Hint

Sample Input 2 
2.000 2.000 1.000 1.000 
1.500 1.500 
2.500 2.500 

Output for Sample Input 2 
The gopher can escape through the hole at (2.500,2.500). 

Source

Waterloo local 1999.09.25
 */
public class p2610 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double xt = 0.0;
        double yt = 0.0;
        boolean flag = false;
        while(in.hasNext() && ! flag) {
            xt = in.nextDouble();
            yt = in.nextDouble();
            double d1 = Math.sqrt((Math.pow((xt-x1), 2))+(Math.pow((yt-y1), 2)));
            double d2 = Math.sqrt((Math.pow((xt-x2), 2))+(Math.pow((yt-y2), 2)));
            if(d1*2 < d2) {
                flag = true;
                break;
            }
            else {
                continue;
            }
        }
        if(flag) {
            System.out.printf("The gopher can escape through the hole at (%.3f,%.3f).\n",xt,yt);
        } 
        else {
            System.out.println("The gopher cannot escape.");
        
        }
    }
}
