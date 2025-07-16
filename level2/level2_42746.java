package level2;

import java.util.Arrays;
import java.util.function.Function;

public class level2_42746 {

//     public static boolean compareElements(int compare1, int compare2){
//         return Integer.parseInt("" + compare1 + compare2) <= Integer.parseInt("" + compare2 + compare1);
//     }
//     public static void main(String[] args) {
//         // 내가 원하는게 뭘까?
//         // 1. 배열의 요소 하나하나의 첫자리 비교.
//         // 2. 만약 동일한 값이라면 뒷자리들도 비교.
//         // stringbuilder를 통해서 값 리턴
//         StringBuilder result = new StringBuilder();
//         int[] numbers = { 6, 10, 2 };
//         // for(int i = 0; i < numbers.length - 1; i++){
//         //     for(int j = i + 1; j < numbers.length; j++){
//         //         if(compareElements(numbers[i], numbers[j])){
//         //             int tmp = numbers[i];
//         //             numbers[i] = numbers[j];
//         //             numbers[j] = tmp;
//         //         }
//         //     }
//         // }
//         for(int number : numbers){
//             result.append(number);
//         }
//         System.out.println(result.toString());
//         // 조합반환
//     }
    public static void main(String[] args) {
        int[] numbers = {2, 6, 10};
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        if (strNumbers[0].equals("0")) {
            System.out.println("0");
        }

        System.out.println(String.join("",
                strNumbers));
        // 타입 추론. <? super T>와 같은 경우 strNumbers를 통해 가장 구체적인 타입 String으로 추론된다. 그렇기 때문에 생략이 가능한 것이다.

        Function<String, String> f = String::toLowerCase;
       
    }
}
