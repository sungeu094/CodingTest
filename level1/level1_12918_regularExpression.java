package level1;

public class level1_12918_regularExpression {
    public static void main(String[] args) {
        String s = "a234";
        if (s.matches("[0-9]{4}|[0-9]{6}")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

// matches 메서드와 정규 표현식을 이용해서 풀이 가능
// 아니면 isDigit를 이용해 String을 char array로 교체해서 풀 수는 있음. But 굳이..?
