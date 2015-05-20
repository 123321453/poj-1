
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * When Can We Meet? Time Limit: 1000MS	Memory Limit: 30000K Total Submissions:
 * 4105	Accepted: 2245 Description
 *
 * The ICPC committee would like to have its meeting as soon as possible to
 * address every little issue of the next contest. However, members of the
 * committee are so busy maniacally developing (possibly useless) programs that
 * it is very difficult to arrange their schedules for the meeting. So, in order
 * to settle the meeting date, the chairperson requested every member to send
 * back a list of convenient dates by E-mail. Your mission is to help the
 * chairperson, who is now dedicated to other issues of the contest, by writing
 * a program that chooses the best date from the submitted lists. Your program
 * should find the date convenient for the most members. If there is more than
 * one such day, the earliest is the best. Input
 *
 * The input has multiple data sets, each starting with a line containing the
 * number of committee members and the quorum of the meeting. * N Q Here, N,
 * meaning the size of the committee, and Q meaning the quorum, are positive
 * integers. N is less than 50, and, of course, Q is less than or equal to N. *
 * N lines follow, each describing convenient dates for a committee member in
 * the following format. * M Date1 Date2 ... DateM Here, M means the number of
 * convenient dates for the member, which is an integer greater than or equal to
 * zero. The remaining items in the line are his/her dates of convenience, which
 * are positive integers less than 100, that is, 1 means tomorrow, 2 means the
 * day after tomorrow, and so on. They are in ascending order without any
 * repetition and separated by a space character. Lines have neither leading nor
 * trailing spaces. * A line containing two zeros indicates the end of the
 * input. Output
 *
 * For each data set, print a single line containing the date number convenient
 * for the largest number of committee members. If there is more than one such
 * date, print the earliest. However, if no dates are convenient for more than
 * or equal to the quorum number of members, print 0 instead. Sample Input
 *
 * 3 2
 * 2 1 4
 * 0
 * 3 3 4 8
 * 3 2
 * 4 1 5 8 9
 * 3 2 5 9
 * 5 2 4 5 7 9
 * 3 3
 * 2 1 4
 * 3 2 5 9
 * 2 2 4
 * 3 3
 * 2 1 2
 * 3 1 2 9
 * 2 2 4
 * 0 0
 * Sample Output
 *
 * 4
 * 5
 * 0
 * 2
 */
public class p2028 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] init = in.nextLine().split("\\s+");
            int N = Integer.parseInt(init[0]);
            int Q = Integer.parseInt(init[1]);
            if ((N | Q) == 0) {
                break;
            }

          //  boolean earlyE = false;
            HashMap<Integer, Integer> tab = new HashMap<Integer, Integer>();
            for (int i = 0; i < N; i++) {
                String[] temp = in.nextLine().split("\\s+");
                int numDay = Integer.parseInt(temp[0]);
                if (numDay == 0) {
                    continue;
                }
                for (int j = 1; j < temp.length; j++) {
                    int tmp = Integer.parseInt(temp[j]);
                    if (tab.containsKey(tmp)) {
                        tab.put(tmp, (tab.get(tmp) + 1));
                    } else {
                        tab.put(tmp, 1);
                    }
                    /*
                    if ((max < tab.get(tmp)) && !earlyE) {
                        max = tab.get(tmp);
                        day = tmp;
                        if(max >= N)
                            earlyE = true; 
                    }
                    * 
                    */
                }
            }
            Set<Integer> key = tab.keySet();
            int max = 0;
            int day = 0;
            for(Integer k : key) {
                if(tab.get(k) > max) {
                    max = tab.get(k);
                    day = k;
                }
                if(tab.get(k) == max) {
                    if(k <= day) 
                        day = k;
                }
            }
       
            if (max >= Q) {
                System.out.println(day);
            } else {
                System.out.println(0);
            }
        }


    }
}
