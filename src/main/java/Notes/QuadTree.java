package Notes;


//Quadtree is a tree data structure in which each internal node either is a leaf node or has exactly 4 children.
//        Input Image:
//        +---------+--------+
//        |  2 |  2 |  3 | 3 |
//        +----|----|----|---|
//        |  2 |  2 |  3 | 3 |
//        +----+----|--------|
//        |  4 |  2 |  5 | 5 |
//        +----|----|----|---|
//        |  2 |  3 |  5 | 5 |
//        +----+----+--------+
//
//        Quadtree representation:
//        +---------+--------+
//        |         |        |
//        |    2    |    3   |
//        +----+----|--------|
//        | 4  | 2  |        |
//        +----|----|    5   |
//        | 2  | 3  |        |
//        +----+----+--------+
//
//        1. How data structure will look like?
//        2. Create a quadtree from a two-dimensional n*n  metric.




import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

class QuadTreeNode {
    public Integer value;
    public boolean hasChildern;
    public QuadTreeNode[] children = new QuadTreeNode[4];
    public QuadTreeNode quad1;
    public QuadTreeNode quad2;
    public QuadTreeNode quad3;
    public QuadTreeNode quad4;


}

// Main class should be named 'Solution'
class QuadTree {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }

    public QuadTreeNode populateQuadTree(int[][] input){
        int n= input.length;

        return populateUtil(input, 0,n-1 , 0, n-1);

    }

    public QuadTreeNode populateUtil(int[][] input, int l,int r,int t,int b){
        QuadTreeNode curr = new QuadTreeNode();
        if(l==r){
            curr.value = input[l][t];
            return curr;
        }
        curr.hasChildern = true ;

        curr.children[0] = populateUtil(input, l,r/2,t,b/2);
        curr.children[1] = populateUtil(input,r/2+1,r,t,b/2);
        curr.children[2] = populateUtil(input,r/2+1,r,b/2+1,b);
        curr.children[1] = populateUtil(input,l,r/2,b/2+1,b);
        return curr;
    }

    public QuadTreeNode compress(QuadTreeNode root){
        if(root != null){
            compress(root.children[0]);
            compress(root.children[1]);
            compress(root.children[2]);
            compress(root.children[3]);
            if(root.children[0].value != null && root.children[1].value != null && root.children[2].value != null  && root.children[3].value != null ){
                if(root.children[0].value == root.children[1].value && root.children[0].value == root.children[2].value && root.children[0].value == root.children[3].value){
                    root.value = root.children[0].value;
                    root.children = null;
                }
            }

        }
        return root;
    }
}
