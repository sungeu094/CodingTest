package level2;

import java.util.Arrays;
import java.util.Comparator;

public class level2_42746_UsingStream {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        String[] numberStr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(numberStr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        }); // -> 함수형 인터페이스가 아니라도 결국 익명 클래스는 해당 인터페이스 속 추상 메서드를 구현시켜주기만 하면 되기 때문에 가능하다.
        Arrays.sort(numberStr, (a,b) -> (b+a).compareTo(a+b));
        
    }
}
