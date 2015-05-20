
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Prerequisites? Time Limit: 2000MS	Memory Limit: 65536K Total Submissions:
 * 3257	Accepted: 2056 Description
 *
 * Freddie the frosh has chosen to take k courses. To meet the degree
 * requirements, he must take courses from each of several categories. Can you
 * assure Freddie that he will graduate, based on his course selection? Input
 *
 * Input consists of several test cases. For each case, the first line of input
 * contains 1 <= k <= 100, the number of courses Freddie has chosen, and 0 <= m
 * <= 100, the number of categories. One or more lines follow containing k
 * 4-digit integers follow; each is the number of a course selected by Freddie.
 * Each category is represented by a line containing 1 <= c <= 100, the number
 * of courses in the category, 0 <= r <= c, the minimum number of courses from
 * the category that must be taken, and the c course numbers in the category.
 * Each course number is a 4-digit integer. The same course may fulfil several
 * category requirements. Freddie's selections, and the course numbers in any
 * particular category, are distinct. A line containing 0 follows the last test
 * case. Output
 *
 * For each test case, output a line containing "yes" if Freddie's course
 * selection meets the degree requirements; otherwise output "no". Sample Input
 *
 * 3 2
 * 0123 9876 2222 2 1 8888 2222 3 2 9876 2222 7654 3 2 0123 9876 2222 2 2 8888
 * 2222 3 2 7654 9876 2222 0 Sample Output
 *
 * yes no
 */
public class p2664 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            boolean fail = false;
            String[] arr = null;
            arr = in.nextLine().split("\\s+");
            int k = Integer.parseInt(arr[0]);
            if (k == 0) {
                break;
            }
            int m = Integer.parseInt(arr[1]);
            String[] cours = in.nextLine().split("\\s+");
            HashMap<Integer,String> tmp = new HashMap<Integer,String>();
            for(int i = 0;i < k ; i++) {
                tmp.put(i, cours[i]);
            }
            for(int j = 0 ; j < m ; j++) {
                int t = 0;
                String[] arg = in.nextLine().split("\\s+");
                int c = Integer.parseInt(arg[0]);
                int r = Integer.parseInt(arg[1]);
                for(int p = 2; p < 2+c; p++) {
                    if(tmp.containsValue(arg[p]))
                        t++;
                }
                if(t < r) {
                    fail = true;
             //       break;
                }
            }
            if(fail) {
                System.out.println("no");
            }
            else {
                System.out.println("yes");
            }
        }
    }
}
