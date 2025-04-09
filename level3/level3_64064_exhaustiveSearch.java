package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class level3_64064_exhaustiveSearch {
    private static void dfs(int depth, Set<String[]> path, List<String[]> listBannedID, List<String> nowPossibleID, boolean[] checkDFS){
        if(nowPossibleID.size() == listBannedID.size()){
            return;
        }
        // 어떻게 dfs + 백트래킹을 해야할까?

        // 사이즈 확인
        for(int i = 0; i < listBannedID.size(); i++){
            if(checkDFS[i] == false){
                checkDFS[i] = true;
                
            }
        }
    }

    public static void main(String[] args) {
        String[] applicantID = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] illegalID = {"fr*d*", "*rodo", "*****", "******"};
        List<String[]> listBannedID = new ArrayList<>();
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

        Set<String[]> bannedApplicant = new HashSet<>();
        boolean[] checkDFS = new boolean[listBannedID.size()];
        Arrays.fill(checkDFS, false);

        dfs(0, bannedApplicant, listBannedID, new ArrayList<>(), checkDFS);
    }
}
