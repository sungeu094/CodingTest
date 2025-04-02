package SectionOrganize;

public class section5_RecursionEx {
    private static int Recursion(int n, int m) {
        if (m == 0 || n == 1 || n == 0) {
            return 1;
        } // 종료 조건

        return n * Recursion(n, m - 1); // 점화식
    }

    public static void main(String[] args) {
        // N과 M을 변수로 재귀를 이용해 N^M을 구하기
        int n = 6, m = 3; // 상태
        System.out.println(Recursion(n, m));
    }
}
