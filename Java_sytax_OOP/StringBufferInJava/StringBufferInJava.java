package StringBufferInJava;
public class StringBufferInJava
{
    public static void main(String a[])
    {
        StringBuffer sb = new StringBuffer("");
        System.out.println(sb.capacity()); // capacity 是記憶體分配的容量
        System.out.println(sb.length()); 
        
        StringBuffer sb1 = new StringBuffer("SHAWN");
        System.out.println(sb1.capacity()); 
        System.out.println(sb1.length()); 
        
        //StringBuffer會分配給這個String多16個字元大小的Buffer
    }
}