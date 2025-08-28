package Anonymousinnerclass;
class A 
{
    public void show()
    {
        System.out.println("in A show");
    }
}

// IF the extended class just needed to be executed once we only need to us Anonymousinnerclass

// class B extends A
// {
//     public void show()
//     {
//         System.out.println("in B show");
//     }
// }

public class Anonymousinnerclass {
    public static void main(String a[])
    {
        //A obj = new B(); // 會印出 "in B show" 。也就是等於 下面的程式碼 注意！！ 這裡是new BBBBBBBBB!!!
        
        A obj = new A() // 注意！ 這裡是new AAAAA!!!
        {
            public void show()
            {
                System.out.println("in B show");
            }
        };
        obj.show();
    } 
}

// AIC 根本跟 innerclass 概念不一樣，我們指示只用一次的子類別叫做AIC，但innerclass 是類別裡的類別