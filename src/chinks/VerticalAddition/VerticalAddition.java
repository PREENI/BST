
package chinks.VerticalAddition;
import java.util.HashMap;
import java.util.Scanner;

public class VerticalAddition {
   public class Node {
        int data;
        Node left;
        Node right;
        public Node (int a) {
            this.left = null;
            this.data = a;
            this.right = null;
        }
   }
   
     Node root = null;
     HashMap<Integer,Integer> map = new HashMap<>();
     int a,flag;
     
   private void push(int a) {
        root = insert(root,a);
    }
    
    private Node insert(Node root,int a) {
        if(root == null){
            root = new Node(a);
            return root;
        }
        else {
            	if(a < root.data) {
                	root.left = insert(root.left,a);
            }
            else if(a > root.data) {
                	root.right = insert(root.right,a);
            }
            return root;
         }
    }
    
    private void inorderrec() {
        inorder(root,0);   
        System.out.println(map);   
    }
    
    
    private void inorder(Node root,int R) {
        if(root == null)
            return ;
                       
        inorder(root.left,R-1);
        if(map.get(R) == null) {
            a = 0;      
        }
        else
            a = map.get(R);
        map.put(R,a+root.data);
        inorder(root.right,R+1);
   } 
       
    public static void main(String args[]) {
        VerticalAddition va = new VerticalAddition();
        Scanner sc = new Scanner(System.in);
        int a;
        int n = sc.nextInt();
        
        for(int i = 0; i < n; ++i) {
            a = sc.nextInt();
            va.push(a);
        }
        va.inorderrec();
    }
 }
