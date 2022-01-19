public class MaximalNetworkRank {

    public static void main(String[] args){
        int[] A = {1, 2, 4, 5};
        int[] B = {2, 3, 5, 6};
        System.out.println(solution(A,B,6));
    }

    public static int solution(int[] A, int[] B, int N) {
        int maxRank = 0;
        int[][] adjMat = new int[N][N];
        int[] hood = new int[N];

        for(int i=0;i<A.length;i++){
            int src = A[i]-1;int dest = B[i]-1;
            adjMat[src][dest] = 1;
            adjMat[dest][src] = 1;
            hood[src]++;
            hood[dest]++;
        }

        for(int i=0;i<A.length;i++){
            int src = A[i]-1;int dest = B[i]-1;
            int locMaxRank = hood[src]+hood[dest]-adjMat[src][dest];
            maxRank = Math.max(maxRank,locMaxRank);
        }
        return maxRank;
    }
}
