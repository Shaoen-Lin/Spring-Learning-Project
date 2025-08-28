package MethodsOverridding;
class A
{
    public void add(int a, int b)
    {
        System.out.println(a + b);
    }
}
//@Overrriding // This is a annotation
class B extends A 
{
    // public void add(int a, int b)
    // {
    //     System.out.println(a + b + 1);
    // }
}

public class MethodsOverridding {
    public static void main(String a[])
    {
        B obj = new B();
        obj.add(3,4);
    }
}

// Overrriding 是指繼承的class之間有同個methods， Overloading 是指同個class有同個Methods 