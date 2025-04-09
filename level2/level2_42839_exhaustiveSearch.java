package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class level2_42839_exhaustiveSearch {
    public static void main(String[] args) {
        String s = "17";
        int maxS  = Integer.parseInt(
            s.chars()                            // IntStream (각 문자를 int로)
            .mapToObj(c -> (char)c)            // int → char
            .sorted(Comparator.reverseOrder()) // 내림차순
            .map(String::valueOf)              // char → String
            .collect(Collectors.joining())     // 붙이기
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
        for (int i = 0; i < maxS; i++) {
            if (checkPrime[i] == true) {
                System.out.println(i);
                primeList.add(i);
            }
        }

        for (int i = 0; i < primeList.size(); i++) {
            char[] ch = String.valueOf(primeList.get(i)).toCharArray();
            // List<char[]> digit = new ArrayList<>(ch);
            // System.out.println(digit);
            
            primeList.get(i);

        }
    }
}
