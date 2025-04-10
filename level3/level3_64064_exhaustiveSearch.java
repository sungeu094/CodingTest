package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class level3_64064_exhaustiveSearch {
    static boolean[] check;
    static List<String[]> listBannedID;

    private static boolean contains(String[] arr, String value) {
        for (String str : arr) {
            if (str.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(int depth, String[] matchNoRepeat) {
        if (depth == matchNoRepeat.length) {
            for (String i : matchNoRepeat) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < listBannedID.get(depth).length; i++) {
            if (!contains(matchNoRepeat, listBannedID.get(depth)[i]) && check[depth] == false) {
                check[depth] = true;
                matchNoRepeat[depth] = listBannedID.get(depth)[i];
                dfs(depth + 1, matchNoRepeat);
                check[depth] = false;
            }
        }
    }
    // abc123, frodoc은 
    public static void main(String[] args) {
        String[] applicantID = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] illegalID = { "fr*d*", "*rodo", "******", "******" };
        listBannedID = new ArrayList<>();
        for (int i = 0; i < illegalID.length; i++) {
            int illegalID_length = illegalID[i].length();
            char[] spellNotLegalID = illegalID[i].toCharArray();

            List<String> bannedID = new ArrayList<>();

            for (int j = 0; j < applicantID.length; j++) {
                boolean isBanned = true;
                char[] spellApplicantID = applicantID[j].toCharArray();
                if (applicantID[j].length() == illegalID_length) {
                    for (int k = 0; k < spellApplicantID.length; k++) {
                        if (!(spellNotLegalID[k] == '*' || spellApplicantID[k] == spellNotLegalID[k])) {
                            isBanned = false;
                            break;
                        }
                    }

                    if (isBanned) {
                        System.out.println(applicantID[j]);
                        bannedID.add(applicantID[j]);
                    }
                }
            }
            listBannedID.add(bannedID.stream().toArray(String[]::new));
        }
        System.out.println("listBannedID:");
        for (int i = 0; i < listBannedID.size(); i++) {
            System.out.println("illegalID[" + i + "]에 매칭되는 후보자: " + Arrays.toString(listBannedID.get(i)));
        }

        check = new boolean[listBannedID.size()];
        Arrays.fill(check, false);

        String[] matchNoRepeat = new String[listBannedID.size()];
        Arrays.fill(matchNoRepeat, "");

        dfs(0, matchNoRepeat);

    }
}
