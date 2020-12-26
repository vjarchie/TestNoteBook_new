package DS;

import Util.BTreePrinter;
import Util.Node;

public class AVLTree
{
	Node root;

	Node rightRotate(Node root){
		System.out.println("Rotating right at "+ root.data);
		Node left=root.left;
		Node lRight = left.right;
		left.right=root;
		root.left = lRight;
		root.height=1+Math.max(height(root.left),height(root.right));
		left.height=1+Math.max(height(left.left),height(left.right));
		return left;
	}

	Node leftRotate(Node root){
		System.out.println("Rotating left at "+ root.data);
		Node right=root.right;
		Node rLeft= right.left;
		right.left = root;
		root.right=rLeft;
		right.height=1+Math.max(height(right.left),height(right.right));
		root.height=1+Math.max(height(root.left),height(root.right));
		return right;
	}

	int height(Node root){
		if(root==null){
			return 0;
		}
		return root.height;
	}

	int getBalance(Node root){
		if(root==null){
			return 0;
		}
		else return height(root.left)-height(root.right);
	}

	Node insert(Node node,int key){
		if(node == null){
			return new Node(key);
		}

		if(key<node.data){
			node.left=insert(node.left,key);
		}else if(key>node.data){
			node.right=insert(node.right,key);
		}else{
			return node;
			//duplicate
		}

		node.height = 1+ Math.max(height(node.left),height(node.right));

		int diff = getBalance(node);
		System.out.println("node data= "+node.data+" diff="+diff);

		if(diff>1 && key<node.left.data){
			//Left-left case;
			System.out.println("L-L");
			return rightRotate(node);
		}

		if(diff>1 && key>node.left.data){
			//Left-Right
			System.out.println("L-R");
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}

		if(diff<-1 && key>node.right.data){
			//Right-Right
			System.out.println("R-R");
			return leftRotate(node);
		}

		if(diff<-1 && key<node.right.data){
			//Right-Left
			System.out.println("R-L");
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	void preOrder(Node root){
		if(root != null){
			System.out.print(root.data+ " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args){
		AVLTree tree=new AVLTree();

		tree.root=tree.insert(tree.root,10);

		tree.root=tree.insert(tree.root,20);
		BTreePrinter.printNode(tree.root);
		tree.root=tree.insert(tree.root,30);
		BTreePrinter.printNode(tree.root);
		tree.root=tree.insert(tree.root,40);
		BTreePrinter.printNode(tree.root);
		tree.root=tree.insert(tree.root,50);
		BTreePrinter.printNode(tree.root);
		tree.root=tree.insert(tree.root,60);
		BTreePrinter.printNode(tree.root);
		tree.root=tree.insert(tree.root,25);
		BTreePrinter.printNode(tree.root);

		tree.preOrder(tree.root);
	}
}
