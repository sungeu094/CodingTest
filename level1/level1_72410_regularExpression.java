package level1;

public class level1_72410_regularExpression {
    public static void main(String[] args) {
        // String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "ss";

        // 단계별로 순차적으로 코드 진행

        // 1단계. 대문자를 소문자로 변경
        new_id = new_id.toLowerCase();
        System.out.println(new_id);

        // 2단계. 특정 문자 제외하면 다 제거하기
        new_id = new_id.replaceAll("[^0-9a-zA-Z\\._-]", "");
        // \\ -> \가 두개인 것은 그 뒤의 문자가 특수문자로 사용된다는 것을 말해준다.
        System.out.println(new_id);

        // 3단계. 마침표 두개 연달아면 하나로 합치기
        new_id = new_id.replaceAll("\\.{2,}", ".");
        System.out.println(new_id);

        // 4단계. 마침표가 처음이나 끝에 위치하면 제거
        new_id = new_id.replaceAll("\\.$", "").replaceAll("^\\.", "");
        System.out.println(new_id);

        // 5단계. new_id가 빈 문자열이면, new_id에 "a" 대입
        new_id = new_id.equals("") ? "a" : new_id;
        System.out.println(new_id);

        // 6단계. 16자 이상이라면 15자로 줄이기
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        }
        System.out.println(new_id);

        // 7단계. 문자열의 길이가 2 이하라면 마지막 문자 반복.
        if (new_id.length() <= 2) {
            StringBuilder underTwoLengthId = new StringBuilder(new_id);
            while (underTwoLengthId.length() < 3) {
                underTwoLengthId.append(new_id.charAt(new_id.length() - 1));
            }
            new_id = underTwoLengthId.toString();
        }
        System.out.println(new_id);

    }
}
