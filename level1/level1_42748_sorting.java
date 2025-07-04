package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level1_42748_sorting {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,6,3,7,4};
        int[][] commands = new int[][]{{2,5,3},{4,4,1},{1,7,3}};
        
        List<Integer> list = new ArrayList<>();

        for (int[] command : commands) {
            int[] slice = Arrays.copyOfRange(arr, command[0] - 1, command[1]);
            Arrays.sort(slice);
            list.add(slice[command[2]-1]);

        }

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
    }
}


// Quick Sort 사용해서 정렬을 시킨 후 값을 찾는 방법이 아닌 바로 값을 찾는 방법으로 가도 괜찮다.