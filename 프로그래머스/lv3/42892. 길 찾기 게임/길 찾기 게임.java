import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Node {
    public int x;
    public int y;
    public int number;
    public Node left;
    public Node right;
    
    public Node (int x, int y, int number, Node left, Node right){
        this.x = x;
        this.y = y;
        this.number = number;
        this.left = left;
        this.right = right;
    }
    
}

class Solution {
    public void preorder(Node node, List<Integer> list){
        if(node != null){
            list.add(node.number);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }
    
    public void postorder(Node node, List<Integer> list){
        if(node != null){
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.number);
        }
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for(int i=0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare (Node n1, Node n2) {
                if(n1.y == n2.y) {
                    return n1.x - n2.x;
                } else {
                    return n2.y - n1.y;
                }
            }
        });
        
        for(int i=0; i < nodes.length; i++) {
        }
        Node root = nodes[0];
        Node parent;
        
        for(int i=1; i < nodes.length; i++) {
            parent = root;
            Node node = nodes[i];
            
            while(parent.y > node.y+1){
                if(node.x > parent.x){
                    if(parent.right == null) break;
                    parent = parent.right;
                } else {
                    if(parent.left == null) break;
                    parent = parent.left;
                }
            }
            if(node.x > parent.x){
                parent.right = node;
            } else {
                parent.left = node;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        preorder(root, list);
        answer[0] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();
        
        postorder(root, list);
        answer[1] = list.stream().mapToInt(Integer::intValue).toArray();
        list.clear();
        
        
        return answer;
    }
}