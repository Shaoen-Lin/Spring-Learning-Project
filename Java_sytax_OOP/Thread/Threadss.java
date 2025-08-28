package Thread;
class A extends Thread
{
    public void run()
    {
        for(int i=0 ; i<5 ; i++)
        {
            System.out.println("HI");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {e.printStackTrace();} // 因為現今的電腦都太快了 10 指的是 ms
        }
    }
}
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

public class Threadss {
    public static void main(String a[])
    {
        A obj1 = new A();

        // B obj1 = new B(); 
        Runnable obj2 = () -> // 注意 Lamda Expression 只能用在 Interface
            {
                for(int i=0 ; i<5 ; i++)
                {
                    System.out.println("HELLO");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {e.printStackTrace();} // 因為現今的電腦都太快了 10 指的是 ms
                }   
            };

        obj1.start(); // start() 才會讓 Threads 輪流跑(就類似 跑步比賽中的鳴槍)

        try {
                Thread.sleep(20);
            } catch (InterruptedException e) {e.printStackTrace();} 

        
        // 因為 start 是定義在 Thread 中的，所以 Runnable 中沒有start  
        // obj2.start();  改成

        Thread t2 = new Thread(obj2);
        t2.start();

        // obj2.setPriority(Thread.MAX_PRIORITY); // 1~10 , 10 是最高的
    }
}
