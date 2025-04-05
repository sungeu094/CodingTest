package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class level2_67257_exhaustiveSearch {
    private static void numSignCase(String s, Stack<String> stack) {
        int a, b;
        System.out.println(s);
        String result = switch (s) {
            case "+" ->{
                a = Integer.parseInt(stack.pop());
                b = Integer.parseInt(stack.pop());
                //System.out.println("a " + a + " b " + b);
                yield (String.valueOf(b + a));  
            }
            case "-" ->{
                a = Integer.parseInt(stack.pop());
                b = Integer.parseInt(stack.pop());
                System.out.println("a " + a + " b " + b);
                yield (String.valueOf(b - a));  
            }
            case "*" ->{
                a = Integer.parseInt(stack.pop());
                b = Integer.parseInt(stack.pop());
                //System.out.println("a " + a + " b " + b);
                yield (String.valueOf(b * a));  
            }

            default -> throw new IllegalArgumentException("지원하지 않는 연산자");
        };

        stack.add(result);
    }
    public static void main(String[] args) {
        // 방법 (Algorithm - 차량기지 알고리즘)
        /**
         * 1. + - * 의 우선순위 정하기.
         * 2. 숫자는 바로 List에 넣어버리고, 기호는 우선순위에 따라서 stack안에서 push, pop해주기
         * 3. 그것을 바탕으로 후위 연산
         */

        

        String[] priority = { "-+*", "-*+", "*-+", "*+-", "+-*", "+*-"};
        String problem = "100-200*300-500+20";
        String[] problem_num = Arrays.stream(problem.split("[^0-9]+"))
                                        .filter(s -> !s.isEmpty())
                                        .toArray(String[]::new);
        String[] problem_sign = Arrays.stream(problem.split("[0-9]+"))
                                        .filter(s -> !s.isEmpty())
                                        .toArray(String[]::new);
        
        // Ex. 연산 우선순위가 "+ -> - -> *"일때 계산
        
        int max = Integer.MIN_VALUE;
        for (int prior = 0; prior < priority.length; prior++) {
            Stack<String> sign = new Stack<>();
            List<String> num_sign = new ArrayList<>();
            for (int i = 0; i < problem_num.length - 1; i++) {
                num_sign.add(problem_num[i]);
                while (!sign.isEmpty() && priority[prior].indexOf(problem_sign[i]) <= priority[prior].indexOf(sign.peek())) {
                    num_sign.add(sign.peek());
                    sign.pop();
                }
                sign.push(problem_sign[i]);
            }
            num_sign.add(problem_num[problem_num.length - 1]);
            while (!sign.isEmpty()) {
                num_sign.add(sign.peek());
                sign.pop();
            }
            System.out.println(num_sign);

            Stack<String> calNumSign = new Stack<>();
            for (int i = 0; i < num_sign.size(); i++) {
                if (!(num_sign.get(i).equals("-") || num_sign.get(i).equals("+") || num_sign.get(i).equals("*"))) {
                    calNumSign.add(num_sign.get(i));
                } else {
                    numSignCase(num_sign.get(i), calNumSign);
                }
            }
            max = Math.abs(Integer.parseInt(calNumSign.peek())) > max ? Math.abs(Integer.parseInt(calNumSign.peek()))
                    : max;
            //System.out.println(Math.abs(Integer.parseInt(calNumSign.peek())));
        }  
        // switch - case를 이용한 단축 가능
        // System.out.println();
        // System.out.println(max);

    }
}
