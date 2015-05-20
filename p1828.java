
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 * Monkeys' Pride Time Limit: 2000MS	Memory Limit: 65536K Total Submissions:
 * 7938	Accepted: 2568 Description
 *
 * Background There are a lot of monkeys in a mountain. Every one wants to be
 * the monkey king. They keep arguing with each other about that for many years.
 * It is your task to help them solve this problem. * Problem Monkeys live in
 * different places of the mountain. Let a point (x, y) in the X-Y plane denote
 * the location where a monkey lives. There are no two monkeys living at the
 * same point. If a monkey lives at the point (x0, y0), he can be the king only
 * if there is no monkey living at such point (x, y) that x>=x0 and y>=y0. For
 * example, there are three monkeys in the mountain: (2, 1), (1, 2), (3, 3).
 * Only the monkey that lives at the point (3,3) can be the king. In most cases,
 * there are a lot of possible kings. Your task is to find out all of them.
 * Input
 *
 * The input consists of several test cases. In the first line of each test
 * case, there are one positive integers N (1<=N<=50000), indicating the number
 * of monkeys in the mountain. Then there are N pairs of integers in the
 * following N lines indicating the locations of N monkeys, one pair per line.
 * Two integers are separated by one blank. In a point (x, y), the values of x
 * and y both lie in the range of signed 32-bit integer. The test case starting
 * with one zero is the final test case and has no output. Output
 *
 * For each test case, print your answer, the total number of the monkeys that
 * can be possible the king, in one line without any redundant spaces. Sample
 * Input
 *
 * 3
 * 2 1
 * 1 2
 * 3 3
 * 3
 * 0 1
 * 1 0
 * 0 0
 * 4
 * 0 0
 * 1 0
 * 0 1
 * 1 1
 * 0
 * Sample Output
 *
 * 1
 * 2
 * 1
 */
class Node implements Comparable {

    public int x;
    public int y;

    @Override
    public int compareTo(Object a) {
        if (this.x > ((Node)a).x) {
            return 1;
        }
        if (this.x < ((Node)a).x) {
            return -1;
        } else {
            if (this.y > ((Node)a).y) {
                return 1;
            }
            else if(this.y == ((Node)a).y)
                return 0;
        }
        return 0;
    }

}

public class p1828 {

    // public static class Compa implements Comparator<int[][]> {
    //     public int compare(int[][] arg0, int[][] arg1) {
    //        if(arg0[][0] > arg1[][0])
    //            return 1;
    //           else {
    //     } 
    // }
    //}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int i;
        String[] arr;
        int totalK = 0;
        int y;
        Node[] monkey = new Node[50001];
        while (in.hasNext()) {;
            totalK = 0;
            n = Integer.parseInt(in.nextLine());

            if (n == 0) {
                break;
            }
            for (i = 0; i < n; i++) {
                arr = in.nextLine().split("\\s+");
                monkey[i] = new Node();
                monkey[i].x = Integer.parseInt(arr[0]);
                monkey[i].y = Integer.parseInt(arr[1]);
            }
            Arrays.sort(monkey,0,n);
            totalK = 1;
            //those monkey with y value higher than [n-1].x monkey could be king also
            y = monkey[n-1].y;
            for(i = n-2; i >=0;i--){
                if(y < monkey[i].y){
                    totalK++;
                    y = monkey[i].y;
                }
            }
            System.out.println(totalK);
            /*
             * curNum = x + y;
             *
             * if (((x > maxX) && (y < maxY)) || ((x < maxX) && (y > maxY))) {
             * // System.out.println("Fxxx:enter"); if (curMax != -1) {
             * totalK++; } } else { if (curNum == curMax) { totalK++; } } if ((x
             * > maxX) && (y > maxY)) { maxX = x; maxY = y; curMax = curNum;
             * totalK = 1; } // System.out.println("maxX " + maxX + " maxY " +
             * maxY + " K " + totalK); } //System.out.println(totalK);
             *
             */
        }
    }
}
