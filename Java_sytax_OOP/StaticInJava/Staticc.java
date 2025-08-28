package StaticInJava;
class Mobile
{
    String brand;
    int price;
    static String name = "Phone"; // 代表所有創建出來的物件的值都會是相同的

    static // static Constructor 不用每次初始因為每個都長一樣 
    {
        name = "Phone";

        System.out.println("Static block"); // 驗證Static Block 呼叫次數
    }

    public Mobile() //Constrctor 每次建構一個物件都會用這些Properties初始化
    {
        brand = "None";
        price = 0;

        System.out.println("Constructor block"); // 驗證 Constructor Block 呼叫次數
    }

    public void say() 
    {
        System.out.println(brand + " : " + price + " : " + name); 
    }

    public static void say1() // static function
    {
        // System.out.println(brand + " : " + price + " : " + name); // 但裡面不能用到不是 static 的 variable
    }
} 

public class Staticc {
    public static void main(String a[]) // 所以 main 必須要是 static 的原因在於它是 starting point，若是non static須先建立一個object來(跟前者矛盾)
    {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile();

        m1.say(); // Static不館有幾個物件都只會呼叫一次
        m2.say(); 

        m1.brand = "Apple";
        m1.price = 25600;
        m2.brand = "Samsung";
        m2.price = 34560;

        m1.say();
        m2.say();

        Mobile.name = "brick"; // Static變數可以用 Class 直接改

        m1.say();
        m2.say();
    }
}
