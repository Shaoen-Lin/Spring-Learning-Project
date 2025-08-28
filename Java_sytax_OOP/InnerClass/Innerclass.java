package InnerClass;

class OuterClass 
{
    private String outerField = "我是外部類別";

    //  1. 成員內部類別（需要先建立外部類別物件）
    public class MemberInnerClass {
        public void print() {
            System.out.println("成員內部類別：" + outerField);
        }
    }

    //  2. 靜態內部類別（像 static 方法，不需要外部物件）
    public static class StaticInnerClass {
        public void print() {
            System.out.println("靜態內部類別：我不能直接存取外部實體欄位");
        }
    }
}
public class Innerclass 
{
    public static void main(String a[]) 
    {
        // 🔹 建立外部類別物件
        OuterClass outer = new OuterClass();

        // 1️⃣ 使用成員內部類別
        OuterClass.MemberInnerClass member = outer.new MemberInnerClass(); // 必須要先建立一個外部類別才能建立內部類別，Except 內部類別 為 Static
        member.print();

        // 2️⃣ 使用靜態內部類別
        OuterClass.StaticInnerClass staticInner = new OuterClass.StaticInnerClass(); // Static Inner Class
        staticInner.print();
    }
}

