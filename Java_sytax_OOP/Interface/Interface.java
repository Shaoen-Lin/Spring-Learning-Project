package Interface;
// abstract class A
// {
//     public abstract void show();
//     public abstract void config(); // 
// }
// 上面 = 下面
interface A
{
    void show();
    void config(); //自動忽略 public abstract
}

interface X
{
    void run();
}

class B implements A // class (implements) -> interface
{
    public void show()
    {
        System.out.println("in B show");
    }

    public void config()
    {
        System.out.println("in B config");
    }

    /////////////////////
    /// 
    public void run()
    {
        System.out.println("in B run");
    }
}

public class Interface {
    public static void main(String a[])
    {
        A obj = new B();
        obj.show();
        obj.config();
        // 但問題他用 interface 宣告 A 後 就不能使用Interface X 的 methods 
    }
}
