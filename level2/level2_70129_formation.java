package level2;

public class level2_70129_formation {
    public static void main(String[] args) {
        int countZero = 0; // 0 제거 개수 파악
        int countFormation = 0; // 변환 과정 개수 파악

        String s = "110010101001";

        while (!s.equals("1")) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.indexOf("0") != -1) {
                int index = sb.lastIndexOf("0");
                System.out.println(index);
                sb.deleteCharAt(index);
                countZero++;
                System.out.println("CountZero : " + countZero);
            }

            s = Integer.toString(sb.length(), 2);
            System.out.println("s : " + s);
            countFormation++;
            System.out.println("CountFormation : " + countFormation);
        }

        System.out.println(countZero + " " + countFormation);

    }
}

// 코드 평가
// 코드 자체는 깔끔하지만 중첩된 while, index를 search, delete하는 메서드의 시간 복잡도를 고려하지 않은게 문제임
