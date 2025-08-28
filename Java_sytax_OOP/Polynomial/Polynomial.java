package Polynomial;

class A
{
    public void s()
    {
        System.out.println("in A");
    }
}

class B extends A
{
    public void s()
    {
        System.out.println("in B");
    }
}

final class C extends A
{
    public void s()
    {
        System.out.println("in C");
    }
}

public class Polynomial {
    
    public static void main(String a[])
    {
        A obj = new A();
        obj.s();

        obj = new B(); // Only 父類別 可以 assign 給 子類別, This concept is called "Dynamic Concept Dispatch"，是指在程式執行期間，根據物件的實際類型來決定呼叫哪個方法版本的機制。
        obj.s();

        obj = new C();
        obj.s();
    }
}

// Polynomial's concept is "different behavior"(多形)，也就是同個函式在不同的class具有不同功能
// 分成 Runtime Polymorphism -> Method Overriding 和 Compile-time Polymorphism ->  Method Overloading

// final - virable 代表 const in C
// final - methods 代表 do not OVERRIDING
// final - class 代表 是最後一代(do not extends)
