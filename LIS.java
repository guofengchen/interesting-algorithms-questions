
package LIS;

/**
 *
 * @author chenguofeng08qh@gmail.com
 */
import java.util.*;
public class LIS {
       public static int[] LIS(int [] x, int n){
       int [] p = new int[n];
       int [] m = new int [n];
       p[0] = 1; 
       m[0] = x[0];
       int l = 1;
       for(int j=1; j<n; j++)
       {
           if( x[j] > m[l-1] ){ m[l]=x[j]; l = l+1; p[j] = l;}
           else{
               int k = binarysearch(x[j], m, 0, l-1);
               m[k] = x[j];  
               p[j] = k+1;
           }
       }
           int [] result = getlis(x , p, n, l);
           return result;
       }
       public static int[] getlis( int [] x, int [] p, int n, int l)
       {
           int [] result = new int[l]; 
           int t = l;
           for (int i = n-1; i>=0; i--)
           {
               if (p[i] == t){result[t-1] = x[i]; t--;}
               
           }
           return result;
           
       }
       
       
       public static int binarysearch(int x, int[] m, int start, int end)
       {
        while (start < end) {
        int mid = (start + end) / 2;  // Compute mid point.
        if (x < m[mid]) {
            end = mid;     // repeat search in bottom half.
        } else if (x > m[mid]) {
            start = mid + 1;  // Repeat search in top half.
        } else {
            return mid;     // Found it. return position
        }
        }
          return (start);    // Failed to find key
       }
      
   
   
 public static void main(String[] args) 
   { 
       while(true)
       {
       Scanner scanner = new Scanner(System.in);
       System.out.println("找最长递增子序列程序测试");
       System.out.print("请输入随机数组长度：");
       try{
           int userin = scanner.nextInt();
           if(userin > 0 ) {
                int []a = new int[userin];
                Random random = new Random();
                for (int i=0; i< userin; i++){
                  a[i] = (Math.abs(random.nextInt()))%1000;
                }
            System.out.println("原始序列：");
            for (int i = 0; i< a.length; i++)
            {
            System.out.println(a[i]);
            } 
            System.out.println("最长单调递增子序列：");
            int[] result = LIS(a, a.length);
            for (int i = 0; i< result.length; i++)
            {
            System.out.println(result[i]);
            } 
           }
             
       
           else{
               System.out.print("对不起，输入无效");
           }
       }
       catch (Exception e)
       {
             System.out.print("对不起，输入无效");
       }
       }
      /*
       int[] a =
         { 4,7,9,2,10,3 };

     int[] result = LIS(a, a.length);
     for (int i = 0; i< result.length; i++)
     {
     System.out.println(result[i]);
     }*/
             
     
   }
}
    
