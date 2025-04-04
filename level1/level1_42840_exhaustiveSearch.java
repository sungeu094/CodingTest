package level1;

import java.util.stream.IntStream;

public class level1_42840_exhaustiveSearch {
    private static final int[][] RULES = {
            { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
    };

    private static int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;

        return rule[index];
    }

    public static void main(String[] args) {
        int[] answers = { 0, 0, 0, 0, 0, 0, 0 };
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }

        }

        // List<Integer> maxPersonList = new ArrayList<>();
        // for (int person = 0; person < 3; person++) {
        // if (corrects[person] == max) {
        // maxPersonList.add(person + 1);
        // }
        // }

        // System.out.println(Arrays.asList(maxPersonList));

        final int maxCorrects = max; // 나중에 Stream의 filter()와 같은 메서드를 사용할 때 max를 사용할 것인데 이러한 외부 변수를 익명 메서드나 람다가 사용할 때는 값의 수정이 이루어지면 안되기 때문에 final 키워드를 붙여 주는 것이다. 기본적으로 filter 속 변수는 final로 생각하기는 하지만 지금은 연습이기 때문에 좀 더 자세히 나타내기 위해서 사용한 것이다.

        int[] result = IntStream.range(0, 3).filter(i -> corrects[i] == maxCorrects).map(i -> i + 1).toArray();
        // Stream은 toArray()와 같은 최종연산이 없으면 안된다.
        

        


        System.out.println();

        // String person1 = "12345";
        // boolean person1Size = false;
        // int count1 = 0;

        // String person2 = "21232425";
        // boolean person2Size = false;
        // int count2 = 0;

        // String person3 = "3334224455";
        // boolean person3Size = false;
        // int count3 = 0;

        // int[] answers = { 1, 2, 3, 4, 5, 1, 2, 3, 5, 3, 2, 1, 4 };
        // // 반복되는 부분을 stringBuilder로 주고, 길이에 맞게 append 후 for문을 통해 비교하여 값 구하기
        // StringBuilder repeatPerson1 = new StringBuilder(person1);
        // StringBuilder repeatPerson2 = new StringBuilder(person2);
        // StringBuilder repeatPerson3 = new StringBuilder(person3);

        // while (true) {
        // if (repeatPerson1.length() > answers.length)
        // person1Size = true;

        // if (repeatPerson2.length() > answers.length)
        // person2Size = true;

        // if (repeatPerson3.length() > answers.length)
        // person3Size = true;

        // repeatPerson1.append(person1);
        // repeatPerson2.append(person2);
        // repeatPerson3.append(person3);

        // if (person1Size && person2Size && person3Size) {
        // break;
        // }

        // }

        // for (int i = 0; i < answers.length; i++) {
        // if (repeatPerson1.charAt(i) == (char) (answers[i] + '0')) {
        // count1++;
        // }
        // if (repeatPerson2.charAt(i) == (char) (answers[i] + '0')) {
        // count2++;
        // }
        // if (repeatPerson3.charAt(i) == (char) (answers[i] + '0')) {
        // count3++;
        // }
        // }

        // System.out.println(count1 + " " + count2 + " " + count3);

        // }
    }
}