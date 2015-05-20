
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author taofeng
 */
public class p3561_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[][] tab = new char[x][y];
            for (int j = 0; j < x; j++) {
                tab[j] = in.next().toCharArray();
            }
            //  boolean flag = true;
            boolean cntX1 = false;
            boolean cntX2 = false;
            boolean cntH1 = false;
            boolean cntS1 = false;
            int prevXa = 0;
            int prevYa = 0;
            int prevXb = 0;
            int prevYb = 0;
            int prevXH = 0;
            int prevYH = 0;
            int prevXS = 0;
            int prevYS = 0;
            int cnt = 0;
            for (int j = 0; j < x; j++) {
                if (cnt > 1) {
                    break;
                }
                for (int k = 0; k < y; k++) {
                    if (cnt > 1) {
                        break;
                    }
                    if (tab[j][k] == '.') {
                        continue;
                    }
                    if (tab[j][k] == '\\') {
                        if (!cntX1) {
                            cnt++;
                            cntX1 = true;
                            continue;
                        } else {
                            if(j == 0) {
                                cnt++;
                                continue;
                            }
                            if (j > 0 && k > 0) {
                                if (tab[j - 1][k - 1] != '\\') {
                                    cnt++;
                                    continue;
                                }
                            }
                            if (j < x-1 && k < y-1) {
                                if (tab[j + 1][k + 1] != '\\') {
                                    cnt++;
                                    continue;
                                }
                            }
                        }
                    }
                    if (tab[j][k] == '/') {
                        if (!cntX2) {
                            cnt++;
                            cntX2 = true;

                        } else {
                            if (j < x-1 && k > 0) {
                                if (tab[j + 1][k - 1] != '/') {
                                    cnt++;
                                    continue;
                                }
                            }
                            if (j > 0 && k < y-1) {
                                if (tab[j - 1][k + 1] != '/') {
                                    cnt++;
                                    continue;
                                }
                            }
                        }

                    }
                    if (tab[j][k] == '-') {
                        if (!cntH1) {
                            cnt++;
                            cntH1 = true;
                            continue;
                        } else {
                            if (k > 0) {
                                if (tab[j][k - 1] != '-') {
                                    cnt++;
                                    continue;
                                }
                            }
                            if (k < y-1) {
                                if (tab[j][k + 1] != '-') {
                                    cnt++;
                                    continue;
                                }
                            }
                        }

                    }
                    if (tab[j][k] == '|') {
                        if (!cntS1) {
                            cnt++;
                            cntS1 = true;
                            continue;
                        } else {
                            if(j < x-1) {
                                if(tab[j + 1][k] != '|') {
                                    cnt++;
                                    continue;
                                }
                            }
                            if(j > 0) {
                                if(tab[j - 1][k] != '|') {
                                    cnt++;
                                    continue;
                                }
                            }
                        }

                    }


                }
            }
            if (cnt != 1) {
                System.out.println("INCORRECT");
            } else {
                System.out.println("CORRECT");
            }
        }
    }
}
