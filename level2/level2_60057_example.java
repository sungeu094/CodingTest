package programmers;


import java.util.ArrayList;
import java.util.List;

public class level2_60057_example {
    // 설정된 길이만큼 문자열을 잘라 낸 token 배열 생성
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        // source를 length만큼 잘라 tokens 리스트에 추가
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {

            // 문자열을 startIndex부터 잘라서 tokens 리스트에 추가
            int endIndex = startIndex + length;
            if (endIndex > source.length()) {
                endIndex = source.length();
            }

            // 문자열을 startIndex부터 endIndex까지 잘라서 tokens 리스트에 추가
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private int compress(String source, int length) {
        // 압축한 문자열 길이 변환
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 1;
        for (String token : split(source, length)) {
            // 압축 문자열 구성
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    builder.append(count);
                }
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            builder.append(count);
        } // 마지막 부분은 더하지 못한 상황이기 때문
        builder.append(last);
        System.out.println(builder.toString());

        return builder.length();
    }

    public static void main(String[] args) {
        String s = "aabbaccc";

        // 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하며 반복
        int min = Integer.MAX_VALUE;

        level2_60057_example l = new level2_60057_example();
        for (int length = 1; length < s.length(); length++) {
            // 문자열을 압축해서 가장 짧은 길이를 선택.
            int compressed = l.compress(s, length);
            System.out.println(compressed);
            if (compressed < min) {
                min = compressed;
            }
        }

        System.out.println(min);
    }

}
