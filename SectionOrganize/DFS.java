package SectionOrganize;

import java.util.Arrays;
import java.util.List;

public class DFS {

    static List<String[]> list;
    static boolean[] check;

    static boolean contains(String[] arr, String value){
        for(String str : arr){
//            System.out.println(str);
            if(str.equals(value)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        list = Arrays.asList(
                new String[]{"cannon", "Alphabet"},
                new String[]{"CC", "BB", "cannon", "alpahet"},
                new String[]{"cannon", "Alphabet", "karlos"}
        );

        check = new boolean[]{false, false, false};
        String[] matchString = new String[list.size()];
        Arrays.fill(matchString, "");
        backTracking(0, matchString);
    }

    static void backTracking(int depth, String[] matchString) { 
        if (depth == 3) {
            for(String i : matchString){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < list.get(depth).length; i++){
            if (!contains(matchString, list.get(depth)[i])){
                check[depth] = true;
                matchString[depth] = list.get(depth)[i];
                backTracking(depth+1, matchString);
                check[depth] = false;
            }
        }
        
    }
}
