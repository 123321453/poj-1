
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Photograph
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 280		Accepted: 192
Description

The election campaign just started, so PSOS decided to make some propagation. One of the representatives came with a great idea - he proposes to make an photography of their Parliament Club. Unfortunatelly, even after many briefings, the representatives are still not able to agree upon an ordering of people in the photography. Moreover, there are a lot of representatives and it is not possible to have all of them in a single picture. The situation became critical. In the end, the representatives decided they will make one photo of every possible combination of people and their ordering. Different photographs will be used for a large number of billboards PSOS plan to use. To make things more clear, every person gets a Unique Identification Number (UIN). Every picture can be then described as the succession of several UINs x1, x2, ... xk, in whichxi is UIN of the i-th person in the picture x. Now we can sort all the possible photographs (combinations) to a single succession. The ordering of combinations of the same length (photographs with the same number of people in it) is defined as follows: the combination p is greater than the combination q if there exists any i such as that pj = qj for every j < i, and pi > qi. Your goal is to find the right place for a given picture among all possible photographs. 
Input

At the first line there is a positive integer N stating the number of assignments to follow. Each assignment consists of exactly two lines. At the first line of each assignment, there are two integers n and k, 1 <= k <= n <= 12 stating the total number of representatives (n) and the number of them which can fit into a single picture (k). At the second line of the assignment, there is exactly k positive numbers x1, x2, ... xk, each of them 1 <= xi <= n. No number can appear more than once on this line. 
Output

For each assignment, output the text "Variace cislo I ma poradove cislo J." (Combination #I is J-th in sequence). Fill the number of assignment instead of I (starting with one), and the number of the given photograph among all possible combinations after ordering, instead of J (also starting with one).
Sample Input

4
1 1
1
5 1
4
3 3
1 2 3
5 3
5 3 1
Sample Output

Variace cislo 1 ma poradove cislo 1.
Variace cislo 2 ma poradove cislo 4.
Variace cislo 3 ma poradove cislo 1.
Variace cislo 4 ma poradove cislo 55.
Source

CTU FEE Local 1998
 */
public class p2211 {
    private static int[] seq;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int order = 1;
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            seq = new int[k];
            for(int j = 0; j < k ;j++)
                seq[j] = in.nextInt();
            int result = 1;
            int tmp;
            int p;
            for(int o = 0; o < k; o++) {
               // if(o != k-1)
                    tmp = (seq[o]-1);
                //else
                  //  tmp = seq[o];
                for(p = o+1; p < k; p++) {
                    tmp *= (n-p);
                }
                result += tmp;
                for(p = o+1; p < k; p++) {
                    if(seq[p] > seq[o])
                        seq[p]--;
                }
            }
            System.out.printf("Variace cislo %d ma poradove cislo %d.\n",i+1,result);
        }
    }
}
