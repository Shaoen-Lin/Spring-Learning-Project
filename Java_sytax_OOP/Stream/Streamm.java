package Stream;
import java.util.Arrays;
import java.util.List;

public class Streamm {
    public static void main(String a[])
    {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);
        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        // Stream<Integer> s3 = s2.map(n -> n * 2);
        // int result = s3.reduce(0, (c, e) -> c + e);
        
        //Stream 就是水流，他不會影響到前一個stream，而且一個Stream只能印一次 

        int result = nums.stream()
                        .filter(n -> n % 2 == 0)      // 過濾 = 出偶數：4, 2, 6
                        .map(n -> n * 2)              // map(映射) = 每個數乘 2：8, 4, 12
                        .reduce(0, (c, e) -> c + e);  // 累加：8 + 4 + 12 = 24

        System.out.println(result);
    }
}
