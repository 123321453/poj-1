
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Phone List Time Limit: 1000MS	Memory Limit: 65536K Total Submissions: 17708
 * Accepted: 5635 Description
 *
 * Given a list of phone numbers, determine if it is consistent in the sense
 * that no number is the prefix of another. Let's say the phone catalogue listed
 * these numbers:
 *
 * Emergency 911 Alice 97 625 999 Bob 91 12 54 26 In this case, it's not
 * possible to call Bob, because the central would direct your call to the
 * emergency line as soon as you had dialled the first three digits of Bob's
 * phone number. So this list would not be consistent.
 *
 * Input
 *
 * The first line of input gives a single integer, 1 ≤ t ≤ 40, the number of
 * test cases. Each test case starts with n, the number of phone numbers, on a
 * separate line, 1 ≤ n ≤ 10000. Then follows n lines with one unique phone
 * number on each line. A phone number is a sequence of at most ten digits.
 *
 * Output
 *
 * For each test case, output "YES" if the list is consistent, or "NO"
 * otherwise.
 *
 * Sample Input
 *
 * 2
 * 3
 * 911 97625999 91125426 5 113 12340 123440 12345 98346 Sample Output
 *
 * NO YES Source
 *
 * Nordic 2007
 */
public class p3630 {

    private static int SIZE = 10;

    private static class TrieNode {

        private int num;
        private TrieNode[] son;
        // private boolean isEnd;
        private char val;
        private boolean visited;

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            //isEnd = false;
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
    private static TrieNode root;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            root = new TrieNode();
            String[] tab = new String[n];
            for (int j = 0; j < n; j++) {
                tab[j] = in.next();
                //System.out.println("test1: "+tab[j]);
                root.insert(tab[j]);
                root.setNum(tab[j]);
            }
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (root.retNum(tab[j]) > 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
