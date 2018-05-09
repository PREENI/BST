package chinks.MaxWidth;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxWidth {
	
	class Node {
		int data;
		Node left,right;
		
		Node(int a) {
			this.data=a;
			this.left=null;
			this.right=null;
		}
	}
	
	Node root=null;
	Queue<Node> q=new LinkedList<>();
	
	private void insertrec(int a) {
		root=insert(root,a);
	}
	
	private Node insert(Node root,int a) {
		if(root == null){
			return new Node(a);
		}
		else {
			if(a < root.data) 
				root.left = insert(root.left,a);
			else 
				root.right = insert(root.right,a);
			}
		return root;
		
	}
	private void maxwidth() {
		int count = 0, width = 0;
		Node temp;
	    temp = root;
	    q.add(root);
		while(q.isEmpty() != true) {
			width=q.size();
			count=Math.max(width, count);
			while(width-- > 0) {
			temp=q.remove();
			if(temp.left !=null)
				q.add(temp.left);
			if(temp.right !=null)
				q.add(temp.right);
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		
		MaxWidth mw=new MaxWidth();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a;
		
		for(int i = 0; i < n ;++i) {
			a=sc.nextInt();
			mw.insertrec(a);
		}
		
		mw.maxwidth();
	}

}
