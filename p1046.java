
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Color Me Less Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 26373	Accepted: 12698 Description
 *
 * A color reduction is a mapping from a set of discrete colors to a smaller
 * one. The solution to this problem requires that you perform just such a
 * mapping in a standard twenty-four bit RGB color space. The input consists of
 * a target set of sixteen RGB color values, and a collection of arbitrary RGB
 * colors to be mapped to their closest color in the target set. For our
 * purposes, an RGB color is defined as an ordered triple (R,G,B) where each
 * value of the triple is an integer from 0 to 255. The distance between two
 * colors is defined as the Euclidean distance between two three-dimensional
 * points. That is, given two colors (R1,G1,B1) and (R2,G2,B2), their distance D
 * is given by the equation * Input
 *
 * The input is a list of RGB colors, one color per line, specified as three
 * integers from 0 to 255 delimited by a single space. The first sixteen colors
 * form the target set of colors to which the remaining colors will be mapped.
 * The input is terminated by a line containing three -1 values. Output
 *
 * For each color to be mapped, output the color and its nearest color from the
 * target set. * If there are more than one color with the same smallest
 * distance, please output the color given first in the color set. Sample Input
 *
 * 0 0 0
 * 255 255 255 0 0 1 1 1 1 128 0 0 0 128 0 128 128 0 0 0 128 126 168 9 35 86 34
 * 133 41 193 128 0 128 0 128 128 128 128 128 255 0 0 0 1 0 0 0 0 255 255 255
 * 253 254 255 77 79 134 81 218 0 -1 -1 -1 Sample Output
 *
 * (0,0,0) maps to (0,0,0) (255,255,255) maps to (255,255,255) (253,254,255)
 * maps to (255,255,255) (77,79,134) maps to (128,128,128) (81,218,0) maps to
 * (126,168,9)
 */
public class p1046 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] tab = new int[16][3];
        int i = 0;
        String[] arr;
        String input;
        int a, b, c, tmp;
        int min = -1;
        boolean flag = false;
        //  HashMap<Integer, Integer> entryTab = null;
        int index = 0;
        for (i = 0; i < 16; i++) {
            input = in.nextLine();
            arr = input.split("\\s+");
            tab[i][0] = Integer.parseInt(arr[0]);
            tab[i][1] = Integer.parseInt(arr[1]);
            tab[i][2] = Integer.parseInt(arr[2]);
        }
        /*
         * System.out.println("END"); for(i = 0; i < 16; i++) {
         * System.out.println(); System.out.println(tab[i][0] + "," + tab[i][1]
         * + "," + tab[i][2]); }
         *
         */

        while (in.hasNext()) {
            input = in.nextLine();
            arr = input.split("\\s+");
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[1]);
            c = Integer.parseInt(arr[2]);
            //  entryTab = new HashMap<Integer, Integer>();
            if ((a == b) && (b == c) && (c == -1)) {
                break;
            }
            flag = false;
            for (i = 0; i < 16; i++) {
                tmp = (int) Math.sqrt( Math.pow((a - tab[i][0]), 2) +  Math.pow((b - tab[i][1]), 2) + Math.pow((c - tab[i][2]), 2));
               // System.out.println("DEBUG:" + tmp);
                if(tmp == 0) {
                    min = tmp;
                    index = i;
                    break;
                }
                if(flag == false){
                    min = tmp;
                    index = i;
                    flag = true;
                }

                if (min > tmp) {
                    min = tmp;
                    index = i;
                    // entryTab.put(min, i);
                }
              //  System.out.println("DEBUG:" + tmp + "," + min + "," + index);

            }
           // System.out.println("Debug:" + min);
            System.out.println("(" + a + "," + b + "," + c + ")" + " maps to (" + tab[index][0] + "," + tab[index][1] + "," + tab[index][2] + ")");

        }

    }
}
