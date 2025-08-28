package Collection;
import java.util.HashMap;
import java.util.Map;

public class Mapp {
    public static void main(String a[])
    {
        Map<String, Integer> students = new HashMap<String, Integer>(); // 這裡 Integer 不能打成 int 且 HashTable也歐虧 
        students.put("Navin",80);
        students.put("Shawn",67);
        students.put("Paul",98);
        students.put("Gina",79);

        // 注意他不是照號碼印出來的 跟 Set一樣

        for(String key : students.keySet())
        {
            System.out.println(key + " : " + students.get(key));
        }
    }
}


//MAP 就是 Array 但 其他東西作為 Index (不是 0,1,2...)