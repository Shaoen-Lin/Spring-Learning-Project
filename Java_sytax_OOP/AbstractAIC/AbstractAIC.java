package AbstractAIC;

abstract class A 
{
    abstract public void show();
}


public class AbstractAIC {
    public static void main(String a[])
    {
        A obj = new A() // 使用 AIC 來說明 (也就是只會用到一次)
        {
            public void show()
            {
                System.out.println("in B show");
            }
        };
        obj.show();
    } 
}
