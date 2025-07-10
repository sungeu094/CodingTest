package level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class level2_42747_sorting {

    public static void main(String[] args) {
        int[] citations = new int[]{10, 10, 10, 1};
        // Arrays.sort(citations); // {1,10,10,10}
        // int maxIndex = 0;

        // for (int i = 0; i <= citations[citations.length - 1]; i++) {
        //     int count = 0;
        //     for (int H_Index = 0; H_Index < citations.length; H_Index++) {
        //         if (citations[H_Index] >= i) {
        //             count++;
        //         }
        //     }

        //     System.out.println("count : " + count + " i : " + i);

        //     if (i <= count) {
        //         maxIndex = i;
        //     }
        // }

        // System.out.println(maxIndex);
    
        List<String> list;
        
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            System.out.println("smaller : " + smaller);
            answer = Math.max(answer, smaller);
            System.out.println("answer : " + answer);
        }

        Comparator<String> comparator;
    }
}


// 12917, 12915, 42746, 72411