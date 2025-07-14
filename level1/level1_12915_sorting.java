package level1;

import java.util.Arrays;

public class level1_12915_sorting {
    public static void main(String[] args) {
        String[] str = { "abce", "abcd", "cdx" };
        int n = 2;

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                int compareN = str[i].substring(n, n + 1).compareTo(str[j].substring(n, n + 1));
                int compareString = str[i].compareTo(str[j]);

                System.out.println("compareN : " + compareN + " 앞 : " + str[i].substring(n - 1, n) + " 뒤 : "
                        + str[j].substring(n - 1, n));

                if (compareN > 0 || (compareN == 0 && compareString > 0)) {
                    String tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(str));
    }
}
