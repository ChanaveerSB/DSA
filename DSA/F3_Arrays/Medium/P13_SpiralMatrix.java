package F3_Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class P13_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;
        List<Integer> li = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                li.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                li.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    li.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    li.add(matrix[i][left]);
                }
                left++;
            }
        }

        return li;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(spiralOrder(matrix));
    }
}
