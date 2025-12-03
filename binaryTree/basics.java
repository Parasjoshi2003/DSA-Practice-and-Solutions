package binaryTree;
import javax.print.attribute.standard.SheetCollate;
import java.util.*;
public class basics {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

         private static void preorder(Node root){
            if(root == null) return ;
            System.out.print(root.data + " ");
             preorder(root.left);
             preorder(root.right);
        }

        public static void inorder( Node root){
            if(root == null) return;
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root){
            if (root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                if(q.peek()== null){
                    System.out.println();
                    q.remove();
                    if(q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
//                    continue;
                }
                System.out.print(q.peek().data + " ");
                Node temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }

        public static int height(Node root){
            if(root == null) return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return Integer.max(lh , rh ) + 1;
        }
        public static int heightInEdges(Node root){
            if(root == null) return -1;
//            if(root.left == null && root.right == null) return 0;
            int lh = heightInEdges(root.left);
            int rh = heightInEdges(root.right);
            System.out.println(root.data + " height is "+ (Integer.max(lh , rh ) + 1));
            return Integer.max(lh , rh ) + 1;
        }

        public static int count(Node root){
            if(root == null) return 0;
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount + rightCount + 1;
        }
        public static int sum(Node root){
            if(root == null) return 0;
            int leftCount = sum(root.left);
            int rightCount = sum(root.right);
            return leftCount + rightCount + root.data;
        }

        public static int diameter(Node root){
            if (root == null)
                return 0;
//            if(root.left == null && root.right == null) return 0;
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);
            int leftHeight = heightInEdges(root.left);
            int rightHeight = heightInEdges(root.right);
            int currentDiameter = leftHeight + rightHeight + 2;
            int dia = Integer.max(leftDiameter, Integer.max(rightDiameter, currentDiameter));
            System.out.println("Currentdiamete "+ dia + " root is " + root.data + " lefth " + leftHeight + " RightH "+ rightHeight);
            return dia;
        }

//        static class info{
//            int diameter;
//            int height;
//            info(int diameter , int height){
//                this.diameter = diameter;
//                 this.height = height;
//            }
//        }
//        public static info diam(Node root){
//            info i = new info(0,0);
//            if (root == null ) return i;
//            info left = diam(root.left);
//            info right = diam(root.right);
//            System.out.println(root.data);
//            info currD = new info((left.height + right.height+1), (Integer.max(left.height, right.height)+1));
//            return currD;
//        }
        static class infos{
            Node root;
            int hd;
            public infos(Node root, int hd){
                this.root = root;
                this.hd = hd;
            }
        }
        public ArrayList<Integer> topView(Node root) {
            // code here
            ArrayList<Integer> list = new ArrayList<>();
            if(root == null ) return list;
            Queue<infos> q = new LinkedList<>();
            HashMap<Integer , Node> map = new HashMap<>();
            q.add(new infos(root, 0));
            q.add(new infos(null , 0));
            int min = 0 , max = 0;
            while (!q.isEmpty()){
                infos curr = q.remove();
                // null condition
                if(curr.root == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(new infos(null, 0));
                        continue;
                    }
                }
                //add to hashmap if key is not present already
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.root);
                }
                //add left root
                if(curr.root.left != null){
                        q.add(new infos(curr.root.left , curr.hd-1));
                        min = Math.min(min, curr.hd-1);
                }
                //add right root
                if(curr.root.right != null){
                    q.add(new infos(curr.root.right , curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
            for(int i = min ; i<= max;i++){
                list.add(map.get(i).data);
            }
            return list;
        }
    }


    public static void main(String[] args) {
//        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes);
//        System.out.println(BinaryTree.idx);
        ArrayList<Integer> list = b.topView(root);
    }
}
