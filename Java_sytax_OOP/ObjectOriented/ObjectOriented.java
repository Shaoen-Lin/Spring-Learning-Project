package ObjectOriented;
class Calculator    // Class 是一個Blueprint
{
    public int add(int a, int b)
    {
        return a+b;
    }
}
public class ObjectOriented
{
    public static void main(String a[])
    {
        int num1 = 2;
        int num2 = 3;
        Calculator calc = new Calculator(); //說我想要建構一個Physically的Object，也就是請JVM幫我們建構一個object叫做calc(但其實這個 calc 是 Reference variable，不是 object )，且依照藍圖(class) Calculator 做

        int result = calc.add(num1,num2);
        
        System.out.println(result);
    }
}

// Every Object have two things ： Properties(指class) & Methods(指函式)
// Java is a Strongly typed language(強型態語言)，是指對資料型態（data type）檢查嚴格的程式語言，如果變數的型態不對，這種語言不會偷偷幫你轉換，而是會直接報錯clae