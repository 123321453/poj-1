
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Stripies Time Limit: 1000MS	Memory Limit: 30000K Total Submissions: 9521
 * Accepted: 4628 Description
 *
 * Our chemical biologists have invented a new very useful form of life called
 * stripies (in fact, they were first called in Russian - polosatiki, but the
 * scientists had to invent an English name to apply for an international
 * patent). The stripies are transparent amorphous amebiform creatures that live
 * in flat colonies in a jelly-like nutrient medium. Most of the time the
 * stripies are moving. When two of them collide a new stripie appears instead
 * of them. Long observations made by our scientists enabled them to establish
 * that the weight of the new stripie isn't equal to the sum of weights of two
 * disappeared stripies that collided; nevertheless, they soon learned that when
 * two stripies of weights m1 and m2 collide the weight of resulting stripie
 * equals to 2*sqrt(m1*m2). Our chemical biologists are very anxious to know to
 * what limits can decrease the total weight of a given colony of stripies. You
 * are to write a program that will help them to answer this question. You may
 * assume that 3 or more stipies never collide together. Input
 *
 * The first line of the input contains one integer N (1 <= N <= 100) - the
 * number of stripies in a colony. Each of next N lines contains one integer
 * ranging from 1 to 10000 - the weight of the corresponding stripie. Output
 *
 * The output must contain one line with the minimal possible total weight of
 * colony with the accuracy of three decimal digits after the point. Sample
 * Input
 *
 * 3
 * 72 30 50 Sample Output
 *
 * 120.000
 */
public class p1862 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int i;
        float a, b, c;
        List<Float>ls = new ArrayList<Float>();
        if (n == 1) {
            System.out.println(new DecimalFormat("0.000").format(in.nextFloat()));
        }
        if (n == 2) {
            a = in.nextFloat();
            b = in.nextFloat();
            if(a < 1 || a > 10000 || b < 1 || b > 10000)
                return;
            System.out.println(new DecimalFormat("0.000").format(2 * Math.sqrt(a * b)));
        } else {
            for(i = 0;i < n; i++) {
                a = in.nextFloat();
                if(a < 1 || a > 10000)
                    return;
                ls.add(a);
            }
            Collections.sort(ls); 
            double result = 2*Math.sqrt(ls.get(ls.size()-1) * ls.get(ls.size()-2));
            int index = ls.size() - 1;
            for(i = (index - 2); i >=0; i --) {
                a = ls.get(i);
                result = 2*Math.sqrt(a*result);
            }
            System.out.printf("%.3f\n",result); 
        }
    }

}
