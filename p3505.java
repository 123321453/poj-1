
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Tower Parking Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 1473
 * Accepted: 918 Description
 *
 * There is a new revolution in the parking lot business: the parking tower. The
 * concept is simple: you drive your car into the elevator at the entrance of
 * the tower, and the elevator and conveyor belts drag the car to an empty
 * parking spot, where the car remains until you pick it up. When you return,
 * the elevator and conveyor belts move your car back to the entrance and you’re
 * done.
 *
 * The layout of the tower is simple. There is one central elevator that
 * transports the cars between the different floors. On each floor there is one
 * giant circular conveyor belt on which the cars stand. This belt can move in
 * clockwise and counterclockwise direction. When the elevator arrives on a
 * floor, it becomes part of the belt so that cars can move through it.
 *
 * At the end of the day the tower is usually packed with cars and a lot of
 * people come to pick them up. Customers are processed in a first come first
 * serve order: the elevator is moved to the floor of the first car, the
 * conveyor belt moves the car on the elevator, the elevator is moved down
 * again, and so on. We like to know how long it takes before the last customer
 * gets his car. Moving the elevator one floor up- or downwards takes 10 seconds
 * and moving a conveyor belt one car in either direction takes 5 seconds.
 *
 * Input
 *
 * On the first line one positive number: the number of testcases, at most 100.
 * After that per testcase:
 *
 * One line with two integers h and l with 1 ≤ h ≤ 50 and 2 ≤ l ≤ 50: the height
 * of the parking tower and the length of the conveyor belts.
 *
 * h lines with l integers: the initial placement of the cars. The jth number on
 * the ith line describes the jth position on the ith floor. This number is −1
 * if the position is empty, and r if the position is occupied by the rth car to
 * pick up. The positive numbers form a consecutive sequence from 1 to the
 * number of cars. The entrance is on the first floor and the elevator (which is
 * initially empty) is in the first position. There is at least one car in the
 * parking tower.
 *
 * Output
 *
 * Per testcase:
 *
 * One line with the number of seconds before the last customer is served.
 * Sample Input
 *
 * 2
 * 1 5
 * -1 2 1 -1 3 3 6 -1 5 6 -1 -1 3 -1 -1 7 -1 2 9 -1 10 4 1 8 -1 Sample Output
 *
 * 25 320 Source
 *
 * Northwestern Europe 2007
 */
public class p3505 {

    private static int[][] tab;

    public static int shift(int o, int l, int loc) {
        int flag = 0;
        int i;
       // System.out.println("l: "+l);
        for (i = 1; i < l; i++) {
            if (tab[o][i] == loc) {
                flag = i;
                break;
            }
        }
        //System.out.println("loc: "+loc);
        //System.out.println("flag: "+flag);
        int[] tmp = new int[l + 2];
        int cnt = 1;
        if (flag - 1 <= (l - flag + 1)) {
            /*
            for (i = 1; i <= l; i++) {
                int ln = (flag + i - 1) % 6;
                tmp[cnt++] = tab[o][ln];
            }
            */
            
            for(int k = flag; cnt <= l; k++) {
                tmp[cnt++] = tab[o][k];
                if(k > l) k = 1;
            }
       
            for (int t = 1; t <= l; t++) {
                tab[o][t] = tmp[t];
            }

            return flag - 1;
        } else {
            /*
            for (i = 1; i <= l; i++) {
                int ln = (flag + i - 1) % 6;
                tmp[cnt++] = tab[o][ln];
            }
            */
            
            for(int k = flag; cnt <= l; k++) {
                tmp[cnt++] = tab[o][k];
                if(k > l) k = 1;
            }
          
            for (int t = 1; t <= l; t++) {
                tab[o][t] = tmp[t];
            }
            return l - flag + 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int h = in.nextInt();
            int l = in.nextInt();
            tab = new int[h + 2][l + 2];
            int nullC = 0;
            int j, k;
            for (j = 1; j <= h; j++) {
                for (k = 1; k <= l; k++) {
                    tab[j][k] = in.nextInt();
                    if (tab[j][k] == -1) {
                        nullC++;
                    }
                }
            }
            int sum = 0;
            for (int op = 1; op <= h * l - nullC; op++) {
                for (j = 1; j <= h; j++) {
                    for (k = 1; k <= l; k++) {
                       // System.out.println("any?");
                        if (tab[j][k] == op) {
                            int tmp = shift(j, l, op);
                            //System.out.println("tmp: " + tmp);
                            sum += tmp * 5 + (j - 1) * 20;
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
