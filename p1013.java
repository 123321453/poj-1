
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Counterfeit Dollar Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 34579	Accepted: 10985 Description
 *
 * Sally Jones has a dozen Voyageur silver dollars. However, only eleven of the
 * coins are true silver dollars; one coin is counterfeit even though its color
 * and size make it indistinguishable from the real silver dollars. The
 * counterfeit coin has a different weight from the other coins but Sally does
 * not know if it is heavier or lighter than the real coins. Happily, Sally has
 * a friend who loans her a very accurate balance scale. The friend will permit
 * Sally three weighings to find the counterfeit coin. For instance, if Sally
 * weighs two coins against each other and the scales balance then she knows
 * these two coins are true. Now if Sally weighs one of the true coins against a
 * third coin and the scales do not balance then Sally knows the third coin is
 * counterfeit and she can tell whether it is light or heavy depending on
 * whether the balance on which it is placed goes up or down, respectively. By
 * choosing her weighings carefully, Sally is able to ensure that she will find
 * the counterfeit coin with exactly three weighings. Input
 *
 * The first line of input is an integer n (n > 0) specifying the number of
 * cases to follow. Each case consists of three lines of input, one for each
 * weighing. Sally has identified each of the coins with the letters A--L.
 * Information on a weighing will be given by two strings of letters and then
 * one of the words ``up'', ``down'', or ``even''. The first string of letters
 * will represent the coins on the left balance; the second string, the coins on
 * the right balance. (Sally will always place the same number of coins on the
 * right balance as on the left balance.) The word in the third position will
 * tell whether the right side of the balance goes up, down, or remains even.
 * Output
 *
 * For each case, the output will identify the counterfeit coin by its letter
 * and tell whether it is heavy or light. The solution will always be uniquely
 * determined. Sample Input
 *
 * 1
 * ABCD EFGH even ABCI EFJK up ABIJ EFGH even Sample Output
 *
 * K is the counterfeit coin and it is light. Source
 *
 * East Central North America 1998
 */
public class p1013 {

    private static char[] t1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        //System.out.println(num);
        for (int i = 0; i < num; i++) {
            int[] real = new int[12];
            int[] ln = new int[12];
            int maxID = -1;
            boolean lightF = false;
            for (int k = 0; k < 3; k++) {
               // String tmp1 = in.next();
                String[] tab =  new String[3];
                for(int o = 0; o < 3; o++)
                    tab[o] = in.next();
               // System.out.println(tmp1);
                char[] left;
                char[] right;
                int j;
                if (tab[2].equals("even")) {
                    left = tab[0].toCharArray();
                    right = tab[1].toCharArray();
                    for (j = 0; j < left.length; j++) {
                        real[left[j] - 'A'] = 1;
                        ln[left[j] - 'A'] = 0;
                    }
                    for (j = 0; j < right.length; j++) {
                        real[right[j] - 'A'] = 1;
                        ln[right[j] - 'A'] = 0;
                    }

                } else if (tab[2].equals("up")) {
                    left = tab[0].toCharArray();
                    right = tab[1].toCharArray();
                    for (j = 0; j < left.length; j++) {
                        // real[left[j]-'A'] = 1;
                        ln[left[j] - 'A']++;
                    }
                    for (j = 0; j < right.length; j++) {
                        //    real[right[j]-'A'] = 1;
                        ln[right[j] - 'A']--;
                    }
                } else {
                    left = tab[0].toCharArray();
                    right = tab[1].toCharArray();
                    for (j = 0; j < left.length; j++) {
                        //real[left[j]-'A'] = 1;
                        ln[left[j] - 'A']--;
                    }
                    for (j = 0; j < right.length; j++) {
                        //   real[right[j]-'A'] = 1;
                        ln[right[j] - 'A']++;
                    }
                }
                int max = Integer.MIN_VALUE;
                //int maxID = -1;
                for (j = 0; j < 12; j++) {
                    if (real[j] != 1 && ln[j] != 0) {
                        if (Math.abs(ln[j]) > max) {
                            max = Math.abs(ln[j]);
                            maxID = j;
                            if(ln[j] < 0)
                                lightF = true;
                            else
                                lightF = false;
                        }
                    }
                }
            }
            if(lightF)
                System.out.println(t1[maxID] + " is the counterfeit coin and it is light.");
            else
                System.out.println(t1[maxID] + " is the counterfeit coin and it is heavy.");
        }
    }
}
