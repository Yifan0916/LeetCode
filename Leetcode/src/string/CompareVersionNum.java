package string;

public class CompareVersionNum {
	public int compareVersion(String version1, String version2) {
        /*
         * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.         
         */
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int i=0;
        int j=0;
        int m=s1.length;  //这里注意不是length(),而是length!!!
        int n=s2.length;
        for (;i<m &&j<n;i++,j++) {
            if (Integer.parseInt(s1[i])<Integer.parseInt(s2[i])) return -1;
            if (Integer.parseInt(s1[i])>Integer.parseInt(s2[i])) return 1;
            
        }
        while (i<m) {
            if (Integer.parseInt(s1[i])!=0) return 1;
            i++;
        }
        while (j<n) {
            if (Integer.parseInt(s2[i])!=0) return -1;
            j++;
        }
        return 0;
    } 
	public int compareVersion_Update(String version1, String version2) {          
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        int i=0;
        int j=0;
        int m=s1.length;
        int n=s2.length;
        for (;i<Math.max(m,n);i++,j++) {
            
            int a=i<m?Integer.parseInt(s1[i]):0; //用比较的方法！不存在直接赋值为0；
            int b=j<n?Integer.parseInt(s2[i]):0;
            if (a<b) return -1;
            if (a>b) return 1;
        }
        return 0;
    } 

}
