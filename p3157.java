
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Java vs C++ Time Limit: 2000MS	Memory Limit: 65536K Total Submissions: 6892
 * Accepted: 1961 Description
 *
 * Apologists of Java and C++ can argue for hours proving each other that their
 * programming language is the best one. Java people will tell that their
 * programs are clearer and less prone to errors, while C++ people will laugh at
 * their inability to instantiate an array of generics or tell them that their
 * programs are slow and have long source code.
 *
 * Another issue that Java and C++ people could never agree on is identifier
 * naming. In Java a multiword identifier is constructed in the following
 * manner: the first word is written starting from the small letter, and the
 * following ones are written starting from the capital letter, no separators
 * are used. All other letters are small. Examples of a Java identifier are
 * javaIdentifier, longAndMnemonicIdentifier, name, nEERC.
 *
 * Unlike them, C++ people use only small letters in their identifiers. To
 * separate words they use underscore character ‘_’. Examples of C++ identifiers
 * are c_identifier, long_and_mnemonic_identifier, name (you see that when there
 * is just one word Java and C++ people agree), n_e_e_r_c.
 *
 * You are writing a translator that is intended to translate C++ programs to
 * Java and vice versa. Of course, identifiers in the translated program must be
 * formatted due to its language rules — otherwise people will never like your
 * translator.
 *
 * The first thing you would like to write is an identifier translation routine.
 * Given an identifier, it would detect whether it is Java identifier or C++
 * identifier and translate it to another dialect. If it is neither, then your
 * routine should report an error. Translation must preserve the order of words
 * and must only change the case of letters and/or add/remove underscores.
 *
 * Input
 *
 * The input file consists of one line that contains an identifier. It consists
 * of letters of the English alphabet and underscores. Its length does not
 * exceed 100.
 *
 * Output
 *
 * If the input identifier is Java identifier, output its C++ version. If it is
 * C++ identifier, output its Java version. If it is none, output “Error!
 * instead.
 *
 * Sample Input
 *
 * sample input #1 long_and_mnemonic_identifier
 *
 * sample input #2 anotherExample
 *
 * sample input #3 i
 *
 * sample input #4 bad_Style Sample Output
 *
 * sample output #1 longAndMnemonicIdentifier
 *
 * sample output #2 another_example
 *
 * sample output #3 i
 *
 * sample output #4 Error! Source
 *
 * Northeastern Europe 2006
 */
public class p3157 {

    public static String java2cpp(String line) {
       // ArrayList<Character> list = new ArrayList();
        StringBuffer list = new StringBuffer();
        char[] tab = line.toCharArray();
        for(int i = 0; i < tab.length ; i++) {
            //System.out.println(tab[i]);
            if(Character.isLowerCase(tab[i])) {
                list.append(tab[i]);
            }
            if(Character.isUpperCase(tab[i])) {
                list.append('_');
                list.append(Character.toLowerCase(tab[i]));
            }
        }
        String tmp = new String(list);
        return tmp;
    }

    public static String cpp2java(String line) {
        //ArrayList<Character> list = new ArrayList();
        StringBuffer list = new StringBuffer();
        char[] tab = line.toCharArray();
        boolean isUnder = false;
        for (int i = 0; i < tab.length; i++) {
            if(Character.isLowerCase(tab[i])) {
                if(!isUnder) {
                    list.append(tab[i]);
                    isUnder = false; 
                }
                else {
                    list.append(Character.toUpperCase(tab[i]));
                    isUnder = false;
                }
            }
            if(tab[i] == '_') {
                isUnder = true;
                continue;
            }
        }
        String tmp = new String(list); 
        return tmp;
    }

    public static boolean isJava(String line) {
        char[] tab = line.toCharArray();
        for (int i = 0; i < tab.length; i++) {
            if (i == 0) {
                if (!Character.isLowerCase(tab[i])) {
                    return false;
                }
            }
            if (tab[i] == '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean isCpp(String line) {
        char[] tab = line.toCharArray();
        boolean isUnder = false;
        for (int i = 0; i < tab.length; i++) {
            if (i == 0) {
                if (!Character.isLowerCase(tab[i])) {
                    return false;
                }
            }
            if(Character.isUpperCase(tab[i]))
                return false;
            if(i == tab.length -1) {
                if (tab[i] == '_') {
                    return false;
                }
            }
            else {
                if(tab[i] == '_') {
                    if(!isUnder) {
                        isUnder = true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    isUnder = false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        boolean iscpp = isCpp(line);
        boolean isjava = isJava(line);
        //System.out.println(iscpp + " " + isjava);
        if(iscpp) {
            System.out.println(cpp2java(line));
        }
        else if(isjava) {
            System.out.println(java2cpp(line));
        }
        else {
            System.out.println("Error!");
        }

    }
}
