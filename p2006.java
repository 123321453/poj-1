
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Litmus Test
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 1187		Accepted: 626
Description

The pH scale measures the concentration of protons (H+) in a solution and, therefore, its acidity or alkalinity. The pH value of a solution is a number between 0 and 14; it is less than 7 if the solution is acidic, greater than 7 if the solution is basic, and 7 if it is neutral. 

The formula for calculating pH is 
pH = -log10 [H+]

where [H+] is the concentration of protons measured in moles per litre. 

To calculate the pH value of an acid, one has to determine the concentration of protons in the solution. When an acid is dissolved in water, an equilibrium is reached and is governed by the equation 
Ka = [H+] [acid ions] / [acid]

where Ka is the acidity constant (known for each acid), [acid ions] is the concentration of the acid ions that have dissolved, and [acid] is the concentration of the undissolved acid. Before the acid is added, both [H+] and [acid ions] are assumed to be 0. 
For example, the acidity constant of methanoic acid is 1.6 * 10-4. Dissolving one mole of acid molecules results in one mole of H+ and one mole of acid ions. If the initial concentration of the methanoic acid is 0.1 moles/L and x moles of acid are dissolved (per liter), then the final concentration at equilibrium would be 0.1 - x moles/L for the acid and x moles/L for H+ and the acid ions.
Input

The input consists of a number of test cases. Each test case contains 4 numbers on a line: two positive floating-point numbers specifying the acidity constant Ka and the original concentration of the acid (in moles/liter) added to the water, as well as two positive integers m and n indicating that each mole of acid molecules is dissolved into m moles of H+ ions and n moles of acid ions. The floating-point numbers are specified in scientific notation as shown below. The input is terminated with a line containing four zeros. 
Output

For each test case, print on a line the pH value of the solution, rounded to 3 decimal places.
Sample Input

1.6e-04 1.0e-01 1 1
1.6e-04 1.0e-01 4 1
1.5e-05 5.0e-02 1 2
0 0 0 0
Sample Output

2.407
2.101
3.216
Source

Rocky Mountain 2004
 */
public class p2006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            double ka = in.nextDouble();
            double acid = in.nextDouble();
            int m = in.nextInt();
            int n = in.nextInt();
            if(ka == 0.0 && acid == 0.0 && m == 0 || n == 0)
                break;
            double delta = Math.sqrt((ka*ka) + 4* n*acid*ka*m);
            double temp = (-ka+delta) / (2*n);
            double res = -Math.log10(temp);
            System.out.printf("%.3f\n",res);
        }
    }
}
