
import java.util.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Description
 *
 * Businesses like to have memorable telephone numbers. One way to make a
 * telephone number memorable is to have it spell a memorable word or phrase.
 * For example, you can call the University of Waterloo by dialing the memorable
 * TUT-GLOP. Sometimes only part of the number is used to spell a word. When you
 * get back to your hotel tonight you can order a pizza from Gino's by dialing
 * 310-GINO. Another way to make a telephone number memorable is to group the
 * digits in a memorable way. You could order your pizza from Pizza Hut by
 * calling their ``three tens'' number 3-10-10-10. * The standard form of a
 * telephone number is seven decimal digits with a hyphen between the third and
 * fourth digits (e.g. 888-1200). The keypad of a phone supplies the mapping of
 * letters to numbers, as follows: * A, B, and C map to 2 D, E, and F map to 3
 * G, H, and I map to 4 J, K, and L map to 5 M, N, and O map to 6 P, R, and S
 * map to 7 T, U, and V map to 8 W, X, and Y map to 9 * There is no mapping for
 * Q or Z. Hyphens are not dialed, and can be added and removed as necessary.
 * The standard form of TUT-GLOP is 888-4567, the standard form of 310-GINO is
 * 310-4466, and the standard form of 3-10-10-10 is 310-1010. * Two telephone
 * numbers are equivalent if they have the same standard form. (They dial the
 * same number.) * Your company is compiling a directory of telephone numbers
 * from local businesses. As part of the quality control process you want to
 * check that no two (or more) businesses in the directory have the same
 * telephone number. * Input
 *
 * The input will consist of one case. The first line of the input specifies the
 * number of telephone numbers in the directory (up to 100,000) as a positive
 * integer alone on the line. The remaining lines list the telephone numbers in
 * the directory, with each number alone on a line. Each telephone number
 * consists of a string composed of decimal digits, uppercase letters (excluding
 * Q and Z) and hyphens. Exactly seven of the characters in the string will be
 * digits or letters. Output
 *
 * Generate a line of output for each telephone number that appears more than
 * once in any form. The line should give the telephone number in standard form,
 * followed by a space, followed by the number of times the telephone number
 * appears in the directory. Arrange the output lines by telephone number in
 * ascending lexicographical order. If there are no duplicates in the input
 * print the line: * No duplicates. Sample Input
 *
 * 12 4873279 ITS-EASY 888-4567 3-10-10-10 888-GLOP TUT-GLOP 967-11-11 310-GINO
 * F101010 888-1200 -4-8-7-3-2-7-9- 487-3279 Sample Output
 *
 * 310-1010 2 487-3279 4 888-4567 3
 */
public class p1002 {

    public static char returnVal(char c) {
        if (c <= 67 && c >= 65) {
            return '2';
        } else if (c <= 70 && c >= 68) {
            return '3';
        } else if (c <= 73 && c >= 71) {
            return '4';
        } else if (c <= 76 && c >= 74) {
            return '5';
        } else if (c <= 79 && c >= 77) {
            return '6';
        } else if (c <= 83 && c >= 80) {
            return '7';
        } else if (c <= 86 && c >= 84) {
            return '8';
        } else if (c <= 89 && c >= 87) {
            return '9';
        } else {
            return '0';
        }
        /*
         * if (c >= 'A' && c <= 'C') { return '2'; } if (c >= 'D' && c <= 'F') {
         * return '3'; } if (c >= 'G' && c <= 'I') { return '4'; } if (c >= 'J'
         * && c <= 'L') { return '5'; } if (c >= 'M' && c <= 'O') { return '6';
         * } if (c == 'P' || c == 'R' || c == 'S') { return '7'; } if (c >= 'T'
         * && c <= 'V') { return '8'; } if (c >= 'W' && c <= 'Y') { return '9';
         * } if (c == '-') { return ' '; } else { return c; }
         *
         */
    }

    public static String convert(String num) {
        char[] NUMS = num.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < NUMS.length; i++) {
            if (returnVal(NUMS[i]) != ' ') {
                list.add(NUMS[i]);
            }
        }
        list.add(2, '-');

        return String.valueOf(list.toArray());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> entryTab = new HashMap<String, Integer>();
        int n = in.nextInt();
        int i = 0;
        //     boolean flag = false;
        for (i = 0; i < n; i++) {
            //       flag = false;
            String tmp = convert(in.next());
            /*
             * for (Iterator<String> it = entryTab.keySet().iterator();
             * it.hasNext();) { String key = it.next(); if (key.equals(tmp)) {
             * flag = true; int val = entryTab.get(key);
             * entryTab.put(key,val++); break; } }
             *
             * if(flag == false) { entryTab.put(tmp,1); }
             */
            if (list.contains(tmp)) {
                int val = entryTab.get(tmp);
                entryTab.put(tmp, val++);
            } else {
                list.add(tmp);
                entryTab.put(tmp, 1);
            }
        }
        Collections.sort(list);
        boolean flag = true;
        String num = "";
        int freq = 0;
        for (i = 0; i < list.size(); i++) {
            num = list.get(i);
            freq = entryTab.get(num);
            if (freq > 1) {
                flag = false;
                System.out.println(num + " " + freq + "\n");
            }
        }
        if (flag == true) {
            System.out.println("No duplicates.");
        }



    }
}


/*
 
 import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
import java.util.TreeSet;  
  
public class Main {  
    static public char returnValue(char c) {  
        if (c <= 67 && c >= 65) {  
            return '2';  
        } else if (c <= 70 && c >= 68) {  
            return '3';  
        } else if (c <= 73 && c >= 71) {  
            return '4';  
        } else if (c <= 76 && c >= 74) {  
            return '5';  
        } else if (c <= 79 && c >= 77) {  
            return '6';  
        } else if (c <= 83 && c >= 80) {  
            return '7';  
        } else if (c <= 86 && c >= 84) {  
            return '8';  
        } else if (c <= 89 && c >= 87) {  
            return '9';  
        } else {  
            return '0';  
        }  
    }  
  
    public static String parse(String str) {  
        String temp = "";  
        for (int j = 0; j < str.length(); j++) {  
            if (str.charAt(j) == '-') {  
                continue;  
            } else {  
                char t = str.charAt(j);  
                if (t >= '0' && t <= '9') {  
                    temp += t;  
                } else {  
                    temp += returnValue(t);  
                }  
            }  
        }  
        return temp;  
    }  
  
    public static void main(String[] args) throws Exception {  
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        Map<String, Integer> m = new HashMap<String, Integer>();  
        int ncase = Integer.parseInt(in.readLine());  
        while (ncase-- != 0) {  
            String str = in.readLine();  
            /*此方法太耗时，不可用 
             * str = str.replaceAll("-", "").replaceAll("[ABC]", "2") 
             * .replaceAll("[DEF]", "3").replaceAll("[GHI]", "4") 
             * .replaceAll("[JKL]", "5").replaceAll("[MNO]", "6") 
             * .replaceAll("[PRS]", "7").replaceAll("[TUV]", "8") 
             * .replaceAll("[WXY]", "9"); 
             // 
            str = parse(str);  
            Integer times = m.get(str);  
            m.put(str, times == null ? 1 : times + 1);  
        }  
        Set<String> keys = new TreeSet<String>(m.keySet());  
        boolean hasOutput = false;  
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {  
            String key = it.next();  
            if (m.get(key) > 1) {  
                hasOutput = true;  
                System.out.println(key.substring(0, 3) + "-"  
                        + key.substring(3, 7) + " " + m.get(key));  
            }  
        }  
        if (!hasOutput) {  
            System.out.println("No duplicates.");  
        }  
    }  
}  
*/