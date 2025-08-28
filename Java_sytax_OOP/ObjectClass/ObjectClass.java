package ObjectClass;
class Laptop
{
    String model;
    int price;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        // 注意，這個model.hashCode()不是遞迴，因為model是String，而不是int喔！(但卻不會用記憶體位置計算)
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + price;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    
}

public class ObjectClass {
    public static void main(String a[])
    {
        Laptop obj = new Laptop();
        // obj.model = "Lenovo Yoga";
        obj.price = 1000;

        Laptop obj1 = new Laptop();
        obj1.model = "Lenovo Yoga";
        obj1.price = 1000;

        //System.out.println(obj); // 會印出 Laptop@54bedef2 (這是一格記憶體位置的Hash值) 在沒有任何 Methods 的情況下 = System.out.println(obj.toString()); // 會印出 Laptop@54bedef2
        
        // Default 會用記憶體計算，但Overide後就不會用記憶體計算
        System.out.println(obj.hashCode()); 
        System.out.println(obj1.hashCode()); 
        System.out.println(obj.equals(obj1)); 
    }
}
// 這個 Object Class 要探討的是 Default SUPER CLASS 裡面的 Method