
package LPS;

/**
 *
 * @author chenguofeng08qh@gmail.com
 */
import java.util.*;

public class LPS {
     /*朴素递归 */
  public static String lps(String s, int start, int end)
  {
       if (end - start ==-1) {return "";}
       else if (end-start == 0) {return Character.toString(s.charAt(start));}
       else{
           if (s.charAt(start)== s.charAt(end)) {return s.charAt(start) + lps(s, start+1, end-1) + s.charAt(end);}
           else{
               String s1 = lps(s, start+1, end);
               String s2 = lps(s, start, end-1);
               return (s1.length()>s2.length()? s1: s2);
           }
           }
 
       }
  
     /*备忘录方法 */
  public static String memolps(String s)
  {
      String [][] a = new String[s.length()][s.length()];
      for (int i=0;i<s.length();i++)
          for (int j =0; j<s.length(); j++)
          {
              a[i][j] = null;
          }
          return lookuplps(s,0,s.length()-1,a);
          }
  public static String lookuplps(String s, int start, int end, String[][]a)
  {
    if (a[start][end] != null) return a[start][end];
    else if (end - start ==-1) { a[start][end] = ""; return a[start][end];}
    else if (end-start == 0) {a[start][end] = Character.toString(s.charAt(start)); return a[start][end];}
    else{
           if (s.charAt(start)== s.charAt(end)) {a[start][end] =  s.charAt(start) + lps(s, start+1, end-1) + s.charAt(end); return a[start][end];}
           else{
               String s1 = lps(s, start+1, end);
               String s2 = lps(s, start, end-1);
               a[start][end] = (s1.length()>s2.length()? s1: s2);
               return a[start][end];
           }
           }
       
 
 
   }
  
  
      
 
  
 
    
      /*longest palindrone subsequence bottom up*/
 //  public static String bottom_up_lps(String s, int start, int end){


   
//   }
 public static String RandomString(int length)
 {
  String str="abcdefghijklmnopqrstuvwxyz";
  Random  random = new Random();
  StringBuffer buf = new StringBuffer();
  
  for(int i = 0 ;i < length ; i ++)
  {
   int num = random.nextInt(26);
   buf.append(str.charAt(num));
  }
  
  return buf.toString();
 } 
 public static void main(String[] args) 
   {
      while(true)
       {
       Scanner scanner = new Scanner(System.in);
       System.out.println("找最长回文字符串程序测试");
       System.out.print("请输入随机字符串长度：");
       try{
           int userin = scanner.nextInt();
           if(userin > 0 ) {
           String s = RandomString(userin);
           System.out.print("原始字符串：");
           System.out.println(s);
           String result = memolps(s);
           System.out.print("最长回文串：");
           System.out.println(result);           
           
           }
       
           else{
               System.out.println("对不起，输入无效");
           }
       }
       catch (Exception e)
       {
             System.out.println("对不起，输入无效");
       }
       }  
   } 
}
