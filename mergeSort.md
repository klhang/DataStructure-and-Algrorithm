```java
class MergeSort{
  public void sort(int[] arr, int l, int r){
    //recursively sort until there is only 1 int in arr
    if (l < r){
      int mid = l + (r-l)/ 2;

      sort(arr, l, mid);
      sort(arr, mid + 1, r);

      merge(arr, l, r, mid);
    }
  }

  private void merge(int[] arr, int l, int r, int mid){
    //1.copy both sorted part
    //2.init pointers: i,j,k
    //3.compare arr[i] vs arr[j], = arr[k]
    //4.take into account the rest

    int[] left = new int[mid - l + 1];
    int[] right = new int[r - mid];
    left = Arrays.copyOfRange(arr, l, mid);
    right = Arrays.copyOfRange(arr, mid, r);

    int i = 0; //for leftArr
    int j = 0; //for rightArr
    int k = 0; //for arr

    while (i < left.length && r < right.length){
      if (left[i]< right[j]){
        arr[k] = left[i];
        i ++;
      } else {
        arr[k] = right[j];
        r ++;
      }
      k ++;
    }

    while (i < left.length){
      arr[k] = left[i];
      i ++;
      k ++;
    }
    while (j < right.length){
      arr[k] = right[j];
      j ++;
      k ++;
    }
  }
}


```
