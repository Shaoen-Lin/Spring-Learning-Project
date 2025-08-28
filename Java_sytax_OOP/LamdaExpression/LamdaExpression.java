package LamdaExpression;
interface C
{
    void add(int i, int j); // THIS IS FUNCTIONAL INTERFACE！ // 這裡可以省去 public
}

public class LamdaExpression {
    public static void main(String a[])
    {        
        // C obj = new C() 
        // {
        //     public void add(int i, int j) // 這裡就不能省去 Public
        //     {
        //         System.out.println(i+j);
        //     }
        // };

        C obj = (int i, int j) -> System.out.println(i+j); // This is Lamda Expression 
        //也就等於上面那串
        // C obj = (i, j) -> System.out.println(i+j); // This is Lamda Expression 

        obj.add(1,2);        
    } 
}

// Interface 分成3種：
// 1. Normal Interface - 一個Interface有兩個以上的Methods
// 2. Functional Interaface (SAM - Single Abstract Method)  - One Interface Only has one method , 唯一可以使用 Lamda Expression
// 3. Marker Interface - There's no Method in Marker Interface