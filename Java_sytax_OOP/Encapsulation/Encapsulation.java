package Encapsulation;
class Human
{
    private int age;    // EVERYTIME WHEN YOU CREATE A VARIABLE PLEASE！ MAKE IT PRIVATE！
    private String name; // LET IT THEM ASK ME RATHER THAN USE IT IN A DIRECT WAY 

    public Human() // Default Constructor is a Function, There's a standard. Don't Openly assign the value to variable, Just use a method(Function) 
    {
        age = 22;
        name = "Shawn";
    }

    public Human(int age, String name) { // Parameterized Constructor，可以透過 Source Action 得到
        this.age = age;
        this.name = name;
    }

    public int getAge() {   // 可以透過 Source Action 得到
        return age;
    }
    public void setAge(int age) {
        this.age = age; // This 指的是這個 class 裡的 local varible
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}

public class Encapsulation {
    
    public static void main(String a[])
    {
        Human obj = new Human(); // 這裡會呼叫 Constructor，所以不能設為Private
        System.out.println(obj.getAge() + " : " + obj.getName());

        obj.setAge(39);
        obj.setName("Paul");
        System.out.println(obj.getAge() + " : " + obj.getName());

        Human obj1 = new Human(18, "Navin"); // Constructor OVERLOADING！ 
        System.out.println(obj1.getAge() + " : " + obj1.getName());
    }
}


// 封裝(膠囊) 就是把箱子的東西裝起來的概念，所以就是保護自己資料不被其他人(其他 Object)一問就知道，使用Private