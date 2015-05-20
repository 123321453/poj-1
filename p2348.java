
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Euclid's Game Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 6395
 * Accepted: 2608 Description
 *
 * Two players, Stan and Ollie, play, starting with two natural numbers. Stan,
 * the first player, subtracts any positive multiple of the lesser of the two
 * numbers from the greater of the two numbers, provided that the resulting
 * number must be nonnegative. Then Ollie, the second player, does the same with
 * the two resulting numbers, then Stan, etc., alternately, until one player is
 * able to subtract a multiple of the lesser number from the greater to reach 0,
 * and thereby wins. For example, the players may start with (25,7): 25 7
 *
 * 11 7
 *
 * 4 7
 *
 * 4 3
 *
 * 1 3
 *
 * 1 0
 *
 * an Stan wins. Input
 *
 * The input consists of a number of lines. Each line contains two positive
 * integers giving the starting two numbers of the game. Stan always starts.
 * Output
 *
 * For each line of input, output one line saying either Stan wins or Ollie wins
 * assuming that both of them play perfectly. The last line of input contains
 * two zeroes and should not be processed. Sample Input
 *
 * 34 12 15 24 0 0 Sample Output
 *
 * Stan wins Ollie wins
 */
public class p2348 {
    public static boolean judge(int x,int y){
        int t;
        if(x == y)
            return true;
        if(x < y) {
            t = x;
            x = y;
            y = t;
        }
        if((x - y) < y)
            return !judge(y, (x-y));
        else 
            return true;
        
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x,y;
        String[] arr;
        while(in.hasNext()) {
            arr = in.nextLine().split("\\s+");
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            if((x | y) == 0)
                break;
            if(judge(x,y))
                System.out.println("Stan wins");
            else
                System.out.println("Ollie wins");
        }
    }
}