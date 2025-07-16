package level1;

public class level1_12917_sorting {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String str = "Zbc".intern();
        System.out.println(str);
        String result = new StringBuilder(s).reverse().toString();
        System.out.println(result);        
    }
}
