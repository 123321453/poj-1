
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
False coin
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 14905		Accepted: 4126
Description

The "Gold Bar"bank received information from reliable sources that in their last group of N coins exactly one coin is false and differs in weight from other coins (while all other coins are equal in weight). After the economic crisis they have only a simple balance available (like one in the picture). Using this balance, one is able to determine if the weight of objects in the left pan is less than, greater than, or equal to the weight of objects in the right pan. 
In order to detect the false coin the bank employees numbered all coins by the integers from 1 to N, thus assigning each coin a unique integer identifier. After that they began to weight various groups of coins by placing equal numbers of coins in the left pan and in the right pan. The identifiers of coins and the results of the weightings were carefully recorded. 
You are to write a program that will help the bank employees to determine the identifier of the false coin using the results of these weightings. 
Input

The first line of the input file contains two integers N and K, separated by spaces, where N is the number of coins (2<=N<=1000 ) and K is the number of weightings fulfilled (1<=K<=100). The following 2K lines describe all weightings. Two consecutive lines describe each weighting. The first of them starts with a number Pi (1<=Pi<=N/2), representing the number of coins placed in the left and in the right pans, followed by Pi identifiers of coins placed in the left pan and Pi identifiers of coins placed in the right pan. All numbers are separated by spaces. The second line contains one of the following characters: '<', '>', or '='. It represents the result of the weighting: 
'<' means that the weight of coins in the left pan is less than the weight of coins in the right pan, 
'>' means that the weight of coins in the left pan is greater than the weight of coins in the right pan, 
'=' means that the weight of coins in the left pan is equal to the weight of coins in the right pan. 
Output

Write to the output file the identifier of the false coin or 0, if it cannot be found by the results of the given weightings.
Sample Input

5 3
2 1 2 3 4
<
1 1 4
=
1 2 5
=
Sample Output

3
 */
public class p1029 {
    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int[] less = new int[N+1];
        int[] more = new int[N+1];
        boolean[] normal = new boolean[N+1];   
        boolean[] equal = new boolean[N+1];
        int i;
        for(i = 1; i <=N ;i++)
            normal[i] = true;
      //  int[] times = new int[N+1];
        int K = in.nextInt();

        int nonE = 0;
        for(i = 0 ; i < K ; i++) {
            int num = in.nextInt();
            int[] left = new int[num+1];
            int[] right = new int[num+1];
            int j;
            for(j = 1 ; j <= num ; j++ )
                left[j] = in.nextInt();
            for(j = 1 ; j <= num ; j++ )
                right[j] = in.nextInt();
            String op = in.next();
            if(op.equals("<")) {
                nonE++;
                for(j = 1 ; j <= num ; j++) {
                //    System.out.println(left[j]);
                    less[left[j]] ++;
                    more[right[j]] ++;
                    
                    normal[left[j]] = false;
                    normal[right[j]] = false;
                }
            }
            else if (op.equals(">")) {
                nonE++;
                for (j = 1; j <= num; j++) {
                    more[left[j]] ++;
                    less[right[j]] ++;
                    normal[left[j]] = false;
                    normal[right[j]] = false;
                }
            }
            else if(op.equals("=")) {
                for (j = 1; j <= num; j++) {
                    equal[left[j]] = true;
                    equal[right[j]] = true;
                }
            }
            else {
                
            }
        }
        int falseCoin = -1;
        int maxNum = 0;
        for(i = 1; i <= N;i++){
            if(nonE == 0) {
                if(equal[i] == true) {
                    continue;
                }
                else {
                    normal[i] = false;
                }
            }
           // if(less[i] + more[i] == nonE) {
            if(less[i] + more[i] < nonE && nonE != 0) {
                normal[i] = true;
            }
            else if(less[i] != 0 && more[i] != 0)
                    normal[i] = true;
            else
                normal[i] = false;
           // }
        }
        
        for(i = 1 ; i <= N;i++){
            if(equal[i]) {
             //   System.out.println(i);
                continue;
            }
            else {
                if(normal[i]){
                 //  System.out.println(i);
                    continue;
                }
                else {
                   // System.out.println(i);
                    
                    falseCoin = i;
                    maxNum++;
                }
            }
        }
        if(maxNum==1)
            System.out.println(falseCoin);
        else
            System.out.println("0");
        
    }
}