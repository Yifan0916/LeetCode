package array;

public class SetZeroes {
	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	 * 我们看到其实判断某一项是不是0只要看它对应的行或者列应不应该置0就可以，所以我们可以维护一个行和列的布尔数组，
	 * 然后扫描一遍矩阵记录那一行或者列是不是应该置0即可，后面赋值是一个常量时间的判断。这种方法的空间复杂度是O(m+n)。
     *再优化就是现在的常量的空间复杂度。
     *http://blog.csdn.net/linhuanmars/article/details/24066199
	 */
	public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rFlag=false;
        boolean cFlag=false;
        for (int i=0;i<n;i++) { //the first row;
            if(matrix[0][i]==0) {
                rFlag=true;
                break;
            }
        }
        for (int j=0;j<m;j++) { //the first column;
            if(matrix[j][0]==0) {
                cFlag=true;
                break;
            }
        }
       
        for (int i=1;i<m;i++) {   //如果某一个cell为0，把所在列的开头和所在行的开头置零。
            for (int j=1;j<n;j++) {
                if (matrix[i][j]==0) {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if (rFlag) {
            for (int i=0;i<n;i++) matrix[0][i]=0;
        }
        if (cFlag) {
            for (int i=0;i<m;i++) matrix[i][0]=0;
        }
    }
	
	public void setZeroes_Review(int[][] matrix) { //问题出在first, left没赋值！！！！！因为额外用了两个一维空间！！！下面是错的答案！
		
		if(matrix.length==0) return;
        int[] first=new int[matrix[0].length];
        int[] left=new int[matrix.length];
        boolean f1=false;
        boolean f2=false;
        
        for(int i=0;i<matrix[0].length;i++){
        	//System.out.println(matrix[0].length+" "+i);
            if(matrix[0][i]==0) {
            	f1=true;
            	//System.out.println(f1);
            	 break;
            }
           
            
        }
        for(int j=0;j<matrix.length;j++){
            if(matrix[j][0]==0) {
            	f2=true;
                break;
            }
            	
        }
        //System.out.println(f1+" "+f2);
        for(int i=1;i<matrix.length;i++){//row
            for(int j=1;j<matrix[0].length;j++){//column
                if(matrix[i][j]==0) {
                    first[j]=0;
                    left[i]=0;
                    //System.out.println(i+" "+j);
                }
            }
        }
        System.out.println(first[3]);
        //Set 0;
        for(int j=1;j<matrix[0].length;j++){//set col 0.
        	System.out.println(j);
            if(first[j]==0) {
                for(int i=1;i<matrix.length;i++) matrix[i][j]=0;
                
            }
        }
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		System.out.print(matrix[i][j]);
        	}
        }
        
        for(int i=1;i<matrix.length;i++){//set col 0.
            if(left[i]==0) {
                for(int j=1;j<matrix[0].length;j++) matrix[i][j]=0;
            }
        }
        //first and left
        if(f1) {
            for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
        }
        if(f2){
            for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }
    }
	
	public static void main(String[] args) {
		SetZeroes test=new SetZeroes();
		int[][] matrix={{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		test.setZeroes_Review(matrix);
	}
}
