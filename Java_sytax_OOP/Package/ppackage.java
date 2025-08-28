package Package;
import Package.libr.*;

public class ppackage {
    public static void main(String a[])
    {
        A obj = new A();
        obj.say();
    }
}

// Pacakage is a folder, If you want to use it, we should "import it"

// Public 全部地方都可以access 4 (通常函式都會用這個)
// Private 在同一個 class 才能 access 1 (通常variable都用) 
// Default(也就是不打) 在同一個 package(folder) 才能 access, Different package can't be access 2 (不常用)
// Protected 可以 在 same package(folder) access, 且 不能在不同的package(folder) access but can access in subclass(繼承的子類別) of indifferent package 3 (通常function 會if想要他在subclass can be access)

// Cannot make two class public in the same file