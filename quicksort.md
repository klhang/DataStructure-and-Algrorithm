```java
import java.util.*;

public class test {
    public static void quicksort (int[] arr){
      sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int start, int end){
      if (start >= end){
        return;
      }
      int j = partition(arr, start, end);
      sort(arr, start, j-1);
      sort(arr, j+1, end);
    }

    private static int partition(int[] arr, int start, int end){
      int pivot = start;
      int left = start + 1;
      int right = end;

      while(true){
        while (arr[pivot] > arr[left]){
          if (left == end){
            break;
          }
          left++;
        }

        while (arr[pivot] < arr[right]){
          if (right == start){
            break;
          }
          right--;
        }

        if (left >= right){
          break;
        }

        swap(arr, left, right);
      }

      swap(arr, pivot, right);
      return right;
    }

    private static void swap(int[] arr, int left, int right){
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
    }

    public static void main(String[] args) {

      int[] arr = new int[]{6,4,1,3,2,9,7};
      quicksort(arr);
      System.out.println(arr[0]);
      System.out.println(arr[1]);
      System.out.println(arr[2]);
      System.out.println(arr[3]);
      System.out.println(arr[4]);
      System.out.println(arr[5]);
      System.out.println(arr[6]);
    }
}
```
