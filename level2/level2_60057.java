package level2;

import java.util.ArrayList;
import java.util.List;

public class level2_60057 {

    public static void main(String[] args) {
        // String s = "abrabcabcadqabcabc";
        String s = "abcabcdededededede";
        int minLength = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int x = 0;

            List<String> strList = new ArrayList<>();
            while (x < s.length()) {
                if (x + i >= s.length()) {
                    strList.add(s.substring(x, s.length()));
                    System.out.println(s.substring(x, s.length()));
                } else {
                    strList.add(s.substring(x, x + i));
                    System.out.println(s.subSequence(x, x + i));
                } // ok
                x += i;
            }

            System.out.println(strList);
            List<String> isDupList = new ArrayList<>();

            for (int j = 1; j < strList.size(); j++) {
                if (strList.get(j - 1).equals(strList.get(j))) {
                    if (!(j + 1 < strList.size() && strList.get(j).equals(strList.get(j + 1)))) {
                        isDupList.add(strList.get(j - 1));
                    }
                }
            }
            System.out.println("isDupList : " + isDupList);
            if (isDupList.isEmpty()) {
                continue;
            }

            int[] countDupList = new int[isDupList.size()];
            int index = 0, countArray = 0;
            while (index < strList.size() - 1) {
                System.out.println("index + " + strList.get(index));
                if (index + 1 >= strList.size()) {
                    break;
                }
                if (strList.get(index).equals(strList.get(index + 1))) {
                    countDupList[countArray]++;
                    strList.remove(index);
                } else {
                    index++;
                    if (countDupList[countArray] != 0 && countDupList.length > countArray + 1) {
                        countArray++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(String.join("", strList));
            for (int count : countDupList) {
                System.out.println("Count + " + (count + 1));
                sb.append(count + 1);
            }
            System.out.println(sb.toString());

            if (sb.length() < minLength) {
                System.out.println("minLength : " + sb.toString());
                minLength = sb.length();
            }

        }

        System.out.println(minLength);
    }

}
