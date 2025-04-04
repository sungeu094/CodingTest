package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level3_12946_recursionHanoi {
    private static void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] { from, to });
            return;
        }
        int empty = 6 - from - to;
        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);

    }

    public static void main(String[] args) {
        // 상태
        /*
         * 기둥 1에서 기둥 3으로 n개의 원판을 옮기는 것. 즉, n개를 현재 원판의 위치에서(from) 원하는 기둥으로 이동(to)을 적절히
         * 계속해서 해주어야 한다.
         * 
         * 상태 : (n, from, to)
         */

        // 종료조건
        /*
         * 종료조건이란 가장 작은 부분 문제가 무엇이냐는 것.
         * 바로 원판을 1개만 옮길 때이기 때문에 (1, from, to) == [[from, to]]
         * 
         * 종료조건 : (1, from, to) (= [[from, to]])
         */

        // 점화식
        /*
         * 결국 종료조건과 상태를 비교해보면 n이 1이 되어야지 상태가 종료조건이 된다. 따라서 점화식에서 (n-1, , )이 되어야지 n이 결국에는
         * 1이 된다.
         * 이때, 젤 밑 원판을 원하는 곳에 올리기 위해서는 나머지 원판들은 비어있는 곳으로 이동된 후 from의 가장 밑 원판이 to로 이동하고,
         * 다시 empty의 원판이 to로 이동해야 한다.
         * 
         * 따라서 점화식은 (n, from, to) = (n-1, from, 6 - from - to) + (1, from, to) + (n-1,
         * empty, to)가 된다.
         */

        int n = 3;
        List<int[]> process = new ArrayList<int[]>();
        hanoi(n, 1, 3, process);
        for (int[] re : process) {
            System.out.println(Arrays.toString(re));
        }
    }

}
