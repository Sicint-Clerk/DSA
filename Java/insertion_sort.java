import java.util.*;

public class insertion_sort{

    static void s(int [] arr){
        for (int i=1;i<arr.length;i++)
        {
            int key=arr[i];
            int j=i-1;

        
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
    }
    public static void main(String[] args){
        System.out.println("tell the size of your input");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("input the number");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();

        }
        s(arr);
        for (int i=0;i<n;i++)
        {
            System.out.print(arr[i]+"  ");
        }


    }

}