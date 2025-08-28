package Abstract;

abstract class Car
{
    abstract void playMusic();
    // abstract method must in abstract class
}

class Benz extends Car
{
    public void playMusic()
    {
        System.out.println("Playing Music...");
    }

    // abstract method need all be complished in subclass
}

class Abstract
{
    public static void main(String a[])
    {
        Benz b = new Benz();
        b.playMusic();
    }    
}
// Java 會認大小寫