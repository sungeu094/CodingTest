package level1;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class level1_68644_sorting {
    public static void main(String[] args) throws Exception {
        int[] array = new int[]{5,0,2,7};
        Set<Integer> arraySum = new TreeSet<>();
        // HashSet --> Hash Table을 사용. 이는 결국 추가나 제거에서는 시간복잡도가 적게 걸림. 하지만 현재 코드는 정렬 또한 중요하기 때문에 Hash Set보다는 정렬의 기능도 함께 포함하는 TreeSet이 낫다. TreeSet은 이진 트리 구조를 가지는 Set을 만드는 것이기 때문이다.

        for(int i = 0; i < array.length - 1; i++){
            for(int j = i+1; j < array.length; j++){
                arraySum.add(array[i] + array[j]);
            }
        }

        int[] result = arraySum.stream().sorted().mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

        Stream<Integer> stream = arraySum.stream().sorted();
        Integer[] arr = stream.toArray(Integer[]::new);

        Class<?> clazz = Class.forName("level1.level1_12930");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        clazz.getMethod("reflection").invoke(obj);        
    }
}
