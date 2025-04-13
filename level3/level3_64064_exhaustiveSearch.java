package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class level3_64064_exhaustiveSearch {

    private static class Node{
        String name;
        int depth;
        List<Node> children = new ArrayList<>();
        
        public Node(String name, int depth){
            this.name = name;
            this.depth = depth;
        }

        void addChild(Node child){
            children.add(child);
        }
    }

    private static void dfs(Node node, List<String> mixtureList) {
        if (mixtureList.size() == 4) {
            System.out.println(mixtureList);
            return;
        }

        
        for(Node child : node.children){
            mixtureList.add(child.name);
            dfs(child, mixtureList);
        }
    }

    
    public static void main(String[] args) {
        String[] applicantID = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] illegalID = { "fr*d*", "*rodo", "******", "******" };
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

        Map<String, Node> makeNode = new HashMap<>();
        for(int depth = 0; depth < listBannedID.size(); depth++){
            for(String value : listBannedID.get(depth)){
                makeNode.put(value + depth, new Node(value, depth));
            }
        }

        for(int depth = 0; depth < listBannedID.size()-1; depth++){
            for(String parent : listBannedID.get(depth)){
                for(String child : listBannedID.get(depth+1)){
                    makeNode.get(parent + depth).addChild(makeNode.get(child + (depth+1)));
                }
            }
        }

        List<String> mixtureList = new ArrayList<>();

        for(int i = 0; i < listBannedID.get(0).length; i++){
            dfs(makeNode.get(listBannedID.get(0)[i]), mixtureList);
        }

        //dfs로 줄 것.

    }
}
