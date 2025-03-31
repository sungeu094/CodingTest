package level1;

public class level1_81301_formation {
    private static final String[] words = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) {
        String s = "1zerotwozero3";
        // StringBuilder changeNumber = new StringBuilder(s);
        for (int i = 0; i < words.length; i++) {
            if (s.contains(words[i])) {
                s = s.replaceAll(words[i], String.valueOf(i));
            }
        }

        System.out.println(s);
    }

}
