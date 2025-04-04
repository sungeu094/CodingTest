package level2;

import java.util.ArrayList;
import java.util.List;

public class level2_42842_exhaustiveSearch {

    private static int[] countWidth(int brown, int yellow) {
        int sumTile = brown + yellow;
        List<int[]> result = mulTwoNumbers(sumTile);

        for (int i = 0; i < result.size(); i++) {
            int width = Math.max(result.get(i)[0], result.get(i)[1]);
            int height = Math.min(result.get(i)[0], result.get(i)[1]);
            if ((width + height) * 2 - 4 == brown) {
                return new int[] { width, height };
            }
        }

        // 여기까지 왔다는 것은 논리적으로 오류가 있는 경우
        throw new IllegalArgumentException("올바른 카펫 크기를 찾을 수 없음");
    }

    private static List<int[]> mulTwoNumbers(int sumTile) {
        List<int[]> width_height = new ArrayList<>();
        for (int i = 3; i * i <= sumTile; i++) {        // Refactoring - O(N) => O(루트 n)
            if (sumTile % i == 0) {
                width_height.add(new int[] { i, sumTile / i });
            }
        }
        return width_height;
    }

    public static void main(String[] args) {
        // 전체 칸 개수 중요
        int brown = 8;
        int yellow = 1;
        int[] countWidthHeight = countWidth(brown, yellow);
        System.out.println(countWidthHeight[0] + " " + countWidthHeight[1]);
    }
}
