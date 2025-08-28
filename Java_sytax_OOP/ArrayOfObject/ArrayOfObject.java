package ArrayOfObject;
class Student // 注意Class後面不用()
{
    String name;
    int marks;
}

public class ArrayOfObject
{
    public static void main(String a[])
    {
        Student s1 = new Student();
        s1.name = "John";
        s1.marks = 88;

        Student s2 = new Student();
        s2.name = "Mary";
        s2.marks = 97;

        Student students[] = new Student[2];
        students[0] = s1;
        students[1] = s2;

        for(int i=0 ; i < students.length ; ++i)
        {
            System.out.println(students[i].name + " : " + students[i].marks);
        }
    }    
}