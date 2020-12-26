package Util;

public class Node
{
	public int data, height;
	public Node left, right;

	public Node(int item)
	{
		this.data = item;
		left = right = null;
		this.height = 1;
	}

}
