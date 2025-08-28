package Enumerate;
enum Laptop
{
    Macbook(2000), Asus(1500) , Acer(1399) , Surface; // 每個都是一個Object如下

    // Laptop Macbook = new Laptop(2000); 
    // Laptop Asus = new Laptop(1500);
    // Laptop Acer = new Laptop(1399);
    // Laptop Surface = new Laptop(); 

    //又因為是一個 "物件" (只是這個Object是建在自己本身的Class中)，所以可以用Constructor賦值

    private int price;

    private Laptop()
    {
        price = 500;
    }

    private Laptop(int price) // Constructor 通常會用 Private
    {
        this.price = price; 
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    

}

public class AdvEnum {
    public static void main(String a[])
    {
        for(Laptop lap : Laptop.values())
        {
            System.out.println( lap + " : " + lap.getPrice());
        }
    }
}
