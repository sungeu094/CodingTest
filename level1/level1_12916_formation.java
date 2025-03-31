package level1;

public class level1_12916_formation {
    public static void main(String[] args) {
        String s = "pPoooyY";
        int countP = 0;
        int countY = 0;

        for (char digitS : s.toLowerCase().toCharArray()) {
            if (digitS == 'p') {
                countP++;
            } else if (digitS == 'y') {
                countY++;
            }
        }
        boolean answer = (countP == countY) ? true : false;

        System.out.println(answer);
    }
}
