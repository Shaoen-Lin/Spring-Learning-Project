package Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayList_Set {
    public static void main(String a[])
    {
        // Collection<Integer> nums = new ArrayList<Integer>();  // 壞處就是 不能取Index + 不能有重複值 ！ 
        // 改
        List<Integer> nums = new ArrayList<Integer>(); // Collection 改 List 後就可以取 Index 了。List 也就是 Vector！！ 
        nums.add(5);
        nums.add(2);
        nums.add(3);

        for(int n : nums)
        {
            System.out.println(n);
        }

        System.out.println(nums.get(1));
        System.out.println("//////////////////");

        Set<Integer> nums2 = new HashSet<Integer>(); // Set 把重複項忽略掉 
        nums2.add(31);
        nums2.add(72);
        nums2.add(488);
        nums2.add(3);

        for(int n : nums2)
        {
            System.out.println(n);
        }

        Set<Integer> nums3 = new TreeSet<Integer>(); // 排序後的SET
        nums2.add(31);
        nums2.add(72);
        nums2.add(488);
        nums2.add(3);

        for(int n : nums2)
        {
            System.out.println(n);
        }

        
    }
}
