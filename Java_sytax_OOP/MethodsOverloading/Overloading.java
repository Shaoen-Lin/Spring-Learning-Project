package MethodsOverloading;
class Calculator
{
    public int add(int num1, int num2, int num3)
    {
        return num1 + num2 + num3;
    }
    public int add(int num1, int num2)
    {
        return num1 + num2;
    }
    public float add(float num1, float num2)
    {
        return num1 + num2;
    }
}

public class Overloading 
{
    public static void main(String a[])
    {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        float f1 = 1.1f;
        float f2 = 1.2f;

        Calculator calc = new Calculator();
        
        System.out.println(calc.add(n1,n2,n3));
        System.out.println(calc.add(n1,n2));
        System.out.println(calc.add(f1,f2));

    }
}
