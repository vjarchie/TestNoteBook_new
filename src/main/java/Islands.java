import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Islands {

    public static void main(String args[]){
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<>(Arrays.asList(1,0,0,0,0));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(0,1,0,0,0));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(0,0,1,0,0));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(0,0,0,1,0));
        List<Integer> row5 = new ArrayList<>(Arrays.asList(0,0,0,0,1));
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        input.add(row5);
        System.out.println(minimumHours(5,5,input));

    }

    static int minimumHours(int rows, int columns, List<List<Integer> > grid)
    {
        if(rows<0 || columns <0)
            return 0;
        //create input matrix
        int input[][] = new int[rows][columns];
        for(int i =0 ;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                input[i][j] = grid.get(i).get(j);
            }
        }

        System.out.println("input matrix");
        for(int p=0;p<rows;p++) {
            for (int q = 0; q < columns; q++) {
                System.out.print(input[p][q]);
            }
            System.out.println("\n");
        }

        return countMin(rows,columns,input);
    }

    static int countMin(int R,int C,int input[][]){
        int[][] dp = new int[R][C];
        int[][] visited = new int[R][C];
        int max = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
//                if(input[i][j] == 1){
                    minDistance(input,i,j,dp,visited,R,C);
                    System.out.println("here2");
                    for(int p=0;p<R;p++) {
                        for (int q = 0; q < C; q++) {
                            System.out.print(dp[p][q]);
                        }
                        System.out.println("\n");
                    }
                //}
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if( dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }

        if(max<Integer.MAX_VALUE)
            return max;

        return -1;



    }

    static int minDistance(int m[][],int i,int j,int[][] dp,int[][] visited,int R,int C){
        if( i>= R || j>=C || i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        else if(dp[i][j] > 0 && dp[i][j] < Integer.MAX_VALUE){
            return dp[i][j];
        }
        else if(m[i][j] == 1){
            dp[i][j] = 0;
            return 0;
        }
        else if(visited[i][j] == 1){
            return Integer.MAX_VALUE;
        }
        else{
            visited[i][j] = 1;
            int temp1 = minDistance(m,i+1,j,dp,visited,R,C);
            int temp2 = minDistance(m,i-1,j,dp,visited,R,C);
            int temp3 = minDistance(m,i,j+1,dp,visited,R,C);
            int temp4 = minDistance(m,i,j-1,dp,visited,R,C);
            dp[i][j] = 1+fmin(temp1,temp2,temp3,temp4);
            System.out.println("here 1");
            for(int p=0;p<R;p++) {
                for (int q = 0; q < C; q++) {
                    System.out.print(dp[p][q]);
                }
                System.out.println("\n");
            }

        }
        return dp[i][j];
    }

     static int fmin(int p,int q,int r,int s){
        int temp1 = p<q?p:q;
        int temp2=  r<s?r:s;
        return temp1<temp2?temp1:temp2;
    }
}
