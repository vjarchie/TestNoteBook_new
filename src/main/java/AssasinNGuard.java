public class AssasinNGuard {

    static int ai,aj;
    public static void main(String[] args){
        String[] B = {"X.....>",
                      "..v..X.",
                      ".>..X..",
                      "A......"};
        solution(B);
        // part 2 rat in maze to reach n-1,n-1
    }

    public static boolean solution(String[] B) {
        int rows = B.length;
        int cols = B[0].length();
        int[][] mat = new int[rows][cols];
        fillObstacle(mat,rows,cols,B);
        System.out.println(ai + " --- "+ aj);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println("\n");
        }
return true;
    }



    public static void fillObstacle(int[][] mat,int rows,int cols,String[] B){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                switch(B[i].charAt(j)){
                    case 'X' : mat[i][j]=1;break;
                    case 'A' : ai = i; aj = j;break;
                    case '>' :{
                        int p = j;
                        while(p<cols && (B[i].charAt(p) == '>'||B[i].charAt(p) == '.' ||B[i].charAt(p) == 'A' )){
                            mat[i][p] = 1;
                            p++;
                        }
                    }
                    break;
                    case '<' :{
                        int p = j;
                        while( p>=0 && (B[i].charAt(p) == '<'||B[i].charAt(p) == '.' ||B[i].charAt(p) == 'A' )){
                            mat[i][p] = 1;
                            p--;
                        }
                    }
                    break;
                    case 'v' : {
                        int p=i;
                        while(p<rows && (B[p].charAt(j) == 'v'||B[p].charAt(j) == '.' ||B[p].charAt(j) == 'A' )){
                            mat[p][j] = 1;
                            p++;
                        }
                    }
                    break;
                    case '^' :{
                        int p = i;
                        while( p>=0 && (B[p].charAt(j) == '^'||B[p].charAt(j) == '.' ||B[p].charAt(j) == 'A' )){
                            mat[p][j] = 1;
                            p--;
                        }
                    }
                    break;

                }
            }
        }
    }



}
