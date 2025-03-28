package programmers;

// static의 여부는 객체를 생성하면서 값의 변화 차이이다. 만약 값이 변해야한다면 static을 사용하면 안된다.
public class level1_12932 {
    private static class ChangeChar {
        public final String numberStr;

        public ChangeChar(String numberStr) {
            this.numberStr = numberStr;
        }

        public int[] toDigitArray() {
            StringBuilder reversedStr = new StringBuilder(numberStr).reverse();
            char[] charArray = reversedStr.toString().toCharArray();

            int[] digitArray = new int[charArray.length];
            for (int i = 0; i < digitArray.length; i++) {
                digitArray[i] = charArray[i] - '0';
            }
            return digitArray;
        }

    }

    public static void main(String[] args) {
        String numberStr = "12345";

        ChangeChar changeChar = new ChangeChar(numberStr);
        int[] resultArray = changeChar.toDigitArray();

        for (int digit : resultArray) {
            System.out.println(digit);
        }
    }
}
