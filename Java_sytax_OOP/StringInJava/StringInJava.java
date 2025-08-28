package StringInJava;

public class StringInJava 
{   
    public static void main(String a[])
    {
        String name = new String("Shawn"); // 證明String is a object

        System.out.println(name);

        String s2 = "John";
        String s3 = "John";

        System.out.println(s2);
        System.out.println(s3);
        // 發現只有建構一個Object而s2 和 s3的位置一樣

    }
}

// String is not a primitive varible
// String is a reference varible 
// and the first location is in the stack， the String is kept in HEAP
// Normal String is string buider not string buffer 
