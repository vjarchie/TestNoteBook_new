package problems;

import CTCI.TreeNGraphs.TreeNode;

public class MaxSumPathInTree {
    static Integer max_val;
    public static void main(String[] args){
        reset();
        max_gain(TreeNode.getExampleTree1());
        System.out.println("Maximum path sum " + max_val);
        reset();
        max_gain(TreeNode.getExampleTree2());
        System.out.println("Maximum path sum " + max_val);
    }

    public static void reset(){
        max_val = Integer.MIN_VALUE;
    }

    public static   Integer max_gain(TreeNode root){
        if(root == null){
            return  0;
        }
        Integer l_gain = Math.max(max_gain(root.left),0);
        Integer r_gain = Math.max(max_gain(root.right),0);

        int new_path = root.val + l_gain+r_gain;
        max_val = Math.max(max_val,new_path);

        return root.val+Math.max(l_gain,r_gain);
    }
}
