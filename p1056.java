
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * IMMEDIATE DECODABILITY Time Limit: 1000MS	Memory Limit: 10000K Total
 * Submissions: 9223	Accepted: 4371 Description
 *
 * An encoding of a set of symbols is said to be immediately decodable if no
 * code for one symbol is the prefix of a code for another symbol. We will
 * assume for this problem that all codes are in binary, that no two codes
 * within a set of codes are the same, that each code has at least one bit and
 * no more than ten bits, and that each set has at least two codes and no more
 * than eight.  *
 * Examples: Assume an alphabet that has symbols {A, B, C, D}  *
 * The following code is immediately decodable: A:01 B:10 C:0010 D:0000  *
 * but this one is not: A:01 B:10 C:010 D:0000 (Note that A is a prefix of C)
 * Input
 *
 * Write a program that accepts as input a series of groups of records from
 * standard input. Each record in a group contains a collection of zeroes and
 * ones representing a binary code for a different symbol. Each group is
 * followed by a single separator record containing a single 9; the separator
 * records are not part of the group. Each group is independent of other groups;
 * the codes in one group are not related to codes in any other group (that is,
 * each group is to be processed independently). Output
 *
 * For each group, your program should determine whether the codes in that group
 * are immediately decodable, and should print a single output line giving the
 * group number and stating whether the group is, or is not, immediately
 * decodable. Sample Input
 *
 * 01 10 0010 0000 9 01 10 010 0000 9 Sample Output
 *
 * Set 1 is immediately decodable Set 2 is not immediately decodable
 *
 * Source
 *
 * Pacific Northwest 1998
 */
public class p1056 {

    private static int SIZE = 2;
    private static TrieNode root ;

    private static class TrieNode {

        private int num;
        private TrieNode[] son;
        private char val;
        private boolean visited;

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            visited = false;
        }

        public void insert(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode node = root;
            char[] tmp = str.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - '0';
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                    node.son[pos].val = tmp[i];
                    node.son[pos].num = 0;
                } else {
                    //node.son[pos].num++;
                }
                node = node.son[pos];
            }
        }
        
        public void setNum(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode node = root;
            char[] tmp = str.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - '0';
                node = node.son[pos];
                // if(node != root)
                node.num++;
                // node = node.son[pos];
            }
           // node.num++;
        }
        
        public boolean has(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            TrieNode node = root;
            char[] tmp = str.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - '0';
                if (node.son[pos] == null) {
                    return false;
                } else {
                    node = node.son[pos];
                }
            }
            return true;
        }
        
        public int retNum(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            TrieNode node = root;
            char[] tmp = str.toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - '0';
                if (node.son[pos] == null) {
                    return 0;
                } else {
                    node = node.son[pos];
                }
            }
            return node.num;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 1;
        while(in.hasNext()) {
            root = new TrieNode();
            ArrayList<String> tab = new ArrayList();
            while(true) {
                String tmp = in.next();
                if(tmp.equals("9"))
                    break;
               // System.out.println("test: "+ tmp);
                tab.add(tmp);
                //char[] ls = tmp.toCharArray();
                //  StringBuffer lst = new StringBuffer();
                //  for(int i = 0; i < tmp.length(); i++) {
                //  lst.append(tmp.charAt(i));
                root.insert(tmp);
              //  }
                root.setNum(tmp);
            }
            String[] lt = new String [tab.size()];
            tab.toArray(lt);
            boolean flag = false;
            for(int i = 0; i < lt.length; i++) {
                if(root.retNum(lt[i]) > 1) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.printf("Set %d is not immediately decodable\n",cnt++);
            }
            else {
                System.out.printf("Set %d is immediately decodable\n",cnt++);
            }
        }
    }
}
