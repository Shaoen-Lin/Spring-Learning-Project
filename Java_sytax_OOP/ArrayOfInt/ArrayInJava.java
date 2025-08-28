package ArrayOfInt;
public class ArrayInJava
{
    public static void main(String a[])
    {
        int nums[][] = new int[4][3]; // 初始化成0的方法

        for(int i=0 ; i<4 ;i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                nums[i][j] = (int)(Math.random() * 10 );
            }
        }

        for(int n[] : nums) // 一列一列抓 This is enhanced for loop
        {
            for(int m : n)
            {
                System.out.print( m + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        int arr[][] = new int [3][]; // This is jagged array
        arr[0] = new int [1];
        arr[1] = new int [3]; 
        arr[2] = new int [2];

        for(int i=0 ; i < arr.length ;i++)
        {
            for(int j=0 ; j < arr[i].length ; j++)
            {
                nums[i][j] = (int)(Math.random() * 10 );
            }
        }
        for(int n[] : arr) // 一列一列抓 This is enhanced for loop
        {
            for(int m : n)
            {
                System.out.print( m + " ");
            }
            System.out.println();
        }
    }    
}