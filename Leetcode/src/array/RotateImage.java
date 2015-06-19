package array;

public class RotateImage {
	//You are given an n x n 2D matrix representing an image.
    //Rotate the image by 90 degrees (clockwise).
	public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) return;
        int n=matrix.length;
        int[][] rotate = new int [n][n];
        for (int i =0; i<n;i++) {
            for (int j=0;j<n;j++) {
                rotate[j][n-i-1]=matrix[i][j];
            }
        }
        matrix=rotate;
    }
	//In-place!!!!
	public static void rotate_I(int[][] matrix) {
		int n = matrix.length;
        int layer = n / 2;
        int top = 0;
        int bot;
        for (; top < layer; top++) { //cannot equal
            bot = n - 1 - top;
            int l = top;
            int r = bot;
            for(int i = l; i < r; i++) {//cannot equal
                int tmp = matrix[top][i];
                /*left->top */
                matrix[top][i] = matrix[bot - i +l][l];
                /* botton -> left */
                matrix[bot - i +l][l] = matrix[bot][r - i + l];
                /* right -> botton */
                matrix[bot][r - i + l] = matrix[i][r];
                /* top -> right */
                matrix[i][r] = tmp;
            }
        }
	}
}
