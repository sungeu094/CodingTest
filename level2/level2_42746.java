package level2;

public class level2_42746 {

    public static int getFirstNum(int n) {
        while (n >= 10) {
            n = n / 10;
        }

        return n;
    }

    public static void main(String[] args) {
        // 내가 원하는게 뭘까?
        // 1. 배열의 요소 하나하나의 첫자리 비교.
        // 2. 만약 동일한 값이라면 뒷자리들도 비교.
        // stringbuilder를 통해서 값 리턴

        StringBuilder sb = new StringBuilder();
        int[] numbers = { 6, 10, 2 };
        int[] max = new int[numbers.length];

        System.out.println(level2_42746.getFirstNum(100));

    }

}
