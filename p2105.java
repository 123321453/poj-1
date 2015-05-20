
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
IP Address
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 16776		Accepted: 9660
Description

Suppose you are reading byte streams from any device, representing IP addresses. Your task is to convert a 32 characters long sequence of '1s' and '0s' (bits) to a dotted decimal format. A dotted decimal format for an IP address is form by grouping 8 bits at a time and converting the binary representation to decimal representation. Any 8 bits is a valid part of an IP address. To convert binary numbers to decimal numbers remember that both are positional numerical systems, where the first 8 positions of the binary systems are: 
27   26  25  24  23   22  21  20 

128 64  32  16  8   4   2   1 

Input

The input will have a number N (1<=N<=9) in its first line representing the number of streams to convert. N lines will follow.
Output

The output must have N lines with a doted decimal IP address. A dotted decimal IP address is formed by grouping 8 bit at the time and converting the binary representation to decimal representation.
Sample Input

4
00000000000000000000000000000000 
00000011100000001111111111111111 
11001011100001001110010110000000 
01010000000100000000000000000001 
Sample Output

0.0.0.0
3.128.255.255
203.132.229.128
80.16.0.1
Source

México and Central America 2004
 */
public class p2105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0;i < num;i++) {
            String tmp = in.next();
            char[] tab = tmp.toCharArray();
            int[] result = new int[4];
            int j,k,n;
            for(n = 0 ; n < 4; n++) {
                for(j = 7,k = (0+n*8); j>= 0; j--,k++) {
                    
                    result[n] += (int)Math.pow(2, (double)j)*Integer.valueOf(Character.toString(tab[k]));
                    
                }
            }
            System.out.println(result[0]+"."+result[1]+"."+result[2]+"."+result[3]);
        }
    }
}
