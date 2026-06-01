package F3_Arrays.F2_Medium;

import java.util.Arrays;

public class P11_SetMatrixZeroes {
    //brute //TC = O(NxM) x O(N+M) + O(NxM) //SC = 0
    public static void markRow(int t,int[][] matrix){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[t][i]!=0)
                matrix[t][i]=-1;            
        }
    }
    public static void markCol(int t,int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][t]!=0)
                matrix[i][t]=-1;
        }
    }
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        //O(NxM)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    //O(N+M)
                    markRow(i,matrix);
                    markCol(j,matrix);
                }
            }
        }   //O(N x M) x O(N + M)

        //O(NxM)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1) matrix[i][j]=0;
            }
        }
    }

    //better    //TC = O(2(NxM)) //SC = O(n)+O(m)
    public static void setZeroes1(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[] row=new int[n];
        int[] col=new int[m];
        //O(NxM)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        //O(NxM)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    //After better we reduced time to n^2 ie O(NxM) so we cannot reducce it any further 
    //so we try to reduce the O(n+m) space complexity in optimal
    
    //We do that by istead of taking seperate 2 arr we take 1st row and colm of the matrix for marking zero contain in that row and col of amtrix
    //optimal
    public static void setZeroes2(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int col0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0)
                        matrix[0][j]=0;
                    else 
                        col0=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0)
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //0th index col m1 depends on col0
        if(matrix[0][0]==0)
            for(int j=1;j<m;j++)
                matrix[0][j]=0;

        //0th index row n1 depends on matrix[0][0]
        if(col0==0)
            for(int i=1;i<n;i++)
                matrix[i][0]=0;

        if(col0==0) matrix[0][0]=0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };

        // int[][] matrix1 = {
        //     {1, 0, 2},
        // };

        // int[][] matrix2 = {
        //     {3},
        //     {0},
        //     {1}
        // };

        // setZeroes(matrix);
        // setZeroes1(matrix);
        setZeroes2(matrix);

        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
