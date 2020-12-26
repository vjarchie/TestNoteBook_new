package problems;

import Util.BTreePrinter;
import Util.Node;

public class ArbitSumTree
{
	public static void incrementNode(Node root, int diff)
	{
		if (root.left != null)
		{
			root.left.data += diff;
			incrementNode(root.left, diff);
		}
		else if (root.right != null)
		{

			root.right.data += diff;
			incrementNode(root.right, diff);
		}

	}

	public static void convertArbitTosSumTree(Node root)
	{
		int ldata = 0, rdata = 0;
		if (root == null || (root.left == null && root.right == null))
			return;
		else
		{
			convertArbitTosSumTree(root.left);
			convertArbitTosSumTree(root.right);
			if (root.left != null)
			{
				ldata = root.left.data;
			}
			if (root.right != null)
			{
				rdata = root.right.data;
			}
			int diff = root.data - (ldata + rdata);

			if (diff > 0)
				incrementNode(root, diff);
			else if (diff < 0)
				root.data += -diff;
		}
	}

	/**
	 * convert arbitrary value tree to sum tree
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{

		Node root = new Node(50);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(1);
		root.right.right = new Node(30);
		BTreePrinter.printNode(root);
		convertArbitTosSumTree(root);
		BTreePrinter.printNode(root);

	}

}
