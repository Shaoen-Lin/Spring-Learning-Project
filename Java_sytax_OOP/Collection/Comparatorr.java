package Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Students
{
    int age;
    String name;
    
    public Students(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students [age=" + age + ", name=" + name + "]";
    }
}

public class Comparatorr {
    public static void main(String a[])
    {
        
        List<Students> studs = new ArrayList<>(); 
        studs.add(new Students(268 , "Shawn"));
        studs.add(new Students(23 , "Gina"));
        studs.add(new Students(50 , "Navin"));

        // Comparator<Students> com = new Comparator<Students>()  // Comparator 是一個 Interface 我們可以透過 Anonymous class 來 OVERLOADING 裡面的compare來更改其 排列的規則
        // {
        //     public int compare(Students i, Students j)
        //     {
        //         return i.age > j.age ? 1 : -1;
        //     }
        // };

        // 又因為是Interface所以改成Lamda Expression

        Comparator<Students> com = (Students i, Students j) ->
            {
                return i.age > j.age ? 1 : -1;
            };

        Collections.sort(studs, com); // sort 要加入 collections , comparator

        for(Students s : studs)
            System.out.println( s.name + " : " + s.age);
    }
}
