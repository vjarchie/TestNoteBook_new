package problems;

import CTCI.TreeNGraphs.TreeNode;

public class TreeToCircuarList {

    public static  TreeNode convertToCircularList(TreeNode node){
        if(node != null){
            TreeNode leftList =  convertToCircularList(node.left);
            TreeNode rightList = convertToCircularList(node.right);
            node.left = node.right = node;
            return merge(merge(leftList,node),rightList);
        }
        return null;
    }

    public static  TreeNode merge(TreeNode leftList,TreeNode rightList){
        if(leftList == null){
            return rightList;
        }
        if(rightList == null){
            return leftList;
        }
        TreeNode leftLast = leftList.left;
        TreeNode rightLast = rightList.left;
        leftLast.right = rightList;
        rightList.left = leftLast;
        rightLast.right = leftList;
        leftList.left=rightLast;

        return leftList;

    }

    public static void display(TreeNode node){

        TreeNode itr = node;
        do
        {
            System.out.print(itr.val+ " " );
            itr = itr.right;
        }
        while (itr != node);
        System.out.println();
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode dllhead = convertToCircularList(root);
        display(dllhead);
    }
}
