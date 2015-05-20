
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * GYM Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 353	Accepted:
 * 209 Description
 *
 * Model a stochastic gym exercise. An entertaining game for elementary school
 * children in gym class is set up as follows: N baskets are placed at various
 * locations on the gym floor, each with a distinguishing picture on them.
 *
 * Each basket contains some index cards. Each index card has a destination
 * written on them.
 *
 * The game proceed as follows: the children gather at a specified start basket.
 * They each take a turn picking a random card from the basket, memorizing the
 * destination, and returning the card before the next child picks one. When the
 * teacher blows the whistle, all the children move to the basket indicated on
 * the notecard.  *
 * Given the configuration of index cards at each basket, you are to determine
 * the probabiliites a kindergardener will appear at each basket for the first
 * ten steps of the game.  *
 * For example, suppose there are four baskets, "tree," "house," "car" and
 * "park." Each basket has the following index cards: The "tree" basket has 2
 * cards with "tree" on it, 1 card with "house", and 2 cards with "car." The
 * "house" basket has 1 card with "tree" on it, 1 card with "car" on it, and 2
 * cards with "park" on it. The "car" basket has 1 card with "tree" on it. The
 * "park" basket has one of each card in it.
 *
 *
 * This arrangement is summarized by the following table: destination basket
 * tree	house	car	park tree	2	1	2	0 house	1	0	1	2 car	1	0	0	0 park	1	1	1	1
 *
 * Everyone starts at the tree, so initially, P0(tree)=1, and P0(else where)=0
 *
 * In the middle of the game, the probablity of being at some new location is
 * equal to the sum of the probabilities of being at any location on the
 * previous step, times the probablity of moving to the destination location
 * from that past location. For the example,
 * Ps+1(tree)=0.40*Ps(tree)+0.25*Ps(house)+1.00*Ps(car)+0.25*Ps(park)
 *
 * Input
 *
 * For N baskets, 2<=N<=10, the input will contain N lines of information. The N
 * lines will give the index card count as in the table for the example above.
 * There will be at most 10 cards of the same name in any given basket, and each
 * basket will contain at least one card. Output
 *
 * There should be 10 lines of output for any given input. You should print out
 * the probabilites for seeing a kindergardener at any given basked for the
 * first 10 steps in the game.  *
 * Your results should give the correct probablities to five digits of
 * precision. We recommend you do the internal computations using double
 * precision arithmetic. Sample Input
 *
 * 2 1 2 0
 * 1 0 1 2
 * 1 0 0 0
 * 1 1 1 1
 * Sample Output
 *
 * 1.00000 0.00000 0.00000 0.00000 0.40000 0.20000 0.40000 0.00000 0.61000
 * 0.08000 0.21000 0.10000 0.49900 0.14700 0.28900 0.06500 0.54160 0.11605
 * 0.25260 0.08975 0.52069 0.13076 0.26809 0.08046 0.52917 0.12425 0.26108
 * 0.08549 0.52519 0.12721 0.26411 0.08350 0.52686 0.12591 0.26275 0.08448
 * 0.52609 0.12649 0.26334 0.08408 Hint
 *
 * Assume they always start at the first basket.
 */
public class p2321 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tmp = in.nextLine().split("\\s+");
        int n = tmp.length;
        int[][] da = new int[n][n];
        int[] sum = new int[n];
        int i, j;
        double[][] cur = new double[10][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                da[i][j] = new Integer(Integer.parseInt(tmp[j]));
                sum[i] +=da[i][j];
            }
            if(i != (n-1))
                tmp = in.nextLine().split("\\s+");
        }
/*
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(da[i][j] + " ");
            }
            System.out.println("Debug: " + sum[i]);
        }
*/
        //in.close();
        for (i = 0; i < 10; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0) {
                    if (j == 0) {
                        cur[i][j] = 1.0;
                    } else {
                        cur[i][j] = 0.0;
                    }
                } else {
                    for(int k = 0; k < n; k++) {
                       // if(j == 2 && i == 1) {
                        //    System.out.println();
                       // if(i == 1)
                         //   System.out.print(da[k][j] + " " + da[j][k]+ " ffff "+ cur[i-1][j] + " ");
                        //    System.out.println();
                       // }
                       // System.out.println("how about: " + da[k][j] + " " + sum[k]+" "+cur[i-1][k]+" i: "+i+" j: "+j);
                         cur[i][j] += ((double)da[k][j]/(double)sum[k])*cur[i-1][k];
                        // System.out.println("Cur[][] "+cur[i][j]+" i "+i+" j "+j);
                    }
                   
                }
                 System.out.printf("%.5f", cur[i][j]);
                System.out.print(" ");
                        
            }
            System.out.println();
        }

    }
}
