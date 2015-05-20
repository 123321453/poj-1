
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Billiard Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 1208
 * Accepted: 766 Description
 *
 * In a billiard table with horizontal side a inches and vertical side b inches,
 * a ball is launched from the middle of the table. After s > 0 seconds the ball
 * returns to the point from which it was launched, after having made m bounces
 * off the vertical sides and n bounces off the horizontal sides of the table.
 * Find the launching angle A (measured from the horizontal), which will be
 * between 0 and 90 degrees inclusive, and the initial velocity of the ball.
 * Assume that the collisions with a side are elastic (no energy loss), and thus
 * the velocity component of the ball parallel to each side remains unchanged.
 * Also, assume the ball has a radius of zero. Remember that, unlike pool
 * tables, billiard tables have no pockets. Input
 *
 * Input consists of a sequence of lines, each containing five nonnegative
 * integers separated by whitespace. The five numbers are: a, b, s, m, and n,
 * respectively. All numbers are positive integers not greater than 10000. Input
 * is terminated by a line containing five zeroes. Output
 *
 * For each input line except the last, output a line containing two real
 * numbers (accurate to two decimal places) separated by a single space. The
 * first number is the measure of the angle A in degrees and the second is the
 * velocity of the ball measured in inches per second, according to the
 * description above. Sample Input
 *
 * 100 100 1 1 1 200 100 5 3 4 201 132 48 1900 156 0 0 0 0 0 Sample Output
 *
 * 45.00 141.42 33.69 144.22 3.09 7967.81
 * 
* equation: a*m = vcos0s b*n = vsin0s
 */
public class p2641 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().split("\\s+");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int s = Integer.parseInt(arr[2]);
            int m = Integer.parseInt(arr[3]);
            int n = Integer.parseInt(arr[4]);
            if ((a | b | s | m | n) == 0) {
                break;
            }
            double x = b * n;
            double y = a * m;
            System.out.printf("%.2f %.2f\n", Math.atan2(x, y) / Math.acos(-1) * 180, Math.sqrt(x * x + y * y) / s);
        }
    }
}
