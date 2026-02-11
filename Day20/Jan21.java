import java.util.*;

public class Jan21 {
    public static int deepCompare(String[][] a, String[][] b) {
    for (int i = 0; i < Math.min(a.length, b.length); i++) {
        int cmp = Arrays.compare(a[i], b[i]);
        if (cmp != 0) return cmp;
    }
    return Integer.compare(a.length, b.length);
}

    public static void main(String[] args) {
        // Write a program to compare two integer arrays using Arrays.equals().
        int arr1[] = {5,9,6,7};
        int arr2[] = {1,2,7,6};
        int arr3[] = {5,9,6,7};
       System.out.println( Arrays.equals(arr1, arr2));
       System.out.println(Arrays.equals(arr1, arr3));

    //    Write a program to compare two arrays lexicographically using Arrays.compare().
        String[] arr4 = {"Ram","Mohan","Shyam"};
        String[] arr5 = {"Shyam","Mohan","Ram"};
       System.out.println(Arrays.compare(arr4,arr5));

    //    Write a program to compare two 2-D arrays using Arrays.deepEquals().
     int matrix1[][] = {{1,2},{3,4}};
     int matrix2[][] = {{1,2},{3,4}};
     int matrix3[][] = {{3,4},{5,6}};
     System.out.println(Arrays.deepEquals(matrix1, matrix2));
    System.out.println(Arrays.deepEquals(matrix2, matrix3));

    // Write a program to compare two multidimensional arrays using Arrays.deepCompare().
    String matrix4[][] = {{"Ram"},{"Mohan"}};
    String matrix5[][] = {{"Shyam"},{"Radhika"}};
    System.out.println(deepCompare(matrix4,matrix5));

    // Write a Java program to find the minimum element in a list using Collections.min().
    List<Integer> list = Arrays.asList(8,5,3);
    System.out.println(Collections.min(list));

    
    }
}
