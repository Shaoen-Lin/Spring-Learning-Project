package Exception;
public class EException {
    public static void main(String a[])
    {
        try 
        {
            System.out.println(3/0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

// ERROR
// 1. Compile Time ERROR - Compile時無法編譯的錯誤 最好Debug                                       
// 2. Runtime ERROR - 原本執行的了，但因為某些原因執行不了 Code called " EXCEPTION " ex. OUTOFBOUND、DVIDEBYZERO ... 
// 3. Logical ERROR - 程式執行的了，但出來的答案跟你要的不一樣