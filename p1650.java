
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Integer Approximation Time Limit: 1000MS	Memory Limit: 65536K Total
 * Submissions: 4965	Accepted: 1606 Description
 *
 * The FORTH programming language does not support floating-point arithmetic at
 * all. Its author, Chuck Moore, maintains that floating-point calculations are
 * too slow and most of the time can be emulated by integers with proper
 * scaling. For example, to calculate the area of the circle with the radius R
 * he suggests to use formula like R * R * 355 / 113, which is in fact
 * surprisingly accurate. The value of 355 / 113 ≈ 3.141593 is approximating the
 * value of PI with the absolute error of only about 2*10-7. You are to find the
 * best integer approximation of a given floating-point number A within a given
 * integer limit L. That is, to find such two integers N and D (1 <= N, D <= L)
 * that the value of absolute error |A - N / D| is minimal. Input
 *
 * The first line of input contains a floating-point number A (0.1 <= A < 10)
 * with the precision of up to 15 decimal digits. The second line contains the
 * integer limit L. (1 <= L <= 100000). Output
 *
 * Output file must contain two integers, N and D, separated by space. Sample
 * Input
 *
 * 3.14159265358979 10000 Sample Output
 *
 * 355 113
 */
public class p1650 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        int L = in.nextInt();
        int N = 1;
        int D = 1;
        int cn = 0;
        int cd = 0;
        double tmp;
       // double min = A;
        double er = A;
        while(N <= L && D <= L){
            tmp = (N*1.0)/(D*1.0);
            if(tmp >= A) {
                if( er > (tmp -A)) {
                    cn = N;
                    cd = D;
                    er = tmp -A;
                }
                D++;
            }
            else{
                if(er > (A - tmp)){
                    cn = N;
                    cd = D;
                    er = A-tmp;
                }
                N++;
                
            }
                
        }
        System.out.printf("%d %d",cn,cd);
        
    }
}
