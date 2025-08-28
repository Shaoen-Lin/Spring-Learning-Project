package Record;
// class Computer
// {
//     private final int id;
//     private final String name;

//     public Computer(int id, String name) { // Conanical Constructor = Parameterized Contructor
//         this.id = id;
//         this.name = name;
//     }

//     public int getIp() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

    

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + id;
//         result = prime * result + ((name == null) ? 0 : name.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Computer other = (Computer) obj;
//         if (id != other.id)
//             return false;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }

//     @Override
//     public String toString() {
//         return "Computer [id=" + id + ", name=" + name + "]";
//     }
//     // toString 基本上就是印出 JSON 檔

    
// }

record Computer(int id, String name) // 其實這裡的Parameter都是 Final + Static + 裡面有已經寫好的 POJO (LOMBOK)
{
    // 裡面不得有 非 Static 的 int 跟 method
    public Computer // 這裡的 Constructor 必須是 Cononical Comsturctor 所以 不用定義 Parameter，也叫做 Compact Cononical Comsturctor
    {
        if(id == 0)
        {
            throw new IllegalArgumentException("id cannot be zero！");
        }
    }
}

public class Recordd {
    public static void main(String a[])
    {
        Computer com = new Computer(0, "Shawn");
        Computer com1 = new Computer(0, "Shawn");
        
        System.out.println(com.toString()); 
        System.out.println(com.equals(com1)); 
    } 
}
