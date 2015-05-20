
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Rectangles
Time Limit: 5000MS		Memory Limit: 10000K
Total Submissions: 3098		Accepted: 1609
Description

A specialist in VLSI design testing must decide if there are some components that cover each other for a given design. A component is represented as a rectangle. Assume that each rectangle is rectilinearly oriented (sides parallel to the x and y axis), so that the representation of a rectangle consists of its minimum and maximum x and y coordinates. 
Write a program that counts the rectangles that are entirely covered by another rectangle.
Input

The input contains the text description of several sets of rectangles. The specification of a set consists of the number of rectangles in the set and the list of rectangles given by the minimum and maximum x and y coordinates separated by white spaces, in the format:

nr_rectangles 
xmin1 xmax1 ymin1 ymax1 
xmin2 xmax2 ymin2 ymax2 
... 
xminn xmaxn yminn ymaxn 

For each set,there will be less than 5000 rectangles.
Output

The output should be printed on the standard output. For each given input data set, print one integer number in a single line that gives the result (the number of rectangles that are covered).
Sample Input

3
100 101 100 101
0 3 0 101
20 40 10 400
4
10 20 10 20
10 20 10 20
10 20 10 20
10 20 10 20
Sample Output

0
4
Source

Southeastern Europe 2000
 */
public class p1468 {
   // private static recT tmp;
    public static boolean cover(recT a , recT b) {
        return (a.x1 <= b.x1 && a.x2 >= b.x2 && a.y1 <= b.y1 && a.y2 >= b.y2);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            recT[] tab =  new recT[N];
            //tmp =  new recT();
            //tmp = new recT();
            for(int i = 0; i < N ; i++) {
                tab[i] = new recT();
                tab[i].x1 = in.nextInt();
               // tab[i].recX1(in.nextInt());
                tab[i].x2 = in.nextInt();
                tab[i].y1 = in.nextInt();
                tab[i].y2 = in.nextInt();
            }
            //Comparator<recT> cmp =  new recT();
            Comp c = new Comp();
            int result = 0;
            Arrays.sort(tab,c);
            for(int i = 0; i < N ; i++) {
                if(i != 0 && cover(tab[i-1],tab[i])) {
                    result++;
                    continue;
                }
                for(int j = i+1; j < N ; j++) {
                    if(cover(tab[j],tab[i])) {
                        result++;
                        break;
                    }
                }
            }
            System.out.println(result);
            
        }
    }
    
    static class recT implements Comparable<recT> {
        public int x1;
        public int x2;
        public int y1;
        public int y2;
        public recT() {
            x1 = 0;
            x2 = 0;
            y1 = 0;
            y2 = 0;
        }
        
        @Override
        public int compareTo(recT a) {
            if (this.x1 != a.x1) {
                return (a.x1 - this.x1);
            } else if (this.x2 != a.x2) {
                return (this.x2 - a.x2);
            } else if (this.y1 != a.y1) {
                return (a.y1 - this.y1);
            } else {
                return (this.y2 - a.y2);
            }
        }
    }
    
    public static class Comp implements Comparator<recT> {
        @Override
        public int compare(recT a, recT b) {
            return a.compareTo(b);
        }
    }
}
