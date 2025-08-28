package Collection;

import java.util.Arrays;
import java.util.List;

public class ASlist {
    public static void main(String a[])
    {
        List<Integer> nums = Arrays.asList(4,5,7,3,2,6);
        // 這裡的意思是用 Integer 來給後面的 array 當 Index
        System.out.println(nums.get(2));
        System.out.println("///////////////");
        
        // nums.add(77); 
        // Array.aslist不給 add data

        nums.forEach(n -> System.out.println(n)); // 這個用 在做 Comsumer Interface 的 Anonymous Class
    }
}
