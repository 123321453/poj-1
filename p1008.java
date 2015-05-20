
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Maya Calendar Time Limit: 1000MS	Memory Limit: 10000K Total Submissions:
 * 54424	Accepted: 16819 Description
 *
 * During his last sabbatical, professor M. A. Ya made a surprising discovery
 * about the old Maya calendar. From an old knotted message, professor
 * discovered that the Maya civilization used a 365 day long year, called Haab,
 * which had 19 months. Each of the first 18 months was 20 days long, and the
 * names of the months were pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen,
 * yax, zac, ceh, mac, kankin, muan, pax, koyab, cumhu. Instead of having names,
 * the days of the months were denoted by numbers starting from 0 to 19. The
 * last month of Haab was called uayet and had 5 days denoted by numbers 0, 1,
 * 2, 3, 4. The Maya believed that this month was unlucky, the court of justice
 * was not in session, the trade stopped, people did not even sweep the floor. *
 * For religious purposes, the Maya used another calendar in which the year was
 * called Tzolkin (holly year). The year was divided into thirteen periods, each
 * 20 days long. Each day was denoted by a pair consisting of a number and the
 * name of the day. They used 20 names: imix, ik, akbal, kan, chicchan, cimi,
 * manik, lamat, muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, canac,
 * ahau and 13 numbers; both in cycles. * Notice that each day has an
 * unambiguous description. For example, at the beginning of the year the days
 * were described as follows: * 1 imix, 2 ik, 3 akbal, 4 kan, 5 chicchan, 6
 * cimi, 7 manik, 8 lamat, 9 muluk, 10 ok, 11 chuen, 12 eb, 13 ben, 1 ix, 2 mem,
 * 3 cib, 4 caban, 5 eznab, 6 canac, 7 ahau, and again in the next period 8
 * imix, 9 ik, 10 akbal . . . * Years (both Haab and Tzolkin) were denoted by
 * numbers 0, 1, : : : , where the number 0 was the beginning of the world.
 * Thus, the first day was: * Haab: 0. pop 0 * Tzolkin: 1 imix 0 Help professor
 * M. A. Ya and write a program for him to convert the dates from the Haab
 * calendar to the Tzolkin calendar. Input
 *
 * The date in Haab is given in the following format: NumberOfTheDay. Month Year
 * * The first line of the input file contains the number of the input dates in
 * the file. The next n lines contain n dates in the Haab calendar format, each
 * in separate line. The year is smaller then 5000. Output
 *
 * The date in Tzolkin should be in the following format: Number NameOfTheDay
 * Year * The first line of the output file contains the number of the output
 * dates. In the next n lines, there are dates in the Tzolkin calendar format,
 * in the order corresponding to the input dates. Sample Input
 *
 * 3
 * 10. zac 0 0. pop 0 10. zac 1995 Sample Output
 *
 * 3
 * 3 chuen 0 1 imix 0 9 cimi 2801
 */
public class p1008 {

    public static String getTzolkinMonth(int month) {

        if (month == 1) {

            return "imix";

        } else if (month == 2) {

            return "ik";

        } else if (month == 3) {

            return "akbal";

        } else if (month == 4) {

            return "kan";

        } else if (month == 5) {

            return "chicchan";

        } else if (month == 6) {

            return "cimi";

        } else if (month == 7) {

            return "manik";

        } else if (month == 8) {

            return "lamat";

        } else if (month == 9) {

            return "muluk";

        } else if (month == 10) {

            return "ok";

        } else if (month == 11) {

            return "chuen";

        } else if (month == 12) {

            return "eb";

        } else if (month == 13) {

            return "ben";

        } else if (month == 14) {

            return "ix";

        } else if (month == 15) {

            return "mem";

        } else if (month == 16) {

            return "cib";

        } else if (month == 17) {

            return "caban";

        } else if (month == 18) {

            return "eznab";

        } else if (month == 19) {

            return "canac";

        } else if (month == 0) {

            return "ahau";

        } else {

            return "";

        }

    }

    public static int getHaabMonth(String name) {
        if (name.equals("pop")) {
            return 0;
        } else if (name.equals("no")) {
            return 1;
        } else if (name.equals("zip")) {
            return 2;
        } else if (name.equals("zotz")) {
            return 3;
        } else if (name.equals("tzec")) {
            return 4;
        } else if (name.equals("xul")) {
            return 5;
        } else if (name.equals("yoxkin")) {
            return 6;
        } else if (name.equals("mol")) {
            return 7;
        } else if (name.equals("chen")) {
            return 8;
        } else if (name.equals("yax")) {
            return 9;
        } else if (name.equals("zac")) {
            return 10;
        } else if (name.equals("ceh")) {
            return 11;
        } else if (name.equals("mac")) {
            return 12;
        } else if (name.equals("kankin")) {
            return 13;
        } else if (name.equals("muan")) {
            return 14;
        } else if (name.equals("pax")) {
            return 15;
        } else if (name.equals("koyab")) {
            return 16;
        } else if (name.equals("cumhu")) {
            return 17;
        } else if (name.equals("uayet")) {
            return 18;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] Haab = {"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh",
            "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet"};
        String[] Tzolkin = {"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik",
            "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            String num = in.next();
            int day = Integer.parseInt(num.substring(0, num.length() - 1));
            String name = in.next();
            int year = in.nextInt();

            int month = getHaabMonth(name);

            int totalDay = 0;
            totalDay += (year * 365);
            if (month < 18) {
                totalDay += month * 20;
            } else {
                totalDay += 360;
            }
            totalDay += (day + 1);

            int yearT = totalDay / 260;

            int dayT = totalDay % 260;

            if (dayT == 0) {
                yearT--;
            }

            int day2 = dayT % 13;
            
            if(day2 == 0)
                day2 = 13;

            int monthT = dayT % 20;
            String monT = getTzolkinMonth(monthT);

            //int monthT = (totalDay%260) / 20;

            //String monT = (monthT == 0) ? Tzolkin[0] : Tzolkin[monthT-1];

            //int dayT = (totalDay%260) % 13;

            System.out.println(day2 + " " + monT + " " + yearT);

        }
    }
}
