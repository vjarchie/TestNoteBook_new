package CTCI.TreeNGraphs;

import java.util.ArrayList;
import java.util.List;

public class LinkedListOfLevelInTree {

    public static void main(String[] args){
        TreeNode sample = TreeNode.getExampleTree1();
        List<List<TreeNode>> lists = new ArrayList<>();
        createLLfromTreeRecursive(sample,lists,0);
        for(List<TreeNode> list:lists){
            for(TreeNode t:list){
                System.out.print(t.val + " -> ");
            }
            System.out.println("");
        }
    }

    public static void createLLfromTreeRecursive(TreeNode root, List<List<TreeNode>> lists, int level){
        if(root == null){
            return;
        }
        List<TreeNode> l = null;
        if(level == lists.size()){
            l = new ArrayList<>();
            lists.add(l);
        }else{
             l = lists.get(level);
        }
      l.add(root);
        createLLfromTreeRecursive(root.left,lists,level+1);
        createLLfromTreeRecursive(root.right,lists,level+1);
    }




}
