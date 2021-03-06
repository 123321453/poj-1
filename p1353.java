
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Color Change of Go Game Pieces
Time Limit: 1000MS		Memory Limit: 10000K
Total Submissions: 434		Accepted: 288
Description

Assume that there are lots of two colors of black and white Go Game Pieces in a box, we take out n Go Game Pieces (0 < n < 129, n is a natural number) each time from the box, among which all the m pieces taken out earlier are white and the latter pieces are all black. Place all pieces around a circle in sequence uniformly. Thereafter according to the distributing of color of these pieces of this circle, taking out other pieces from this box and placing another circle in sequence uniformly, namely putting a new piece between two piece from head to end of this circle, put a black piece between every two white pieces; put a white between every white and black pieces; put a black between every two black pieces; put a white between every black and white pieces. In such way, there are also n pieces in the new circle. After that the original pieces are all taken off. Then repeat the above process. Doing in such way, that the original set of the pieces on the circle is taken away as soon as new set of the pieces has being placed on, how many white pieces are on the circle after the k-th time of repetition (k is a natural number, k < 10001)? 

For example, when n=8, m=2, k=2, the situation is as following: 
 
    Original    first repetition  second repetition
Input

On every line a group of data is given. In each group there are three natural number n, m, k, separated by commas. After all data are given there is -1 as the symbol of termination.
Output

Find the number of white pieces corresponding to the input data of each group. One line is for every output. Its fore part is a repetition of the input data and then it follows a colon and a space. The last part of it is the computed number of the white pieces.
Sample Input

8,2,2
3,1,1234
-1
Sample Output

8,2,2: 4
3,1,1234: 2
Source

Xi'an 2002
 */
public class p1353 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] tmp = in.nextLine().split(",");
            if(tmp[0].equals("-1"))
                break;
            int n = Integer.valueOf(tmp[0]);
            int m = Integer.valueOf(tmp[1]);
            int k = Integer.valueOf(tmp[2]);
            char[] src = new char[n];
            char[] dest = new char[n];
            for(int i = 0; i < m; i++)
                src[i] = 'w';
            for(int i = m; i < n ; i++)
                src[i] = 'b';
            for(int i = 0; i < k ; i++) {
                for(int j = 0; j < n; j++) {
                    if(src[j] == src[(j+1)%n])
                        dest[j] = 'b';
                    else
                        dest[j] = 'w';
                }
                for(int j = 0; j < n; j++)
                    src[j] = dest[j];
            }
            int num = 0;
            for(int i = 0; i < n; i++) {
                if(src[i] == 'w')
                    num++;
            }
            System.out.printf("%d,%d,%d: %d\n",n,m,k,num);
        }
    }
}
