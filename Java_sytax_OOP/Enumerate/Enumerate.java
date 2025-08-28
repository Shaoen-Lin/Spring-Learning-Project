package Enumerate;
enum Status{ // Status 是一個類別
    Running, Failed, Pending, Success; // 這些是一個 OBJ 的概念
 }

public class Enumerate {
    public static void main(String a[])
    {
        Status s = Status.Pending;
        switch(s) // Switch case work well with Status
        {
            case Running:
                System.out.println("ALL GOOD");
                break;
            
            case Failed:
                System.out.println("TRY AGAIN");
                break;

            case Pending:
                System.out.println("PLEASE WAIT");
                break;
            default:
                System.out.println("DONE");
                break;
        }


        Status[] ss = Status.values(); // 得到 String陣列

        for(Status S : ss)
        {
            System.out.println(S + " : " + S.ordinal());
        }
    }
}
