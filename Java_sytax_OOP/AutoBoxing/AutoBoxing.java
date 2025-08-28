package AutoBoxing;

class AutoBoxing
{
    public static void main(String a[])
    {
        int num = 7;
        Integer n = num; // This is called AutoBoxing (放入原本的class中) 
    
        int num1 = n; // Auto-Unboxing

        String str = "12";
        int num2 = Integer.parseInt(str); // 這就是去呼叫 int 的 class INTEGER 去使用裡面的 methods

        System.out.println(num2);
    }
}

// Primitive variable - int、double、float、String (可以不要宣告成物件，直接用變數宣告)