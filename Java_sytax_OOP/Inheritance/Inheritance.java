package Inheritance;
public class Inheritance 
{
    public static void main(String a[])
    {
        //Calc obj1 = new Calc();
        //AdvCalc obj = new AdvCalc();
        VeryAdvCalc obj = new VeryAdvCalc();
        
        int r1 = obj.add(1,2);
        int r2 = obj.multi(3,4);
        double r3 = obj.power(2,8);

        System.out.println(r1);
        System.out.println(r1 + " " + r2 + " " + r3);
    } 
}
