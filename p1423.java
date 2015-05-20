
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Big Number Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 22417
 * Accepted: 7162 Description
 *
 * In many applications very large integers numbers are required. Some of these
 * applications are using keys for secure transmission of data, encryption, etc.
 * In this problem you are given a number, you have to determine the number of
 * digits in the factorial of the number. Input
 *
 * Input consists of several lines of integer numbers. The first line contains
 * an integer n, which is the number of cases to be tested, followed by n lines,
 * one integer 1 <= m <= 10^7 on each line. Output
 *
 * The output contains the number of digits in the factorial of the integers
 * appearing in the input. Sample Input
 *
 * 2
 * 10 20 Sample Output
 *
 * 7
 * 19
 * 
* 斯特林[striling]公式(求阶乘(n!)的位数) 2 -10-05 13:49 3 例如1000阶乘位数： 4
 * log10(1)+log10(2)+···+log10(1000)取整后加1 5 6
 */
public class p1423 {
    /*
     * public static void main(String[] args) { Scanner in = new
     * Scanner(System.in); int num = Integer.parseInt(in.nextLine()); long
     * result ; int tmp; for(int i = 0; i < num ; i++) { result = 1; tmp =
     * Integer.parseInt(in.nextLine()); // System.out.println("xxx " + tmp);
     * for(int j = 1; j <= tmp ; j++){ result += Math.log10((double)j); }
     * System.out.println(result); } }
     *
     */

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        while (n > 0) {
            int test = cin.nextInt();
            if (test <= 3) {
                System.out.println(1);
            } else {
                double result = 0.5 * Math.log10(2 * test * Math.PI)
                        + test * Math.log10(test / Math.E) + 1;;
                System.out.println((int) (result));
            }
            n--;
        }
    }
}
