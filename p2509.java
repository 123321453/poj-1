
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Peter's smokes Time Limit: 1000MS	Memory Limit: 65536K Total Submissions:
 * 16078	Accepted: 6517 Description
 *
 * Peter has n cigarettes. He smokes them one by one keeping all the butts. Out
 * of k > 1 butts he can roll a new cigarette. How many cigarettes can Peter
 * have? Input
 *
 * Input is a sequence of lines. Each line contains two integer numbers giving
 * the values of n and k. Output
 *
 * For each line of input, output one integer number on a separate line giving
 * the maximum number of cigarettes that Peter can have. Sample Input
 *
 * 4 3
 * 10 3 100 5 Sample Output
 *
 * 5
 * 14 124
 */
public class p2509 {

    public static int numCiga(int n, int k) {
        int result = 0;
        if(n < k)
            return result;
        else {
            return ( (n/k) + numCiga(((n/k) + n%k),k ) );    
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int tmp = n;
            int add = 0;
            while(n >= k) {
                int diff = n/k;
                add = add + diff;
                n = diff + n - (diff * k);
            }
            System.out.println(tmp+add);
        }
    }
}
