
package LSS;

/**
 *
 * @author chenguofeng08qh@gmail.com
 */
public class LSS {
    /* naive recursive */
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
    /* bottom-up*/
   public static int bottom_up_lss(int [] a, int n){
       if (n == 0) {return 0;}
       else{
           int pref =0;
           int pretail = 0;
           for(int j=1; j<=n; j++)
           {
               int tail = (pretail + a[j-1] > a[j-1] ? pretail + a[j-1]: a[j-1]);
               int f = (pref > tail ? pref: tail);
               pref = f;
               pretail = tail;
           }
           return pref;
       }

   
   }
   
 public static void main(String[] args) 
   { int[] a =
         { 3,-5,7, -2,4,5};
     int result = bottom_up_lss(a, a.length);
     System.out.println(result);
   } 
}
