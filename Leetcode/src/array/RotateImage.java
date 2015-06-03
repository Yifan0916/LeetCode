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
		int n =  matrix.length;
        int layNum=n/2;
        for(int layer=0;layer<layNum;layer++) {
            int first=layer;
            int last=n-1-layer;
            for(int i=first;i<last;i++) {
                int offset=i-first;
                int temp = matrix[first][i];
                //Left to Top.
                matrix[first][i]=matrix[last-offset][first];
                //Bottome to Left.
                matrix[last-offset][first]=matrix[last][last-offset];
                //Right to Bottom.
                matrix[last][last-offset]=matrix[i][last];
                //Top to Right.
                matrix[i][last]=temp;
            }
        }
	}
}
