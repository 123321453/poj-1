
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Freckles Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 6209
 * Accepted: 3118 Description
 *
 * In an episode of the Dick Van Dyke show, little Richie connects the freckles
 * on his Dad's back to form a picture of the Liberty Bell. Alas, one of the
 * freckles turns out to be a scar, so his Ripley's engagement falls through.
 * Consider Dick's back to be a plane with freckles at various (x,y) locations.
 * Your job is to tell Richie how to connect the dots so as to minimize the
 * amount of ink used. Richie connects the dots by drawing straight lines
 * between pairs, possibly lifting the pen between lines. When Richie is done
 * there must be a sequence of connected lines from any freckle to any other
 * freckle. Input
 *
 * The first line contains 0 < n <= 100, the number of freckles on Dick's back.
 * For each freckle, a line follows; each following line contains two real
 * numbers indicating the (x,y) coordinates of the freckle. Output
 *
 * Your program prints a single real number to two decimal places: the minimum
 * total length of ink lines that can connect all the freckles. Sample Input
 *
 * 3
 * 1.0 1.0 2.0 2.0 2.0 4.0 Sample Output
 *
 * 3.41 Source
 *
 * Waterloo local 2000.09.23
 */
public class p2560 {

    private static int Max = 105;
    private static double inf = 1 << 29;
    static double[][] tab;
    static double[] dis;

    private static double prim(int n) {
        double ans = 0.0;
        int now = 0;
        int next = -1;
        double min_e = -1;
        for (int i = 0; i < n; i++) {
            dis[i] = inf;
        }
        for (int i = 1; i < n; i++) {
            dis[now] = -1;
            min_e = inf;
            for (int j = 0; j < n; j++) {
                if (now != j && dis[j] > 0) {
                    dis[j] = (dis[j] > tab[now][j]) ? tab[now][j] : dis[j];
                    if (dis[j] < min_e) {
                        min_e = dis[j];
                        next = j;
                    }
                }
            }
            ans += min_e;
            now = next;
        }


        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            double[] xptr = new double[n];
            double[] yptr = new double[n];
            tab = new double[n][n];
            dis = new double[n];
            for (int i = 0; i < n; i++) {
                xptr[i] = in.nextDouble();
                yptr[i] = in.nextDouble();

            }
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    tab[i][j] = Math.sqrt(((xptr[i] - xptr[j]) * (xptr[i] - xptr[j])) + ((yptr[i] - yptr[j]) * (yptr[i] - yptr[j])));
                    tab[j][i] = tab[i][j];
                }
            }
            double ans = prim(n);
            System.out.println(String.format("%.2f",ans));
            //System.out.printf("%.2f\n",ans);

        }

    }
}
