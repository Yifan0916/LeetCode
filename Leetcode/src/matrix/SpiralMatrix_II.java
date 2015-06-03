package matrix;

public class SpiralMatrix_II {
	public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];
        if (n == 0) return matrix;
        int row = 0, col = -1;
        int num=0;
        while (true) {
             for (int i=0; i<n;i++) {
                 matrix[row][++col]=++num;
             }
             if(num>=n*n) break;             
             for (int i=0; i<n-1; i++) {
                 matrix[++row][col]=++num;
             }
             if(num>n*n) break; 
             for (int i=0;i<n-1;i++) {
                 matrix[row][--col]=++num;
             }
             if(num>=n*n) break; 
             for (int i=0;i<n-2;i++) {
                 matrix[--row][col]=++num;
             }
             if(num>=n*n) break; 
             n=n-2;
        }
        return matrix;
       
    }
	//四边bound的解法。
	public int[][] generateMatrix_Bound(int n) {
	    int[][] res = new int[n][n];
	    int k = 1;
	    int top = 0, bottom = n - 1, left = 0, right = n - 1;
	    while (left < right && top < bottom) {
	        for (int j = left; j < right; j++) {
	            res[top][j] = k++;
	        }
	        for (int i = top; i < bottom; i++) {
	            res[i][right] = k++;
	        }
	        for (int j = right; j > left; j--) {
	            res[bottom][j] = k++;
	        }
	        for (int i = bottom; i > top; i--) {
	            res[i][left] = k++;
	        }
	        left++;
	        right--;
	        top++;
	        bottom--;
	    }
	    if (n % 2 != 0) //最中间的元素没有定义前就跳出while，所以应该在此处进行处理。
	        res[n / 2][n / 2] = k;
	    return res;
	}
	
	
	//参照I。
	public static void main(String[] args) {
		SpiralMatrix_II spiral=new SpiralMatrix_II();
		int[][] matrix=spiral.generateMatrix(4);
		System.out.println(matrix[2][2]);
	}
	public int[][] generateMatrix_Update(int n) {
        int[][] matrix= new int[n][n];
        if (n == 0) return matrix;
        int row = 0, col = -1;
        int num=0;
        int a=n,b=n;
        while (true) {
             for (int i=0; i<b;i++) {
                 matrix[row][++col]=++num;
             }
             if(--a==0) break;             
             for (int i=0; i<a; i++) {
                 matrix[++row][col]=++num;
             }
             if(--b==0) break; 
             for (int i=0;i<b;i++) {
                 matrix[row][--col]=++num;
             }
             if(--a==0) break; 
             for (int i=0;i<a;i++) {
                 matrix[--row][col]=++num;
             }
             if(--b==0) break; 
             //n=n-2;
        }
        return matrix;
       
    }
}
