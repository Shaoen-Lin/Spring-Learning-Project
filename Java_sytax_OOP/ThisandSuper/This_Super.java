package ThisandSuper;
class A extends Object // Default EXTENDS
{
    public A() 
    {
        super(); // EVERY CONSTRUCTOR HAS A SUPER(),而且Super的意思就是去呼叫他的 super class (這個的super class 會 extends Object)
        System.out.println("in A");
    }

    public A(int a)
    {
        super();
        System.out.println("in A int");
    }
}
class B extends A
{
    public B() // Constructor
    {
        super(5); // 即使沒有去呼叫寫他，他也會自動呼叫自己的super class
        System.out.println("in B");
    }

    public B(int b)
    {
        this(); // This() will call the "DEFAULT" Constructor of the same class, 但跟super()只能同時使用。
        //super(b);
        // super(); // 這樣寫會去呼叫沒有parameter one
        System.out.println("in B int");
    }
}

public class This_Super {
    public static void main(String a[])
    {
        B obj = new B(5);
    }
}
