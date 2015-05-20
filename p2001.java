
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
Shortest Prefixes
Time Limit: 1000MS		Memory Limit: 30000K
Total Submissions: 10375		Accepted: 4386
Description

A prefix of a string is a substring starting at the beginning of the given string. The prefixes of "carbon" are: "c", "ca", "car", "carb", "carbo", and "carbon". Note that the empty string is not considered a prefix in this problem, but every non-empty string is considered to be a prefix of itself. In everyday language, we tend to abbreviate words by prefixes. For example, "carbohydrate" is commonly abbreviated by "carb". In this problem, given a set of words, you will find for each word the shortest prefix that uniquely identifies the word it represents. 

In the sample input below, "carbohydrate" can be abbreviated to "carboh", but it cannot be abbreviated to "carbo" (or anything shorter) because there are other words in the list that begin with "carbo". 

An exact match will override a prefix match. For example, the prefix "car" matches the given word "car" exactly. Therefore, it is understood without ambiguity that "car" is an abbreviation for "car" , not for "carriage" or any of the other words in the list that begins with "car". 
Input

The input contains at least two, but no more than 1000 lines. Each line contains one word consisting of 1 to 20 lower case letters.
Output

The output contains the same number of lines as the input. Each line of the output contains the word from the corresponding line of the input, followed by one blank space, and the shortest prefix that uniquely (without ambiguity) identifies this word.
Sample Input

carbohydrate
cart
carburetor
caramel
caribou
carbonic
cartilage
carbon
carriage
carton
car
carbonate
Sample Output

carbohydrate carboh
cart cart
carburetor carbu
caramel cara
caribou cari
carbonic carboni
cartilage carti
carbon carbon
carriage carr
carton carto
car car
carbonate carbona
Source

Rocky Mountain 2004
 */
public class p2001 {
    private static int SIZE = 26;
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
                int pos = tmp[i] - 'a';
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
            for(int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - 'a';
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
                int pos = tmp[i] - 'a';
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
            for(int i = 0; i < tmp.length; i++) {
                int pos = tmp[i] - 'a';
                if(node.son[pos] == null) 
                    return 0;
                else
                    node = node.son[pos];
            }
            return node.num;
        }
        
    }
    private static TrieNode root = new TrieNode();
        
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TrieNode nt = new TrieNode();
        String[] tab = new String[10000];
        int i = 0;
        int cnt = 0;
        while(in.hasNext()) {
            String tmp = in.next();
            tab[i++] = tmp;
            StringBuffer lst = new StringBuffer();
            for(int j = 0; j < tmp.length(); j++) {
                lst.append(tmp.charAt(j));
                root.insert(lst.toString());
            }
            root.setNum(tmp);
            cnt++;
          //if(cnt == 3)
            //    break;
        }
        for(int j = 0; j < cnt; j++) {
            boolean flag = false;
            char[] num = tab[j].toCharArray();
            StringBuffer lt = new StringBuffer();
            for(int k = 0; k < num.length; k++) {
                String newStr =  new String(lt.append(num[k]));
                if(root.has(newStr)) {
                    if(root.retNum(newStr) == 1) {
                       // System.out.print("test1: ");
                        System.out.println(tab[j]+" "+newStr);
                        break;
                    }
                    else {
                        if(newStr.equals(tab[j])) {
                            System.out.println(tab[j]+" "+newStr);
                        }
                    }
                        
                }
            }
        }
        
    }
}
