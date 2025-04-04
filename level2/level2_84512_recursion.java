package level2;

public class level2_84512_recursion {
    private static int wordOrder(int wordIndex, String word, int order) {
        if (wordIndex == word.length()) {
            return order;
        }

        int geometricSequenceSum = ((int) Math.pow(5, 5 - wordIndex) - 1) / 4;

        String vowels = "AEIOU";
        order += geometricSequenceSum * vowels.indexOf(word.charAt(wordIndex));
        order++;

        return wordOrder(wordIndex + 1, word, order);
    }

    public static void main(String[] args) {

        /**
         * 상태 : (i(현재 보고 있는 index), s)
         * 점화식 : (i,s) = (i+1, s)
         * 종료 조건 : i가 s의 길이보다 커질때
         */
        String word = "EIO";
        System.out.println(wordOrder(0, word, 0));

    }

    // 규칙을 먼저 찾으면 재귀가 쉽게 풀릴 문제.
    /**
     * AAAAE -> (첫 A는 첫번째니까 (5^4 + 5^3 + 5^2 + 5^1 + 5^0) * 0 + 1) + (두번재 A도 첫번째니까
     * (5^3 + 5^2 + 5^1 + 5^0) * 0 + 1) + (세번째 A도 첫번째니까 (5^2 + 5^1 + 5^0) * 0 + 1) +
     * (네번째 A도 첫번째니까 (5^1 + 5^0) * 0 + 1) + (5번째 E는 두번째니까 (5^0) * 1 + 1) == 6
     * AAAE -> (첫 A는 첫번째니까 (5^4 + 5^3 + 5^2 + 5^1 + 5^0) * 0 + 1) + (두번재 A도 첫번째니까
     * (5^3 + 5^2 + 5^1 + 5^0) * 0 + 1) + (세번째 A도 첫번째니까 (5^2 + 5^1 + 5^0) * 0 + 1) +
     * (네번째 E는 두번째니까 (5^1 + 5^0) * 1 + 1)
     */

    /**
     * 규칙 : Ex. OI
     * O --> 4번째
     * I --> 3번째
     * 1. O --> (5^4 + 5^3 + 5^2 + 5^1 + 5^0) * (4-1) + 1 = 2344
     * 2. I --> (5^3 + 5^2 + 5^1 + 5^0) * (3-1) + 1 = 313
     * 더하면 2657
     */

}

/**
 * 괜찮은 재귀 사용. But. dfs를 이용한 더 쉬운 방법이 존재함
 */