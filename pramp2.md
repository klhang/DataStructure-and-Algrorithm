```java
Array Index & Element Equality
Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

Examples:

input: arr = [-8,0,2,5]
output: 2 # since arr[2] == 2

input: arr = [-1,0,3,6]
output: -1 # since no index in arr satisfies arr[i] == i


class Solution {

  static int indexEqualsValueSearch(int[] arr) {
    // your code goes here
    int start = 0;
    int end = arr.length-1;
    int res = Integer.MAX_VALUE;

    while (start <= end){
      int mid = start + (end - start) / 2;

      if (mid < arr[mid]){
        end = mid -1;
      } else if (mid > arr[mid]){
        start = mid + 1;
      } else if (mid == arr[mid] ){
        res = Math.min(res, mid);
        end = mid -1;
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}

```
### Takeaways
1. int[] 实际上是二维， 很多题目会在此基础上出。
2. bs on itself, idx 作为 target
3. return res == Integer.MAX_VALUE ? -1 : res;
