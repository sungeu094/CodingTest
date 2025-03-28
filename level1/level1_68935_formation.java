package level1;

public class level1_68935_formation {
    public static void main(String[] args) {
        int n = 125;
        StringBuilder threeFormationN = new StringBuilder(Integer.toString(n, 3));
        threeFormationN.reverse();
        long backToN = Long.parseLong(threeFormationN.toString(), 3);
        System.out.println(backToN);
    }
}
