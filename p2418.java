
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Hardwood Species Time Limit: 10000MS	Memory Limit: 65536K Total Submissions:
 * 14559	Accepted: 5890 Description
 *
 * Hardwoods are the botanical group of trees that have broad leaves, produce a
 * fruit or nut, and generally go dormant in the winter. America's temperate
 * climates produce forests with hundreds of hardwood species -- trees that
 * share certain biological characteristics. Although oak, maple and cherry all
 * are types of hardwood trees, for example, they are different species.
 * Together, all the hardwood species represent 40 percent of the trees in the
 * United States. * On the other hand, softwoods, or conifers, from the Latin
 * word meaning "cone-bearing," have needles. Widely available US softwoods
 * include cedar, fir, hemlock, pine, redwood, spruce and cypress. In a home,
 * the softwoods are used primarily as structural lumber such as 2x4s and 2x6s,
 * with some limited decorative applications. * Using satellite imaging
 * technology, the Department of Natural Resources has compiled an inventory of
 * every tree standing on a particular day. You are to compute the total
 * fraction of the tree population represented by each species. Input
 *
 * Input to your program consists of a list of the species of every tree
 * observed by the satellite; one tree per line. No species name exceeds 30
 * characters. There are no more than 10,000 species and no more than 1,000,000
 * trees. Output
 *
 * Print the name of each species represented in the population, in alphabetical
 * order, followed by the percentage of the population it represents, to 4
 * decimal places. Sample Input
 *
 * Red Alder Ash Aspen Basswood Ash Beech Yellow Birch Ash Cherry Cottonwood Ash
 * Cypress Red Elm Gum Hackberry White Oak Hickory Pecan Hard Maple White Oak
 * Soft Maple Red Oak Red Oak White Oak Poplan Sassafras Sycamore Black Walnut
 * Willow Sample Output
 *
 * Ash 13.7931 Aspen 3.4483 Basswood 3.4483 Beech 3.4483 Black Walnut 3.4483
 * Cherry 3.4483 Cottonwood 3.4483 Cypress 3.4483 Gum 3.4483 Hackberry 3.4483
 * Hard Maple 3.4483 Hickory 3.4483 Pecan 3.4483 Poplan 3.4483 Red Alder 3.4483
 * Red Elm 3.4483 Red Oak 6.8966 Sassafras 3.4483 Soft Maple 3.4483 Sycamore
 * 3.4483 White Oak 10.3448 Willow 3.4483 Yellow Birch 3.4483 Hint
 *
 * This problem has huge input, use scanf instead of cin to avoid time limit
 * exceeded. Source
 *
 * Waterloo Local 2002.01.26
 */
public class p2418 {

    private static int SIZE = 52;

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
                int pos = 0;
                if (Character.isLowerCase(tmp[i])) {
                    pos = tmp[i] - 'a' + 26;
                } else {
                    pos = tmp[i] - 'A';
                }
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
                int pos = 0;
                if (Character.isLowerCase(tmp[i])) {
                    pos = tmp[i] - 'a' + 26;
                } else {
                    pos = tmp[i] - 'A';
                }
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
                int pos = 0;
                if (Character.isLowerCase(tmp[i])) {
                    pos = tmp[i] - 'a' + 26;
                } else {
                    pos = tmp[i] - 'A';
                }
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
                int pos = 0;
                if (Character.isLowerCase(tmp[i])) {
                    pos = tmp[i] - 'a' + 26;
                } else {
                    pos = tmp[i] - 'A';
                }
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

    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat format = new DecimalFormat("0.0000");
        int cnt = 0;
        root = new TrieNode();
        HashMap<String, String> tab = new HashMap();
        ArrayList<String> lt = new ArrayList();
        String tmp;
        while ((tmp = in.readLine()) != null) {
            // tmp = in.readLine();
            StringBuffer lst = new StringBuffer();
            for (int i = 0; i < tmp.length(); i++) {
                if (!Character.isSpaceChar(tmp.charAt(i))) {
                    lst.append(tmp.charAt(i));
                }
            }
            String newStr = new String(lst);
            // System.out.println("test1: "+newStr);
            if (tab.get(tmp) == null) {
                tab.put(tmp, newStr);
            }
            if (!lt.contains(tmp)) {
                lt.add(tmp);
            }
            root.insert(newStr);
            root.setNum(newStr);
            //System.out.println("test2: " + newStr+" "+root.retNum(newStr));
            cnt++;
           // if(cnt == 29)
             // break;
        }
         String[] result = new String[lt.size()];
         lt.toArray(result);
         Arrays.sort(result);
        //Collections.sort(lt);
        for (int i = 0; i < result.length; i++) {
           System.out.println(tab.get(result[i]) +format.format(((double) root.retNum(tab.get(result[i])) / cnt) * 100.0));
           // String tes = lt.get(i);
            // if(tab.get(tes) != null && cnt != 0)
           // System.out.println(tab.get(tes) + " " + format.format(((double) root.retNum(tab.get(tes)) / cnt) * 100.0));
        }

    }
}
