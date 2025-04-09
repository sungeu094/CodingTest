package level2;

import java.util.HashSet;
import java.util.Set;

public class level2_42839_exhaustiveSearchEx {

    private static void getPrimes(int selectNum, int[] numbers, boolean[] isUsed, Set<Integer> insertPrimes) {
        if (isPrime(selectNum)) insertPrimes.add(selectNum);
        for (int i = 0; i < numbers.length; i++) {
            if(isUsed[i]) continue;
            int nextSelectNum = selectNum * 10 + numbers[i];
            isUsed[i] = true;
            // 할때마다 list 복사 후 원소 제거 O(N) 시간복잡도가 소요됨. 그러면서 for문 안이기 때문에 O(N^2)이 된다.
            getPrimes(nextSelectNum, numbers, isUsed, insertPrimes);
            isUsed[i] = false;
            // 현재 코드는 직관적으로 설명하면 Set에 return된 Set 원소를 하나하나 순회하면서 넣는 작업을 하는 것이기 때문에 매 호출마다 발생하는 작업이라 시간복잡도가 클 수 밖에 없다. 즉, 시간복잡도 측면에서는 챙기지 못한 코드라고 볼 수 있다.
        }

    }

    private static boolean isPrime(int selectNum) {
        if (selectNum <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(selectNum); i++) {
            if (selectNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> primes = new HashSet<>();

        String nums = "1234";
        int[] numbers = nums.chars()
                .map(c -> c - '0')
                .toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        System.out.println(primes.size());
    }
}

// 재귀를 통한 문제 해결
/**
 * 문제 해결 방법 : 기존 숫자에 숫자들을 하나씩 더해가면서 소수인지 판별해나가는 방법을 사용. 이때, 재귀를 통한 문제해결을 할 것.
 */
/**
 * 상태 {selectNum, remainNum} -> 현재 만들어진 숫자 : selectNum, 사용할 수 있는 종이 : remainNum
 * 종료 조건 {selectNum, 0} -> remainNum이 없어질 때까지 점화식 {selectNum, remainNum} =
 * {selectNum * 10 + n, remainNum - n} -> 만약 selectNum이 소수이면 일단 소수로 저장이 되고, 그 뒤에
 * 오는 숫자를 n이라 하면 select * 10 + n이 그 다음 숫자가 되는 것이다.
 */
