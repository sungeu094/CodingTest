package SectionOrganize;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearch_DFS {
    private static class Node{
        int value;
        int depth;
        List<Node> children = new ArrayList<>();

        public Node(int value, int depth){
            this.value = value;
            this.depth = depth;
        }

        void addChild(Node child){
            children.add(child);
        }
    }
    
    public static void main(String[] args) {
        
    }
}
