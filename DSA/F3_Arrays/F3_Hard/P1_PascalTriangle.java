package F3_Arrays.F3_Hard;

import java.util.ArrayList;
import java.util.List;

public class P1_PascalTriangle {
    // Give exact val at given row col in pascal triangle   O(r)
    public static int positionValue(int row, int col) {
        // formula: (row-1) C (col-1)
        int r = row - 1;
        int c = col - 1;
        int ans = 1;

        for (int i = 0; i < c; i++) {
            ans = ans * (r - i);    //10*9*8
            ans = ans / (i + 1);    //1*2*3
        }
        return ans;
    }

    //Brute : To generate row   O(n*r)
    public static List<Integer> generateRow(int row) {
        List<Integer> temp = new ArrayList<>();

        // from 2nd col to 6th col incl 1 at last
        for (int col = 1; col <= row; col++) {
            temp.add(positionValue(row, col));
        }
        return temp;
    }

    // Optimal : Generate Pascal Triangle   O(n*r)
    //Optimal : To generate row O(r)
    public static List<Integer> generateRow1(int row) {
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans); // add 1 in begining of a row
        // from 2nd col to 6th col incl 1 at last
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            temp.add(ans);
        }
        return temp;
    }
    //O(n)
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> li = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            li.add(generateRow1(row));
        }
        return li;
    }

    public static void main(String[] args) {
        System.out.println(positionValue(5, 3));
        System.out.println(generateRow(5));
        System.out.println(generatePascalTriangle(6));

    }
}
