
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Ancient Cipher
Time Limit: 1000MS		Memory Limit: 65536K
Total Submissions: 22518		Accepted: 7599
Description

Ancient Roman empire had a strong government system with various departments, including a secret service department. Important documents were sent between provinces and the capital in encrypted form to prevent eavesdropping. The most popular ciphers in those times were so called substitution cipher and permutation cipher. 
Substitution cipher changes all occurrences of each letter to some other letter. Substitutes for all letters must be different. For some letters substitute letter may coincide with the original letter. For example, applying substitution cipher that changes all letters from 'A' to 'Y' to the next ones in the alphabet, and changes 'Z' to 'A', to the message "VICTORIOUS" one gets the message "WJDUPSJPVT". 
Permutation cipher applies some permutation to the letters of the message. For example, applying the permutation <2, 1, 5, 4, 3, 7, 6, 10, 9, 8> to the message "VICTORIOUS" one gets the message "IVOTCIRSUO". 
It was quickly noticed that being applied separately, both substitution cipher and permutation cipher were rather weak. But when being combined, they were strong enough for those times. Thus, the most important messages were first encrypted using substitution cipher, and then the result was encrypted using permutation cipher. Encrypting the message "VICTORIOUS" with the combination of the ciphers described above one gets the message "JWPUDJSTVP". 
Archeologists have recently found the message engraved on a stone plate. At the first glance it seemed completely meaningless, so it was suggested that the message was encrypted with some substitution and permutation ciphers. They have conjectured the possible text of the original message that was encrypted, and now they want to check their conjecture. They need a computer program to do it, so you have to write one.
Input

Input contains two lines. The first line contains the message engraved on the plate. Before encrypting, all spaces and punctuation marks were removed, so the encrypted message contains only capital letters of the English alphabet. The second line contains the original message that is conjectured to be encrypted in the message on the first line. It also contains only capital letters of the English alphabet. 
The lengths of both lines of the input are equal and do not exceed 100.
Output

Output "YES" if the message on the first line of the input file could be the result of encrypting the message on the second line, or "NO" in the other case.
Sample Input

JWPUDJSTVP
VICTORIOUS
Sample Output

YES
 */
public class p2159 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] tab1 = in.nextLine().toCharArray();
        char[] tab2 = in.nextLine().toCharArray();
        HashMap<Character,Integer> map1 = new HashMap();
        HashMap<Character,Integer> map2 = new HashMap();
        int i;
        for(i = 0; i < tab1.length;i++){
            if(map1.containsKey(tab1[i])){
                map1.put(tab1[i] , (map1.get(tab1[i])+1));
                
            }
            else {
                map1.put(tab1[i], 1);
            }
        }
        for(i = 0; i < tab2.length;i++){
            if(map2.containsKey(tab2[i])){
                map2.put(tab2[i] , (map2.get(tab2[i])+1));
                
            }
            else {
                map2.put(tab2[i], 1);
            }
        }
        Object[] val1 = map1.values().toArray();
        Object[] val2 = map2.values().toArray();
       
        Arrays.sort(val1);
        Arrays.sort(val2); 
        
        boolean flag = true;
        if(val1.length != val2.length) {
            flag = false;
        }
        else {
            for(i = 0; i < val1.length ; i++) {
                if(val1[i] != val2[i]) {
                    flag = false;
                    break;
                }
                else
                    continue;
            }
        }
        if(flag) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
        
    }
}
