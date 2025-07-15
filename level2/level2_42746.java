package level2;

public class level2_42746 {

    public static boolean compareElements(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        if (strA.charAt(0) > strB.charAt(0)) {
            return true;
        } else if (strA.charAt(0) == strB.charAt(0)) {

        }

        return false;
    }

    public static void main(String[] args) {
        // 내가 원하는게 뭘까?
        // 1. 배열의 요소 하나하나의 첫자리 비교.
        // 2. 만약 동일한 값이라면 뒷자리들도 비교.
        // stringbuilder를 통해서 값 리턴
        StringBuilder result = new StringBuilder();
        int[] numbers = { 6, 10, 2 };

        // 조합반환

    }

}
