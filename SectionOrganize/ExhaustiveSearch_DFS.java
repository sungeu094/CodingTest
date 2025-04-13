package SectionOrganize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExhaustiveSearch_DFS {
    private static class Node{
        int value;
        int depth;
        boolean isSearch;
        List<Node> children = new ArrayList<>();

        public Node(int value, int depth, boolean isSearch){
            this.value = value;
            this.depth = depth;
            this.isSearch = isSearch;
        }

        void addChild(Node child){
            children.add(child);
        }
    }

    private static void dfs(Node node){
        if(node == null) {
            return;
        }
        System.out.println("value : " + node.value + ", depth : " + node.depth);

        for(Node child : node.children){
            if(!child.isSearch){
                child.isSearch = true;
                dfs(child);
            }
        }
    }
    
    public static void main(String[] args) {
        List<int[]> depthData = List.of(
            new int[]{1},
            new int[]{2,6},
            new int[]{3,5,7},
            new int[]{4,8,9}
        );

        // int[][] edges = {
        //     {1,2},{1,6},{2,3},{2,5},{3,4},{6,7},{7,8},{7,9}
        // };

        // Node 하나씩 다 만들기.(이중 for문 사용)
        Map<Integer, Node> makeNode = new HashMap<>();
        for(int depth = 0; depth < depthData.size(); depth++){
            for(int value : depthData.get(depth)){
                makeNode.put(value, new Node(value, depth, false));
            }
        }   // 이중 for문이라도 모두가 O(N^2)의 시간복잡도를 가지는 것이 아니다. 단순 순회라면 결국 O(N)의 시간복잡도가 될수도 있다는 것을 명심하자.

        for(int depth = 0; depth < depthData.size()-1; depth++){
            for(int parent : depthData.get(depth)){
                for(int child : depthData.get(depth+1)){
                    makeNode.get(parent).addChild(makeNode.get(child));
                }
            }
        }
        // for(int[] edge : edges){
        //     int parent = edge[0];
        //     int child = edge[1];
        //     makeNode.get(parent).addChild(makeNode.get(child));
        // }

        dfs(makeNode.get(1));
    }
}




