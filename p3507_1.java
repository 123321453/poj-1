
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author taofeng
 */
public class p3507_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int[] panel = new int[6];
            int minI = -1;
            int maxI = -1;
            //boolean flag = true;
            for (int i = 0; i < 6; i++) {
                panel[i] = in.nextInt();
                if (max < panel[i]) {
                    max = panel[i];
                    maxI = i;
                }
                if (min > panel[i]) {
                    min = panel[i];
                    minI = i;
                }
                if (panel[i] != 0) {
                    // flag = false;
                }

            }
            if (panel[0] == 0 && panel[1] == 0 && panel[2] == 0 && panel[3] == 0 && panel[4] == 0 && panel[5] == 0) {
                //all are 0
                break;
            } else {
                //System.out.println("max: "+panel[maxI] + " min: " + panel[minI]);
                Arrays.sort(panel);
                double result = 0.0;
                for (int j = 1; j <= 4; j++) {
                    result += panel[j];
                }
                result = result / 4;
                BigDecimal dec = new BigDecimal(result);
                System.out.println(dec);
            }

        }
    }
}
