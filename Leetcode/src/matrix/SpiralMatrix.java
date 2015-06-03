package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral= new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return spiral;
        int m = matrix.length;
        int n = matrix[0].length;
        int num = 0;
        
        for (int i = 0; num < m * n; i++) {
            for ( int a = i; a < n-i; a ++) {
                spiral.add(matrix[i][a]);
                num++;
               //if (num > m*n) break;
            }
            if (num >= m*n) break;
            for (int b = i+1; b<m-i; b++ ) {
                spiral.add(matrix[b][n-i-1]);
                num++;
                // if (num > m*n) break;
            }
            if (num >= m*n) break;
            for (int c =n-i-2; c>=i; c--) {
                spiral.add(matrix[m-i-1][c]);
                num++;
                //if (num > m*n) break;
            }
            if (num >= m*n) break;
            for (int d = m-i-2; d>i;d--) {
                spiral.add(matrix[d][i]);
                num++;
                //if (num > m*n) break;
            }
        }
        System.out.println(spiral);
        return spiral;
    }
	
	public List<Integer> spiralOrderUpdate(int[][] matrix) {
        List<Integer> spiral= new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return spiral;
        int m = matrix.length;
        int n = matrix[0].length;
        int row=0, col=-1;
        while (true) {
        	for (int i=0; i< n; i++) {
                spiral.add(matrix[row][++col]);

        	}
        	if (--m == 0) break;
        	for (int i=0; i<m; i++) {
                spiral.add(matrix[++row][col]);

        	}
        	if (--n == 0) break;
        	for (int i=0; i<n ; i++) {
                spiral.add(matrix[row][--col]);

        	}
        	if (--m == 0) break;
        	for (int i=0; i< m; i++) {
                spiral.add(matrix[--row][col]);
        	}
        	if (--n == 0) break;
        }
        System.out.println(spiral);
        return spiral;
	}
	public static void main(String[] args){
		SpiralMatrix test=new SpiralMatrix();
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		test.spiralOrder(matrix);
	}
}
