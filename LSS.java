
package LSS;

/**
 *
 * @author chenguofeng08qh@gmail.com
 */
public class LSS {
    public static int tail(int[] a, int n) {  
        if (n ==1){return (a[0]>0 ? a[0] : 0);}
        else{
            int pre = tail(a , n-1);
            return (pre > 0 ?  pre + a[n-1]: a[n-1]) ;}
        
    }
    public static int lss(int[] a, int n) {  
        if (n ==1){return (a[0]>0 ? a[0] : 0);}
        else{
            int pre = lss(a , n-1);
            int tail = tail(a, n);
            return(pre > tail ? pre: tail);
        }
    }
   
 public static void main(String[] args) 
   { int[] a =
         { 3,-5,7, -2,4,5};
     int result = lss(a, a.length);
     System.out.println(result);
   } 
}
