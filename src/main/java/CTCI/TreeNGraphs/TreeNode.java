package CTCI.TreeNGraphs;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer val;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public static TreeNode getExampleTree1(){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr= new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        return root;
    }

}
