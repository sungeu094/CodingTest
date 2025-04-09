package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class level2_42839_exhaustiveSearch {
    public static void main(String[] args) {
        String s = "011";
        int maxS = Integer.parseInt(
                s.chars() // IntStream (각 문자를 int로)
                        .mapToObj(c -> (char) c) // int → char
                        .sorted(Comparator.reverseOrder()) // 내림차순
                        .map(String::valueOf) // char → String
                        .collect(Collectors.joining()) // 붙이기
        );

        // System.out.println(maxS);
        boolean[] checkPrime = new boolean[maxS + 1];
        Arrays.fill(checkPrime, true);
        checkPrime[0] = false;
        checkPrime[1] = false;

        for (int i = 2; i <= (int) Math.sqrt(maxS); i++) {
            for (int j = 2; j * i <= maxS; j++) {
                checkPrime[i * j] = false;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 0; i <= maxS; i++) {
            if (checkPrime[i] == true) {
                // System.out.println(i);
                primeList.add(i);
            }
        }

        int count = 0;
        for (int i = 0; i < primeList.size(); i++) {
            char[] eachDigit = String.valueOf(primeList.get(i)).toCharArray();
            List<Character> digit = new ArrayList<>();
            for (int j = 0; j < eachDigit.length; j++) {
                digit.add(eachDigit[j]);
            }
            System.out.println(digit);

            char[] compareEachDigit = s.toCharArray();
            List<Character> compareDigit = new ArrayList<>();
            for (int j = 0; j < compareEachDigit.length; j++) {
                compareDigit.add(compareEachDigit[j]);
            }

            for (int j = digit.size() - 1; j >= 0; j--) {
                // digit.get(j)가 compareDigit list속 요소로 있는지지
                if (compareDigit.contains(digit.get(j))) {
                    compareDigit.remove(compareDigit.indexOf(digit.get(j)));
                    digit.remove(j);
                }
            }

            if (digit.isEmpty()) {
                System.out.println(primeList.get(i));
                count++;
            }

        }

        System.out.println(count);
    }
}
