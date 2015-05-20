
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Filling Out the Team
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 8969		Accepted: 4993
Description

Over the years, the people of the great city of Pittsburgh have repeatedly demonstrated a collective expertise at football second to none. Recently a spy has discovered the true source of the city's football power-a wizard known only as "Myron," who is infallible at selecting the proper position at which each player will excel. 

Now that you know the source of Pittsburgh's wisdom, you are determined to provide your school's football team with a computer program that matches the wisdom of "Myron." You have consulted with the best football minds you can find, and they have dispensed their wisdom on the slowest speed, minimum weight, and minimum strength required to play each position. 


Using this knowledge, you will develop a program that reads in several players physical attributes and outputs what position(s) they are able to play.
Input

Each line of the input file will list the attributes for one player: 
< speed > < weight > < strength > 
Each number will be a real-valued number. The file will end with a line reading "0 0 0"
Output

For each player, you will output one line listing the positions that player can play. A player can play a position if each of their attributes is greater or equal to the minimum for weight and strength, and less than or equal to the slowest speed. If a player can play multiple positions, output them in the order listed above, separated by whitespace. You may leave an extra space at the end of the line. If a player can play no positions, write "No positions" on the line.
Sample Input

4.4 180 200
5.5 350 700
4.4 205 350
5.2 210 500
0 0 0
Sample Output

Wide Receiver
Lineman
Wide Receiver Quarterback
No positions
Source

Mid-Atlantic 2004
 */
public class p2070 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        double[] speed = new double[3];
        int[] weight =  new int[3];
        int[] strength = new int[3];
        String[] name =  new String[3];
        speed[0] = 4.5;
        speed[1] = 6.0;
        speed[2] = 5.0;
        weight[0] = 150;
        weight[1] = 300;
        weight[2] = 200;
        strength[0] = 200;
        strength[1] = 500;
        strength[2] = 300;
        name[0] = "Wide Receiver";
        name[1] = "Lineman";
        name[2] = "Quarterback";
        while(in.hasNext()) {
            double sp = in.nextDouble();
            int w = in.nextInt();
            int st = in.nextInt();
            if((int)sp == 0 & w == 0 && st == 0)
                break;
            boolean flag = true;
            for(int i = 0; i < 3; i++) {
                if(sp <= speed[i] && w >= weight[i] && st >= strength[i]) {
                    flag = false;
                    System.out.print(name[i]+" ");
                }
            }
            if(flag) {
                System.out.println("No positions");
            }
            else {
                System.out.println();
            }
        }
            
        
    }
}
