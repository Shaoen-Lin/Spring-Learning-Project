package Thread;
// class A extends Runnable
// {
//     public void run()
//     {
//         for(int i=0 ; i<5 ; i++)
//         {
//             System.out.println("HI");
//             try {
//                 Thread.sleep(50);
//             } catch (InterruptedException e) {e.printStackTrace();} // 因為現今的電腦都太快了 10 指的是 ms
//         }
//     }
// }
// class B extends Runnable
// {
//     public void run()
//     {
//         for(int i=0 ; i<5 ; i++)
//         {
//             System.out.println("HELLO");
//             try {
//                 Thread.sleep(50);
//             } catch (InterruptedException e) {e.printStackTrace();} // 因為現今的電腦都太快了 10 指的是 ms
//         }    
//     }
// }

// Threads 中的 函式(methods) 必須叫做 run, run 是 Thread's Parent Process 的 Abstract Method, 所以我們要 implement it 


class Counter
{
    int cnt;
    
    public synchronized void increment() // Synchronization！！！
    {
        ++cnt;
    }
}
public class AdvThreads 
{
    public static void main(String a[])
    {
        Counter c = new Counter();

        // B obj1 = new B(); 
        Runnable obj1 = () -> // 注意 Lamda Expression 只能用在 Interface
            {
                for(int i=0 ; i<1000 ; i++) // 注意這是在Overridding run，但 run 是在 Thread class 中
                {
                    c.increment();
                }    
            };
        Runnable obj2 = () -> // 注意 Lamda Expression 只能用在 Interface
            {
                for(int i=0 ; i<1000 ; i++)
                {
                    c.increment();
                }    
            };

        Thread obj11 = new Thread(obj1);
        Thread obj22 = new Thread(obj2);

        obj11.start(); // 有 run 要執行就必須透過 start, start 也是在 Thread class 中
        obj22.start();

        // 等上方執行完後 main 才能結束 但依舊發現少了一些值 
        try {
            obj11.join(); 
        } catch (InterruptedException e) {e.printStackTrace();}
        try {
            obj22.join();
        } catch (InterruptedException e) {e.printStackTrace();}

        System.out.println(c.cnt);
    }
}
