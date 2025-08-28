package TypeCasting;

class A
{
    public void say1()
    {
        System.out.println("in A");
    }
}

class B extends A
{
    public void say2()
    {
        System.out.println("in B");
    }
}

class TypeCasting
{
    public static void main(String a[])
    {
        A obj = (A) new B(); // Upcasting (因為Parent知道child) 所以不打也可以
        obj.say1();

        B obj1 = (B) obj; // Downcasting (因為Parent通常不知道child) 
        obj1.say2();
    }
}

// Typecasting 是指型態轉換