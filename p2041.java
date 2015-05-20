
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Unreliable Message
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 1752		Accepted: 1087
Description

The King of a little Kingdom on a little island in the Pacific Ocean frequently has childish ideas. One day he said, "You shall make use of a message relaying game when you inform me of something." In response to the King's statement, six servants were selected as messengers whose names were Mr. J, Miss C, Mr. E, Mr. A, Dr. P, and Mr. M. They had to relay a message to the next messenger until the message got to the King. 
Messages addressed to the King consist of digits ('0'-'9') and alphabet characters ('a'-'z', 'A'-'Z'). Capital and small letters are distinguished in messages. For example, "ke3E9Aa" is a message. 

Contrary to King's expectations, he always received wrong messages, because each messenger changed messages a bit before passing them to the next messenger. Since it irritated the King, he told you who are the Minister of the Science and Technology Agency of the Kingdom, "We don't want such a wrong message any more. You shall develop software to correct it!" In response to the King's new statement, you analyzed the messengers' mistakes with all technologies in the Kingdom, and acquired the following features of mistakes of each messenger. A surprising point was that each messenger made the same mistake whenever relaying a message. The following facts were observed. 

Mr. J rotates all characters of the message to the left by one. For example, he transforms "aB23d" to "B23da". 

Miss C rotates all characters of the message to the right by one. For example, she transforms "aB23d" to "daB23". 

Mr. E swaps the left half of the message with the right half. If the message has an odd number of characters, the middle one does not move. For example, he transforms "e3ac" to "ace3", and "aB23d" to "3d2aB". 

Mr. A reverses the message. For example, he transforms "aB23d" to "d32Ba". 

Dr. P increments by one all the digits in the message. If a digit is '9', it becomes '0'. The alphabet characters do not change. For example, he transforms "aB23d" to "aB34d", and "e9ac" to "e0ac". 

Mr. M decrements by one all the digits in the message. If a digit is '0', it becomes '9'. The alphabet characters do not change. For example, he transforms "aB23d" to "aB12d", and "e0ac" to "e9ac". 

The software you must develop is to infer the original message from the final message, given the order of the messengers. For example, if the order of the messengers is A->J->M->P and the message given to the King is "aB23d", what is the original message? According to the features of the messengers' mistakes, the sequence leading to the final message is "32Bad"->"daB23"->"aB23d"->"aB12d"->"aB23d": As a result, the original message should be "32Bad". 
Input

The input format is as follows. 

n 
The order of messengers 
The message given to the King 
... 
The order of messengers 
The message given to the King 

The first line of the input contains a positive integer n, which denotes the number of data sets. Each data set is a pair of the order of messengers and the message given to the King. The number of messengers relaying a message is between 1 and 6 inclusive. The same person may not appear more than once in the order of messengers. The length of a message is between 1 and 25 inclusive. 
Output

The inferred messages are printed each on a separate line.
Sample Input

5
AJMP
aB23d
E
86AE
AM
6
JPEM
WaEaETC302Q
CP
rTurnAGundam1isdefferentf
Sample Output

32Bad
AE86
7
EC302QTWaEa
TurnAGundam0isdefferentfr
Source

Japan 2003,Aizu
 */
public class p2041 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i < num ; i++) {
            char[] serv = in.next().toCharArray();
            String org = in.next();
            char[] tmp = org.toCharArray();
            
            for(int j = serv.length-1; j >= 0; j--){
                StringBuffer temp = new StringBuffer();
                if(serv[j] == 'A') {
                    //d32Ba - > aB23d
                    //d3Ba - > aB3d
                    for(int k = tmp.length-1; k >= 0; k--)
                        temp.append(tmp[k]);
                    tmp = (new String(temp)).toCharArray();
                }
                if(serv[j] == 'J') {
                    //B23da - > aB23d
                    temp.append(tmp[tmp.length-1]);
                    for(int k = 0; k < tmp.length-1; k++)
                        temp.append(tmp[k]);
                    tmp = (new String(temp)).toCharArray();
                }
                if (serv[j] == 'M') {
                    //aB12d - > aB23d
                    for(int k = 0; k <= tmp.length-1; k++) {
                        if(Character.isDigit(tmp[k])) {
                            if(tmp[k] != '9') {
                                tmp[k] = (char)(tmp[k]+1);
                                temp.append(tmp[k]);
                                //System.out.println("test: "+ tmp[k]);
                            }
                            else {
                                tmp[k] = '0';
                                temp.append(tmp[k]);
                            }
                        }
                        else
                            temp.append(tmp[k]);
                    }
                    tmp = (new String(temp)).toCharArray();
                }
                if (serv[j] == 'P') {
                    //aB34d -> aB23d
                    for (int k = 0; k <= tmp.length - 1; k++) {
                        if (Character.isDigit(tmp[k])) {
                            if (tmp[k] != '0') {
                                tmp[k] = (char)(tmp[k] - 1);
                                temp.append(tmp[k]);
                            } else {
                                tmp[k] = '9';
                                temp.append(tmp[k]);
                            }
                        } else {
                            temp.append(tmp[k]);
                        }
                    }
                    tmp = (new String(temp)).toCharArray();
                    
                }
                if (serv[j] == 'E') {
                    //ace3 - > e3ac
                    //3d2aB -> aB23d
                    if(tmp.length %2 == 0) {
                        for(int k = tmp.length/2; k < tmp.length; k++)
                            temp.append(tmp[k]);
                        for(int k = 0; k < tmp.length/2; k++)
                            temp.append(tmp[k]);
                        tmp = (new String(temp)).toCharArray();
                    }
                    else {
                        for(int k = tmp.length/2+1; k < tmp.length; k++)
                            temp.append(tmp[k]);
                        temp.append(tmp[tmp.length/2]);
                        for(int k = 0; k < tmp.length/2; k++)
                            temp.append(tmp[k]);                       
                        tmp = (new String(temp)).toCharArray();
                    }
                }
                if (serv[j] == 'C') {
                    //daB23 -> aB23d
                                        //temp.append(tmp[tmp.length-1]);
                    for(int k = 1; k <= tmp.length-1; k++)
                        temp.append(tmp[k]);
                    temp.append(tmp[0]);
                    tmp = (new String(temp)).toCharArray();
                }
            }
            //org =  new String(tmp);
            System.out.println(tmp);
        }
    }
}
