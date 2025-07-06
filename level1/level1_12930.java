package level1;

public class level1_12930 {
    public static void main(String[] args) {
        String s = "       AA  aa  ZZ  zz  ";
        String[] strArray = s.split(" ", -1); // 뒤에 오는 공백도 유지됨

        StringBuilder appendString = new StringBuilder();

        for (int j = 0; j < strArray.length; j++) {
            char[] charArray = strArray[j].toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                } else {
                    charArray[i] = Character.toLowerCase(charArray[i]);
                }
            }
            strArray[j] = new String(charArray);
        }

        for (int i = 0; i < strArray.length; i++) {
            appendString.append(strArray[i]);
            if (!(i == strArray.length - 1)) {
                appendString.append(" ");
            }
        }

        System.out.println(appendString.toString());

    }

    public void reflection(){
        System.out.println("reflection 예제");
    }
}
